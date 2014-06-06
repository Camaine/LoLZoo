package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

@SuppressWarnings("serial")
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
	public void mouseClicked(MouseEvent e)			//이거 작동안하는듯 언제작동함?
	{
		clickcount += e.getClickCount();		
		System.out.println(clickcount);
		if(clickcount == 2)					
		{
			clickcount = 0;
			activate = 1;
			System.out.println("TAT");
			
			Timer tm = new Timer(100, new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Check13");
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
		if (mousepress == 0)		//mousepress의 초기값은 0이다. 따라서 첫작동
		{
			System.out.println("check1");
			Xcheck1 = e.getX();			//첫번째 클릭했을때의x,y좌표를 받는다.
			Ycheck1 = e.getY();
			mousepress++;				//다음에 눌렀을때 시행되지 않는다.
		} 
		else
		{
			Xcheck2 = e.getX();			//2번째 클릭했을 때 x,y 좌표를 받는다.
			Ycheck2 = e.getY();
			mousepress = 0;				//초기상태로 되돌린다. 즉 다음에는 위의 if문이 실행될것.
			x1 = Xcheck1;				//x1 y1 x2 y2의 값을 저장하고
			y1 = Ycheck1;
			x2 = Xcheck2;
			y2 = Ycheck2;
			if(Xcheck1 < Xcheck2)		//Xcheck중 크기가 작은것이 xpoint1, 큰것이 xpoint2로 되게한다.
			{
				xpoint1 = Xcheck1;
				xpoint2 = Xcheck2;
			}
			else
			{
				xpoint1 = Xcheck2;
				xpoint2 = Xcheck1;
			}
			if(Ycheck1 < Ycheck2)		//Ycheck중 크기가 작은것이 ypoint1, 큰것이 ypoint2로 되게한다.
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
