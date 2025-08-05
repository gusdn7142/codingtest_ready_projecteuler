package jakshim_challenge_production.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * 출처 : https://www.acmicpc.net/problem/10820
 * 문제 10820 : 문자열 분석
 *
 * 상세설명:
 * 여러 줄의 문자열이 입력되며, 각 줄마다 소문자, 대문자, 숫자, 공백의 개수를 각각 세어 출력하는 문제이다.
 * 문자열의 개수는 주어지지 않으며, 입력이 빈 줄일 경우 종료된다.
 * 각 문자열의 길이는 최대 100자이며, 공백을 포함할 수 있다.
 *
 * 풀이방식:
 * Scanner를 사용해 한 줄씩 입력받는다.
 * 빈 줄이 입력되면 반복을 종료한다.
 * 각 줄에 대해 문자 하나씩 순회하며 Character 클래스의 메서드로 문자의 종류를 판별한다.
 * 각 종류별로 개수를 세어 StringBuilder에 결과를 저장하고, 마지막에 한 번에 출력한다.
 */
public class 문자열_분석_refactoring {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) {
            int lower = 0;
            int upper = 0;
            int digit = 0;
            int space = 0;

            for (char ch : input.toCharArray()) {
                if (Character.isLowerCase(ch)) lower++;
                else if (Character.isUpperCase(ch)) upper++;
                else if (Character.isDigit(ch)) digit++;
                else if (ch == ' ') space++;
            }
            System.out.printf("%d %d %d %d%n", lower, upper, digit, space);
        }

    }
}
