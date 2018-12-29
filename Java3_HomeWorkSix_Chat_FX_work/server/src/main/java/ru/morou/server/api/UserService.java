package ru.morou.server.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.morou.server.model.User;

public interface UserService {

    @NotNull
    User findByLogin(@Nullable String login);

    boolean check(@Nullable String login, @Nullable String password);

    boolean registration(@Nullable String login, @Nullable String password);

    boolean exists(@Nullable String login);

    boolean setNick(@Nullable String login, @Nullable String nick);

    boolean setPassword(@Nullable String login, @Nullable String passwordOld, @Nullable String passwordNew);
}
