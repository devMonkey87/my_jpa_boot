package com.example.postgresdemo;

import jdk.internal.joptsimple.internal.Strings;

import java.util.Base64;

public class Utils {

    public static String decodeByteArrayToBase64(byte[] bytes){
        return bytes != null ? new String(Base64.getDecoder().decode(bytes)) : Strings.EMPTY;
    }
}
