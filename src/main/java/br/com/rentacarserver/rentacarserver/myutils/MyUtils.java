package br.com.rentacarserver.rentacarserver.myutils;

import java.sql.Timestamp;

public class MyUtils {
    public static Long datetime = System.currentTimeMillis();
    public static Timestamp timestamp = new Timestamp(datetime);
}