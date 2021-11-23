package service;

import com.google.gson.Gson;
import model.User;

import java.io.InputStreamReader;
import java.util.Objects;


public class UserService {

    private final Gson gson = new Gson();
    private User[] users;
    private User loggedIn = null;

    public UserService() {
        this.users = gson.fromJson(new InputStreamReader(Objects.requireNonNull(UserService.class.getResourceAsStream("/users.json"))), User[].class);
    }

    public boolean login(String username, String password) {
        //TODO
        return false;
    }

    public boolean logout(String username) {
        //TODO
        return false;
    }

    public boolean delete(String username) {
        //TODO
        return false;
    }

    public User register(String username, String password, String firstName, String lastName) {
        //TODO
        return new User();
    }

    public boolean checkIfUsernameExists(String username) {
        //TODO
        return false;
    }
}
