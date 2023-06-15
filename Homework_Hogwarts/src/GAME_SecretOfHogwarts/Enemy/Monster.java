package GAME_SecretOfHogwarts.Enemy;

public class Monster extends Enemy {
    public Monster(String 이름, int 몬스터경험치){
        super(이름, (int) (Math.random()*몬스터경험치+몬스터경험치/3+5),(int)(Math.random()*(몬스터경험치/2+2)+1));
        this.몬스터경험치=몬스터경험치;
    }
    public int 일반공격(){
        return (int)(Math.random()*(몬스터경험치/2+1)+경험치/2+3);
    }

    public int 방어(){
        return (int)(Math.random()*(몬스터경험치/2+1)+경험치/2+3);
    }
}
