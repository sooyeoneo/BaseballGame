import java.util.*;

public class BaseballGame {
    private final List<Integer> answerNumber; // 랜덤 3자리 수를 저장할 Set

    public BaseballGame() {
        Random random = new Random();
        Set<Integer> baseballNumber = new LinkedHashSet<>(); // 삽입한 순서를 유지

        while (baseballNumber.size() < 3) {
            int number = random.nextInt(9) + 1; // 1부터 9 사이의 숫자
            baseballNumber.add(number);
        }
        answerNumber = new ArrayList<>(baseballNumber); // set은 순서보장이 안됨. list로 index 사용
        // 객체 생성시 랜덤 3자리 수의 정답을 만든다.
        // System.out.println("생성된 3자리 수: " + NumberGenerator);
    }

    public int play() {

        Scanner sc = new Scanner(System.in); // 사용자에게 입력값을 받는다.
        while (true) {
            System.out.println("숫자를 입력하세요 (중복되지 않은 3자리 수) : ");
            String userInput = sc.next(); // 문자열로 입력 받는다.


            if (userInput.length() != 3) {
                System.out.println("잘못된 입력입니다. 3자리 숫자를 입력하세요.");
                continue; // 조건이 맞지 않으면 다시 입력 받기
            }

            // 입력된 문자열을 문자 배열로 바꾸고 각각의 문자를 숫자로 변환
            Set<Integer> userNumberSet = new HashSet<>();
            for (char digit : userInput.toCharArray()) { // 각 문자를 하나씩 분리
                userNumberSet.add(Character.getNumericValue(digit)); // 문자를 숫자로 변환
            }



        }
        // 게임 진행횟수 반환
    }
}
