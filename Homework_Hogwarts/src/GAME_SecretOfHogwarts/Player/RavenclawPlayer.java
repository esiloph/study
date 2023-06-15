package GAME_SecretOfHogwarts.Player;

import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;

import java.util.ArrayList;

public class RavenclawPlayer extends Player {
    public RavenclawPlayer(String 이름, int 풀체, int 풀마, int 경험치, int 골드, int 공격력, int 방어력, int 마법공격력) {
        super(이름, 풀체, 풀마, 경험치, 골드, 공격력, 방어력, 마법공격력);
        this.기숙사이름= "래번클로";
        this.마법주문[0]=new MagicSpell("아쿠아에릭토",(int)(Math.random()*마법공격력/2+풀마/10),10,"물줄기를 소환하여 상대에게 데미지를 입혔다!");
        this.마법주문[1]=new MagicSpell("스투페파이",(int)(Math.random()*마법공격력+풀마/5),20,"상대가 기절하고 치명적인 데미지를 입혔다");
        this.마법주문[2]=new MagicSpell("엑스펙토 패트로눔",(int)(Math.random()*5*마법공격력+풀마/3),(int) (풀마*0.6),"페트로누스가 소환되어 상대 몬스터에게 피해를 주었다.");
        this.마법주문[3]=new MagicSpell("크루시오",(int)(Math.random()*100*마법공격력+풀마/3),(int) (풀마*0.9),"상대는 엄청난 고통을 느끼고 있다.");

        플레이어포션= new int[]{this.체력포션=0, this.마력포션=0, this.만능포션=0};
        아이템인벤토리=new ArrayList<Item>();
        착용아이템 =new Item[3];
        for (int i = 0; i < 착용아이템.length; i++) {
            착용아이템[i] = null;
        }
    }
    public void 보유아이템목록보기(Player player) {
        if (player.아이템인벤토리.isEmpty()) {
            System.out.println("보유한 아이템이 없습니다.");
        } else {
            System.out.println("보유 아이템:");
            for (int i = 0; i < player.아이템인벤토리.size(); i++) {
                Item 아이템 = player.아이템인벤토리.get(i);
                if (아이템 == null) {
                    System.out.println("[" + (i + 1) + "] [비어있음]");
                } else {
                    System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
                }
            }
        }
        GA.아무키나();
    }
    @Override
    public void 착용아이템목록보기(Player player) {
        System.out.println("착용된 아이템 목록");
        for (int i = 0; i < 착용아이템.length; i++) {
            if (착용아이템[i] != null) {
                System.out.println((i + 1) + ". " + 착용아이템[i].아이템이름);
            } else {
                System.out.println((i + 1) + ". [비어있음]");
            }
        }
        System.out.println("=========================");
        GA.아무키나();
    }
    public void 보유착용아이템목록보기(Player player) {
        if (아이템인벤토리.isEmpty()) {
            System.out.println("보유한 아이템이 없습니다.");
        } else {
            System.out.println("보유 아이템:");
            for (int i = 0; i < 아이템인벤토리.size(); i++) {
                Item 아이템 = 아이템인벤토리.get(i);
                if (아이템 == null) {
                    System.out.println("[" + (i + 1) + "] [비어있음]");
                } else {
                    System.out.println("[" + (i + 1) + "] " + 아이템.아이템이름);
                }
            }
        }
        System.out.println("착용된 아이템 목록");
        for (int i = 0; i < 착용아이템.length; i++) {
            if (착용아이템[i] != null) {
                System.out.println((i + 1) + ". " + 착용아이템[i].아이템이름);
            } else {
                System.out.println((i + 1) + ". [비어있음]");
            }
        }
        GA.절취선(30);
    }
    public int 일반공격(){
        return (int) (Math.random()*(공격력+경험치+무기번호)+경험치/10);
    }
    public int 방어() {
        return (int) (Math.random()*방어력);
    }
}

