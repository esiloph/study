package GAME_SecretOfHogwarts.GameProcess;

public class Story {
    GameAssist GA = new GameAssist();
    public void GryffindorStory(){
        GA.화면클리어();
        GA.게임진행대사("              스토리 인트로");
        GA.아무키나();
    }
    public void 인트로스토리(){
        GA.화면클리어();
        GA.게임진행대사("              스토리 인트로");
        GA.아무키나();
    }
    public void 액트1클리어(){
        GA.화면클리어();
        GA.게임진행대사("액트1 클리어");
        GA.아무키나();
    }

    public void 액트2시작(){
        GA.화면클리어();
        GA.게임진행대사("액트2 시작");
        GA.아무키나();
    }
    public void 게임클리어(){

    }
}
