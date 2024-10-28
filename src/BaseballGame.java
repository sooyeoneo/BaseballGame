import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    private final List<Integer> answerNumber; // 랜덤 3자리 수를 저장할 Set
    private final int level; // 난이도에 따른 자리수

    public BaseballGame(int level) {
        this.level = level;
        Random random = new Random();
        Set<Integer> baseballNumber = new LinkedHashSet<>(); // 삽입한 순서를 유지

        while (baseballNumber.size() < level) {
            int number = random.nextInt(9) + 1; // 1부터 9 사이의 숫자
            baseballNumber.add(number);
        }
        answerNumber = new ArrayList<>(baseballNumber); // set은 순서보장이 안됨. list로 index 사용
        // 객체 생성시 랜덤 3자리 수의 정답을 만든다.
        System.out.println("생성된 3자리 수: " + baseballNumber); // 랜덤 3자리 수 확인
        // System.out.println("생성된 3자리 수: " + answerNumber);
    }

    public int play() {

        Scanner sc = new Scanner(System.in); // 사용자에게 입력값을 받는다.
        int attempts = 0; // 정답을 맞힐 때까지의 게임 시도 횟수

        while (true) {
            System.out.println("< 게임을 시작합니다 >");
            System.out.println("숫자를 입력하세요 (중복되지 않은 3자리 수) : ");
            String userInput = sc.next(); // 문자열로 입력 받는다.


            if (userInput.length() != level) {
                System.out.println("잘못된 입력입니다. 3자리 숫자를 입력하세요.");
                continue; // 조건이 맞지 않으면 다시 입력 받기
            }

            // 입력된 문자열을 문자 배열로 바꾸고 각각의 문자를 숫자로 변환
            Set<Integer> userNumberSet = new LinkedHashSet<>();
            boolean isDigit = true; // 숫자 여부를 확인하는 boolean 변수 초기값 true

            for (char digit : userInput.toCharArray()) { // 각 문자를 하나씩 분리
                if (!Character.isDigit(digit)) {
                    System.out.println("올바른 숫자를 입력하세요.");
                    isDigit = false;
                    break;
                }
                userNumberSet.add(Character.getNumericValue(digit)); // 문자를 숫자로 변환
                System.out.println("Character.isDigit(digit) = " + Character.isDigit(digit));
            } // 예외 처리 : 숫자가 아닌 값이 들어왔을 때
            if (!isDigit) {
                continue;
            }

            // 중복된 숫자가 있으면 다시 입력 받기
            if (userNumberSet.size() != level) {
                System.out.println("중복된 숫자를 입력할 수 없습니다.");
                continue; // 중복된 숫자는 다시 입력 받기
            }

            int strike = 0;
            int ball = 0;
            int out = 0;
            List<Integer> userNumberList = new ArrayList<>(userNumberSet);
            // 반환된 사용자 입력과 랜덤으로 생성된 수 비교하기
            for (int userNumberIdx = 0; userNumberIdx < userNumberList.size(); userNumberIdx++) {
                int userNumber = userNumberList.get(userNumberIdx);
                // boolean isMatchedNumber = false;
                for (int answerNumberIdx = 0; answerNumberIdx < this.answerNumber.size(); answerNumberIdx++) {
                    int number = this.answerNumber.get(answerNumberIdx);
                    if (userNumber == number) {
                        // isMatchedNumber = true;
                        if (userNumberIdx == answerNumberIdx) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
                if (strike == 0 && ball == 0) { // (!isMatchedNumber)
                    out++;
                }
            }
            attempts++; // 정답을 맞힐 때까지의 게임 시도 횟수 증가

            if (strike > 0 || ball > 0) {
                System.out.println("스트라이크 : " + strike + " 볼 : " + ball); // 스트라이크 개수, 볼 개수
            } else {
                System.out.println("아웃"); // out 출력
            }


            // 정답을 맞춘 경우 게임 종료
            if (strike == level) {
                System.out.println("축하합니다! 정답입니다! " + attempts + "번 만에 맞췄습니다.");
                break;
            }
        }
        return attempts; // 게임 시도 횟수 반환
    }
}
