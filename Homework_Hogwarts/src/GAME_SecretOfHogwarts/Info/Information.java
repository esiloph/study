package GAME_SecretOfHogwarts.Info;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.Item.Potion;
import GAME_SecretOfHogwarts.Player.Player;
import GAME_SecretOfHogwarts.GameProcess.Story;

public class Information {
    GameAssist GA=new GameAssist();
    Story story=new Story();
    public void 플레이어정보(Player player, Potion 포션[], Item item){
        GA.화면클리어();
        GA.절취선(30);
        System.out.println("플레이어 정보 \n"+
                "소속 기숙사: "+player.기숙사이름              +
                "\n 이름 : " + player.이름 + "/ 체력 : " + player.체력 + "/" + player.풀체 + "     마력 : " + player.마력 + "/" + player.풀마 + "\n" +
                "경험치 : " + player.경험치 + "         보유 골드 : " + player.골드 +
                "\n\n 보유 포션 " +
                "\n" + 포션[0].아이템이름 + " : " + player.플레이어포션[0] + "개 / " + 포션[1].아이템이름 + " : " + player.플레이어포션[1] + "개 / " + 포션[2].아이템이름 + " : " + player.플레이어포션[2] + "개");
        GA.절취선(30);
        if (player.무기번호 > 0) {
            System.out.println("당신의 착용하고 있는 무기는 :  " + player.기본무기[player.무기번호 - 1]);
        }
        if (player.방어구번호 > 0) {
            System.out.println("당신의 착용하고 있는 방어구는 : " + player.기본방어구[player.방어구번호 - 1]);
        }
        GA.절취선(30);
        System.out.println("보유 아이템");
        for (int i = 0; i < player.아이템인벤토리.size(); i++) {
            Item 아이템 = player.아이템인벤토리.get(i);
            if(아이템==null){
                GA.정보알림("보유한 아이템이 없습니다.");
            }else {
                System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
            }
        }
        GA.절취선(30);
        System.out.println("\n착용 아이템");
        for (int i = 0; i < player.착용아이템.length; i++) {
            Item 아이템 = player.착용아이템[i];
            if (아이템 != null) {
                System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
            }else{
                System.out.println("[" + (i + 1) +"] <비어있음>");
            }
        }
        GA.절취선(30);
        GA.중간띄우기();
        GA.아무키나();
    }
    public void 아이템능력업그레이드(Player player){

        GA.화면클리어();
        GA.게임진행대사("        기본아이템을 선택해주세요~!\n" +
                      "        (1) "+player.기본무기[player.무기번호] + "      (2) "+player.기본방어구[player.방어구번호]);
        int 아이템입력=GA.번호입력(":",2);
        GA.화면클리어();
        if(아이템입력==1){
            GA.게임진행대사("                "+player.기본무기[player.무기번호]+" 선택");
            player.무기번호++;
        }else{
            GA.게임진행대사("                "+player.기본방어구[player.방어구번호]+" 선택");
            player.방어구번호++;
        }
        GA.아무키나();
    }

    public void 액트확인(int 액트,int 장소, String[] 몬스터, String[] 무작위상황, Player player) {
        if (player.경험치 >= 10 && 액트 == 1) {
            액트 = 2;
            장소 = 1;

            story.액트1클리어();
            story.액트2시작();

            몬스터[0] = "고블린";
            몬스터[1] = "픽시";
            몬스터[2] = "오거";
            몬스터[3] = "오거";
            몬스터[4] = "스네이크";
            무작위상황[3] = "전투";

        } else if (player.경험치 >= 50 && 액트 == 2) {
        }
    }

}
