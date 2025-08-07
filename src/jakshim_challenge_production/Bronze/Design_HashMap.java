package jakshim_challenge_production.Bronze;


import java.util.Arrays;



/**
 * 출처 : https://leetcode.com/problems/design-hashmap/
 * 문제 706 : Design HashMap (해시맵 디자인)
 * 상세설명
 * - 내장된 해시 테이블 라이브러리를 사용하지 않고 해시맵 자료구조를 직접 디자인하는 문제입니다.
 * - MyHashMap 클래스는 put(key, value), get(key), remove(key) 메서드를 구현해야 합니다.
 * - put: 키-값 쌍을 삽입하거나, 키가 이미 존재하면 값을 업데이트합니다.
 * - get: 키에 해당하는 값을 반환하며, 매핑된 값이 없으면 -1을 반환합니다.
 * - remove: 키에 해당하는 매핑을 제거합니다.
 *
 * 풀이방식
 * - 배열을 -1로 초기화
 * - key 자체를 배열의 인덱스로 직접 사용하여 데이터에 접근
 */

class MyHashMap {

    int data[];

    public MyHashMap() {
        data = new int[1000000];
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

public class Design_HashMap {
    public static void main(String[] args) {

        // MyHashMap 객체 생성
        MyHashMap myHashMap = new MyHashMap();
        System.out.println("MyHashMap 객체 생성 완료.");
        System.out.println("--- 테스트 시작 ---");

        // 예시 1: put(1, 1)
        myHashMap.put(1, 1);
        System.out.println("put(1, 1) 호출");

        // 예시 1: put(2, 2)
        myHashMap.put(2, 2);
        System.out.println("put(2, 2) 호출");

        // 예시 1: get(1)
        int result1 = myHashMap.get(1);
        System.out.println("get(1) 호출 -> 결과: " + result1 + " (예상: 1)");

        // 예시 1: get(3)
        int result2 = myHashMap.get(3);
        System.out.println("get(3) 호출 -> 결과: " + result2 + " (예상: -1)");

        // 예시 1: put(2, 1) - 값 업데이트
        myHashMap.put(2, 1);
        System.out.println("put(2, 1) 호출 (값 업데이트)");

        // 예시 1: get(2)
        int result3 = myHashMap.get(2);
        System.out.println("get(2) 호출 -> 결과: " + result3 + " (예상: 1)");

        // 예시 1: remove(2)
        myHashMap.remove(2);
        System.out.println("remove(2) 호출");

        // 예시 1: get(2)
        int result4 = myHashMap.get(2);
        System.out.println("get(2) 호출 -> 결과: " + result4 + " (예상: -1)");

        System.out.println("--- 테스트 종료 ---");

    }
}
