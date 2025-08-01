package ProjectEuler;

import java.util.Scanner;

/**
 * 출처 : https://euler.synap.co.kr/problem=1
 * 문제1 : 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면?
 * 상세설명
 * - 10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
 * - 1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
 * 풀이방식
 * - 포함배제의 원리 (+등차수열 합 공식)
 */
public class Problems_1_v2 {
    public static void main(String[] args) {
        int limit = 1000;
        int sum = (sumMultiples(3, limit) + sumMultiples(5, limit)) - sumMultiples(15, limit); // 3과 5의 최소공배수인 15의 배수를 빼줌 (포함-배제 원리)

        System.out.println(sum);
    }

    //limit 미만의 number의 배수 합을 구하는 함수
    private static int sumMultiples(int number, int limit) {
        int count = (limit - 1) / number;         // 배수의 개수 계산
        return number * count * (count + 1) / 2;  // 등차수열의 합 공식 이용
    }
}