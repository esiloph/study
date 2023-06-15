package GAME_SecretOfHogwarts.BattleProcess;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Player.Player;

public class Rest {
    GameAssist GA = new GameAssist();

    public void 기숙사휴식(Player player) {
        GA.화면클리어();
        GA.게임진행대사(" 저기 침대가 보인다. 좀 휴식을 취할까?\n" +
                " (1) 예\n" +
                " (2) 아니오");

        int 숫자입력 = GA.번호입력(":", 2);
        if (숫자입력 == 1) {
            player.체력 = player.풀체;
            player.마력 = player.풀마;
            GA.게임진행대사(" 체력, 마력 모두 회복된 것 같다. 기운이 넘쳐" +
                    "\n 체력 : " + player.체력 +
                    "\n 마력 : " + player.마력);

            GA.아무키나();
            GA.화면클리어();

        } else {
            GA.게임진행대사(" 휴식은 필요없을 것 같아 아직 견딜만 해" +
                    "\n체력 : " + player.체력 +
                    "\n마력 : " + player.마력);
            GA.아무키나();
        }
    }
    public void 휴식(Player player) {
        GA.화면클리어();
        if (player.남은휴식횟수 >= 1) {
            GA.게임진행대사("저기서 조금 쉴 수 있을 것 같다. 휴식을 취할까? (남은 휴식횟수 " + player.남은휴식횟수 + "번 남음)\n" +
                    "(1) 예 \n" +
                    "(2) 아니오 ");

            int 숫자입력 = GA.번호입력(":", 2);
            if (숫자입력 == 1) {
                GA.화면클리어();
                if (player.체력 < player.풀체 || player.마력 < player.풀마) {
                    int 체력회복 = (int) (Math.random() * (player.경험치 / 4 + 1) + 10);
                    int 마력회복 = (int) (Math.random() * (player.경험치 / 4 + 1) + 10);
                    player.체력 += 체력회복;
                    player.마력 += 마력회복;
                    if (player.체력 > player.풀체 || player.마력 < player.풀마) {
                        player.체력 = player.풀체;
                        player.마력 = player.풀마;
                        GA.게임진행대사("휴식을 취했고, 체력과 마력이 회복되었다." +
                                "\n나의 현재 상태는 " +
                                "\n" + player.체력 + "/" + player.풀체 +
                                "\n" + player.마력 + "/" + player.풀마);

                        player.남은휴식횟수--;
                        GA.아무키나();
                    }
                } else {
                    GA.게임진행대사("휴식이 필요없다!");
                    GA.아무키나();
                }
            } else {
                GA.게임진행대사("아직 참을만 해! 휴식은 필요없을 것 같아");
                GA.아무키나();
            }
        }
    }

}
