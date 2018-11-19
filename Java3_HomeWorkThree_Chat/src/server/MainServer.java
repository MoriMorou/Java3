package server;


import javax.swing.*;

public class MainServer {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setBounds(500, 500, 100, 100);
        jf.setTitle("Server");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SQLHandler.connect();
        Server server = new Server();

    }
}
