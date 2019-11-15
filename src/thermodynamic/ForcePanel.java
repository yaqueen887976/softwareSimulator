package thermodynamic;

import java.awt.event.*;
import javax.swing.*;

public class ForcePanel extends JPanel implements ActionListener
{
	public static final String EDIT = "edit";
	private static final long serialVersionUID = 1L;
	private static final String FORCE = "FORCE";
	private static final String VECTOR = "VECTOR";
	
	private JLabel forceLabel,vectorLabel;
	private JButton forceButton, vectorButton;
	private JPanel forcePanel,vectorPanel;
	private Force force;
	
	public ForcePanel(Force force) {
		super();
		this.force = force;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		forceLabel = new JLabel("Force = "+force.getForce() + " N");
		vectorLabel = new JLabel("Vector = "+force.getVector()+"°");
		
		forceButton = new JButton(EDIT);
		vectorButton = new JButton(EDIT);
		forceButton.setActionCommand(FORCE);
		vectorButton.setActionCommand(VECTOR);
		forceButton.addActionListener(this);
		vectorButton.addActionListener(this);
		
		forcePanel = new JPanel();
		forcePanel.setLayout(new BoxLayout(forcePanel, BoxLayout.X_AXIS));
		forcePanel.add(forceLabel);
		forcePanel.add(Box.createHorizontalGlue());
		forcePanel.add(forceButton);
		forcePanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		vectorPanel = new JPanel();
		vectorPanel.setLayout(new BoxLayout(vectorPanel, BoxLayout.X_AXIS));
		vectorPanel.add(vectorLabel);
		vectorPanel.add(Box.createHorizontalGlue());
		vectorPanel.add(vectorButton);
		vectorPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		add(forcePanel);
		add(vectorPanel);
		setBorder(BorderFactory.createTitledBorder(force.name.toUpperCase()));
		setBounds(5,0,300,100);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();
		switch(action) {
			case FORCE:
				float oldForce = force.getForce();
				float newForce = Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new magnitude", "Edit Force", JOptionPane.QUESTION_MESSAGE,null,null,oldForce).toString());
				if(newForce == oldForce) {return;}
				force.setForce(newForce);
				forceLabel.setText("Force = "+ force.getForce() + " N");
			case VECTOR:
				float oldVector = force.getForce();
				float newVector= Float.parseFloat(JOptionPane.showInputDialog(Main.frame, "Enter the force's new vector", "Edit Force", JOptionPane.QUESTION_MESSAGE,null,null,oldVector).toString());
				if(newVector == oldVector) {return;}
				force.setVector(newVector);
				vectorLabel.setText("Vector = "+ force.getVector() + "°");
				break;
				default: break;
		}
	}

}
