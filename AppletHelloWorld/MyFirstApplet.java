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
  public void paint(Graphics g){
         str=str+"paint-";;
         g.drawString(str,40,100);
         g.drawString("Hello from the Applet.", 40,40);
         g.drawString("How are you doing?", 40, 60);
         g.drawString("We wish you a pleasant day today.", 40, 80);
    }

}
