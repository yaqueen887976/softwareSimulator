package thermodynamic;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Main implements Runnable{
	public static final String VERSION = "0.0.1";
	public static final String TITLE = "Simulator "+VERSION;
	public static final Dimension SCREEN_SIZE = new Dimension(800,600);
	
	public static JFrame frame;
	public static JPanel screenPanel;
	
	public Renderer rend;
	public ForceList forceList;
	
	public static void main(String[] args) {
		Main main = new Main();
		new Thread(main).start();
	}
	
	public Main() {
		frame = new JFrame();
		frame.setSize(SCREEN_SIZE);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); //use absolute layout
		frame.setLayout(null);
		
		
		rend = new Renderer(frame);
		forceList = new ForceList();
		screenPanel = new JPanel(null);
		
		forceList.setBounds(0,0,200,565);
		screenPanel.setBounds(205, 0, 595, 580);
		screenPanel.setBackground(Color.LIGHT_GRAY);
		frame.add(forceList);
		frame.add(screenPanel);
		
		frame.setVisible(true);
	}
	
	public void run()
	{
		while(true){
			rend.render();
			try {
				Thread.sleep(50);
			}catch(InterruptedException ie) {}
		}
	}
}
