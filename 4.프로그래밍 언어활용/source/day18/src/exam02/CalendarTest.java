package exam02;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CalendarTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("년 월 입력:");
            String input = sc.nextLine(); // 2024 5

            if (input.equals("exit")) {
                System.out.println("종료 합니다.");
                break;
            }

            try {
                String[] data = input.split("\\s+");
                int year = Integer.parseInt(data[0]);
                int month = Integer.parseInt(data[1]);

                System.out.printf("---- %d년 %d월 ----%n", year, month);
                System.out.println("S  M  T  W  T  F  S");

                int[] days = getCalendar(year,month);
                System.out.println(Arrays.toString(days));

            } catch (Exception e) { // 숫자 형식 오류가 발생한 경우
                System.out.printf("입력 형식이 잘못됐습니다. 입력 예시 : 2024 5%n");
            }
        }
    }

    public static int[] getCalendar(int year, int month) {
        /**********************************************/
        /* 1. 매월 1일이 무슨 요일에 시작하는지               */
        /* 2. 매월의 종료일이 무엇인지(30, 31, 28, 29)      */
        /**********************************************/

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        int yoil = startDate.getDayOfWeek().getValue() % 7;  // 0(sun)~6(sat)
        int start = yoil * -1 +1;

        int[] days = IntStream.rangeClosed(start, endDate.getDayOfMonth()).toArray();
        for (int i = 0; i<days.length; i++) {
            int day = days[i];
            if (day>0) {
                System.out.printf("%2d  ", day);
            } else{
                System.out.print("    ");
            }
            if ((i+1) % 7 == 0) {
                System.out.println();
            }
        }

        return days;
    }
}



