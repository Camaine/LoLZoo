import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;


public class Poro extends JPanel implements DrawAnimal
{
	int size = 0;
	int move = 0;
	int x1 = 0;
	int y1 = 0;
	BasicStroke BS = new BasicStroke(3);
	Color white = new Color(255,255,255);
	Color black = new Color(0,0,0);
	Color tong = new Color(255,200,200);
	Color horn = new Color(180,180,100);
	Ellipse2D.Double fur1 = new Ellipse2D.Double();
	Ellipse2D.Double fur2 = new Ellipse2D.Double();
	Ellipse2D.Double fur3 = new Ellipse2D.Double();
	Ellipse2D.Double fur4 = new Ellipse2D.Double();
	Ellipse2D.Double fur5 = new Ellipse2D.Double();
	Ellipse2D.Double fur6 = new Ellipse2D.Double();
	Ellipse2D.Double fur7 = new Ellipse2D.Double();
	Ellipse2D.Double fur8 = new Ellipse2D.Double();
	Ellipse2D.Double fur9 = new Ellipse2D.Double();
	Ellipse2D.Double eye1 = new Ellipse2D.Double();
	Ellipse2D.Double eye2 = new Ellipse2D.Double();
	Ellipse2D.Double leg1 = new Ellipse2D.Double();
	Ellipse2D.Double leg2 = new Ellipse2D.Double();
	Ellipse2D.Double leg3 = new Ellipse2D.Double();
	Line2D.Double mouth = new Line2D.Double();
	Line2D.Double Bul1 = new Line2D.Double();
	Line2D.Double Bul2 = new Line2D.Double();
	Line2D.Double Bul3= new Line2D.Double();
	Line2D.Double Bul4 = new Line2D.Double();
	public Poro()
	{
		repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
				
	}

	@Override
	public void draw(Graphics2D g2)
	{
		Ellipse2D.Double body = new Ellipse2D.Double(x1+10,y1+10,100,60);
		g2.setColor(white);
		g2.fill(body);
		g2.draw(body);
		
		for(int i=0; i<5; i++)
		{
			Bul3 = new Line2D.Double(x1+92+i, y1+10+i, x1+95+i, y1+5+i);			//¿À¸¥ÂÊ »ÔÀ» ±×·ÁÁÜ(¿ì¸®½Ã¼± ±âÁØ)
			g2.setStroke(BS);
			g2.setColor(horn);
			g2.draw(Bul3);
		}
		
		for(int i=0; i<7; i++)
		{
			Bul4 = new Line2D.Double(x1+94+2*i, y1+6+i, x1+98+i, y1+5+i);	//¿À¸¥ÂÊ »ÔÀ» ±×·ÁÁÜ(¿ì¸®½Ã¼± ±âÁØ)
			g2.setStroke(BS);
			g2.setColor(horn);
			g2.draw(Bul4);
		}
		
		leg1 = new Ellipse2D.Double(x1+20,y1+67,10,10);
		g2.setColor(white);
		g2.fill(leg1);
		g2.draw(leg1);
		
		leg2 = new Ellipse2D.Double(x1+70,y1+67,10,10);
		g2.setColor(white);
		g2.fill(leg2);
		g2.draw(leg2);
		
		leg3 = new Ellipse2D.Double(x1+103,y1+59,10,10);
		g2.setColor(white);
		g2.fill(leg3);
		g2.draw(leg3);
		
		for(int i=0; i<5; i++)
		{
			fur1 = new Ellipse2D.Double(x1+12+i*6,y1+15-i*2,10,10);
			g2.setColor(white);
			g2.fill(fur1);
			g2.draw(fur1);
		}
		
		for(int i=0; i<7; i++)
		{
			fur2 = new Ellipse2D.Double(x1+40+i*6,y1+7,10,10);
			g2.setColor(white);
			g2.fill(fur2);
			g2.draw(fur2);
		}
		
		for(int i=0; i<4; i++)
		{
			fur3 = new Ellipse2D.Double(x1+76+i*6,y1+7+i*3,10,10);
			g2.setColor(white);
			g2.fill(fur3);
			g2.draw(fur3);
		}
		
		for(int i=0; i<6; i++)
		{
			fur4 = new Ellipse2D.Double(x1+94+i*2,y1+16+i*4,10,10);
			g2.setColor(white);
			g2.fill(fur4);
			g2.draw(fur4);
		}
		
		for(int i=0; i<5; i++)
		{
			fur5 = new Ellipse2D.Double(x1+104,y1+35+i*4,10,10);
			g2.setColor(white);
			g2.fill(fur5);
			g2.draw(fur5);
		}
		
		for(int i=0; i<5; i++)
		{
			fur6 = new Ellipse2D.Double(x1+100-i*5,y1+55+i*2,10,10);
			g2.setColor(white);
			g2.fill(fur6);
			g2.draw(fur6);
		}
		
		for(int i=0; i<15; i++)
		{
			fur7 = new Ellipse2D.Double(x1+85-i*5,y1+62,10,10);
			g2.setColor(white);
			g2.fill(fur7);
			g2.draw(fur7);
		}
		
		for(int i=0; i<8; i++)
		{
			fur8 = new Ellipse2D.Double(x1+12-i,y1+59-i*2,10,10);
			g2.setColor(white);
			g2.fill(fur8);
			g2.draw(fur8);
		}
		
		for(int i=0; i<8; i++)
		{
			fur9 = new Ellipse2D.Double(x1+4+i,y1+45-i*4,10,10);
			g2.setColor(white);
			g2.fill(fur9);
			g2.draw(fur9);
		}
		
		eye1 = new Ellipse2D.Double(x1+55,y1+30,10,10);					//¿ÞÂÊ´«
		g2.setColor(black);
		g2.fill(eye1);
		g2.draw(eye1);
		
		eye2 = new Ellipse2D.Double(x1+95,y1+25,10,10);					//¿À¸¥ÂÊ´«
		g2.setColor(black);
		g2.fill(eye2);
		g2.draw(eye2);
		
		for(int i=0; i<10; i++)
		{
			mouth = new Line2D.Double(x1+70+i, y1+55+i, x1+95-i, y1+50+2*i);		//ÀÔºÎºÐ(Çô)
			g2.setStroke(BS);
			g2.setColor(tong);
			g2.draw(mouth);
		}
		
		for(int i=0; i<8; i++)
		{
			Bul1 = new Line2D.Double(x1+45-i, y1+25-i, x1+49-i, y1+21-i);		//¿ÞÂÊ»Ô±×·ÁÁÜ(¿ì¸®½Ã¼±±âÁØ)
			g2.setStroke(BS);
			g2.setColor(horn);
			g2.draw(Bul1);
		}
		
		for(int i=0; i<4; i++)
		{
			Bul2 = new Line2D.Double(x1+39+i, y1+18+i, x1+35, y1+30);		//¿ÞÂÊ»Ô±×·ÁÁÜ(¿ì¸®½Ã¼±±âÁØ)
			g2.setStroke(BS);
			g2.setColor(horn);
			g2.draw(Bul2);
		}
		
	}
}
