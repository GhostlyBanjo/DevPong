import net.ge.src.Game;


/**
 * Created by s613271 on 2/19/2015.
 */
public class Main {
    public static Game game;
    public static void main(String[] args){
        game = new Game();
        game.stateHandler.Push(new MainMenuState());
        game.Run();
    }
}
