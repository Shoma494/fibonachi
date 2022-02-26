import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

//3., 4. сокращаем использование памяти и выделяем в отдельный класс (реализация метода со stackoverflow).
public class Fibonachi {
    static Map<Integer, BigInteger> fibMap = new HashMap<>();
    // матричное умножение двух матриц размера 2 на 2
    public static BigInteger[][] matrixMultiplication(BigInteger[][] a, BigInteger[][] b) {
        // [a00 * b00 + a01 * b10, a00 * b01 + a01 * b11]
        // [a10 * b00 + a11 * b10, a10 * b01 + a11 * b11]
        return new BigInteger[][]{
                {
                        a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])),
                        a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))
                },
                {
                        a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])),
                        a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))
                },
        };
    }

    // возведение матрицы размера 2 на 2 в степень n
    public static BigInteger[][] matrixPowerFast(BigInteger[][] a, int n) {
        if (n == 0) {
            // любая матрица в нулевой степени равна единичной матрице
            return new BigInteger[][]{
                    {BigInteger.ONE, BigInteger.ZERO},
                    {BigInteger.ZERO, BigInteger.ONE}
            };
        } else if (n % 2 == 0) {
            // a ^ (2k) = (a ^ 2) ^ k
            return matrixPowerFast(matrixMultiplication(a, a), n / 2);
        } else {
            // a ^ (2k + 1) = (a) * (a ^ 2k)
            return matrixMultiplication(matrixPowerFast(a, n - 1), a);
        }
    }

    // функция, возвращающая n-ое число Фибоначчи
    public static BigInteger fib3(int n) {
        if (fibMap.containsKey(n)) {
            System.out.println("Число взято из мапы");
            return fibMap.get(n);

        }

        if (n == 0) {
            return BigInteger.ZERO;
        }
        else {

            BigInteger[][] a = {
                    {BigInteger.ONE, BigInteger.ONE},
                    {BigInteger.ONE, BigInteger.ZERO}
            };
            BigInteger[][] powerOfA = matrixPowerFast(a, n - 1);

            BigInteger nthFibonacci = powerOfA[0][0];
            fibMap.put(n, nthFibonacci);
            return nthFibonacci;
        }
    }




}
