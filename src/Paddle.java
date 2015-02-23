import net.ge.src.Entities.Entity;
import net.ge.src.util.Pair;

import java.awt.*;

/**
 * Created by s613271 on 2/19/2015.
 */
public class Paddle extends Entity {
    private Color c = Color.white;

    public Paddle(String name, Pair<Float, Float> loc, Pair<Float, Float> size) {
        super(name, loc, size);
    }

    public void drawObject(Graphics g){
        Color temp = g.getColor();
        g.setColor(this.c);
        g.fillRect(this.getLocation().getKey().intValue(),this.getLocation().getValue().intValue(),this.getSize().getKey().intValue(),this.getSize().getValue().intValue());
        g.setColor(temp);
    }
}
