package GAME_SecretOfHogwarts.Info;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;

import java.util.Scanner;

public class DefaultSetting {
    Scanner sc = new Scanner(System.in);
    GameAssist GA = new GameAssist();

    public void 이름설정(String 이름) {
        boolean 이름설정 = false;
        //----------------------------------이름 설정 반복문-------------------------------------------
        do {
            GA.게임진행대사("     플레이어의 이름은 " + 이름 + " ... 맞습니까?\n\n" +
                          "  (1) 그렇습니다.\n" +
                          "  (2) 아니요! 다시 말씀드릴게요");
            int 숫자입력 = GA.번호입력(":", 2);
            if (숫자입력 == 1)
                이름설정 = true;
        } while (!이름설정);
    }

    public void 기숙사설정(int 기숙사입력) {
        boolean 기숙사여부 = false;
        do {
            if (기숙사입력 >= 1 && 기숙사입력 <= 4)
                기숙사여부 = true;
        } while (!기숙사여부);
    }
}
