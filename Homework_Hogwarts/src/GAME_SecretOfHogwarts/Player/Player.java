package GAME_SecretOfHogwarts.Player;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;

import java.util.ArrayList;

public abstract class Player {
    GameAssist GA=new GameAssist();
    public MagicSpell[] 마법주문 = new MagicSpell[4];
    public String 기숙사이름, 이름;
    public int 풀체, 체력, 풀마, 마력, 경험치, 무기번호, 공격력, 마법공격력, 방어력, 방어구번호, 골드, 남은휴식횟수, 체력포션, 마력포션, 만능포션;
    public String[] 기본무기= {"지팡이","빛의 지팡이","유니콘의 힘이 깃는 지팡이","불사조 힘이 깃든 지팡이","떡갈나무 지팡이"};
    public String[] 기본방어구={"망토","가죽 망토","빛나는 망토","영원의 망토","미쓰릴 갑옷"};
    public ArrayList<Item> 아이템인벤토리;
    public Item[] 착용아이템;

    public int[] 플레이어포션;
    public Player(String 이름, int 풀체,int 풀마, int 경험치, int 골드, int 공격력, int 방어력,int 마법공격력){
        this.이름=이름;
        this.풀체=풀체;
        this.풀마=풀마;
        this.경험치=경험치;
        this.체력=풀체;
        this.마력=풀마;
        this.공격력=공격력;
        this.마법공격력=마법공격력;
        this.방어력=방어력;
        this.무기번호=0;
        this.방어구번호=0;
        this.골드=골드;
        this.남은휴식횟수=1;
        플레이어포션= new int[]{this.체력포션=0, this.마력포션=0, this.만능포션=0};
        아이템인벤토리=new ArrayList<Item>();
        착용아이템 =new Item[3];
        for (int i = 0; i < 착용아이템.length; i++) {
            착용아이템[i] = null;
        }
    }
    public abstract void 보유아이템목록보기(Player player);
    public abstract void 착용아이템목록보기(Player player);
    public abstract void 보유착용아이템목록보기(Player player);
    public abstract int 일반공격();
    public abstract int 방어();

}
