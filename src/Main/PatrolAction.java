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
		Xcheck1 = x1;				//Xcheck1�� Ycheck1�� ó���� �ѹ� Ŭ���������� ��ǥ�� ��¡
		Ycheck1 = y1;
		Xcheck2 = x2;				//Xcheck2�� Ycheck2�� �ι�° Ŭ������ ���� ��ǥ�� ��¡�Ѵ�.
		Ycheck2 = y2;
		if(Xcheck1 < Xcheck2)		//�ݵ�� xpoint1 < xpoint2 �� ������Ų��.
		{
			xpoint1 = Xcheck1;		//����Xcheck ���� xpoint1�� ���� ū ���� xpoint2�� ����.
			xpoint2 = Xcheck2;		//point�� ��Ʈ���� �� ��ǥ�� ���Ѵ�.
		}
		else
		{
			xpoint1 = Xcheck2;
			xpoint2 = Xcheck1;
		}
		if(Ycheck1 < Ycheck2)		//�ݵ�� ypoint1 < ypoint2�� ������Ų��.
		{
			ypoint1 = Ycheck1;		//���� ����� ����.
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
			if(xcheck == 0)			//�ʱ�����̴�.
			{
			x1 = x1 + 1;			//x1+=1�� �����μ� x��ǥ�� 1�����Ͽ� 
			}						//���������� �̵��ϴ� ȿ���� ����.
			if( x1 >= xpoint2-1)	//���������� �̵��ϴٰ� xpoint2�� �´�߷��� ���
			{
				xcheck = 1;			//������ ���� �����ߴٴ°��� �˸������� xcheck = 1�̵ȴ�.
			}			
			if(xcheck == 1)			//������ ���� ���������Ƿ�
			{
				x1 = x1- 1;			//x1��ǥ�� ���� 1�������Ͽ�
			}						//�������� �̵��ϴ� ȿ���� ����.
			if(x1 <= xpoint1+1)		//�׷��ٰ� ���ʳ��� �����Ѵٸ�
			{
				xcheck = 0;			//���ʳ��� �����ߴٴ°��� �˸������� xcheck = 0�̵ȴ�.
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
