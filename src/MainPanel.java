import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.Border;

public class MainPanel extends JPanel
{
	Image rifts, abysss;
	Cursor Cursor;
	File rift_bg = new File(".\\Resource\\Background.png");
	File abyss_bg = new File(".\\Resource\\Background2.png");
	Buttons button1 = new Buttons();
	JRadioButton PoroButton = new JRadioButton();
	JRadioButton RengarButton = new JRadioButton();
	JRadioButton AhriButton = new JRadioButton();
	JRadioButton NidaleeButton = new JRadioButton();
	JRadioButton EliseButton = new JRadioButton();
	JRadioButton ShivanaButton = new JRadioButton();
	JRadioButton PatrolButton = new JRadioButton();
	JRadioButton MoveButton = new JRadioButton();
	JRadioButton StopButton = new JRadioButton();
	JRadioButton rift = new JRadioButton();
	JRadioButton abyss = new JRadioButton();
	ButtonGroup Group1 = new ButtonGroup();
	ButtonGroup Group2 = new ButtonGroup();
	ButtonGroup Group3 = new ButtonGroup();
	ButtonIcons bti = new ButtonIcons();

	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border compound = BorderFactory.createCompoundBorder(raisedbevel,
			loweredbevel);

	PatrolAction action_poro;
	PatrolAction action_rengar;
	PatrolAction action_elise;
	PatrolAction action_ahri;
	PatrolAction action_nidalee;

	Renga rg = new Renga();
	Poro poro = new Poro();
	Spider elise = new Spider();
	Ahri ahri = new Ahri();
	Nidalee nidalee = new Nidalee();

	Timer tm1;
	MouseListen Patroler = new MouseListen();

	public int check_poro = 0;
	public int check_rengar = 0;
	public int check_elise = 0;
	public int check_ahri = 0;
	public int check_nidalee = 0;
	public int check_bg = 1;
	public int x1, y1, x2, y2;
	public int ChampionMove, mousepress = 0, clickcount = 0;
	public int RengaPat = 0, PoroPat = 0;

	int PoroStart = 0;
	int RengarStart = 0;
	int HowManyCome = 0;

	Timer TmRengar;
	Timer TmPoro;

	MouseAction action = new MouseAction();

	int i;
	int Only_One = 0;
	int poro_patrol_check = 0;
	int rengar_patrol_check = 0;
	int elise_patrol_check = 0;
	int ahri_patrol_check = 0;
	int nidalee_patrol_check = 0;

	public MainPanel() throws IOException
	{
		setLayout(new BorderLayout());
		myCursor();
		Group1.add(PoroButton);
		Group1.add(RengarButton);
		Group1.add(AhriButton);
		Group1.add(NidaleeButton);
		Group1.add(EliseButton);
		Group1.add(ShivanaButton);
		Group2.add(PatrolButton);
		Group2.add(MoveButton);
		Group2.add(StopButton);
		Group3.add(rift);
		Group3.add(abyss);
		PoroButton.setBackground(new Color(60, 60, 60));
		RengarButton.setBackground(new Color(60, 60, 60));
		AhriButton.setBackground(new Color(60, 60, 60));
		EliseButton.setBackground(new Color(60, 60, 60));
		NidaleeButton.setBackground(new Color(60, 60, 60));
		ShivanaButton.setBackground(new Color(60, 60, 60));
		MoveButton.setBackground(new Color(60, 60, 60));
		PatrolButton.setBackground(new Color(60, 60, 60));
		StopButton.setBackground(new Color(60, 60, 60));
		rift.setBackground(new Color(60, 60, 60));
		abyss.setBackground(new Color(60, 60, 60));
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
					if (HowManyCome == 0)
					{
						poro.x1 = x1 - 60;
						poro.y1 = y1 - 40;
						break;
					}
				}
				case 102:
				{
					if (HowManyCome == 0)
					{
						rg.x1 = x1;
						rg.y1 = y1;
						break;
					}
				}
				case 103:
				{
					if (HowManyCome == 0)
					{
						elise.x1 = x1 - 70;
						elise.y1 = y1 - 70;
					}
				}
				case 104:
				{
					if (HowManyCome == 0)
					{
						ahri.x1 = x1 - 70;
						ahri.y1 = y1 - 70;
					}
				}
				case 105:
				{
					if (HowManyCome == 0 && ChampionMove == 105)
					{
						nidalee.x1 = x1 - 70;
						nidalee.y1 = y1 - 70;
					}
				}
				}

				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				final int x = e.getX();
				final int y = e.getY();
				Icons();
				setCursor(Cursor);

			}

		});
		// addMouseListener(action);

		button_action();
		rifts = ImageIO.read(rift_bg);
		abysss = ImageIO.read(abyss_bg);

		add(button1, BorderLayout.NORTH);
		JPanel p1 = new JPanel();
		p1.setBorder(compound);
		p1.add(PatrolButton);
		p1.add(MoveButton);
		p1.add(StopButton);
		p1.setBackground(new Color(60, 60, 60));
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 3));
		p2.setBorder(compound);
		p2.add(PoroButton);
		p2.add(RengarButton);
		p2.add(NidaleeButton);
		p2.add(AhriButton);
		p2.add(EliseButton);
		p2.add(ShivanaButton);
		p2.setBackground(new Color(60, 60, 60));
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		p3.setBorder(compound);
		p3.add(rift);
		p3.add(abyss);
		p3.setBackground(new Color(60, 60, 60));
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 3));
		p4.add(p3);
		p4.add(p2);
		p4.add(p1);
		p4.setBackground(Color.black);
		add(p4, BorderLayout.SOUTH);
		repaint();

	}

	public class MouseListen implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) // 클릭해서 패트롤을 작동시킴
		{
			if (HowManyCome == 0)
			{
				System.out.println(clickcount);
				if (clickcount == 2)
				{
					System.out.println("MainPanel_TAT");
					clickcount = 0;
					mousepress = 0;
					if (PoroButton.isSelected() && PatrolButton.isSelected())
					{
						action_poro = new PatrolAction(x1, y1, x2, y2);
						poro_patrol_check = 1;

					}
					if (RengarButton.isSelected() && PatrolButton.isSelected())
					{
						action_rengar = new PatrolAction(x1, y1, x2, y2);
						rengar_patrol_check = 1;
					}
					HowManyCome += 1; // 패트롤이 한번시행되면 이 변수의 값이 증가하여
					Timers();

				}
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
			if (HowManyCome == 0)
			{
				if (mousepress == 0)
				{
					System.out.println("check1");
					x1 = e.getX();
					y1 = e.getY();
					System.out.println("x1 :" + x1);
					mousepress++;
					clickcount = 1;
				} else
				{
					System.out.println("check2");
					x2 = e.getX();
					y2 = e.getY();
					System.out.println("x2 :" + x2);
					mousepress = 0;
					clickcount = 2;
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			// TODO Auto-generated method stub

		}

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Random rd = new Random();

		if (check_bg == 1)
		{
			g.drawImage(rifts, 0, 0, null);
		} else
			g.drawImage(abysss, 0, 0, null);

		if (check_poro == 1)
		{
			poro.draw(g2);
		}
		if (check_rengar == 1)
		{
			rg.draw(g2);
		}
		if (check_elise == 1)
		{
			elise.draw(g2);
		}
		if (check_ahri == 1)
		{
			ahri.draw(g2);
		}
		if (check_nidalee == 1)
		{
			nidalee.draw(g2);
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
				{ button1.character1, button1.character2, button1.character3,
						button1.character4, button1.character5 };
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

		button1.character4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("ahri");
				check_ahri = 1;
				repaint();
			}

		});

		button1.character5.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("nidalee");
				check_nidalee = 1;
				repaint();
			}

		});

		PatrolButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				PatrolActions();
				// MoveActions();
			}

		});

		MoveButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// PatrolActions();
				MoveActions();
			}

		});

		StopButton.addActionListener(new ActionListener() // StopButton은 초기화를
															// 해줌으로써 멈추는것을 유도한다.
				{

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						if (PoroButton.isSelected() && StopButton.isSelected())
							poro_patrol_check = 0;
						if (RengarButton.isSelected() && StopButton.isSelected())
							rengar_patrol_check = 0;
						System.out.println("STOP");
						
						x1 = 0;
						y1 = 0;
						x2 = 0;
						y2 = 0;
						clickcount = 0;
						mousepress = 0;
						HowManyCome = 0; // HowManyCome 변수는 패트롤을 몇번 시행했는지
											// 알려준다.(그냥 패트롤중엔 드래그불가변수)
						/*poro_patrol_check = 0;
						rengar_patrol_check = 0;
						elise_patrol_check = 0;
						ahri_patrol_check = 0;
						nidalee_patrol_check = 0; */// 이 변수는 Patrol버튼이 딱 1번만
													// 작동시키도록 하기위한 변수다.
						PatrolActions(); // 한번더 호출해줘서 지우도록함
						MoveActions(); // Stop시 한번더 호출해서 초기상태로 되돌린다.
					}

				});

		rift.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				check_bg = 1;
				repaint();
			}

		});

		abyss.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				check_bg = 0;
				repaint();
			}

		});
	}

	public void MoveActions() // 이 메소드는 스위치를 작동시키는 메소드다 //드래그(MOVE) 버튼
	{
		if (PoroButton.isSelected() && MoveButton.isSelected()) // 각각의 경우에 대해서
																// 어떤 동물이 선택되었는지
																// 알수있다.
		{
			ChampionMove = 101;
		}
		if (RengarButton.isSelected() && MoveButton.isSelected()) // 무브버튼과 특정
																	// 동물의 버튼에
																	// 따라서 스위치가
																	// 달라진다.
		{
			ChampionMove = 102;
		}
		if (EliseButton.isSelected() && MoveButton.isSelected()) // 이 함수를 호출하면
																	// 검사를 진행하므로
																	// 자주 호출해서
		{ // 초기화를 시켜주는것이 좋은것으로 판단된다.
			ChampionMove = 103;
		}
		if (AhriButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 104;
		}
		if (NidaleeButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 105;
		}
		if (!MoveButton.isSelected()) // 재호출을 했을때 Move가 선택되지 않았다면 초기상태로 되돌린다.
		{ // 초기화 작업
			ChampionMove = 0;
		}
	}

	public void PatrolActions() // 이 메소드는 패트롤버튼과 어떤 동물의 버튼이 눌렸는지 검사한다. 패트롤 버튼
	{
		if (PoroButton.isSelected() && PatrolButton.isSelected()
				&& poro_patrol_check == 0)
		{
			System.out.println("P_B : " + PoroButton.isSelected());
			System.out.println("Patrol_Button : " + PatrolButton.isSelected());
			System.out.println("Patrol");
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected()) // 재실행을
																		// 하였을 때
																		// 패트롤이
																		// 아니라면
																		// Patroler
																		// 마우스리스너를
																		// 삭제한다.
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			poro_patrol_check = 0;
			System.out.println("FALSE Patroler ACT");
		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			System.out.println("Nothing Happen");
			if (PoroButton.isSelected() && PatrolButton.isSelected())
				poro_patrol_check = 1;
		}

		if (RengarButton.isSelected() && PatrolButton.isSelected()
				&& rengar_patrol_check == 0)
		{
			System.out.println("P_B : " + RengarButton.isSelected());
			System.out.println("Patrol_Button : " + PatrolButton.isSelected());
			System.out.println("Patrol");
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected()) // 재실행을
																		// 하였을 때
																		// 패트롤이
																		// 아니라면
																		// Patroler
																		// 마우스리스너를
																		// 삭제한다.
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			rengar_patrol_check = 0;
			System.out.println("FALSE Patroler ACT");
		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			System.out.println("Nothing Happen");
			if (RengarButton.isSelected() && PatrolButton.isSelected())
				rengar_patrol_check = 1;
		}
	}

	public void Timers() // 패트롤을 해주는 타이머
	{
		tm1 = new Timer(100, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (PoroButton.isSelected() && PatrolButton.isSelected()
						|| poro_patrol_check == 1)
				{
					System.out.println(poro_patrol_check);
					action_poro.PatrolActions();
					poro.x1 = action_poro.getX1();
					poro.y1 = action_poro.getY1();
				}
				if (RengarButton.isSelected() && PatrolButton.isSelected()
						|| rengar_patrol_check == 1)
				{
					action_rengar.PatrolActions();
					rg.x1 = action_rengar.getX1();
					rg.y1 = action_rengar.getY1();
				}
				if (EliseButton.isSelected() && PatrolButton.isSelected())
				{
					action_elise.PatrolActions();
					elise.x1 = action_elise.getX1();
					elise.y1 = action_elise.getY1();
				}
				if (AhriButton.isSelected() && PatrolButton.isSelected())
				{
					action_ahri.PatrolActions();
					ahri.x1 = action_ahri.getX1();
					ahri.y1 = action_ahri.getY1();
				}
				if (NidaleeButton.isSelected() && PatrolButton.isSelected())
				{
					action_nidalee.PatrolActions();
					nidalee.x1 = action_nidalee.getX1();
					nidalee.y1 = action_nidalee.getY1();
				}

				repaint();
			}

		});

		tm1.stop();
		tm1.setDelay(100);
		tm1.start();
	}

	public void Icons() // 간지나는 아이콘들
	{
		// ///////////////////////포로//////////////////////////////
		if (PoroButton.isSelected() == false && check_poro == 0)
		{
			PoroButton.setIcon(new ImageIcon(bti.poro_disable));
		} else if (PoroButton.isSelected() == false && check_poro == 1)
		{
			PoroButton.setIcon(new ImageIcon(bti.poro_active));
		} else if (PoroButton.isSelected() && check_poro == 1)
		{
			PoroButton.setIcon(new ImageIcon(bti.poro_selected));
		}
		// ///////////////////////렝가//////////////////////////////
		if (RengarButton.isSelected() == false && check_rengar == 0)
		{
			RengarButton.setIcon(new ImageIcon(bti.rengar_disable));
		} else if (RengarButton.isSelected() == false && check_rengar == 1)
		{
			RengarButton.setIcon(new ImageIcon(bti.rengar_active));
		} else if (RengarButton.isSelected() && check_rengar == 1)
		{
			RengarButton.setIcon(new ImageIcon(bti.rengar_selected));
		}
		// ///////////////////////아리//////////////////////////////
		if (AhriButton.isSelected() == false && check_ahri == 0)
		{
			AhriButton.setIcon(new ImageIcon(bti.ahri_disable));
		} else if (AhriButton.isSelected() == false && check_ahri == 1)
		{
			AhriButton.setIcon(new ImageIcon(bti.ahri_active));
		} else if (AhriButton.isSelected() && check_ahri == 1)
		{
			AhriButton.setIcon(new ImageIcon(bti.ahri_selected));
		}
		// //////////////////////엘리스//////////////////////////////
		if (EliseButton.isSelected() == false && check_elise == 0)
		{
			EliseButton.setIcon(new ImageIcon(bti.elise_disable));
		} else if (EliseButton.isSelected() == false && check_elise == 1)
		{
			EliseButton.setIcon(new ImageIcon(bti.elise_active));
		} else if (EliseButton.isSelected() && check_elise == 1)
		{
			EliseButton.setIcon(new ImageIcon(bti.elise_selected));
		}
		// //////////////////////니달리//////////////////////////////
		if (NidaleeButton.isSelected() == false && check_nidalee == 0)
		{
			NidaleeButton.setIcon(new ImageIcon(bti.nidalee_disable));
		} else if (NidaleeButton.isSelected() == false && check_nidalee == 1)
		{
			NidaleeButton.setIcon(new ImageIcon(bti.nidalee_active));
		} else if (NidaleeButton.isSelected() && check_nidalee == 1)
		{
			NidaleeButton.setIcon(new ImageIcon(bti.nidalee_selected));
		}
		// ///////////////////////Patrol////////////////////////////
		if (PatrolButton.isSelected())
		{
			PatrolButton.setIcon(new ImageIcon(bti.patrol_active));
		} else
			PatrolButton.setIcon(new ImageIcon(bti.patrol_icon));
		// ///////////////////////Move////////////////////////////
		if (MoveButton.isSelected())
		{
			MoveButton.setIcon(new ImageIcon(bti.move_active));
		} else
			MoveButton.setIcon(new ImageIcon(bti.move_icon));
		// ///////////////////////Stop////////////////////////////
		if (StopButton.isSelected())
		{
			StopButton.setIcon(new ImageIcon(bti.stop_active));
		} else
			StopButton.setIcon(new ImageIcon(bti.stop_icon));
		// ///////////////////////소환사의협곡////////////////////////////
		if (rift.isSelected())
		{
			rift.setIcon(new ImageIcon(bti.rift_selected));
		} else
			rift.setIcon(new ImageIcon(bti.rift_icon));
		// ///////////////////////칼바람나락////////////////////////////
		if (abyss.isSelected())
		{
			abyss.setIcon(new ImageIcon(bti.abyss_selected));
		} else
			abyss.setIcon(new ImageIcon(bti.abyss_icon));
	}

}