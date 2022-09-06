import java.util.Scanner;

public class Main{

Main(String str){

    this.str = str;
}

    public static String str;
    public static int n1;
    public static int n2;
    public static String[] numbers;
    public static int k = 0;
    public static String otv;

    public static String calc(String input) throws Exception{

        Ca.chis(input);
        if (k == 2) {
            if (Integer.parseInt(Ca.res(numbers)) < 1) {
                throw new Exception("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            }
            else {
                otv = Rimsk.Change(Ca.res(numbers));
            }
        }
        else if (k == 0) {
            otv = Ca.res(numbers);
        }
        else if (k == 1){
            throw new Exception("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно");
        }
        return otv;
    }

static class Ca {


    public static void chis(String str) {
        numbers = str.split("[+\\-*/]");
        for (int i = 0; i < numbers.length; i++) {
            for (Rim rimValue : Rim.values()) {
                if (rimValue.toString().equals(numbers[i])) {
                    numbers[i] = rimValue.getNu();
                    k++;
                    break;
                }
            }
        }
    }


    public static String res(String[] nums) throws Exception {
        n1 = Integer.parseInt(nums[0]);
        n2 = Integer.parseInt(nums[1]);

        int gotchis = 0;
        String[] strarr = str.split("");
        for (int i = 0; i < strarr.length; i++) {
            if (strarr[i].equals("-")) {
                gotchis = n1 - n2;
            } else if (strarr[i].equals("/")) {
                gotchis = n1 / n2;
            } else if (strarr[i].equals("+")) {
                gotchis = n1 + n2;
            } else if (strarr[i].equals("*")) {
                gotchis = n1 * n2;
            }
        }
        if (n1 >= 1 & n1 <= 10 && n2 >= 1 & n2 <= 10) {
            return Integer.toString(gotchis);
        } else {
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно");
        }
    }
}
static class Rimsk {

    public static String Change(String a) {
        int b = Integer.parseInt(a);
        String resutlsto;
        String[] desEd = new String[2];
        if (b == 100) {
            resutlsto = "C";
            return resutlsto;
        } else {

            desEd[0] = Integer.toString(b - (b % 10));
            desEd[1] = Integer.toString(b % 10);
            for (int i = 0; i < desEd.length; i++) {
                for (Rim resValue : Rim.values()) {
                    if (resValue.getNu().equals(desEd[i])) {
                        desEd[i] = resValue.toString();
                    }
                }
            }
            var stroka = new StringBuilder();
            for (int j = 0; j < desEd.length; j++) {
                if (!desEd[j].equals("0")) {
                    stroka.append(desEd[j]);
                }
            }
            return stroka.toString();
        }
    }
}

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        System.out.println(calc(str));
    }
}

