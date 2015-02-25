import net.ge.src.Entities.Entity;
import net.ge.src.Game;
import net.ge.src.States.GameState;
import net.ge.src.util.Collision;
import net.ge.src.util.Pair;
import net.ge.src.util.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by s613271 on 2/19/2015.
 */
public class TennisState implements GameState {

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private Paddle player;
    private Ball ball;
    private Entity scoreZone[] = new Entity[2];
    private int score = 0;

    @Override
    public void Update(float v) {
        if(player!=null) {
        Game.collisionHandler.CheckEntityCollisions(player,ball);
        Game.collisionHandler.CheckScreenCollisions(ball);
        Game.collisionHandler.CheckScreenCollisions(player);



            player.Update(v);
            ball.Update(v);
        }
    }

    @Override
    public void Render(Graphics g) {
        g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        player.drawObject(g);
        ball.drawObject(g);
    }

    @Override
    public void HandleInput(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN: player.HandleInput(keyEvent);break;
        }

    }

    @Override
    public void OnExit() {

    }
    public void addScore(){

    }
    @Override
    public void OnEnter() {
        player = new Paddle("Paddle", new Pair<Float, Float>(45f,350f),new Pair<Float, Float>(10f,50f));
        ball = new Ball("Ball", new Pair<Float, Float>((float)(Game.WIDTH/2), 350f), new Pair<Float, Float>(10f,10f));
        ball.changeMovement(new Vector(-.5f,.5f));
        scoreZone[0] = new Entity("Player Score Zone",new Pair<Float, Float>(0f,0f), new Pair<Float, Float>(40f,(float)Game.HEIGHT)) {
            public void Collide(Collision c){
                if(c.getObject() instanceof Ball){
                    (TennisState)(Game.stateHandler.Peek()).addScore();
                }
        }
        };
    }
}
