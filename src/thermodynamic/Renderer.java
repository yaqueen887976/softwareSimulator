package thermodynamic;
import javax.swing.JFrame;
import java.awt.Graphics;
public class Renderer
{
	private JFrame frame;
	public Renderer(JFrame frame) {
		this.frame = frame;
	}
	
	public void render() {
		Graphics g = frame.getGraphics();
		//g.setColor(Color.GREEN);
		//g.drawOval(100, 100, 600, 400);
		g.dispose();
	}
}
