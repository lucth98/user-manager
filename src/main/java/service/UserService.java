package service;

import com.google.gson.Gson;
import model.User;

import java.io.InputStreamReader;
import java.util.*;


public class UserService {

    private static final UserService instance = new UserService();

    private final Gson gson = new Gson();
    private List<User> users;
    private User loggedIn = null;

    public UserService() {
        User[] userArray = gson.fromJson(new InputStreamReader(Objects.requireNonNull(UserService.class.getResourceAsStream("/users.json"))), User[].class);

        users = new ArrayList<>(Arrays.asList(userArray));
    }

    public static UserService getInstance() {
        return instance;
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

    public void register(String username, String password, String firstName, String lastName) {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        String passwordHash = PasswordService.encrypt(password);
        user.setPassword(passwordHash);

        this.users.add(user);
    }

    public boolean checkIfUsernameExists(String username) {
        return this.users
                .stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }
}
