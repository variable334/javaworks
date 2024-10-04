package lesson2;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;
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

            if (str.charAt(i) == str.charAt(i - 1))
            {
                count++;
            }
            else
            {
                compressed.append(str.charAt(i - 1));
                if (count > 1)
                {
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
        String[] splits = strpoly.split("");

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
    public static ArrayList randomarray(){
        Random rnd = new Random();
        ArrayList<Integer>arr = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            arr.add(rnd.nextInt(1,100));
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr,Comparator.reverseOrder());

        return  arr;
    }
    public static Object qw(Object a,Object b){
        if(a instanceof Double && b instanceof Double){
            return  (Object) ((Double) a + (Double) b);
        }else if(a instanceof Integer && b instanceof Integer){
            return (Object)((Integer) a + (Integer) b);
        }
        else {
            return  0;
        }

    }
    public static ArrayList<Integer> removeNum(int[]arr){
        ArrayList<Integer>resArray = new ArrayList<>();
        for(int s:arr){
            resArray.add(s);
        }
        resArray.removeIf(num -> num < 0);

        return resArray;
    }
    public static int[] setNum(int[] arr) {
        // Пример: [1, 2, 2, 3, 4, 4, 5]

        ArrayList<Integer> arrays = new ArrayList<>();
        ArrayList<Integer> resArrays = new ArrayList<>();

        for (int i : arr) {
            arrays.add(i);
        }

        resArrays.add(arrays.get(0));

        for (int i = 1; i < arr.length; i++) {

            // [1, 2, 2, 3, 4, 4, 5]

            if (arrays.get(i).equals(arrays.get(i - 1))) {
                continue;
            }
            resArrays.add(arrays.get(i));
        }

        int[] array = resArrays.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
    public static String[]filterLength(String[]string) {
        ArrayList<String> resstr = new ArrayList<>();
        for (int i = 0; i <string.length; i++) {
            if (string[i].length()>3) {
                resstr.add(string[i]);
            }
        }
        String[] stringArray = resstr.toArray(new String[0]);
        return stringArray;
    }
    public static int middlValueDigits(int[]num) {
        float nums = 0;
        for (int i = 0; i < num.length; i++) {
            nums += num[i];

        }
        nums = nums / num.length;
        int roundedUp = (int) Math.ceil(nums);

        return roundedUp;
    }
}


