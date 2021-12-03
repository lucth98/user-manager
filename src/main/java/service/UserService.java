package service;

import model.User;

import java.util.*;


public class UserService {

    private static final UserService instance = new UserService();

    private final List<User> users;
    private User loggedIn = null;
    private final FileService fileService = new FileService();

    private UserService() {
        users = fileService.getUsers();
    }

    private void saveUsersToFile() {
        fileService.saveUsers(users);
    }

    public static UserService getInstance() {
        return instance;
    }

    public boolean login(String username, String password) {
        Optional<User> foundUser = checkIfUsernameExists(username);
        if (foundUser.isPresent() && PasswordService.checkPassword(password, foundUser.get().getPassword())) {
            loggedIn = foundUser.get();
            return true;
        } else {
            return false;
        }
    }

    public boolean logout(String username) throws NoSuchElementException {
        if (checkIfUsernameExists(username).isPresent() && username.equals(loggedIn.getUsername())) {
            loggedIn = null;
            return true;
        } else {
            throw new NoSuchElementException("There is no user logged in under that name");
        }
    }

    public boolean delete(String username) {
        Optional<User> foundUser = checkIfUsernameExists(username);
        if (foundUser.isPresent()) {
            users.remove(foundUser.get());
            saveUsersToFile();
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String pwd) {
        Optional<User> foundUser = checkIfUsernameExists(username);
        if (foundUser.isPresent()) {
            String pwdHash = PasswordService.encrypt(pwd);
            foundUser.get().setPassword(pwdHash);
            saveUsersToFile();
            return true;
        }
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
        saveUsersToFile();
    }


    public Optional<User> checkIfUsernameExists(String username) {
        return this.users
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public User getUser(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getLoggedIn() {
        return loggedIn;
    }

    /**
     * todo persisting changes
     */
    public void writeToFile() {

    }
}
