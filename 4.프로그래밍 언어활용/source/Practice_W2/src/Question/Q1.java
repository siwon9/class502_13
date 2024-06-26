package Question;

import java.util.Arrays;

// 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다.
// 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때,
// 중앙값을 return 하도록 solution 함수를 완성해보세요.
public class Q1 {
    public static void main(String[] args) {
        int array[] = {1,3,11,8,9};
        System.out.println(solution(array));
    }

    public static int solution(int[] array){
        Arrays.sort(array);
        int middle = array.length/2;

        if(array.length % 2 == 0){
            System.out.println("배열을 홀수단위로 입력하세요");
            return 0;
        }

        return array[middle];
    }
}
