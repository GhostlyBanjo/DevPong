import net.ge.src.Entities.Entity;
import net.ge.src.util.Pair;
import net.ge.src.util.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by s613271 on 2/19/2015.
 */
public class Paddle extends Entity {
    private Color c = Color.white;

    public Paddle(String name, Pair<Float, Float> loc, Pair<Float, Float> size) {
        super(name, loc, size);
        this.changeMovement(new Vector(0,0));
    }

    public void Update(float v){
        super.Update(v);
        this.multiplyMovement(0);
    }
    public void drawObject(Graphics g){
        Color temp = g.getColor();
        g.setColor(this.c);
        g.fillRect(this.getLocation().getKey().intValue(),this.getLocation().getValue().intValue(),this.getSize().getKey().intValue(),this.getSize().getValue().intValue());
        g.setColor(temp);
    }
    public void HandleInput(KeyEvent e) {



        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                this.changeMovement(new Vector(0f, -20f));
                break;
            case KeyEvent.VK_DOWN:
                this.changeMovement(new Vector(0f, 20f));
                break;


        }

    }
}
