package ru.morou.server.service;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.morou.server.api.UserService;
import ru.morou.server.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedHashMap;
import java.util.Map;


@NoArgsConstructor
@ApplicationScoped
public class UserServiceBean implements UserService {

    @NotNull
    private Map<String, User> users = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        registration("admin", "admin");
        registration("test", "test");
    }

    @Override
    public boolean registration(@Nullable final String login, @Nullable final String password){
        if(login == null || login.isEmpty()) return false;
        if(password == null || password.isEmpty()) return false;
        if(exists(login)) return false;
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        users.put(login, user);
        System.out.println("Added new user " + login);
        return true;
    }

    @Override
    public boolean exists(@Nullable final String login) {
        if(login == null || login.isEmpty()) return false;
        return users.containsKey(login);
    }

    @Override
    public boolean setNick(@Nullable String login, @Nullable String nick) {
        return false;
    }

    @Override
    public boolean setPassword(@Nullable String login, @Nullable String passwordOld, @Nullable String passwordNew) {
        return false;
    }

    @Override
    public @NotNull User findByLogin(@Nullable String login) {
        return null;
    }

    @Override
    public boolean check(@Nullable String login, @Nullable String password) {
        if(login == null || login.isEmpty()) return false;
        if(password == null || password.isEmpty()) return false;
        if(exists(login)) return false;
        @NotNull final User user = findByLogin(login);
        if(user == null) return false;
        return password.equals(user.getPassword());
    }
}
