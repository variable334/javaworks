
import lesson2.test;
import lesson3.LLstack;
import lesson3.myStack;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CSV {
    public static String CreateArrays(String[] headers, String[][] data) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", headers)).append("\n");
        for (String[] row : data) {
            sb.append(String.join(",", row)).append("\n");
            System.out.println(Arrays.toString(row));
        }
        return sb.toString().trim();
    }
}

class EmptyString {
    public static StringBuilder returnStrings(String text) {
        StringBuilder str = new StringBuilder();
        String[] pairs = text.split("\n");
        for (int i = 0; i < pairs.length; i++) {
            if (!pairs[i].isEmpty()) {
                if (str.length() > 0) {
                    str.append("\n");
                }
            }
            str.append(pairs[i].trim());
        }
        return str;
    }
}

class logs {
    private static File log;

    private static FileWriter fileWriter;

    public static void MinMax(int[] arr) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);

            int min = arr[0];
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
                WriteLogFiles(min, max);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void WriteLogFiles(int min, int max) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String tm = dateFormat.format(new Date());
            fileWriter.write(tm + " " + min + ", " + max + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    private static int LENGTH = 10_000_000;

    public static void task4() throws IOException {
        FileWriter fw = new FileWriter("out.txt");
        fw.write("hello");
        fw.flush();
        fw.close();


    }

    public static String task3() {
        String s1 = "";

        String s = "Добро пожаловать на курс java";
        String[] splits = s.split(" ");
        for (int i = splits.length - 1; i >= 0; i--) {
//            System.out.print(splits[i] + " ");
            s1 += splits[i] + " ";

        }
        return s1;
    }

    public static void cycly() {
        while (true) {
            task2();
        }
    }

    public static void task2() {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = sc.next();
        if (name.startsWith("q")) System.exit(0);
        if (name.startsWith("Na")) {
            System.out.println("Are you Nail?");
        } else if (name.startsWith("Bob")) {
            System.out.println("Are you Bob?");
        } else {
            System.out.println("Hello " + name + "!");
        }


        System.out.println("Hello " + name + "!");
    }

    private static void task1() {
        LocalTime nows = LocalTime.now();
        LocalDateTime dtime = LocalDateTime.now();
        System.out.println(nows);
        System.out.println(dtime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Дата: dd MMMM yyyy г., время: HH ч. mm мин. ss сек.");
        System.out.println(formatter.format(LocalDateTime.now()));
    }

    private static String[] files(String path) {
        File file = new File(path);
        if (file.isFile()) return new String[0];
        File[] files = file.listFiles();
        String[] names = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            names[i] = files[i].getName();

        }
        return names;
    }

    public static void Writter(String out, String in) {
        String[] names = files(out);
        FileWriter wf = null;
        try {
            wf = new FileWriter(in);
            for (String name : names) {
                wf.write(name + "\n");
            }
            wf.flush();

        } catch (IOException e) {
            throw new RuntimeException("Запись в файл не удалась!");
        } finally {
            try {
                wf.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void getTime() {

        List<Integer> intArrayList = new ArrayList<>(LENGTH); // 10
        List<Integer> intLinkedList = new LinkedList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LENGTH; i++) {
            intArrayList.add(i);
        }

        long endTime = System.currentTimeMillis();

        double result = (endTime - startTime);

        System.out.printf("Run time for ArrayList: %s %s %n", result, "ms");

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            intLinkedList.add(i);
        }
        long endTime2 = System.currentTimeMillis();

        result = (endTime2 - startTime2);
        System.out.printf("Run time for LinkedList: %s %s %n", result, "ms");

        long startTime3 = System.currentTimeMillis();

        long lp = 0;

        while (lp < 4000) {
            intLinkedList.add(20000, 15);
            lp += 2;
        }

        long endTime3 = System.currentTimeMillis();

        System.out.println(endTime3 - startTime3);
    }

    public static void getTime2() {

        List<Integer> intArrayList = new ArrayList<>(); // 16
        List<Integer> intLinkedList = new LinkedList<>();

        long startTime = System.currentTimeMillis();

        long lp = 0;

        while (lp < 4000000) {
            intArrayList.add(20000, 15);
            lp += 2;
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) throws IOException {




        int[] arrays;
        if(args.length==0){
            arrays = new int[]{2,3,32,76,1,7,8,56,24,34,76,100};
        }
        else{
            arrays = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        test.sort.bubble(arrays);
        System.out.println(Arrays.toString(arrays));

        int[]arr;
        if(args.length==0){
            arr = new int[]{2,3,32,76,1,7,8,56,24,34,76,100};
        }
        else {
            arr = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        test.sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));


        String prod1, prod2, prod3;
        Integer count1, count2, count3;

        if (args.length == 0){

            prod1 = "apple";
            prod2 = "grape";
            prod3 = "orange";
            count1 = 2;
            count2 = 5;
            count3 = 2;

        }
        else {
                prod1 = args[0];
                prod2 = args[1];
                prod3 = args[2];
                count1 = Integer.parseInt(args[3]);
                count2 = Integer.parseInt(args[4]);
                count3 = Integer.parseInt(args[5]);
            }



        test.Schoping back = new test.Schoping();

        back.addProduct(prod1,count1);
        back.addProduct(prod2,count2);
        back.addProduct(prod3,count3);

        back.listProd();
        System.out.println();
        System.out.println("count apple: " + back.checkProduct(prod1));


        test.Diction browsHist = new test.Diction();

        browsHist.visiting("google.com");
        browsHist.visiting("stackoverflow.com");
        browsHist.visiting("github.com");
        System.out.println(browsHist.back(0));
        System.out.println(browsHist.returnHistory());

        test.Diction dict = new test.Diction();

        dict.addStudents("alice", 90);
        dict.addStudents("jeko", 23);
        dict.addStudents("john", 100);
        dict.addStudents("alice", 88);

        System.out.println(dict.getDict());
        System.out.println(dict.findStud("alice"));
        dict.removElemDict("alice");
        System.out.println(dict.getDict());




        int[] nums = new int[]{3, 3, 3, 2, 2, 3};
        int val1 = 3;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(val1)) {
                list.remove(Integer.valueOf(val1));
                list.add(val1);

            }
        }
        System.out.println(list);


        String str = "flower,flow,flight";
        String res = "";


        String[] arrstr = str.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(arrstr));


        if (stringList.isEmpty()) {
            System.out.println(res);
            return;
        }


        String firstStr = stringList.get(0);


        for (int i = 0; i < firstStr.length(); i++) {
            char currentChar = firstStr.charAt(i);


            for (int j = 1; j < stringList.size(); j++) {

                if (i >= stringList.get(j).length() || stringList.get(j).charAt(i) != currentChar) {

                    System.out.println("Общий префикс: " + res);
                    return;
                }
            }


            res += currentChar;
        }

        System.out.println("Общий префикс: " + res);



        Deque<String> dq = new LinkedList<>();
        String value;
        if (args.length < 2) {

            dq.add("apple");
            dq.add("banana");
            dq.add("apple");
            dq.add("cherry");
            value = "apple";
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                dq.add(args[i]);
            }
            value = args[args.length - 1];
        }

        test.removeString(dq, value);

        Deque<Integer> deque = new LinkedList<>();
        int n1;
        if (args.length < 1) {

            deque.add(1);
            deque.add(2);
            deque.add(3);
            deque.add(4);
            n1 = -2;
//          n = 2;
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                deque.add(Integer.parseInt(args[i]));
            }
            n1 = Integer.parseInt(args[args.length - 1]);
        }
        System.out.println(test.turn_on(deque, n1));


        LinkedList<String> ocurrent = new LinkedList<>();
        String val;
        if (args.length == 0) {
            ocurrent.add("apple");
            ocurrent.add("apple");
            ocurrent.add("banana");
            ocurrent.add("greap");
            ocurrent.add("pear");
            ocurrent.add("pear");
            val = "pear";
        } else {
            for (String s : args) {
                ocurrent.add(s);
            }
            val = args[args.length - 1];
        }

        test oc = new test();

        System.out.println("Occurrences of \"" + val + "\": " + oc.countOfOcurences(ocurrent, val));

//        System.out.println(oc.countOfOcurences(ocurrent,val));


        LLstack lnkstr = new LLstack();

        if (args.length == 0) {
            lnkstr.push("apple");
            lnkstr.push("grape");
            lnkstr.push("banana");
            lnkstr.push("pear");
        } else {

            for (String s : args) {
                lnkstr.push(s);
            }
        }
        System.out.println(lnkstr.getElem());
        System.out.println(lnkstr.pop());
        System.out.println(lnkstr.getElem());
        System.out.println(lnkstr.peek());
//
//
        LinkedList<String> ls = new LinkedList<>();

        if (args.length == 0) {
            ls.add("apple");
            ls.add(("banana"));
            ls.add("peer");
            ls.add("grape");

        } else {
            for (String str1 : args) {
                ls.add(str1);

            }

        }

        test lls = new test();
        lls.delString(ls);
        System.out.println(ls);
//
//
        myStack stks = new myStack();
        System.out.println(stks);
//
        getTime();

        var exp = "12 2 3 - *".split(" "); // (1 + 2) * 3

        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        int res2 = 0;
        System.out.println(exp);

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                stk.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res2 = stk.pop() + stk.pop();
                        stk.push(res2);
                        break;
                    case "-":
                        res2 = stk.pop() + stk.pop();
                        stk.push(res2);
                        break;
                    case "*":
                        res2 = stk.pop() * stk.pop();
                        stk.push(res2);
                        break;
                    case "/":
                        res2 = stk.pop() / stk.pop();
                        stk.push(res2);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", stk.pop());


        int[] a3;
        if (args.length == 0) {

            a3 = new int[]{4, 2, 7, 5, 1};
        } else {
            a3 = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        test num = new test();
        int resultss = num.middlValueDigits(a3);
        System.out.println(resultss);


        String[] arrs;
        if (args.length == 0) {

            arrs = new String[]{"cat", "elephant", "dog", "giraffe"};
        } else {
            arrs = args[0].split(", ");
        }
        test fl = new test();
        String itresume_res3 = Arrays.toString(fl.filterLength(arrs));
        System.out.println(itresume_res3);


        int[] a2;
        if (args.length == 0) {

            a2 = new int[]{1, 2, 2, 3, 4, 4, 5};
        } else {
            a2 = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        test st = new test();
        String itresume_res2 = Arrays.toString(st.setNum(a2));
        System.out.println(itresume_res2);


        int[] a1;

        if (args.length == 0) {
            a1 = new int[]{-1, 2, -3, 4, -5, 6};

        } else {
            a1 = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        test sd = new test();
        ArrayList<Integer> result = sd.removeNum(a1);
        String itresume_res = result.toString();
        System.out.println(itresume_res);


        int[] a = new int[]{1, 9};
        int[] b = new int[3];
        System.arraycopy(a, 0, b, 0, a.length);
        for (int i : a) {
            System.out.printf("%d ", i);
        }
        for (int j : b) {
            System.out.printf("%d ", j);
        }

        test an = new test();
        System.out.println(an.qw(2, 5));


        test ex = new test();
        System.out.println(ex.randomarray());

        int r = 0;
        String s = "";
        if (args.length == 0) {
            s = "text";
            r = 100;
        }
        test rt = new test();
        System.out.println(rt.repString(s, r));
        String s1 = rt.repString(s, r);


        String strpoly = "";
        if (args.length == 0) {
            strpoly = "abbaa";
        }
        test t = new test();
        System.out.println(t.polyndrom(strpoly));




        String str1 = "";
        String str2 = "";
        int n = 0;
        if (args.length == 0) {
            str1 = "&^%";
            str2 = "@#$";
            n = 2;
        } else {
            str1 = args[0];
            str2 = args[1];
            n = 0;
        }
        test as = new test();
        System.out.println(as.returnstring(str1, str2, n));


        String baseURL = "";
        String params = "";
        if (args.length == 0) {
            baseURL = "https://example.com/search?";
            params = "query=java&sort=desc&filter=null";
        } else {
            baseURL = args[0];
            params = args[1];
        }

        String[] headers = {};
        String[][] data = {};
        if (args.length == 0) {
            headers = new String[]{"Name", "Age", "City"};
            data = new String[][]{
                    {"John", "30", "NewYork"},
                    {"Alice", "25", "LosAngeles"},
                    {"Bob", "35", "Chicago"}
            };
        }
        CSV anw = new CSV();
        System.out.println(anw.CreateArrays(headers, data));

        String text = "";
        if (args.length == 0) {
            text = "line1\n\nline2\n\nline3";
        } else {
            text = args[0];
        }
        int[] arrg = {};
        if (args.length == 0) {
            arrg = new int[]{2, 12, 54, 7, 9, 0};
        } else {
            arrg = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        logs lg = new logs();
        lg.MinMax(arrg);
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {

            String ln;
            while ((ln = br.readLine()) != null) {
                System.out.println(ln);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        EmptyString es = new EmptyString();
        System.out.println(es.returnStrings(text));




        test wr = new test();
        wr.writeString("text.txt", s1);

        Writter(".", "less2.txt");
        task1();
        cycly();
        System.out.println(task3());
        task4();

    }
}