package exam01;

public class Ex02 {  // 단락회로 평가
    public static void main(String[] args) {
        int num = 10;
        boolean result = ++num > 10 && (num  = num + 10) > 15;
        System.out.println(result);
        System.out.println(num);
        boolean result2 = !result;
        System.out.println(result2); // ! NOT 연산자

    }
}
