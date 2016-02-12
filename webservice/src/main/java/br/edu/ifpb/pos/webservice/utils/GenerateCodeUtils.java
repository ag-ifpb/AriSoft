package br.edu.ifpb.pos.webservice.utils;

import java.security.MessageDigest;
import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class GenerateCodeUtils {

    public static String generateCode(String prefix, int length, Object... args) {
        if (prefix == null && prefix.trim().isEmpty()) {
            throw new InvalidParameterException();
        }
        if (!(length - prefix.length() >= 4 && length <= 40 + prefix.length())) {
            throw new InvalidParameterException();
        }
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA1");
            String toDigest = Arrays.toString(args);
            byte[] messageDigest = algorithm.digest(toDigest.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            hexString.append(prefix.toUpperCase());
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString().substring(0, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
