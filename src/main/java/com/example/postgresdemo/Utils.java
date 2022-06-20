package com.example.postgresdemo;


import org.apache.logging.log4j.util.Strings;
import org.springframework.util.Base64Utils;

public class Utils {

    public static String decodeByteArrayToBase64(byte[] bytes) {
        return bytes != null ? Base64Utils.encodeToString(bytes) : Strings.EMPTY;
    }
}
