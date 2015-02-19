import net.ge.src.Game;
import net.ge.src.States.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by s613271 on 2/19/2015.
 */
public class MainMenuState implements GameState {


    char key = ' ';
    Option current = Option.PLAY;

    @Override
    public void Update(float elapsedTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void Render(Graphics g) {
        // TODO Auto-generated method stub


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(Game.titleFont);
        g.drawString("Developer Tennis!", 100, 100);
        drawOptions(g);
    }


    public void HandleInput(KeyEvent e) {
        key = e.getKeyChar();
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            nextOption();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            lastOption();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE){
            doOption();}

    }

    @Override
    public void OnExit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void OnEnter() {
        // TODO Auto-generated method stub

    }

    private void drawOptions(Graphics g){
        g.setFont(Game.menuFont);
        if(current == Option.PLAY){
            g.setColor(Color.yellow);
            g.drawString("Play!",150,150);
            g.setColor(Color.white);
        }else{
            g.drawString("Play!",150,150);
        }
        if(current == Option.OPTIONS){
            g.setColor(Color.yellow);
            g.drawString("Options",150,200);
            g.setColor(Color.white);
        }else{
            g.drawString("Options",150,200);
        }
        if(current == Option.EXIT){
            g.setColor(Color.yellow);
            g.drawString("Exit Game",150,225);
            g.setColor(Color.white);
        }else{
            g.drawString("Exit Game",150,225);
        }
    }

    private void nextOption(){
        if(current == Option.PLAY){ current = Option.OPTIONS;		}
        else if(current == Option.OPTIONS){current = Option.EXIT;		}
        else if(current == Option.EXIT){current = Option.PLAY;		}
    }
    private void lastOption(){
        if(current == Option.PLAY){current = Option.EXIT;	}
        else if(current == Option.OPTIONS){current = Option.PLAY;		}
        else if(current == Option.EXIT){current = Option.OPTIONS;		}
    }

    private void doOption(){
        if(current == Option.PLAY){
            Game.stateHandler.Push(new TennisState());
        }

        else if(current == Option.OPTIONS){}
        else if(current == Option.EXIT){
            Main.game.closeGame();}
    }
}
enum Option{
    PLAY,OPTIONS,EXIT

}