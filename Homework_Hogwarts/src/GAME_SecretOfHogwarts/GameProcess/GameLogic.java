package GAME_SecretOfHogwarts.GameProcess;

import GAME_SecretOfHogwarts.BattleProcess.Battle;
import GAME_SecretOfHogwarts.BattleProcess.Rest;
import GAME_SecretOfHogwarts.Enemy.Monster;
import GAME_SecretOfHogwarts.Info.DefaultSetting;
import GAME_SecretOfHogwarts.Info.Information;
import GAME_SecretOfHogwarts.Item.*;
import GAME_SecretOfHogwarts.Player.*;

import java.util.Scanner;

public class GameLogic {
    //게임에 필요한 객체 선언
    Item item;
    BuyItem buyItem = new BuyItem();
    ItemList itemList =new ItemList();
    UseItem useItem=new UseItem();
    Information info = new Information();
    GameAssist GA = new GameAssist();
    Scanner sc = new Scanner(System.in);
    Story story = new Story();
    Rest rest = new Rest();
    public int 기숙사입력, 포션입력;
    String 이름;
    public boolean 게임진행상황;
    public int 장소 = 0, 액트 = 1;
    public String[] 액트장소 = {"호그와트 지하 감옥1", "호그와트 지하 감옥2"};
    public String[] 몬스터 = {"고블린", "고블린", "타란툴라", "픽시", "픽시"};
    public String[] 무작위상황 = {"전투", "전투", "전투", "전투", "휴식"};
    Player[] players = new Player[4];
    Player 선택된플레이어 = null;


    public GameLogic() {;}


    public static void main(String[] args) {
        // 게임 초기 설정 실행
        GameLogic GL = new GameLogic();
        GL.게임초기설정();
    }
    public void 게임초기설정() {

        //이름과 기숙사 설정 ---- DS.이름설정, DS.기숙사설정  
        DefaultSetting DS = new DefaultSetting();
        GA.게임제목();
        GA.화면클리어();

        GA.게임진행대사("        플레이어의 이름을 말씀해주세요");
        DS.이름설정(이름 = sc.next());
        GA.화면클리어();
        GA.게임진행대사(" 들어가고 싶은 기숙사를 설정해주세요.\n" +
                " (1) 용감하고 대단한 자들의 '그리핀도르'\n" +
                " (2) 성실하고 진실된 자들의 '후플푸프'\n" +
                " (3) 현명하고 사려 깊은 자들의 '래번클로'\n" +
                " (4) 순수한 혈통을 지닌 자들을 위한 '슬리데린'");

        DS.기숙사설정(기숙사입력 = sc.nextInt());
        players[0]= new GryffindorPlayer(이름,60,80,0,100,10,1,10);
        players[1]= new HufflepuffPlayer(이름,40,70,0,100,5,1,5);
        players[2]= new RavenclawPlayer(이름,30,120,0,100000,5,5,10);
        players[3]= new SlytherinPlayer(이름,25,150,0,100,3,5,15);


        if (기숙사입력>=1 && 기숙사입력 <= players.length){
            선택된플레이어 = players[기숙사입력-1];

            if(선택된플레이어 instanceof GryffindorPlayer){
                GryffindorPlayer gryffindorPlayer=(GryffindorPlayer) 선택된플레이어;
            } else if (선택된플레이어 instanceof HufflepuffPlayer) {
                HufflepuffPlayer hufflepuffPlayer=(HufflepuffPlayer) 선택된플레이어;
            } else if (선택된플레이어 instanceof RavenclawPlayer) {
                RavenclawPlayer ravenclawPlayer=(RavenclawPlayer) 선택된플레이어;
            } else if (선택된플레이어 instanceof SlytherinPlayer) {
                SlytherinPlayer slytherinPlayer=(SlytherinPlayer) 선택된플레이어;
            }
            info.아이템능력업그레이드(선택된플레이어);
            GA.게임진행대사(이름 + "님은 '" + 선택된플레이어.기숙사이름 + "' 기숙사를 선택하였습니다.");

            게임루프();
        } else {
            게임진행상황 = false;
        }
    }

    public void 게임루프() {
            GA.정보알림("               " + "호그와트 시계탑");
        GA.게임진행대사 (" 다음 행동을 선택하십시오. \n" +
                " (1) " + 선택된플레이어.기숙사이름 + " 기숙사로 순간이동 \n" +
                " (2) 호그와트 비밀을 파헤친다.\n" +
                " (3) 캐릭터 정보를 확인한다.\n" +
                " (4) 아이템 정보를 확인한다.\n"+
                " (5) 게임을 종료한다.");

        int 숫자입력 = GA.번호입력(":", 5);
        if (숫자입력 == 1) {
            기숙사로순간이동();
        } else if (숫자입력 == 2) {
            //호그와트 비밀 파헤치기
            호그와트비밀파헤치기();
        } else if (숫자입력 == 3) {
            info.플레이어정보(선택된플레이어, Potion.포션, item);
            게임루프();
        } else if (숫자입력==4) {
            아이템정보();
        //캐릭터 정보를 확인한다.
        } else {
            게임진행상황 = false;
        }
    }
    public void 아이템정보(){
        GA.정보알림("               " + "아이템 정보");
        GA.게임진행대사(" 다음 행동을 선택하십시오. \n" +
                " (1) 보유한 아이템을 확인한다. \n" +
                " (2) 착용된 아이템을 확인한다.\n" +
                " (3) 아이템 착용 및 해제\n" +
                " (4) 뒤로가기\n");


        int 숫자입력 = GA.번호입력(":", 4);
        if (숫자입력 == 1) {
            선택된플레이어.보유아이템목록보기(선택된플레이어);
            아이템정보();
        } else if (숫자입력 == 2) {
            //호그와트 비밀 파헤치기
            선택된플레이어.착용아이템목록보기(선택된플레이어);
            아이템정보();
        } else if (숫자입력 == 3) {
            아이템착용해제();
        } else {
            게임루프();
        }
    }
    public void 아이템착용해제() {
        GA.화면클리어();
                GA.정보알림("         아이템 착용 및 해제");
        GA.게임진행대사(     " 다음 행동을 선택하십시오. \n" +
                           "  (1) 아이템 착용 \n" +
                           "  (2) 아이템 해제\n" +
                           "  (3) 뒤로가기\n" );

        int 숫자입력 = GA.번호입력(":", 3);
        if (숫자입력 == 1) {
            선택된플레이어.보유착용아이템목록보기(선택된플레이어);

            System.out.println("보유아이템에서 착용할 아이템을 선택해주세요");

            for (int i = 0; i < 선택된플레이어.아이템인벤토리.size(); i++) {
                Item 착용할아이템 = 선택된플레이어.아이템인벤토리.get(i);
                int 선택보유아이템 = GA.번호입력(":", 선택된플레이어.아이템인벤토리.size() + 1);
                if (선택보유아이템 == i + 1) {
                    boolean 착용완료 = false;
                    for (int j = 0; j < 선택된플레이어.착용아이템.length; j++) {
                        if (선택된플레이어.착용아이템[j] == null) {
                            선택된플레이어.착용아이템[j] = 선택된플레이어.아이템인벤토리.get(i);
                            착용완료 = true;
                            선택된플레이어.아이템인벤토리.remove(i);
                            useItem.아이템착용(선택된플레이어,착용할아이템);
                            GA.화면클리어();
                            System.out.println(착용할아이템.아이템이름+"을(를) 착용했다.");
                            GA.아무키나();
                            아이템착용해제();
                            break;
                        }
                    }
                    if (!착용완료) {
                        System.out.println("더 이상 착용할 수 없습니다.");
                        아이템착용해제();
                    }
                }
            }
        } else if (숫자입력 == 2) {
            GA.정보알림("(2) 아이템 해제");
            선택된플레이어.착용아이템목록보기(선택된플레이어);
            GA.절취선(30);
            System.out.println(" 해제할 아이템을 선택해주세요");
            int 선택해제아이템=GA.번호입력(":",선택된플레이어.착용아이템.length + 1);
            if(선택해제아이템 > 0 && 선택해제아이템 <= 선택된플레이어.착용아이템.length) {
                int 인덱스= 선택해제아이템-1;
                Item 해제아이템=선택된플레이어.착용아이템[인덱스];
                선택된플레이어.착용아이템[인덱스] = null;
                선택된플레이어.아이템인벤토리.add(해제아이템);
                useItem.아이템해제(선택된플레이어, 해제아이템);
                GA.화면클리어();
                GA.게임진행대사(해제아이템.아이템이름 + "을(를) 해제했다.");
                GA.아무키나();
                아이템착용해제();
            }
        } else {
            아이템정보();
        }
    }
    public void 기숙사로순간이동() {
        GA.정보알림("               " + 선택된플레이어.기숙사이름 + "기숙사");
        GA.게임진행대사(" 다음 행동을 선택하십시오. \n" +
                " (1) 기숙사 침대에서 휴식\n" +
                " (2) 호그스미드 포션 상점으로 텔레포트\n" +
                " (3) 다이애건앨리 아이템상점으로 텔레포트\n"+
                " (4) 기숙사 밖으로 나가기\n" +
                " (5) 게임을 종료한다.");

        int 숫자입력 = GA.번호입력(":", 5);
        if (숫자입력 == 1) {
            rest.기숙사휴식(선택된플레이어);
            기숙사로순간이동();
        } else if (숫자입력 == 2) {
            호그스미드포션상점();
        } else if (숫자입력==3) {
            다이애건앨리아이템상점();
        } else if (숫자입력 == 4) {
            게임루프();
        } else {
            게임진행상황 = false;
        }
    }

    public void 호그스미드포션상점() {
        GA.화면클리어();
                 GA.정보알림("             호그스미드 포션 상점");
        System.out.println (" 구입할 포션을 말씀해주세요.");
        for(int i=0;i<Potion.포션.length;i++){
            int 포션번호=i+1;
            System.out.println("("+포션번호+") "+Potion.포션[i].아이템이름+"(가격 :"+Potion.포션[i].아이템가격+"골드)");
        }
        System.out.println("("+(Potion.포션.length+1)+") 상점나가기");
        GA.중간띄우기();
        포션입력 = GA.번호입력(":", 4);
        if (포션입력 >= 1 && 포션입력 <= 3) {
            System.out.println();
            buyItem.포션구입(선택된플레이어, Potion.포션, 포션입력);
            호그스미드포션상점();
        } else {
            기숙사로순간이동();
        }
    }
    public void 다이애건앨리아이템상점() {
        GA.화면클리어();
        GA.정보알림("             다이애건앨리 아이템 상점");
        GA.정보알림("구입할 아이템을 말씀해주세요.");
        ItemList.다이애건앨리상점();
        for(int i=0;i<ItemList.아이템상점.size();i++){
            Item item=ItemList.아이템상점.get(i);
            int 아이템번호=i+1;
            System.out.println("("+아이템번호+") " +item.아이템이름+"(가격 :"+item.아이템가격+"골드, 등급:"+item.아이템등급+")");
        }
        System.out.println("("+(ItemList.아이템상점.size()+1)+") 상점나가기");
        GA.중간띄우기();
        int 아이템입력 = GA.번호입력(":", ItemList.아이템상점.size()+1);
        if (아이템입력 >= 1 && 아이템입력<=ItemList.아이템상점.size() ) {
            Item 선택한아이템=ItemList.아이템상점.get(아이템입력-1);
            System.out.println();
            buyItem.아이템구입(선택된플레이어, 선택한아이템);
            다이애건앨리아이템상점();
        } else {
            기숙사로순간이동();
        }
    }
    public void 호그와트비밀파헤치기() {
        info.액트확인(액트,장소,몬스터,무작위상황,선택된플레이어);
        if (액트 != 2) ;
        무작위여행();
    }
    public void 무작위여행() {
        int random = (int) (Math.random() * 무작위상황.length);
        if (무작위상황[random].equals("전투")) {
            무작위전투();
        } else if (무작위상황[random].equals("휴식")) {
            rest.휴식(선택된플레이어);
            무작위여행();
        }
    }
    public void 무작위전투() {
        GA.화면클리어();
        GA.게임진행대사("    희미하게 무엇인가 보인다. 전투준비를 하자!");
        GA.아무키나();
        전투(new Monster(몬스터[(int) (Math.random() * 몬스터.length)], 선택된플레이어.경험치));
    }
    public void 전투(Monster monster) {
        Battle battle = new Battle();
        while (true) {
            GA.화면클리어();
            GA.정보알림(monster.이름 + "\n 체력" + monster.체력 + "/" + monster.풀체);
            GA.정보알림(선택된플레이어.이름 + "\n 체력" + 선택된플레이어.체력 + "/" + 선택된플레이어.풀체 +
                    "\n 마력" + 선택된플레이어.마력 + "/" + 선택된플레이어.풀마);
            GA.정보알림(" 다음 행동을 선택하세요 \n" +
                    " (1) 일반 공격한다. \n" +
                    " (2) 마법주문을 외운다.\n" +
                    " (3) 포션을 사용한다. \n" +
                    " (4) 도망간다.");

            int 숫자입력 = GA.번호입력(":", 4);
            if (숫자입력 == 1) {
                battle.일반공격(선택된플레이어,monster);

                if (선택된플레이어.체력 <= 0) {
                    GA.죽음();
                    break;

                } else if (monster.체력 <= 0) {
                    battle.전투결과(선택된플레이어,monster);
                    전투후선택();
                    break;
                }
            } else if (숫자입력 == 2) {
                GA.정보알림("시전할 마법을 선택해주세요");
                for (int i = 0; i < 선택된플레이어.마법주문.length; i++) {
                    int 마법번호 = i + 1;
                    System.out.println("(" + 마법번호 + ") " + 선택된플레이어.마법주문[i].이름);
                }
                int 마법입력 = GA.번호입력(":", 4);
                if (마법입력 >= 1 &&마법입력<=4) {
                    battle.마법공격(선택된플레이어, monster,선택된플레이어.마법주문, 마법입력);

                    if (선택된플레이어.체력 <= 0) {
                        GA.죽음();
                        break;

                    } else if (monster.체력 <= 0) {
                        battle.전투결과(선택된플레이어,monster);
                        전투후선택();
                        break;
                    }
                }
            } else if (숫자입력 == 3) {
                boolean 포션선택 = false;
                GA.정보알림("사용할 포션을 선택해주세요");
                int i;
                for(i=0;i<Potion.포션.length;i++){
                    int 포션번호=i+1;
                    System.out.println("("+포션번호+") "+Potion.포션[i].아이템이름);
                }
                포션입력 = GA.번호입력(":", i);
                do {
                    if (포션입력 >= 1 && 포션입력 <= i)
                       useItem.포션사용(선택된플레이어,Potion.포션, 포션입력);
                    포션선택 = true;
                } while (!포션선택);
            } else if (숫자입력 == 4) {
                battle.도망(선택된플레이어,monster);
                전투후선택();
                break;
            }
        }
    }
    public void 전투후선택() {
        GA.정보알림("현재 플레이어 상태 " +
                "\n 체력 : " + 선택된플레이어.체력 + " / " + 선택된플레이어.풀체 +
                "\n 마력 : " + 선택된플레이어.마력 + " / " + 선택된플레이어.풀마 +
                "\n 골드 : " + 선택된플레이어.골드);
        GA.게임진행대사("다음 행동을 선택해주세요" +
                "\n(1) 모험을 계속한다" +
                "\n(2) 이 장소에서 나간다.");
        int 선택입력 = GA.번호입력(":", 2);
        if (선택입력 == 1) {
            무작위여행();
        } else {
            게임루프();
        }
    }
}