import java.applet.Applet;
import java.awt.Graphics;

public class MyFirstApplet extends Applet {

    private static final long serialVersionUID = -3783584337636720597L;

    /**
     * The init method will be called when the applet is launched
     */
    @Override
    public void init() {
        System.out.println("This is being initialized");
    }

    /**
     * This method is responsible for rendering graphics in the applet
     *
     * @param g
     */
    public void draw(Graphics g) {
        g.drawString("Greetings", 10, 100);
    }

}
