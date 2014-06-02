import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPanel extends JPanel
{
	Image img;
	Cursor Cursor;
	File op = new File(".\\Resource\\Poro.jpg");
	Buttons button1 = new Buttons();
	JRadioButton PoroButton = new JRadioButton("Poro");
	JRadioButton RengarButton = new JRadioButton("Rengar");
	JRadioButton AniviaButton = new JRadioButton("Anivia");
	JRadioButton NasusButton = new JRadioButton("Nasus");
	JRadioButton EliseButton = new JRadioButton("Elise");
	JRadioButton ShivanaButton = new JRadioButton("Shivana");
	JRadioButton PatrolButton = new JRadioButton("Patrol");
	JRadioButton MoveButton = new JRadioButton("Move");
	JRadioButton StopButton = new JRadioButton("Stop");
	ButtonGroup Group1 = new ButtonGroup();
	ButtonGroup Group2 = new ButtonGroup();

	PatrolAction action_poro;
	PatrolAction action_rengar;

	Renga rg = new Renga();
	Poro poro = new Poro();
	Spider elise = new Spider();
	
	Timer tm; 

	public int check_poro = 0;
	public int check_rengar = 0;
	public int check_elise = 0;
	public int x1, y1, x2, y2;
	public int ChampionMove, mousepress, clickcount = 0;
	public int RengaPat = 0, PoroPat = 0;

	int PoroStart = 0;
	int RengarStart = 0;

	Timer TmRengar;
	Timer TmPoro;

	MouseAction action = new MouseAction();

	int i;

	public MainPanel() throws IOException
	{
		setLayout(new BorderLayout());
		myCursor();
		Group1.add(PoroButton);
		Group1.add(RengarButton);
		Group1.add(AniviaButton);
		Group1.add(NasusButton);
		Group1.add(EliseButton);
		Group1.add(ShivanaButton);
		Group2.add(PatrolButton);
		Group2.add(MoveButton);
		Group2.add(StopButton);
		addMouseMotionListener(new MouseMotionListener()
		{

			@Override
			public void mouseDragged(MouseEvent e)
			{
				x1 = e.getX();
				y1 = e.getY();
				switch (ChampionMove)
				{
				case 101:
				{
					poro.x1 = x1-60;
					poro.y1 = y1-40;
					break;
				}
				case 102:
				{
					rg.x1 = x1;
					rg.y1 = y1;
					break;
				}
				case 103:
				{
					elise.x1 = x1-70;
					elise.y1 = y1-70;
				}
				}

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				final int x = e.getX();
				final int y = e.getY();

				setCursor(Cursor);

			}

		});
		// addMouseListener(action);

		button_action();
		img = ImageIO.read(op);

		add(button1, BorderLayout.NORTH);
		JPanel p1 = new JPanel();
		p1.add(PatrolButton);
		p1.add(MoveButton);
		p1.add(StopButton);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 3));
		p2.add(PoroButton);
		p2.add(RengarButton);
		p2.add(NasusButton);
		p2.add(AniviaButton);
		p2.add(EliseButton);
		p2.add(ShivanaButton);
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 3));
		p4.add(p2);
		p4.add(p1);
		add(p4, BorderLayout.SOUTH);
		repaint();

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Random rd = new Random();

		g.drawImage(img, 0, 0, null);
		if (check_poro == 1)
		{
			poro.draw(g2);
		}
		if (check_rengar == 1)
		{
			rg.draw(g2);
		}
		if(check_elise == 1)
		{
			elise.draw(g2);
		}

	}

	public void myCursor() throws IOException
	{

		Toolkit tk = Toolkit.getDefaultToolkit();

		Image lol = ImageIO.read(new File(".\\Resource\\LoL_cursor.png"));

		Cursor = tk.createCustomCursor(lol, new Point(10, 10), "OUR CURSOR");
		
		
	}

	public void button_action()
	{
		button1.character_select.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				Object[] Field1 =
				{ button1.character1, button1.character2, button1.character3,};
				int value = JOptionPane.showOptionDialog(null,
						"Select Character", "Select Character",
						JOptionPane.DEFAULT_OPTION, 0, null, Field1, Field1[i]);

			}

		});

		button1.character1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("poro");
				check_poro = 1;
				repaint();
			}

		});

		button1.character2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("rengar");
				check_rengar = 1;
				repaint();
			}

		});
		
		button1.character3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("elise");
				check_elise = 1;
				repaint();
			}

		});

		PatrolButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				PatrolActions();

			}

		});

		MoveButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				MoveActions();

			}

		});
		
		StopButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				tm.stop();
				action_poro.xpoint1 = 0;
				action_poro.ypoint1 = 0;
				action_poro.xpoint2 = 0;
				action_poro.ypoint2 = 0;
				x1=0;
				y1=0;
				x2=0;
				y2=0;
			}
			
		});
	}

	public void MoveActions()
	{
		if (PoroButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 101;
		}
		if (RengarButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 102;
		}
		if(EliseButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 103;
		}
	}

	public void PatrolActions()
	{
		if (PoroButton.isSelected()&& PatrolButton.isSelected())
		{
			System.out.println("Patrol");
			clickcount = 0;
			mousepress = 0;
			addMouseListener(new MouseListener()
			{

				@Override
				public void mouseClicked(MouseEvent e)
				{
					
					System.out.println(clickcount);
					if (clickcount == 2)
					{
						System.out.println("TAT");
						action_poro = new PatrolAction(x1, y1, x2, y2);
						tm = new Timer(100, new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e)
							{
								action_poro.PatrolActions();
								poro.x1 = action_poro.getX1();
								poro.y1 = action_poro.getY1();
								repaint();
							}

						});
						tm.stop();
						tm.setDelay(100);
						tm.start();
					}
				}

				@Override
				public void mouseEntered(MouseEvent arg0)
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0)
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e)
				{
					if (mousepress == 0)
					{
						System.out.println("check1");
						x1 = e.getX();
						y1 = e.getY();
						System.out.println("x1 :"+x1);
						mousepress++;
						clickcount = 1;
					} else
					{
						System.out.println("check2");
						x2 = e.getX();
						y2 = e.getY();
						System.out.println("x2 :"+x2);
						mousepress = 0;
						clickcount = 2;
					}

				}

				@Override
				public void mouseReleased(MouseEvent arg0)
				{
					// TODO Auto-generated method stub

				}

			});
		}
		
	}
	
	public void Timers()
	{
		Timer tm1 = new Timer(100, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(PoroButton.isSelected() && PatrolButton.isSelected())
				action_poro.PatrolActions();
				poro.x1 = action_poro.getX1();
				poro.y1 = action_poro.getY1();
				repaint();
			}

		});
	}
}