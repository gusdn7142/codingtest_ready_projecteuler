package jakshim_challenge_production.Bronze;

import java.util.Scanner;


/**
 * 출처 : https://www.acmicpc.net/problem/1032
 * 문제1032 : 명령 프롬프트
 * 상세설명
 * - 다수의 파일 이름이 주어졌을 때, 모든 파일 이름에서 공통된 부분은 그대로 출력하고,
 *   서로 다른 문자가 있는 위치는 '?' 문자로 대체하여 출력하는 문제입니다.
 * - 예를 들어, 세 개의 파일 이름이 "config.sys", "config.inf", "config.ini"일 경우,
 *   공통된 부분은 "config."이며, 서로 다른 문자는 마지막 세 자리입니다.
 *   따라서 출력은 "config.???"가 됩니다.
 *
 * 풀이방식
 * - 첫 번째 파일을 기준으로 각 인덱스별 문자를 비교합니다.
 * - 모든 파일에서 해당 인덱스의 문자가 동일하면 해당 문자를 출력하고,
 *   하나라도 다르면 '?'로 대체합니다.
 * - StringBuilder를 사용하여 효율적으로 문자열을 구성
 */
public class 명령_프롬프트 {
    public static void main(String[] args) {

        //📌 Step 1: 입력 받기
        // 1단계: 파일 개수와 이름 목록을 입력받는다
        Scanner scanner = new Scanner(System.in);
        int fileCnt = scanner.nextInt();

        String[] files = new String[fileCnt];
        for (int i = 0; i < fileCnt; i++) {
            files[i] = scanner.next();
        }

        //📌 Step 2: 패턴 비교 준비
        // 2단계: 기준 문자열의 길이만큼 반복하면서 공통 패턴을 만든다
        int firstFileLength = files[0].length();
        StringBuilder pattern = new StringBuilder();


        //📌 Step 3: 인덱스별로 문자 비교
        // 3단계: 각 인덱스 위치의 문자가 모든 파일에서 동일한지 확인
        for (int i = 0; i < firstFileLength; i++) {
            char firstFileChar = files[0].charAt(i); // 첫 파일의 i번째 문자 기준
            boolean currentIndexCharAllSame = true; // 현재 인덱스 문자가 모두 같은지 여부

            for (int j = 1; j < fileCnt; j++) {
                if (files[j].charAt(i) != firstFileChar) {
                    currentIndexCharAllSame = false; // 하나라도 다르면 공통 아님
                    break;
                }
            }

            // 4단계: 공통이면 해당 문자 추가, 다르면 '?' 추가
            if (currentIndexCharAllSame) {
                pattern.append(firstFileChar);
            } else {
                pattern.append('?');
            }
        }

        // 📌 Step 4: 결과 출력
        // 5단계: 최종 패턴 출력
        System.out.println(pattern);
    }
}
