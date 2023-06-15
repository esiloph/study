package GAME_SecretOfHogwarts.BattleProcess;

import GAME_SecretOfHogwarts.Enemy.Monster;
import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Player.Player;

public class Battle {
    GameAssist GA =new GameAssist();
    public void 일반공격(Player player, Monster monster){
        GA.게임진행대사("지팡이를 휘둘렀다.");
        GA.아무키나();
        int 데미지 = player.일반공격() - monster.방어();
        int 받은데미지 = monster.일반공격() - player.방어();

        if (받은데미지 < 0) {
            데미지 -= 받은데미지;
            받은데미지 = 0;
        }
        if (데미지 < 0)
            데미지 = 0;
        player.체력 -= 받은데미지;
        monster.체력 -= 데미지;
        GA.화면클리어();
        GA.게임진행대사("전투에서 " +
                "\n당신은 " + monster.이름 + "에게 " + 데미지 + " 피해를 주었고," +
                "\n당신은 " + monster.이름 + "에게 " + 받은데미지 + " 피해를 받았다!!!");
        GA.아무키나();
    }
    public void 마법공격(Player player, Monster monster, MagicSpell[] 마법주문, int 마법입력){
        GA.정보알림(player.마법주문[마법입력 - 1].이름 + "!!!");
        GA.아무키나();
        if (player.마력 >= player.마법주문[마법입력 - 1].마력소모) {
            GA.정보알림(player.마법주문[마법입력 - 1].시전);
            int 데미지 = player.마법주문[마법입력 - 1].데미지 - monster.방어();
            int 받은데미지 = monster.일반공격() - player.방어();

            if (받은데미지 < 0) {
                데미지 -= 받은데미지;
                받은데미지 = 0;
            }

            if (데미지 < 0) {
                데미지 = 0;
            }

            player.체력 -= 받은데미지;
            player.마력 -= player.마법주문[마법입력 - 1].마력소모;
            monster.체력 -= 데미지;

            GA.정보알림("전투에서 " +
                    "\n당신은 " + monster.이름 + "에게 " + 데미지 + " 피해를 주었고," +
                    "\n당신은 " + monster.이름 + "에게 " + 받은데미지 + " 피해를 받았다!!!");
            GA.아무키나();
        } else {
            int 받은데미지 = monster.일반공격();
            GA.정보알림("마력이 충분하지 않습니다.\n" +
                    "몬스터의 습격을 받아 " + 받은데미지 + "만큼의 데미지를 받았다!");
            GA.아무키나();
        }
    }
    public void 전투결과(Player player, Monster monster){
        GA.화면클리어();
        player.경험치 += monster.경험치;
        GA.게임진행대사(monster.이름 + "를(을) 쓰러뜨렸다!!\n" +
                monster.경험치 + "의 경험치를 얻었다!!!");

        boolean 휴식추가 = (Math.random() * 5 + 1 < 2.25);
        int 얻은골드 = (int) (Math.random() * monster.경험치);
        if (휴식추가) {
            player.남은휴식횟수++;
            GA.정보알림("휴식을 취할 수 있는 시간을 얻었다.");
        }
        if (얻은골드 > 0) {
            player.골드 += 얻은골드;
            GA.정보알림(monster.이름 + "에게서 " + 얻은골드 + " 골드를 얻었다!!!");
        }
        GA.아무키나();
    }
    public void 도망(Player player, Monster monster){
        GA.화면클리어();
        if (Math.random() * 10 + 1 <= 3.5) {
            GA.게임진행대사(monster.이름 + "에게서 도망쳤다!");
            GA.아무키나();

        } else {
            GA.게임진행대사(monster.이름 + "에게서 도망치지 못했다.");

            int 받은데미지 = monster.일반공격();
            System.out.println(받은데미지 + "만큼의 데미지를 받았다!");
            GA.아무키나();

            if (player.체력 <= 0) {
                GA.죽음();
            }
        }
    }

}
