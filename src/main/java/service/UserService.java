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

    private UserService() {
        User[] userArray = gson.fromJson(new InputStreamReader(Objects.requireNonNull(UserService.class.getResourceAsStream("/users.json"))), User[].class);

        users = new ArrayList<>(Arrays.asList(userArray));
    }

    public static UserService getInstance() {
        return instance;
    }

    public boolean login(String username, String password){
        Optional<User> foundUser = checkIfUsernameExists(username);
        if (foundUser.isPresent() && PasswordService.checkPassword(password,foundUser.get().getPassword())){
            loggedIn = foundUser.get();
            return true;
        }else {
            return false;
        }
    }

    public boolean logout(String username) throws NoSuchElementException{
        if(checkIfUsernameExists(username).isPresent() && username.equals(loggedIn.getUsername())){
            loggedIn = null;
            return true;
        }else {
            throw new NoSuchElementException("There is no user logged in under that name");
        }
    }

    public boolean delete(String username) {
        Optional<User> foundUser = checkIfUsernameExists(username);
        if(foundUser.isPresent()){
            users.remove(foundUser.get());
            return true;
        }
        return false;
    }

    public boolean changePassword(String username, String pwd){
        Optional<User> foundUser = checkIfUsernameExists(username);
        if(foundUser.isPresent()){
            String pwdHash = PasswordService.encrypt(pwd);
            foundUser.get().setPassword(pwdHash);
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
    }


    public Optional<User> checkIfUsernameExists(String username) {
        return this.users
                .stream()
                .filter(u -> u.getUsername().equals(username)).findFirst();
    }

    /**
     * todo persisting changes
     */
    public void writeToFile(){

    }
}
