package lesson1;

    class Answer {
        public int findMaxOfTwo(int a, int b) {
            int max = a;
            if (b > max) {
                max = b;
            }
            return max;
        }
        public int findMaxOfThree(int a, int b, int c) {

            return findMaxOfTwo(findMaxOfTwo(a, b), c);
        }
        public int SumNumbers(int m) {
            int res = 0;

            while (m > 0) {
                res += m % 10;
                m = m / 10;
            }

            return res;
        }
        public void PrintNums() {

            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
        public int factorial(int n) {


            if (n < 0) {
                return -1;
            }
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;

        }

    }

public class Printer {
    public static void main(String[] args) {

        int n = 5;
        if (args.length > 0)
        {
            n = Integer.parseInt(args[0]);
        }

        int m = 325;
        if (args.length > 0)
        {
            m = Integer.parseInt(args[0]);
        }
        int a = 2, b = 4, c = 6;
        if (args.length == 3)
        {
            a = Integer.parseInt((args[0]));
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);

        }

        Answer ans = new Answer();

        int itresume_res = ans.factorial(n);
        System.out.println(itresume_res);

        ans.PrintNums();

        int ss = ans.SumNumbers(m);
        System.out.println();
        System.out.println(ss);

        int res = ans.findMaxOfThree(a, b, c);
        System.out.println(res);

    }
}