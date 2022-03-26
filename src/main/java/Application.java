import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] array = randomArray(5);
        String[] sArray = new String[] {"green", "aquamarine", "yellow", "red", "purple", "celadon"};
        maxMinAverage(array);
        System.out.println("Сортируем от минимального к максимальному");
        sortingArray(array);
        sqrtEqu(14,-5,-1);
        sqrtEqu(9, -30, 25);
        sqrtEqu(2,1,67);
        longString(sArray);
        replacementString("Test text for replacement words", "or");
        System.out.println("");
        System.out.println(palindrome("racecar"));
        int[] array2 = {5, 4, 3, 5, 6, 7, 8, 2, 1, 5, 6, 7, 8};
        System.out.println(Arrays.toString(deleteNumbers(array2, 5)));
    }

    public static int[] randomArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) Math.round(Math.random() * 100);
            System.out.print(array[i] + " ");
        } System.out.println();
        return array;
    }
    public static void maxMinAverage(int[] array) {
        int max = 0, min = array[0], Ave = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])  max = array[i];
            if (min > array[i])  min = array[i];
            Ave += array[i];
        }
        Ave = Ave / array.length;
        System.out.println("Максимальное число = " + max);
        System.out.println("Минимальное число = " + min);
        System.out.println("Среднее значение в массиве = " + Ave);
    }
    public static void sortingArray(int[] array){
        int change = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    change = array[j];
                    array[j] = array[j+1];
                    array[j+1] = change;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " "); // вывод отсортировонного массива в консоль
        }
        System.out.println();
    }
    public static void sqrtEqu(double a, double b, double c){
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0 ");
        double result, result2;
        double d = b * b - 4 * a * c;
        if (d < 0) {System.out.println("Нет действительных корней");}
        else if (d == 0) {
            result = (-b / (2 * a));
            System.out.println("x1 = x2 = " + result);}
        else if (d > 0) {
            result = (-b + Math.sqrt(d)) / (2 * a);
            result2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("x1 = " + result + " x2 = " + result2);
        }
    }
    public static void longString(String[] array){
        String Max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (Max.length() < array[i].length())  {
                Max = array[i];
            }
        }
        System.out.println("Самое длинная строка это - " + Max);
    }
    public static void replacementString(String word, String line) {
        char[] wd = word.toCharArray();
        char[] ln = line.toCharArray();
        char[] reverse = new char[ln.length]; // другую подстроку придумал как перевернутые символы
        // можно вставить любой массив другой.
        int b = ln.length - 1;
        for (int i = 0; i < ln.length; i++) {
            reverse[b] = ln[i];
            b--;
        }
        int q = 0;
        int k = 0;
        int startPos = 0;
        for (int i = 0; i < wd.length; i++) {
            q = 0;
            if (wd[i] == ln[k]) {
                startPos = i;
                ++q; ++k; ++i;
                while (wd[i] == ln[k] && k < ln.length && i < wd.length) {
                    q++; ++i; if (k < ln.length - 1) {k++;}
                }
                if (q == ln.length) {
                    for (int j = 0; j < ln.length; j++) {
                        wd[startPos] = reverse[j];
                        ++startPos;
                    } k = 0;
                } else {
                    q = 0;
                    k = 0;
                }
            }
        }
        for (int i = 0; i < wd.length; i++) {
            System.out.print(wd[i]);
        }
    }
    public static boolean palindrome(String word){
        char[] wd = word.toCharArray();
        int k = wd.length - 1, i = 0, n = 0, j = 0;
        if (wd.length % 2 == 0) {
            j = (int) wd.length / 2;
        } else  j = (int) (wd.length / 2) + 1;
        while (wd[i] == wd[k]){
            if (n != j) {n++; i++; k--;} else break;
        }
        return j == n;
    }
    public static int[] deleteNumbers(int[] numbers, int d){
        int k = 0, j = 0;
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == d) {
                k++;
            }
        }
        int[] newArray = new int[numbers.length - k];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != d) {
                newArray[j] = numbers[i];
                j++;
            }
        }
        return newArray;
    }
}


