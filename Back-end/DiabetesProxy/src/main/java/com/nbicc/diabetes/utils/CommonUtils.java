package com.nbicc.diabetes.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuolin on 2017/9/26.
 */
public class CommonUtils {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String SALT = "proxy";

    public static  Date string2Date(String timeStr){
        try {
            return dateFormat.parse(timeStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static  String date2String(Date date){
        return dateFormat.format(date);
    }

    public static String encode(String origin){
        return DigestUtils.sha1Hex(origin + SALT);
    }

    public static boolean pswCompare(String original,String encoded){
        return encode(original).equals(encoded);
    }

    public static void main(String[] args){
        System.out.println(encode("111111"));
    }
}
