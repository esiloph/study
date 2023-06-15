package GAME_SecretOfHogwarts.Enemy;

public class MidBoss extends Enemy {
    public String[] 중간보스대사;
    public MidBoss(String 이름, int 풀체, int 풀마, int 경험치) {
        super(이름, 풀체, 풀마, 경험치);
        중간보스대사= new String[]{"네 목숨은 내가 끝낼 것이다! 절대로 피하지 못할 운명이다!", "두려워하라! 내가 널 쓰러뜨리고 어둠으로 뒤덮을 것이다!", "아직 멀었다! 어둠의 힘은 쉽게 사라지지 않는다!"};
    }
    public int 일반공격(){
        return (int)(Math.random()*(몬스터경험치/2+1)+경험치/2+3);
    }
    public int 방어(){
        return (int)(Math.random()*(몬스터경험치/2+1)+경험치/2+3);
    }
}
