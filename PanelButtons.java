package FinalProject;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;


public class PanelButtons extends JPanel {
	

	
	protected JButton ColorFull;
	
	protected JButton circle;
	protected JButton rectangle;
	protected static Color color = Color.LIGHT_GRAY;
	protected static Color paintColor;
	boolean circleMode = false;
	
	boolean rectangleMode = false;
	
	int x1, x2, y1, y2;
	
	public PanelButtons() {
		setLayout(new FlowLayout());
		
		
		ColorFull = new JButton( "" );
		
		circle = new JButton("");
		rectangle = new JButton("");
		
		
		ColorFull.setIcon(new ImageIcon("src/FinalProject/paintbucket.png"));
		
		circle.setIcon(new ImageIcon("src/FinalProject/circle.png"));
		rectangle.setIcon(new ImageIcon("src/FinalProject/rectangle.png"));
		


		
		ColorFull.addActionListener(
				new ActionListener() 
			      {
			         
			         public void actionPerformed( ActionEvent event ){
			            color = JColorChooser.showDialog( 
			            		PanelButtons.this, "Choose a color", color );
			            if ( color == null ){
			               color = Color.WHITE;
			            }
			            TheFrame.TheCanves.background(color);
			         } 
			      });
		
		
		
		
		
		
		
		circle.addActionListener(
				new ActionListener() 
			      {
			         @Override
			         public void actionPerformed( ActionEvent event ){	
			        	 paintColor = JColorChooser.showDialog( 
				            		PanelButtons.this, "Choose a color", paintColor);
			        	 TheFrame.TheCanves.colors.add(paintColor);
			     			circleMode = true;
			         } 
			      });
		rectangle.addActionListener(
				new ActionListener() 
			      {
			         @Override
			         public void actionPerformed( ActionEvent event ){	
			        	 paintColor = JColorChooser.showDialog( 
				            		PanelButtons.this, "Choose a color", paintColor);
			        	 TheFrame.TheCanves.colors.add(paintColor);
			     			rectangleMode = true;
			         } 
			      });
		
		
		add(rectangle);
		add(circle);
		
		add(ColorFull);
	
	}
	
	
	
}
