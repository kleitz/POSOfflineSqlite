package com.lupawktu.possqlite.PublicMethod;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Mind on 5/30/2017.
 */

public class SHA512Password {
    public String acak(){
        return "Xdc$ag67#@a";
    }
    public String Hash(String text, String salt){
        String generatePassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(text.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatePassword = sb.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return generatePassword;
    }
}
