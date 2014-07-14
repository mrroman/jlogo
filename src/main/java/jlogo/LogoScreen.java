// Klasa LogoScreen

package jlogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class LogoScreen extends JComponent {
	Turtle turtles[] = {
		new Turtle(new Color(0,0,0)),
		new Turtle(new Color(85,85,0)),
		new Turtle(new Color(255,85,0)),
		new Turtle(new Color(0,170,0)),
		new Turtle(new Color(255,170,0)),
		new Turtle(new Color(0,0,255)),
		new Turtle(new Color(255,0,255)),
		new Turtle(new Color(255,255,0)) };
	
	Turtle currentTurtle;
	int currentTurtleNo=0;
	Color bgColor = new Color(255,255,255);
	
	public LogoScreen() {
		super();
		setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		currentTurtle=turtles[currentTurtleNo];
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;

		g2.setBackground(bgColor);
		g2.clearRect(0,0,getWidth(),getHeight());

		for (int j=0;j<turtles.length;j++)
			for (int i=0;i<turtles[j].getList().size();i++) {
				g2.setColor((Color)turtles[j].getColorList().get(i));
				g2.draw((Line2D)turtles[j].getList().get(i));
			}
	}
	
	public void clearScreen() {
		currentTurtle.getList().clear();
		turtleSetPos(0,0,false);
		repaint();
	}

	public void turtlesSet() {
		for (int i=0;i<turtles.length;i++) {
			turtles[i].setPos(getWidth()/2.0,getHeight()/2.0);
			turtles[i].setDirection(90);
		}
	}	

	
	public void turtleLeft(double angle) {
		currentTurtle.turn(angle);
	}
		
	public void turtleRight(double angle) {
		currentTurtle.turn(-angle);
	}

	public void turtleSetPos(double posx,double posy) {
		turtleSetPos(posx,posy,true);
	}

	public void turtleSetPos(double posx,double posy,boolean draw) {
		double x,y;

		x=currentTurtle.getX();
		y=currentTurtle.getY();
		currentTurtle.setPos(getWidth()/2.0+posx,getHeight()/2.0-posy);
		if (!draw || !currentTurtle.penDown()) return;

		currentTurtle.addLine(new Line2D.Double(
						x,
						y,
						currentTurtle.getX(),
						currentTurtle.getY()));

		repaint();		
	}


	public void turtleForward(double steps) {
		double x,y;

		x=currentTurtle.getX();
		y=currentTurtle.getY();
		currentTurtle.setPos(x+Math.cos(currentTurtle.getDirection())*steps,y-Math.sin(currentTurtle.getDirection())*steps);
		if (!currentTurtle.penDown()) return;

		currentTurtle.addLine(new Line2D.Double(
						x,
						y,
						currentTurtle.getX(),
						currentTurtle.getY()));

		repaint();		
	}

	public void turtleBackward(double steps) {
		double x,y;

		x=currentTurtle.getX();
		y=currentTurtle.getY();
		currentTurtle.setPos(x-Math.cos(currentTurtle.getDirection())*steps,y+Math.sin(currentTurtle.getDirection())*steps);
		if (!currentTurtle.penDown()) return;

		currentTurtle.addLine(new Line2D.Double(
						x,
						y,
						currentTurtle.getX(),
						currentTurtle.getY()));

		repaint();		
	}	

	public double turtleGetX() {
		return currentTurtle.getX()-getWidth()/2.0;
	}	
	
	public double turtleGetY() {
		return getHeight()/2.0-currentTurtle.getY();
	}	
	
	public double turtleGetHeading() {
		double h = (currentTurtle.getDirection()-Math.PI/2)*180/Math.PI;

		return h % 360;
	}

	public void turtleSetHeading(double angle) {
		double h = (angle*Math.PI/180.0)+Math.PI/2;

		currentTurtle.setDirection(h);
	}

	public void penUp() {
		currentTurtle.setPen(false);
	}

	public void penDown() {
		currentTurtle.setPen(true);
	}

	public int turtlesNumber()
	{
		return turtles.length;
	}

	public int getCurrentTurtle() {
		return currentTurtleNo;
	}

	public void chooseTurtle(int i) {
		currentTurtle=turtles[i % turtles.length];
		currentTurtleNo=i % turtles.length;
	}

	public void setColor(int r,int g,int b) {
		currentTurtle.setColor(new Color(r,g,b));
	}

	public void setBgColor(int r,int g,int b) {
		bgColor=new Color(r,g,b);
		repaint();
	}

	public Color getColor() {
		return currentTurtle.getColor();
	}

	public Color getBgColor() {
		return bgColor;
	}

}
