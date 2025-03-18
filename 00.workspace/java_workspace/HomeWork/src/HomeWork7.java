import java.util.ArrayList;
import java.util.Scanner;

class BaseBall{
    ArrayList<Integer> resList=new ArrayList<>();
    int ballCnt;
    int strikeCnt;
    BaseBall(){
        // 초기값
        ballCnt=0;
        strikeCnt=0;
    }
    void play(int num){
        // 01. 정답 난수로 받기 (중복X)
        int res=(int) (Math.floor(Math.random()*9+1)); // 1~9
        if(resList.contains(res)) {
            res=(int) (Math.floor(Math.random()*9+1)); // 1~9
        }else {
            resList.add(res);
        }

        // 1-1. 사용자 입력 값 num과 비교
        System.out.println("com ["+res+"] | 사용자 ["+num+"]");
        if(num!=res) { // 볼
            System.out.println("**볼**");
            ballCnt++;
        }else { // 스트라이크
            System.out.println("**스트라이크**");
            strikeCnt++;
        }
    }
    boolean result(){
        System.out.println(ballCnt+"개의 볼, "+strikeCnt+"개의 스트라이크");
        if(strikeCnt==3) {
            System.out.println("3 스트라이크를 축하합니다!");
            System.out.println("[게임이 종료되었습니다.]");
            return false;
        }else {
            return true;
        }
    }

}

public class HomeWork7 {
    static int num;
    static ArrayList<Integer> numList=new ArrayList<>();
    public static void check(Scanner scanner) {
        int i;
        while (true) {
            i = scanner.nextInt();

            // 새로입력 값 또는 다시 입력값 i가 numList에 이미 존재 할 때
            if (numList.contains(i)) {
                System.out.println("[이미 존재하는 숫자입니다.]");
                System.out.println("**현재 입력된 숫자**");
                for (int n : numList) {
                    System.out.print("[" + n + "] ");
                }
                System.out.println();
            } else if (i < 1 || i > 9) {
                // 범위 체크
                System.out.println("[1보다 작은 숫자 또는 9보다 큰 숫자는 사용 불가능]");
            } else {
                // 유효한 숫자인 경우
                num = i;
                numList.add(i);
                break; // 유효한 입력이므로 루프 종료
            }
        }
    }

    public static void main(String[] args) {
        boolean isGaming=true;

        while(isGaming) {
            // 사용자 입력값
            Scanner s=new Scanner(System.in);
            // 컴퓨터 입력값
            BaseBall baseBall=new BaseBall();
            for(int i=0;i<3;i++) {
                System.out.print("1~9사이"+(i+1)+"번째 번호 입력: ");
                // 유효성 검사
                check(s);
                baseBall.play(num);
            }
            isGaming=baseBall.result(); // true
            String answer;
            if(isGaming) {
                System.out.println("[한 번더 도전하겠습니까?] (Y/N)");
                answer=s.next();
                if(answer.equals("Y")){
                    // 재 시작시, 사용자의 값을 초기화
                    numList.removeAll(numList);
                    continue;
                }else if(answer.equals("N")) {
                    System.out.println("[게임이 종료되었습니다.]");
                    isGaming=false;
                    s.close(); // 자원 회수
                    break;
                }else {
                    System.out.println("[한 번더 도전하겠습니까?] (Y/N)");
                    answer=s.next();
                }
            }else{ // 스트라이크 3개였을 때
                isGaming=false;
                s.close(); // 자원 회수
                break;
            }
        }
    }
}