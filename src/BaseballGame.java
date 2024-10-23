import java.util.*;

public class BaseballGame {

    public BaseballGame() {
        Random random = new Random();
        Set<Integer> NumberGenerator = new HashSet<>();

        while (NumberGenerator.size() < 3) {
            int number = random.nextInt(9) + 1; // 1부터 9 사이의 숫자
            NumberGenerator.add(number);
        }
        // 객체 생성시 랜덤 3자리 수의 정답을 만든다. ..? ㅠㅠ
        // System.out.println("생성된 3자리 수: " + NumberGenerator);
    }

//    public int play() {
//        while (true) {
//            // 1. 사용자에게 입력값을 받는다.
//            // 2. 올바른 입력값을 받았는지 검증
//            // 3. 게임 진행횟수 증가
//            // 4. 스트라이크 개수 계산
//            // 5. 정답여부 확인, 만약 정답이면 break를 이용해 반복문 종료
//            // 6. 볼 개수 계산
//            // 7. 힌트 출력
//        }
//        // 게임 진행횟수 반환
//    }
//    protected boolean validateInput(String input) {
//
//    }
//    private int countStrike(String input) {
//
//    }
//
//    private int countBall(String input) {
//        return 0;
//    }
}
