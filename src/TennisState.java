import net.ge.src.Entities.Entity;
import net.ge.src.Game;
import net.ge.src.States.GameState;
import net.ge.src.util.Pair;
import net.ge.src.util.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by s613271 on 2/19/2015.
 */
public class TennisState implements GameState {

    ArrayList<Entity> entities = new ArrayList<Entity>();

    @Override
    public void Update(float v) {
        for(Entity e : entities){
            e.Update(v);
        }
    }

    @Override
    public void Render(Graphics g) {
        g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        for(Entity e : entities){
            e.drawObject(g);
        }
    }

    @Override
    public void HandleInput(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP: entities.get(0).changeMovement(new Vector(0,-1));break;
            case KeyEvent.VK_DOWN: entities.get(0).changeMovement(new Vector(0,-1));break;
        }

    }

    @Override
    public void OnExit() {

    }

    @Override
    public void OnEnter() {
        entities.add(new Paddle("Paddle", new Pair<Float, Float>(40f,350f),new Pair<Float, Float>(10f,50f)));
    }
}
