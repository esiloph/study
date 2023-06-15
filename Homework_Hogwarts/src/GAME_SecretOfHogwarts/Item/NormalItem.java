package GAME_SecretOfHogwarts.Item;

public class NormalItem extends Item {
    public int 체력증가;
    public int 마력증가;

    public NormalItem(String 아이템이름, int 아이템가격, String 아이템등급, int 체력증가, int 마력증가) {
        super(아이템이름, 아이템가격, 아이템등급);
        this.체력증가 = 체력증가;
        this.마력증가 = 마력증가;
    }
}
