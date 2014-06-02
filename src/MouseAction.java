import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class MouseAction extends JPanel implements MouseInputListener
{
	public int x1, y1, x2, y2, Xcheck1 = 0, Ycheck1, Xcheck2 = 0, Ycheck2, xcheck = 0, ycheck = 0, mousepress = 0;
	public int xpoint1, ypoint1, xpoint2, ypoint2, clickcount , activate = 0;
	
	MainPanel main = null;
	PatrolAction action_poro;
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		clickcount += e.getClickCount();
		System.out.println(clickcount);
		if(clickcount == 2)
		{
			clickcount -= e.getClickCount();
			activate = 1;
			System.out.println("TAT");
			
			Timer tm = new Timer(100, new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e)
				{
					action_poro.PatrolActions();
					repaint();
					
				}
				
			});
			tm.start();
			//StartTimer();
			
		}

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (mousepress == 0)
		{
			System.out.println("check1");
			Xcheck1 = e.getX();
			Ycheck1 = e.getY();
			mousepress++;
		} else
		{
			Xcheck2 = e.getX();
			Ycheck2 = e.getY();
			mousepress = 0;
			x1 = Xcheck1;
			y1 = Ycheck1;
			x2 = Xcheck2;
			y2 = Ycheck2;
			if(Xcheck1 < Xcheck2)
			{
				xpoint1 = Xcheck1;
				xpoint2 = Xcheck2;
			}
			else
			{
				xpoint1 = Xcheck2;
				xpoint2 = Xcheck1;
			}
			if(Ycheck1 < Ycheck2)
			{
				ypoint1 = Ycheck1;
				ypoint2 = Ycheck2;
			}
			else
			{
				ypoint1 = Ycheck2;
				ypoint2 = Ycheck1;
			}
			System.out.println("check2");
		}

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}
	
	public void StartTimer()
	{
		main.TmPoro.stop();
		main.TmPoro.setDelay(100);
		main.TmPoro.start();
	}
	
	
	public int getX1()
	{
		return x1;
	}
	
	public int getY1()
	{
		return y1;
	}
	
	public int getX2()
	{
		return x2;
	}
	
	public int getY2()
	{
		return y2;
	}

}
