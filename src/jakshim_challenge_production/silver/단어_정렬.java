package jakshim_challenge_production.silver;

import java.util.*;

/**
 * 문제: 알파벳 소문자 단어 N개를 입력받아
 *      1) 중복을 제거한 뒤
 *      2) 길이 오름차순, 길이가 같으면 사전순으로 정렬하여
 *      3) 한 줄에 하나씩 출력한다. (BOJ 1181)
 *
 * 상세설명:
 * - 입력: 첫 줄에 N(1 ≤ N ≤ 20,000), 이후 N개의 소문자 단어(각 길이 ≤ 50).
 * - 중복 제거: HashSet<String>을 사용해 같은 단어를 한 번만 유지
 * - 정렬 기준: (단어 길이 오름차순) → (사전순 오름차순).
 *   · Comparator에서 길이 비교 후 compareTo로 사전순 비교.
 * - 출력: 정렬된 리스트를 순서대로 StringBuilder에 모아 한 번에 출력.
 * - 입력 처리 주의: Scanner.nextInt() 뒤 남는 개행을 nextLine()으로 소비
 *
 * 풀이방식(핵심 아이디어):
 * - HashSet으로 중복 제거 → ArrayList로 옮겨 정렬(사용자 정의 Comparator) → StringBuilder로 출력.
 *
 * 시간복잡도:
 * - 입력 + 중복 제거: 평균 O(N)
 * - 정렬: O(M log M), (M은 중복 제거 후의 단어 수, M ≤ N)
 * - 비교당 비용: 길이 비교 O(1) + 사전순 비교 O(L), L ≤ 50
 */
public class 단어_정렬 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        Set<String> set = new HashSet<>();         //Set으로 입력받음으로써 중복 제거
        for (int i = 0; i < N; i++)
            set.add(scanner.nextLine().trim());

        List<String> strList = new ArrayList<>(set);

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length(); // 길이순
                }
                return a.compareTo(b); // 사전순
            }
        });

        StringBuilder strBulider = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            strBulider.append(strList.get(i)).append('\n');
        }

        System.out.println(strBulider);
    }
}