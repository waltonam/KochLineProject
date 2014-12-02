package edu.cofc.csci221.ui;
/**
 * 
 * @author Aaron Walton
 * @date 12-1-14
 * 
 *This Class creates the Points used for the KochLines as well as creates the KochLine Lines used to make the Fractals
 *This class contains a constructor, getters for each line, a method that compiles the points, and a method to check kochLine validity
 */


public class KochLine extends Line {
	// setting all the points to null
	Point p1=null;
	Point p2=null;
	Point p3=null;
	Point p4=null;
	Point p5=null;
	// creating the constructor for the KochLine Class 
	/**
	 * Constructor that accepts two parameters that are Points
	 *
	 * @param Start= starting point object End=Ending Point Object
	 */
	public KochLine(Point start,Point end){
		// calling the super class with the two objects
		super(start,end);
		//setting p1 and p5 to the start and end points
		p1=this.getStart();
		p5=this.getEnd();
	}
	/**
	 * Creates the first part of the KochLine(segment A)
	 * 
	 * @param none
	 * @return KochLine Object(Line A)
	 */
	public KochLine getLineA(){
		
		KochLine lineA=new KochLine(p1,p2);
		return lineA;
	}
	/**
	 * Creates the first part of the KochLine(segment B)
	 * 
	 * @param none
	 * @return KochLine Object(Line B)
	 */
	public KochLine getLineB(){
		
		KochLine lineB=new KochLine(p2,p3);
		return lineB;
	}
	/**
	 * Creates the first part of the KochLine(segment C)
	 * 
	 * @param none
	 * @return KochLine Object (Line C)
	 * @throws OutOfBoundsException
	 */
	public KochLine getLineC(){
		
		KochLine lineC=new KochLine(p3,p4);
		return lineC;
	}
	/**
	 * Creates the first part of the KochLine(segment D)
	 * 
	 * @param none
	 * @return KochLine Object(Line D)
	 * @throws OutOfBoundsException
	 */
	public KochLine getLineD(){
		KochLine lineD=new KochLine(p4,p5);
		return lineD;
	}
	/**
	 * Creates all the needed Points to create the KochLines and does the calculation for these Points
	 * 
	 * @param None
	 * @return Void
	 * 
	 */
	public void computeFractal(){
		int deltaX51=p5.getX()-p1.getX();
		int deltaY51=p5.getY()-p1.getY();
		int x2=p1.getX()+(deltaX51/3);
		int y2=p1.getY()+(deltaY51/3);
		p2= new Point(x2,y2);
		int x3=(int)((p1.getX()+p5.getX())/2 + (Math.sqrt(3)*(p1.getY()-p5.getY()))/6);
		int y3=(int)((p1.getY()+p5.getY())/2 + (Math.sqrt(3)*(p5.getX()-p1.getX()))/6);
		p3=new Point(x3,y3);
		int x4=p1.getX() + (2*deltaX51/3);
		int y4=p1.getY()+(2*deltaY51/3);
		p4=new Point(x4,y4);
	}
	/**
	 * Checks to see if the KochLine objects that were created are valid
	 * 
	 * @param None
	 * @return Boolean: True if they are all valid Lines, False if one is False
	 
	 */
	public boolean isKochLineValid(){
		return getLineA().isValid() && getLineB().isValid() && getLineC().isValid() && getLineD().isValid();
			
		}
	
	
	
	
}
