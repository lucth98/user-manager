package service;

import com.google.gson.Gson;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileService {

    public static final File saveDir = new File(new File(System.getProperty("user.home")), ".user-manager");
    public static final File file = new File(saveDir, "users.json");

    private final Gson gson = new Gson();

    private boolean createDir() {
        if (!saveDir.exists()) return saveDir.mkdir();
        return false;
    }

    private User[] createFileFromResources() {
        InputStream resourceStream = Objects.requireNonNull(FileService.class.getResourceAsStream("/users.json"));
        User[] users = gson.fromJson(new InputStreamReader(resourceStream), User[].class);

        try {
            if (createDir() && file.createNewFile()) {
                saveUsers(new ArrayList<>(Arrays.asList(users)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<User> getUsers() {
        User[] users;

        try {
            FileReader reader = new FileReader(new File(saveDir, "users.json"));
            users = gson.fromJson(reader, User[].class);
        } catch (FileNotFoundException e) {
            users = createFileFromResources();
        }

        return new ArrayList<>(Arrays.asList(users));
    }

    public void saveUsers(List<User> users) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(gson.toJson(users));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
