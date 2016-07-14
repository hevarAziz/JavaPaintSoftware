package FinalProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TheFrame extends JFrame {
	public static PanelButtons PanelButtons;
	public static TheCanves TheCanves;
	

	public TheFrame() {
		super("My Painter");

		// Jpanel for just the Buttons.
		PanelButtons = new PanelButtons();
		add(PanelButtons, BorderLayout.NORTH);
		PanelButtons.setBackground(Color.GRAY);

		// second panel painter
		TheCanves = new TheCanves();
		add(TheCanves, BorderLayout.CENTER);

		// Menu bar for the application
		JMenuBar menubarj = new JMenuBar();
		setJMenuBar(menubarj);

		JMenu file = new JMenu("file");
		menubarj.add(file);
		
		JMenuItem open = new JMenuItem("open");
		file.add(open); // adding exit to file
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Image img = ImageIO.read(new File("src/FinalProject/background.jpg"));
					TheCanves.backgroundImage = img;
					TheCanves.imgShow = true;
					TheCanves.repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem save = new JMenuItem("save");
		file.add(save); // adding exit to file
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BufferedImage img = new BufferedImage(TheCanves.getWidth(), TheCanves.getHeight(), BufferedImage.TYPE_INT_RGB);
				TheCanves.paint(img.getGraphics());
			   
			    
			    try {
					ImageIO.write(img, "png", new File("savedCanvas.png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem exit = new JMenuItem("exit");
		file.add(exit); // adding exit to file
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		
		
		TheCanves.addMouseListener(new MouseAdapter(){
			int x,y,x2,y2;
			public void mousePressed(MouseEvent event){
				x = event.getX();
				y = event.getY();
			}
			
			public void mouseReleased(MouseEvent event){
				x2 = event.getX()-x;
				y2 = event.getY()-y;
				if(PanelButtons.circleMode){
					Ellipse2D e = new Ellipse2D.Double(x, y, x2, y2);
	     			TheFrame.TheCanves.shapes.add(e);
	     			TheFrame.TheCanves.repaint();
				}
				else if(PanelButtons.rectangleMode){
					Rectangle2D e = new Rectangle2D.Double(x, y, x2, y2);
	     			TheFrame.TheCanves.shapes.add(e);
	     			TheFrame.TheCanves.repaint();
				}
				
				
				
				
			}
		});
	}

}
