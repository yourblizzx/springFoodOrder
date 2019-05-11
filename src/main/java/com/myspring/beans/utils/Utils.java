package com.myspring.beans.utils;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @author Assylkhan
 * on 11.05.2019
 * @project springFoodOrder
 */
@Component
public class Utils {

    public String stringToMD5(String input){
        String res = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] result = messageDigest.digest(input.getBytes("UTF-8"));
            res = (new String(Hex.encode(result)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}
