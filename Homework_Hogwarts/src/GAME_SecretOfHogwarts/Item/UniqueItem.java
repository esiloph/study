package GAME_SecretOfHogwarts.Item;

public class UniqueItem extends RareItem{
    public int 마법공격력증가;

    public UniqueItem(String 아이템이름, int 아이템가격, String 아이템등급, int 체력증가, int 마력증가, int 공격력증가, int 방어력증가, int 마법공격력증가) {
        super(아이템이름, 아이템가격, 아이템등급, 체력증가, 마력증가, 공격력증가, 방어력증가);
        this.마법공격력증가 = 마법공격력증가;
    }
}
