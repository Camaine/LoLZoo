package Main;

public class PatrolAction
{
	public int x1 = 0, y1 = 0, x2, y2, Xcheck1 = 0, Ycheck1, Xcheck2 = 0, Ycheck2, xcheck = 0, ycheck = 0, mousepress = 0;
	public int xpoint1, ypoint1, xpoint2, ypoint2;
	
	public PatrolAction(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		Xcheck1 = x1;				//Xcheck1과 Ycheck1은 처음에 한번 클릭했을때의 좌표를 상징
		Ycheck1 = y1;
		Xcheck2 = x2;				//Xcheck2와 Ycheck2는 두번째 클릭했을 때의 좌표를 상징한다.
		Ycheck2 = y2;
		if(Xcheck1 < Xcheck2)		//반드시 xpoint1 < xpoint2 를 성립시킨다.
		{
			xpoint1 = Xcheck1;		//작은Xcheck 값이 xpoint1에 들어가고 큰 값이 xpoint2에 들어간다.
			xpoint2 = Xcheck2;		//point는 패트롤을 할 좌표를 뜻한다.
		}
		else
		{
			xpoint1 = Xcheck2;
			xpoint2 = Xcheck1;
		}
		if(Ycheck1 < Ycheck2)		//반드시 ypoint1 < ypoint2를 성립시킨다.
		{
			ypoint1 = Ycheck1;		//위의 설명과 같다.
			ypoint2 = Ycheck2;
		}
		else
		{
			ypoint1 = Ycheck2;
			ypoint2 = Ycheck1;
		}
	}
	
	public PatrolAction()
	{
		// TODO Auto-generated constructor stub
	}

	public void PatrolActions()
	{
		if(x1 <= xpoint2)
		{
			if(xcheck == 0)			//초기상태이다.
			{
			x1 = x1 + 1;			//x1+=1을 함으로서 x좌표는 1증가하여 
			}						//오른쪽으로 이동하는 효과를 낸다.
			if( x1 >= xpoint2-1)	//오른쪽으로 이동하다가 xpoint2에 맞닿뜨렸을 경우
			{
				xcheck = 1;			//오른쪽 끝에 도달했다는것을 알리기위해 xcheck = 1이된다.
			}			
			if(xcheck == 1)			//오른쪽 끝에 도달했으므로
			{
				x1 = x1- 1;			//x1좌표는 점점 1씩감소하여
			}						//왼쪽으로 이동하는 효과를 낸다.
			if(x1 <= xpoint1+1)		//그러다가 왼쪽끝에 도달한다면
			{
				xcheck = 0;			//왼쪽끝에 도달했다는것을 알리기위해 xcheck = 0이된다.
			}
		}
		if(y1 <=ypoint2)
		{
			if(ycheck ==0)
			{
				y1 = y1+1;
			}
			if(y1 >= ypoint2-1)
			{
				ycheck = 1;
			}
			if(ycheck == 1)
			{
				y1 = y1-1;
			}
			if(y1 <= ypoint1+1)
			{
				ycheck = 0;
			}
		}
	}
	public int getX1()
	{
		return x1 - 50;
	}
	
	public int getY1()
	{
		return y1 - 50;
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
