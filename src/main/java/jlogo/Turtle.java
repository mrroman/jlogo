// klasa Turtle
//

package jlogo;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Turtle {
	private ArrayList lineList;
	private ArrayList colorList;
	private Color color;
	private double x,y;
	private double dir=Math.PI/2.0;
	private boolean penDown=true;
	
	public Turtle(Color color)
	{
		this.color=color;
		lineList=new ArrayList();
		colorList=new ArrayList();
	}

	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color=color;
	}

	public void setPos(double x,double y)
	{
		this.x=x;
		this.y=y;
	}

	public void setDirection(double dir)
	{
		this.dir=dir*Math.PI/180.0;
	}

	public void turn(double dir)
	{
		this.dir+=dir*Math.PI/180.0;
	}
			
	public double getDirection()
	{
		return dir;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}

	public boolean penDown()
	{
		return penDown;
	}

	public void setPen(boolean newPos)
	{
		penDown=newPos;
	}

	public ArrayList getList() {
		return lineList;
	}

	public ArrayList getColorList() {
		return colorList;
	}

	public void addLine(Line2D line) {
		lineList.add(line);
		colorList.add(color);
	}
}
