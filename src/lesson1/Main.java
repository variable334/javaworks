package lesson1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main{
    public static void main(String[]args) throws IOException {
        task1();
        cycly();
        System.out.println(task3());
        task4();

    }


public static void task4()throws IOException {
    FileWriter fw = new FileWriter("out.txt");
    fw.write("hello");
    fw.flush();
    fw.close();


}
    public static String task3(){
        String s1 ="";

        String s = "Добро пожаловать на курс java";
        String[] splits = s.split(" ");
        for (int i = splits.length-1; i >=0 ; i--) {
//            System.out.print(splits[i] + " ");
              s1 += splits[i] + " ";

        }
    return s1;
    }

    public static void cycly(){
        while (true){
        task2();
        }


    }
public static void task2(){

    Scanner sc = new Scanner(System.in);
    System.out.println("enter your name: ");
    String name = sc.next();
    if(name.startsWith("q")) System.exit(0);
    if(name.startsWith("Na")){
        System.out.println("Are you Nail?");
    }else if(name.startsWith("Bob")){
        System.out.println("Are you Bob?");
    }else {
        System.out.println("Hello " + name + "!");
    }


    System.out.println("Hello " + name +"!");
}

    private static void task1(){
        LocalTime nows = LocalTime.now();
        LocalDateTime dtime = LocalDateTime.now();
        System.out.println(nows);
        System.out.println(dtime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Дата: dd MMMM yyyy г., время: HH ч. mm мин. ss сек.");
        System.out.println(formatter.format(LocalDateTime.now()));


    }
}