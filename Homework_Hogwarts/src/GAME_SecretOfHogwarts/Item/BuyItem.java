package GAME_SecretOfHogwarts.Item;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Player.Player;

public class BuyItem {
    GameAssist GA = new GameAssist();
    public String 이름;

    public void 포션구입(Player player, Potion 포션[], int 포션입력) {
        if (player.골드 >= 포션[포션입력-1].아이템가격 ) {
            GA.게임진행대사(포션[포션입력-1].아이템이름 + "을 구입했다.");
            player.골드 = player.골드 - 포션[포션입력-1].아이템가격;
            player.플레이어포션[포션입력 - 1]++;
            GA.아무키나();
        } else {
            GA.게임진행대사("골드가 부족합니다.");
            GA.아무키나();
        }
    }
    public void 아이템구입(Player player, Item 아이템) {
        if (player.골드 >= 아이템.아이템가격) {
            GA.게임진행대사(아이템.아이템이름 + "을 구입했다.");
            player.골드 -= 아이템.아이템가격;
            player.아이템인벤토리.add(아이템);
            GA.아무키나();
        } else {
            GA.게임진행대사("골드가 부족합니다.");
            GA.아무키나();
        }
    }

}
