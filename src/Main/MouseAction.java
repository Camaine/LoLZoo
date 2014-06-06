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
	public void mouseClicked(MouseEvent e)			//�̰� �۵����ϴµ� �����۵���?
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
		if (mousepress == 0)		//mousepress�� �ʱⰪ�� 0�̴�. ���� ù�۵�
		{
			System.out.println("check1");
			Xcheck1 = e.getX();			//ù��° Ŭ����������x,y��ǥ�� �޴´�.
			Ycheck1 = e.getY();
			mousepress++;				//������ �������� ������� �ʴ´�.
		} 
		else
		{
			Xcheck2 = e.getX();			//2��° Ŭ������ �� x,y ��ǥ�� �޴´�.
			Ycheck2 = e.getY();
			mousepress = 0;				//�ʱ���·� �ǵ�����. �� �������� ���� if���� ����ɰ�.
			x1 = Xcheck1;				//x1 y1 x2 y2�� ���� �����ϰ�
			y1 = Ycheck1;
			x2 = Xcheck2;
			y2 = Ycheck2;
			if(Xcheck1 < Xcheck2)		//Xcheck�� ũ�Ⱑ �������� xpoint1, ū���� xpoint2�� �ǰ��Ѵ�.
			{
				xpoint1 = Xcheck1;
				xpoint2 = Xcheck2;
			}
			else
			{
				xpoint1 = Xcheck2;
				xpoint2 = Xcheck1;
			}
			if(Ycheck1 < Ycheck2)		//Ycheck�� ũ�Ⱑ �������� ypoint1, ū���� ypoint2�� �ǰ��Ѵ�.
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
