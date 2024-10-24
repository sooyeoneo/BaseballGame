import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            BaseballGame game = new BaseballGame(); // 객체 생성
            game.play(); // 게임 실행

            System.out.println("게임을 다시 하시겠습니까? (네/아니오): ");
            String retry = sc.next(); // 게임 재시작 여부를 확인

            if (!retry.equalsIgnoreCase("네")) {
                System.out.println("게임을 종료합니다.");
                break; // 사용자가 "네"가 아닌 값을 입력 시 반복문 종료
            }
        }
    }
}
