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
public class 명령_프롬프트_refactoring {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 📌 파일 이름의 개수 입력
        int fileCnt = sc.nextInt();

        // 📌 첫 번째 파일 이름 입력 (패턴 비교의 기준이 됨)
        String firstFile = sc.next();

        // 패턴 문자열을 만들기 위해 StringBuilder 사용 (문자 하나씩 비교 후 수정 가능)
        StringBuilder patternBuilder = new StringBuilder(firstFile);

        // 📌 나머지 파일 이름 입력 및 문자 비교
        // 첫 번째 파일은 이미 입력받았으므로 나머지 (fileCnt - 1)개 파일 처리
        for(int i = 1; i < fileCnt; i++) {
            String otherFile = sc.next();  // 비교할 파일 이름 입력

            // 각 파일의 문자들을 첫 번째 파일과 한 문자씩 비교
            for(int j = 0; j < firstFile.length(); j++) {
                // 만약 동일한 위치의 문자가 다르다면, 해당 위치를 '?'로 대체
                if(patternBuilder.charAt(j) != otherFile.charAt(j)) {
                    patternBuilder.setCharAt(j, '?');
                }
            }
        }

        // 📌 최종 결과 출력
        // 모든 파일 이름에서 공통된 문자만 유지된 패턴 출력
        System.out.println(patternBuilder);
    }
}
