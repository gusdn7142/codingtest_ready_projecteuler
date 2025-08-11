package jakshim_challenge_production.Easy;


import java.util.Scanner;

/**
 * 문제: n 계단을 올라갈 때, 한 번에 1칸 또는 2칸만 오를 수 있다.
 *      꼭대기(정확히 n칸)에 도달하는 서로 다른 방법의 수를 구하라. (LeetCode 70)
 *
 * 상세설명:
 * - 입력: 정수 n (1 ≤ n ≤ 45)
 * - 이동 규칙: 매 스텝마다 1칸 또는 2칸 이동 가능
 * - 출력: 서로 다른 경로(방법)의 개수
 * - 점화식: f(n) = f(n-1) + f(n-2)
 *   · 마지막 이동이 1칸 → 이전 상태는 (n-1)칸까지의 경우의 수
 *   · 마지막 이동이 2칸 → 이전 상태는 (n-2)칸까지의 경우의 수
 * - 초기값: f(1) = 1, f(2) = 2
 * - 구조: 피보나치 수열과 동일 (시작값이 1, 2인 변형)
 *
 * 풀이방식 (핵심 아이디어):
 * - DP(동적 계획법) Bottom-Up 방식으로 f(1)부터 f(n)까지 순차 계산
 * - 배열에 이전 두 계단의 경우의 수를 저장하고 점화식에 따라 갱신
 * - n=1, n=2는 예외 처리로 바로 반환
 *
 * 시간복잡도:
 * - 점화식 계산: O(n)
 * - 각 단계 계산은 O(1) → 전체적으로 O(n)
 *
 * 공간복잡도:
 * - DP 배열 사용 시 O(n)
 * - 변수 2개로 최적화 가능 시 O(1)
 *
 * 예시:
 * - n = 3 → 출력: 3
 *   · 1 + 1 + 1
 *   · 1 + 2
 *   · 2 + 1
 */
public class Climbing_Stairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 계단 개수 입력
        if (N <= 2) {              // 1계단 또는 2계단인 경우 그대로 출력
            System.out.println(N);
            return;
        }

        int[] arr = new int[N + 1]; // DP 배열 (1-based index)
        arr[1] = 1;                 // 1계단 오르는 방법 = 1
        arr[2] = 2;                 // 2계단 오르는 방법 = 2

        // 점화식: f(i) = f(i-1) + f(i-2)
        for (int i = 3; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[N]); // N계단 오르는 방법 출력
    }
}
