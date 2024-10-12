package lesson2;

import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Optional;

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

    public static boolean polyndrom(String strpoly) {
        int count = 0;
        String[] splits = strpoly.split("");

        if (strpoly.length() % 2 == 0) {
            for (int i = 0; i < strpoly.length() / 2; i++) {
                if (strpoly.charAt(i) == strpoly.charAt(strpoly.length() - 1)) {
                    return true;
                }

            }

        } else {
            System.out.println("not");
        }
        return false;
    }

    public static String repString(String str, int r) {
        StringBuilder rep = new StringBuilder();
        for (int i = 0; i < r; i++) {
            rep.append(str);

        }
        return rep.toString();
    }

    public static void writeString(String name, String text) throws IOException {
        try {

            FileWriter fw = new FileWriter(name);
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList randomarray() {
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(rnd.nextInt(1, 100));
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr, Comparator.reverseOrder());

        return arr;
    }

    public static Object qw(Object a, Object b) {
        if (a instanceof Double && b instanceof Double) {
            return (Object) ((Double) a + (Double) b);
        } else if (a instanceof Integer && b instanceof Integer) {
            return (Object) ((Integer) a + (Integer) b);
        } else {
            return 0;
        }

    }

    public static ArrayList<Integer> removeNum(int[] arr) {
        ArrayList<Integer> resArray = new ArrayList<>();
        for (int s : arr) {
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

    public static String[] filterLength(String[] string) {
        ArrayList<String> resstr = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            if (string[i].length() > 3) {
                resstr.add(string[i]);
            }
        }
        String[] stringArray = resstr.toArray(new String[0]);
        return stringArray;
    }

    public static int middlValueDigits(int[] num) {
        float nums = 0;
        for (int i = 0; i < num.length; i++) {
            nums += num[i];

        }
        nums = nums / num.length;
        int roundedUp = (int) Math.ceil(nums);

        return roundedUp;
    }

    public static void delString(LinkedList<String> llstr) {
        LinkedList<String> varllstr = new LinkedList<>();
        for (String s : llstr) {
            if (s.length() % 2 != 0) {
                varllstr.add(s);
            }
        }
        llstr.removeAll(varllstr);
    }

    public static int countOfOcurences(LinkedList<String> strings, String val) {
        int count = 0;
        for (String s : strings) {
            if (s.equals(val)) {
                count++;
            }
        }
        return count;

    }

    public static Deque<Integer> turn_on(Deque<Integer> dq, int n) {
        if (n > 0) {
            for (int i = 0; i < n % dq.size(); i++) {
                int a = dq.removeFirst();
                dq.addLast(a);
            }
        } else {
            n = n + dq.size();
            for (int i = 0; i < n % dq.size(); i++) {
                int a = dq.removeFirst();
                dq.addLast(a);
            }
        }
        return dq;
    }

    public static void removeString(Deque<String> removeStr, String str) {
        Deque<String> dq = new LinkedList<>();
        for (String elem : removeStr) {
            if (elem.equals(str)) {
                dq.add(elem);
            }
        }
        removeStr.removeAll(dq);
        System.out.println(removeStr);
    }

    public static class Diction {

        private HashMap<String, ArrayList<Integer>> Dictionary = new HashMap<>();

        public void addStudents(String name, int n) {

            Dictionary.computeIfAbsent(name, k -> new ArrayList<>()).add(n);

        }

        public ArrayList<Integer> findStud(String name) {
            return Dictionary.getOrDefault(name, null);
        }

        public void removElemDict(String name) {

            Dictionary.remove(name);
        }

        public HashMap<String, ArrayList<Integer>> getDict() {
            return Dictionary;
        }

        private Deque<String> Llist = new LinkedList<>();

        public void visiting(String site) {
            Llist.addFirst(site);
        }

        public String back(int n) {
            Optional<String> steamstr = Llist.stream().skip(n).findFirst();

            return steamstr.toString();
        }

        public Deque<String> returnHistory() {
            return Llist;
        }
    }

    public static class Schoping {

        private HashMap<String, Integer> backet = new HashMap<>();

        public void addProduct(String product, Integer count) {
            backet.put(product, count);
        }

        public void removeProduct(String nameProd) {
            backet.remove(nameProd);
        }

        public void updateProd(String nameProd, Integer count) {
            if (backet.containsKey(nameProd)) {
                backet.put(nameProd, count);
            }
        }

        public int checkProduct(String nameProd) {
            if (backet.containsKey(nameProd)) {
                return backet.getOrDefault(nameProd, 0);
            }
            return 0;
        }

        public void listProd() {

            for (Map.Entry<String, Integer> entried : backet.entrySet()) {
                System.out.println(entried);
            }
        }
    }

    public class merge {

        public static void merge(int[] left, int[] right, int[] result) {

            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            }

            while (i < left.length) {
                result[k++] = left[i++];
            }

            while (j < right.length) {
                result[k++] = right[j++];
            }



        }

        public static void mergeSort(int[] array) {
            if (array.length < 2) {
                return;
            }
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            merge(left, right, array);

        }
    }
}




