package lesson2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;

public class test {


    public static String returnstring(String str1, String str2, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n * 2; i++) {
            sb.append(str1).append(str2);

        }


        return sb.toString();
    }

    public static String countchars(String str) {
        if (str == null || str.isEmpty()) {
            return str.toString();
        }


        StringBuilder compressed = new StringBuilder();
        int count = 1;
//        "a a a a b b b c c c d d d d";
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {

                compressed.append(str.charAt(i - 1));
                if (count > 1) {
                    compressed.append(count);
                }

                count = 1;
            }

        }

        compressed.append(str.charAt(str.length() - 1));
        if (count > 1) {
            compressed.append(count);
        }

        return compressed.toString();
    }
    public static boolean polyndrom(String strpoly){
        int count=0;
//        String[] splits = strpoly.split("");

        if (strpoly.length()%2==0) {
            for (int i = 0; i < strpoly.length()/2; i++) {
                if(strpoly.charAt(i)==strpoly.charAt(strpoly.length()-1)){
                    return true;
                }

            }

        }
        else {
            System.out.println("not");
        }
        return false;
    }
    public static String repString(String str,int r){
        StringBuilder rep = new StringBuilder();
        for (int i = 0; i <r; i++) {
            rep.append(str);

        }
        return rep.toString();
    }
    public static void writeString(String name,String text) throws IOException {
    try {

        FileWriter fw = new FileWriter(name);
        fw.write(text);
        fw.flush();
        }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    }
}