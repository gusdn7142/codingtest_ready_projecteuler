package jakshim_challenge_production.Bronze;

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
public class 문자열_분석 {
    public static void main(String[] args) {
        // 1. 입력 준비
        Scanner scanner = new Scanner(System.in);
        StringBuilder resultStrBuilder = new StringBuilder();

        // 2. 줄 단위로 입력 받으며 카운트
        while (true) {
            String lineStr = scanner.nextLine();

            // 빈 줄이면 종료
            if (lineStr.trim().isEmpty()) break;

            // 문자 종류별 개수 초기화
            int lowerCaseCnt = 0;
            int upperCaseCnt = 0;
            int digitCnt = 0;
            int whiteSpaceCnt = 0;

            // 3. 문자 하나씩 파싱해서 카운트
            for (int i = 0; i < lineStr.length(); i++) {
                char ch = lineStr.charAt(i);

                if (Character.isLowerCase(ch)) lowerCaseCnt++;
                else if (Character.isUpperCase(ch)) upperCaseCnt++;
                else if (Character.isDigit(ch)) digitCnt++;
                else if (Character.isWhitespace(ch)) whiteSpaceCnt++;
            }

            // 4. 결과 종합
            resultStrBuilder
                    .append(lowerCaseCnt).append(" ")
                    .append(upperCaseCnt).append(" ")
                    .append(digitCnt).append(" ")
                    .append(whiteSpaceCnt).append("\n");
        }

        // 5. 전체 결과 출력
        System.out.print(resultStrBuilder);
        scanner.close();
    }
}
