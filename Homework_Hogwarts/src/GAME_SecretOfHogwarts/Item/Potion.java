
package GAME_SecretOfHogwarts.Item;

public class Potion extends Item{
    public int 회복;

    public Potion(String 아이템이름, int 아이템가격, String 아이템등급, int 회복) {
        super(아이템이름, 아이템가격, 아이템등급);
        this.회복 = 회복;
    }

    public static Potion 포션[] ={new Potion("체력포션", 10,"포션", 20),
                    new Potion("마력포션", 20, "포션",20),
                    new Potion("만능포션", 30, "포션",30) };
}
