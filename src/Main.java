import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gameCount = 0; // n번째 게임 순번 횟수 초기화
        Map<Integer, Integer> store = new HashMap<>(); // 게임 전체 횟수 기록 -> Map

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기");

            String selection = sc.next(); // 사용자로부터 1, 2, 3 입력 받기
            System.out.println(); // 메뉴와 게임 실행 간의 간격

            switch (selection) {
                case "1": // 1을 입력하면 게임 실행 및 재시작 여부 확인
                    while (true) {
                        BaseballGame game = new BaseballGame(); // 새 야구 게임 생성
                        int attempts = game.play(); // 게임 실행
                        gameCount++;
                        store.put(gameCount, attempts); // Key는 gameCount, Value는 attempts

                        System.out.println("게임을 다시 하시겠습니까? (네/아니오): ");
                        String retry = sc.next(); // 게임 재시작 여부를 확인

                        if (!retry.equalsIgnoreCase("네")) {
                            System.out.println("게임을 종료합니다.");
                            break; // 사용자가 "네"가 아닌 값을 입력 시 반복문 종료
                        }
                    }
                    break;

                case "2": // 2를 입력하면 "게임 기록 보기" 기능. n번째 게임 순번 횟수와 정답을 맞힐 때까지의 게임 시도 횟수
                    if (store.isEmpty()) {
                        System.out.println("아직 기록된 게임이 없습니다."); // 게임을 하기 전에 2번을 선택했을 경우
                    } else {
                        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
                            System.out.println(entry.getKey() + "번째 게임 : 시도 횟수 - " + entry.getValue());
                        } // getKey로 gameCount, getValue로 attmepts 값을 가져오기
                    }
                    break;

                case "3": // 3을 입력하면 게임 종료
                    System.out.println("게임을 종료합니다.");
                    return; // 프로그램 종료

                default: // 잘못된 값 입력 받았을 때.
                    System.out.println("잘못된 선택입니다. 1, 2, 3 중에서 선택하세요.");
            }

            System.out.println(); // 메뉴와 결과 사이의 간격
        }
    }
}

