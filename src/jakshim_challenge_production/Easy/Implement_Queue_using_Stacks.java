package jakshim_challenge_production.Easy;

import java.util.Stack;


/**
 * 문제: 두 개의 Stack (LIFO방식)을 이용해 Queue (FIFO방식)를 구현하고 동작을 테스트
 *
 * 상세설명:
 * - Queue는 FIFO(First In, First Out) 특성을 가진다.
 * - Stack은 LIFO(Last In, First Out) 특성을 가진다.
 * - 두 개의 Stack(inStack, outStack)을 사용해 '두 번 뒤집기' 원리로 FIFO를 구현한다.
 *   · push(enqueue): inStack에만 푸시
 *   · pop/deque & peek: outStack이 비었을 때만 inStack → outStack으로 모두 옮겨 순서 역전
 *     → outStack의 top이 Queue의 front가 된다.
 *
 * 풀이방식(핵심 아이디어):
 * - shift(): outStack이 비어 있을 때 inStack의 모든 요소를 꺼내 outStack에 넣는다(순서 역전).
 * - pop/peek 전마다 shift()를 호출해 front를 outStack.top으로 맞춘다.
 *
 * 시간복잡도:
 * - push: O(1)
 * - pop/peek: 평균(Amortized) O(1), 최악 O(n) (outStack이 비어 있을 때만 대량 이동)
 */
class MyQueue {

    // 1) 입력 전용 스택(새 원소를 받는 곳), 2) 출력 전용 스택(꺼낼 때 사용하는 곳)
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    // 1. 초기화: 두 스택 생성
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // 2. enqueue: 새 데이터는 inStack에만 push (O(1))
    public void push(int data) {
        inStack.push(data);
    }

    // 3. dequeue: outStack이 비었으면 inStack→outStack 이동(역전) 후 pop
    public int pop() {
        prepareOutStack();
        return outStack.pop();
    }

    // 4. front 조회: outStack이 비었으면 inStack→outStack 이동(역전) 후 peek
    public int peek() {
        prepareOutStack();
        return outStack.peek();
    }

    // 5. 비었는지 확인: 두 스택 모두 비어 있어야 true
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // 6. 핵심 보조 동작: outStack이 비어 있을 때만 inStack의 모든 요소를 outStack으로 옮겨 '순서 역전'
    private void prepareOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

public class Implement_Queue_using_Stacks {
    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();

        // 데이터 넣기
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        // peek 확인
        System.out.println("peek: " + myQueue.peek());

        // pop 순서 확인 (FIFO)
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());

        // 다시 데이터 넣기
        myQueue.push(4);
        myQueue.push(5);

        // peek & pop
        System.out.println("peek: " + myQueue.peek());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());
        System.out.println("pop: " + myQueue.pop());

        // empty 확인
        System.out.println("empty: " + myQueue.empty());
    }
}
