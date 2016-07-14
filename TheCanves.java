package FinalProject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TheCanves extends JPanel {
	Color c = Color.WHITE;
	static ArrayList<Shape> shapes = new ArrayList<Shape>();
	static ArrayList<Color> colors = new ArrayList<Color>();
	static Image backgroundImage;
	static boolean imgShow = false;
	
	//contructor and method for setting the background
	public TheCanves() {
		background(c);
		
	}
	
	
	
	public void background(Color color){
		setBackground(color);
	}
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if(imgShow == true){
			g2d.drawImage(backgroundImage, 0, 0, null);
		}
		
		for (int i=0; i<shapes.size(); i++) { 
			if(i<colors.size()){
			g2d.setColor(colors.get(i));
			}
			g2d.fill(shapes.get(i));
		}

	}

}

