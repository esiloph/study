package GAME_SecretOfHogwarts.Enemy;

public abstract class Enemy {
    public String 이름;
    public int 풀체, 체력, 풀마 ,마력, 경험치, 공격력, 방어력, 몬스터경험치;


    public Enemy(String 이름, int 풀체, int 경험치) {
        this.이름=이름;
        this.풀체=풀체;
        this.경험치=경험치;
        this.체력=풀체;
    }

    public Enemy(String 이름, int 풀체, int 풀마, int 경험치) {
        this.이름=이름;
        this.풀체=풀체;
        this.풀마=풀마;
        this.체력=풀체;
        this.마력=풀마;
        this.경험치=경험치;
    }
    public abstract int 일반공격();
    public abstract int 방어();

}
