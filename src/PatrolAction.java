
public class PatrolAction
{
	public int x1, y1, x2, y2, Xcheck1 = 0, Ycheck1, Xcheck2 = 0, Ycheck2, xcheck = 0, ycheck = 0, mousepress = 0;
	public int xpoint1, ypoint1, xpoint2, ypoint2;
	
	public PatrolAction(int x1, int y1, int x2, int y2)
	{
		System.out.println("Save");
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		Xcheck1 = x1;
		Ycheck1 = y1;
		Xcheck2 = x2;
		Ycheck2 = y2;
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
		System.out.println("xpoint1 :"+ xpoint1);
		System.out.println("xpoint2 :"+ xpoint2);
		System.out.println("ypoint1 :"+ ypoint1);
		System.out.println("ypoint2 :"+ ypoint2);
		System.out.println("xcheck :"+ xcheck);
		System.out.println("ycheck :"+ ycheck);
	}
	
	public void PatrolActions()
	{
		System.out.println("Patrol");
		System.out.println("xpoint1 :"+ xpoint1);
		System.out.println("xpoint2 :"+ xpoint2);
		System.out.println("ypoint1 :"+ ypoint1);
		System.out.println("ypoint2 :"+ ypoint2);
		System.out.println("xcheck :"+ xcheck);
		System.out.println("ycheck :"+ ycheck);
				
		if(x1 <= xpoint2)
		{
			if(xcheck == 0)
			{
			x1 = x1 + 1;
			}
			if( x1 >= xpoint2-1)
			{
				xcheck = 1;
			}			
			if(xcheck == 1)
			{
				x1 = x1- 1;
			}
			if(x1 <= xpoint1+1)
			{
				xcheck = 0;
			}
			
			System.out.println(x1);
			
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
			System.out.println(y1);
		}
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
