package GAME_SecretOfHogwarts.Item;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Player.Player;

public class UseItem {
    GameAssist GA = new GameAssist();
    public String 이름;
    String[] 플레이어회복 = {"체력", "마력", "체마"};
    public void 포션사용(Player player, Potion 포션[], int 포션입력) {
        if (player.플레이어포션[포션입력 - 1] > 0 && player.체력 < player.풀체) {
            GA.게임진행대사("현재" + 포션[포션입력 - 1].아이템이름 + "을 사용하겠습니까? \n" +
                    "(" + player.플레이어포션[포션입력 - 1] + "개 남음)\n" +
                    "(1) 예\n" +
                    "(2) 아니오 ");

            int 숫자입력 = GA.번호입력(":", 2);
            if (숫자입력 == 1) {
                player.체력 += 포션[포션입력 - 1].회복;
                if (player.체력 >= player.풀체) {
                    player.체력 = player.풀체;
                    GA.게임진행대사("");
                    GA.아무키나();
                }
                GA.화면클리어();
                GA.게임진행대사(포션[포션입력 - 1].아이템이름 + "을 사용했다.");
                GA.아무키나();
            }
        } else if (player.플레이어포션[0] == 0) {
            GA.게임진행대사("현재 가지고 있는 " + 포션[포션입력 - 1].아이템이름 + "이 없습니다.");
            GA.아무키나();
        } else {
            GA.게임진행대사("이미 " + 플레이어회복[포션입력 - 1] + "이 넘칩니다.!");
        }
    }

    public void 아이템착용(Player player,Item item){
        if (item instanceof NormalItem) {
            NormalItem normalItem = (NormalItem) item;
            player.풀체 += normalItem.체력증가;
            player.풀마 += normalItem.마력증가;

        } else if (item instanceof RareItem) {
            RareItem rareItem = (RareItem) item;
            player.풀체 += rareItem.체력증가;
            player.풀마 += rareItem.마력증가;
            player.공격력 += rareItem.공격력증가;
            player.방어력 += rareItem.방어력증가;

        } else if (item instanceof UniqueItem) {
            UniqueItem uniqueItem = (UniqueItem) item;
            player.풀체 += uniqueItem.체력증가;
            player.풀마 += uniqueItem.마력증가;
            player.공격력 += uniqueItem.공격력증가;
            player.방어력 += uniqueItem.방어력증가;
            player.마법공격력 += uniqueItem.마법공격력증가;
        }
    }
    public void 아이템해제(Player player,Item item){
        if (item instanceof NormalItem) {
            NormalItem normalItem = (NormalItem) item;
            player.풀체 -= normalItem.체력증가;
            player.풀마 -= normalItem.마력증가;

        } else if (item instanceof RareItem) {
            RareItem rareItem = (RareItem) item;
            player.풀체 -= rareItem.체력증가;
            player.풀마 -= rareItem.마력증가;
            player.공격력 -= rareItem.공격력증가;
            player.방어력 -= rareItem.방어력증가;

        } else if (item instanceof UniqueItem) {
            UniqueItem uniqueItem = (UniqueItem) item;
            player.풀체 -= uniqueItem.체력증가;
            player.풀마 -= uniqueItem.마력증가;
            player.공격력 -= uniqueItem.공격력증가;
            player.방어력 -= uniqueItem.방어력증가;
            player.마법공격력 -= uniqueItem.마법공격력증가;
        }
    }
}
