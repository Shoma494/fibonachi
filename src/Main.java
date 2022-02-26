

public class Main {
    public static int fib1(int n){  //1. рекурсивный метод
            int f;
            if (n==0) return 0;
            if (n == 1) return 1;
            else f = fib1(n - 1) + fib1(n - 2);
            return f;
    }
    ///////////////////////////////////
    public static int fib2(int n) {  //2. метод в цикле
        int f1 = 0;
        int f2 = 1;
        int f=0;
        if (n==0) f=f1;
        if (n==1) f=f2;
        else {
            for (int i = 1; i < n; i++) {
                f = f2 + f1;
                f1 = f2;
                f2 = f;
            }

        }
        return f;
    }
    /////////////////////////////////


    public static void main(String[] args) {
        int n=25;
        System.out.println(fib1(n)); //Расчет рекурсией
        System.out.println(fib2(n)); //Расчет в цикле
        System.out.println(Fibonachi.fib3(n)); //вычисление чисел Фибоначчи с помощью быстрого умножения матриц
        System.out.println(Fibonachi.fib3(n)); //если расчет числа уже производился, оно занесено в мапу, и при повторном вызове берется из мапы




    }
}
