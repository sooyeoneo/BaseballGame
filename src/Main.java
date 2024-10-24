import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기");

            String selection = sc.next(); // 사용자로부터 1, 2, 3 입력 받기
            System.out.println(); // 메뉴와 게임 실행 간의 간격

            switch (selection) {
                case "1": // 1을 입력하면 게임 실행 및 재시작 여부 확인
                    while (true) {
                        BaseballGame game = new BaseballGame(); // 새 야구 게임 생성
                        game.play(); // 게임 실행

                        System.out.println("게임을 다시 하시겠습니까? (네/아니오): ");
                        String retry = sc.next(); // 게임 재시작 여부를 확인

                        if (!retry.equalsIgnoreCase("네")) {
                            System.out.println("게임을 종료합니다.");
                            break; // 사용자가 "네"가 아닌 값을 입력 시 반복문 종료
                        }
                    }
                    break;

                case "2": // 2를 입력하면 "게임 기록 보기" 기능 구현 예정
                    System.out.println("게임 기록 보기 기능 보여줄 예정.");
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

