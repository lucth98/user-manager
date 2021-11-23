package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordService {

    private static byte[] digest(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String password) {
        byte[] digest = digest(password);
        return Base64.getEncoder().encodeToString(digest);
    }

    public static Boolean checkPassword(String plain, String hash) {
        byte[] bytesPlain = digest(plain);
        byte[] bytesHash = Base64.getDecoder().decode(hash);

        return MessageDigest.isEqual(bytesHash, bytesPlain);
    }

}
