package edu.cofc.csci221.ui;
/**
 * 
 * @author Aaron Walton
 * @date 12-1-14
 * 
 *This class Creates the Fractal Panel as well as draws the KochLines
 *
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


import javax.swing.JPanel;

/**
 * 
 * @author Programming Assignment 9 - FractalPanel class
 * @since 18 Nov 2014
 * 
 * Class that inherits from JPanel with overridden
 * paintComponent method to draw Koch fractal lines
 * 
 *
 */
@SuppressWarnings("serial")
public class FractalPanel extends JPanel {

	// private instance variables
	private int strokeWidth = 1;
	private int level = 0;

	private ArrayList<Line> lines = new ArrayList<Line>();

	/**
	 * Constructor that accepts one parameter
	 * 
	 * DO NOT MODIFY
	 * 
	 * @param level = number of times fractal lines are divided
	 */
	public FractalPanel( int level ) {

		super();
		
		setBackground( Color.BLACK );
		
		if ( level >= 0 ) {
			
			this.level = level;
		
		}

	} // end constructor

	/**
	 * 
	 * Changes the stroke width (i.e. thickness) 
	 * of the line to be drawn.
	 * 
	 * DO NOT MODIFY
	 * 
	 * @param strokeWidth - integer data type
	 */
	public void setStroke( int strokeWidth ) {

		if ( strokeWidth > 1 ) {

			this.strokeWidth = strokeWidth;

		}

	} // end setStroke() method

	/**
	 * 
	 * Remove all line objects. After
	 * this operation is performed, no lines
	 * will be drawn on the FractalPanel.
	 * 
	 * DO NOT MODIFY
	 * 
	 */
	public void clear() {

		lines.clear();

	} // end clear()

	/**
	 * 
	 * Causes the panel to be repainted.
	 * 
	 * DO NOT MODIFY
	 * 
	 */
	public void draw() {

		repaint();
		revalidate();

	} // end draw() method

	/**
	 * Add a Line object to be drawn on the FractalPanel.
	 *  
	 * The Line class will be developed by you. 
	 * Please see Programming Assignment 4 for
	 * Further details.
	 * 
	 * DO NOT MODIFY
	 *  
	 * @param line - Represents a valid Line object
	 */
	public void addLine( Line line ) {

		if ( !lines.contains( line ) ) {

			lines.add( line );

		} 

	} // end addLine() method

	/**
	 * 
	 * Overridden method that draws lines
	 * on panel.
	 * 
	 * @param g - Graphics object
	 */
	public void paintComponent( Graphics g ) {

		super.paintComponent( g );

		Graphics2D g2 = (Graphics2D)g;

		g2.setPaint( Color.GREEN );
		g2.setStroke( new BasicStroke( strokeWidth  ) );
		
		/*
		 * ---------------------------------------
		 * TODO: Complete code below
		 * ---------------------------------------
		 * Iterate through each line in the ArrayList
		 * - call drawKochLine method (don't forget cast operation to KochLine)
		 * 
		 */
		/* iterating through the arrayList and calling the drawKochLine method
		 * 
		 */
		for(int i=0;i<lines.size();i++){
			drawKochLine(g2,level,(KochLine)lines.get(i));
			
		}
		
		

	} // end paintComponent() method

	/**
	 * 
	 * @param g2
	 * @param level
	 * @param line
	 */
	public void drawKochLine( Graphics2D g2, int level, KochLine line ) {
		
		/*
		 * ---------------------------------------
		 * TODO: Complete code below
		 * ---------------------------------------
		 * 
		 * Execute Algorithm provided in Assignment
		 * 
		 */
		// calling the computeFractal method
		 
		line.computeFractal();
	
		if(level==0){
			if(line.isKochLineValid()){
			g2.drawLine(line.getLineA().getStart().getX(),line.getLineA().getStart().getY(),line.getLineD().getEnd().getX(),line.getLineD().getEnd().getY());
			}
		}
		else{
			drawKochLine(g2,level-1,line.getLineA());
			drawKochLine(g2,level-1,line.getLineB());
			drawKochLine(g2,level-1,line.getLineC());
			drawKochLine(g2,level-1,line.getLineD());
		}
		
		

	} // end drawKochLine() method

} // end FractalPanel class definition
