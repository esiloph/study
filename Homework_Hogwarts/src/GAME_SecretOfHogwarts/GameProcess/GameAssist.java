package GAME_SecretOfHogwarts.GameProcess;

import java.util.Scanner;

public class GameAssist {
    Scanner sc = new Scanner(System.in);

    public void 게임제목(){
        화면클리어();
        System.out.println("                                                                                                            ");
        System.out.println(" #######  ##     ## ########     ####    ########    #####   ######  #######  #########    #######  ########");
        System.out.println("    ##    ##     ## ##          ##   ##  ##        ##    ## ##    ## ##          ##       ##     ## ##      ");
        System.out.println("    ##    ##     ## ##          ##       ##       ##       ##     ## ##          ##       ##     ## ##      ");
        System.out.println("    ##    ######### ######       ######  ######   ##       ########  ######      ##       ##     ## ######  ");
        System.out.println("    ##    ##     ## ##                ## ##       ##       ##   ##   ##          ##       ##     ## ##      ");
        System.out.println("    ##    ##     ## ##          ##    ## ##       ##    ## ##    ##  ##          ##       ##     ## ##      ");
        System.out.println("    ##    ##     ## ########     ######  ########  ######  ##     ## ########    ##        #######  ##      ");
        System.out.println("                                                                                                            ");
        System.out.println("            ##     ##  #######   ######   ##      ##    ###    ########  ########  ######                   ");
        System.out.println("            ##     ## ##     ## ##    ##  ##  ##  ##   ## ##   ##     ##    ##    ##    ##                  ");
        System.out.println("            ##     ## ##     ## ##        ##  ##  ##  ##   ##  ##     ##    ##    ##                        ");
        System.out.println("            ######### ##     ## ##   #### ##  ##  ## ##     ## ########     ##     ######                   ");
        System.out.println("            ##     ## ##     ## ##    ##  ##  ##  ## ######### ##   ##      ##          ##                  ");
        System.out.println("            ##     ## ##     ## ##    ##  ##  ##  ## ##     ## ##    ##     ##    ##    ##                  ");
        System.out.println("            ##     ##  #######   ######    ###  ###  ##     ## ##     ##    ##     ######                   ");
        System.out.println("                                                                                                            ");

        for (int i = 0; i < 5; i++)
            System.out.println();
        아무키나();
        화면클리어();
        게임진행대사("              호그와트의 비밀  \n" +
                   "      자바 기초 4주차 클래스의 이해 (상속)\n" +
                   "      BY Hwang FOR TeamNova Homework ");

        아무키나();
        화면클리어();
    }

    public void 화면클리어() {                                         //화면 내에 내용을 클리어 시키는 메소드 (화면을 넘기는 효과)
        for (int i = 0; i < 30; i++)
            System.out.println();
    }
    public void 중간띄우기() {
        for (int i = 0; i < 5; i++)
            System.out.println();
    }
    public void 절취선(int n) {                                       // 절취선 출력하는 메소드
        for (int i = 0; i < n; i++)
            System.out.print("■");
        System.out.println();
    }
    public void 별절취선(int n){
        for (int i = 0; i < n; i++)
            System.out.print("☆★");
        System.out.println();
    }
    public void 정보알림(String 정보){
        별절취선(15);
        System.out.println("\n"+정보+"\n");
        별절취선(15);
    }
    public void 게임진행대사(String 대사) {                           // 게임 진행하는 대사를 출력하는 메소드
        절취선(30);
        System.out.println("\n"+대사+"\n");
        절취선(30);
        for (int i = 0; i < 5; i++)
            System.out.println();
    }
    public void 아무키나() {                                          //아무키나 눌러서 다음 상황으로 진행하는 메소드
        System.out.println("\n 아무 키를 누르고 Enter를 눌러주세요...!");
        sc.next();
    }
    public int 번호입력(String 땡땡, int 숫자) {                        // 번호 입력하는 메소드
        int 숫자입력;
        do {
            System.out.println(땡땡);
            try {
                숫자입력 = Integer.parseInt(sc.next());
            } catch (Exception e) {
                숫자입력 = -1;
                System.out.println("      제대로 말씀해주세요!");
            }
        } while (숫자입력 < 1 || 숫자입력 > 숫자);
        return 숫자입력;
    }
    public void 죽음(){
        화면클리어();
        게임진행대사("       아쉽게도 플레이어가 죽음을 맞이했습니다.");
    }

}
