import net.ge.src.Entities.Entity;
import net.ge.src.util.Collision;
import net.ge.src.util.Pair;
import net.ge.src.util.Vector;

import java.awt.*;

/**
 * Created by s613271 on 2/25/2015.
 */
public class Ball extends Entity {

    public Ball(String name, Pair<Float, Float> loc, Pair<Float, Float> size) {
        super(name, loc, size);
        this.changeMovement(new Vector(0,0));
    }

    public void drawObject(Graphics g){
        Color temp = g.getColor();
        g.setColor(Color.white);
        g.fillRect(this.getLocation().getKey().intValue(),this.getLocation().getValue().intValue(),this.getSize().getKey().intValue(),this.getSize().getValue().intValue());
        g.setColor(temp);
    }
    public void Collide(Collision c) {
        if (c.getObject() instanceof Paddle){
            this.getMovement().flipX();
        }
    }
}
