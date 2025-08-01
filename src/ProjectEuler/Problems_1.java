package ProjectEuler;

import java.util.Scanner;

/**
 * 출처 : https://euler.synap.co.kr/problem=1
 * 문제1 : 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면?
 * 상세설명
 * - 10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
 * - 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
 * 풀이방식
 * - 배수의 법칙 역이용 (3*4=12 --> 12%3=0)
 */
public class Problems_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for(int naturalNum = 1; naturalNum < 1000; naturalNum++) {
            if(naturalNum % 3 == 0 || naturalNum % 5 ==0){
                sum += naturalNum;
            }
        }
        
        System.out.println(sum);
    }
}