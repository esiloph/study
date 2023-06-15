package GAME_SecretOfHogwarts.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    public static List<Item> 아이템상점;
    //노말아이템
    public static Item 마법안경 = new NormalItem("마법안경",10,"노말",0,10);
    public static Item 마법안경클리너 = new NormalItem("마법안경 클리너",5,"노말",0,8);
    public static Item 호그와트교복 = new NormalItem("호그와트 교복",5,"노말",10,0);
    public static Item 퀴디치골든스니치 = new NormalItem("퀴디치 골든 스니치",15,"노말",20,10);
    public static Item 마법사형광팬 = new NormalItem("마법사 형광팬",5,"노말",0,10);
    public static Item 젤리빈주머니 = new NormalItem("젤리빈 주머니",10,"노말",20,0);
    public static Item 마녀양말 = new NormalItem("마녀 양말",10,"노말",20,0);
    public static Item 모래시계 = new NormalItem("모래 시계",20,"노말",10,20);
    //레어아이템
    public static Item 알버스덤블도어의형광침대커버=new RareItem("알버스 덤블도어의 형광 침대 커버",50,"레어",10,0,5,20);
    public static Item 루나러브굿의악마눈알귀걸이=new RareItem("루나 러브굿의 악마눈알 귀걸이",80,"레어",0,20,30,0);
    public static Item 해리포터의비밀일기장=new RareItem("해리포터의 비밀 일기장",50,"레어",0,10,30,0);
    public static Item 뉴트스캐맨더의가면=new RareItem("뉴트 스캐맨더의 가면",80,"레어",10,20,30,5);


    //유니크아이템
    public static Item 신비한동물사전=new UniqueItem("뉴트 스캐맨더의 신비한동물사전",700,"유니크",100,100,50,20,80);

    //호크룩스
    public static Item 마볼로곤트의반지=new UniqueItem("마볼로 곤트의 반지(부활의 돌)",99999,"호크룩스",100,100,250,300,100);
    public static Item 톰마볼로리들의일기장=new UniqueItem("톰 마볼로 리들의 일기장",99999,"호크룩스",50,200,300,300,150);
    public static Item 슬리데린의로켓=new UniqueItem("슬리데린의 로켓",99999,"호크룩스",100,200,500,0,100);
    public static Item 헬가후플푸프의잔=new UniqueItem("헬가 후플푸프의 잔",99999,"호크룩스",100,50,100,200,100);
    public static Item 로웨나래번클로의보관=new UniqueItem("로웨나 래번클로의 보관",99999,"호크룩스",100,50,100,100,150);

    public static void 다이애건앨리상점(){
        아이템상점=new ArrayList<Item>();
        아이템상점.add(마법안경);
        아이템상점.add(마법안경클리너);
        아이템상점.add(호그와트교복);
        아이템상점.add(퀴디치골든스니치);
        아이템상점.add(뉴트스캐맨더의가면);
        아이템상점.add(알버스덤블도어의형광침대커버);
        아이템상점.add(신비한동물사전);
    }
}
