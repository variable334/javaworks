import lesson2.test;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

class CSV{
    public static String CreateArrays(String[]headers,String[][]data){
      StringBuilder sb = new StringBuilder();
      sb.append(String.join(",",headers)).append("\n");
      for(String[]row:data){
            sb.append(String.join(",",row)).append("\n");
          System.out.println(Arrays.toString(row));
      }
      return sb.toString().trim();
    }
}
class EmptyString{
    public static StringBuilder returnStrings(String text){
        StringBuilder str = new StringBuilder();
        String[]pairs=text.split("\n");
        for (int i = 0; i < pairs.length; i++)
        {
            if(!pairs[i].isEmpty())
            {
                if(str.length()>0) {
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
                WriteLogFiles(min,max);
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

    public static void main(String[] args) throws IOException {

        int r = 0;
        String s = "";
        if(args.length==0){
            s = "text";
            r = 100;
        }
        test rt = new test();
        System.out.println(rt.repString(s,r));
        String s1 = rt.repString(s,r);

        String strpoly="";
        if(args.length==0){
            strpoly = "abbaa";
        }
        test t = new test();
        System.out.println(t.polyndrom(strpoly));
        String repStr = "";
        if(args.length==0){
            repStr = "aaaabbbcccdddd";
        }
        else {
            repStr = args[0];
        }
        test ac = new test();
        System.out.println(ac.countchars(repStr));

        String str1= "";
        String str2= "";
        int n =0;
        if (args.length==0) {
            str1 = "&^%";
            str2 = "@#$";
            n = 2;
        }
        else {
            str1 =args[0];
            str2=args[1];
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
        String []headers = {};
        String [][] data = {};
        if(args.length==0){
            headers=new String[]{"Name","Age","City"};
            data =new String[][]{
                {"John","30","NewYork"},
                {"Alice","25","LosAngeles"},
                {"Bob","35","Chicago"}
                };
        }
        CSV an = new CSV();
        System.out.println(an.CreateArrays(headers,data));

        String text = "";
        if(args.length==0){
            text = "line1\n\nline2\n\nline3";
        }
        else{
            text = args[0];
        }
        int[] arr = {};
        if(args.length==0) {
            arr= new int[]{2,12,54,7,9,0};
        }
        else {
                arr = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        logs lg = new logs();
        lg.MinMax(arr);
        try(BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {

            String ln;
            while ((ln = br.readLine())!= null){
                System.out.println(ln);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        EmptyString es = new EmptyString();
        System.out.println(es.returnStrings(text));

        test wr = new test();


        wr.writeString("text.txt",s1);

//        Writter(".", "less2.txt");
//        task1();
//        cycly();
//        System.out.println(task3());
//        task4();

    }
}