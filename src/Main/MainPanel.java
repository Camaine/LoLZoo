package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.applet.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Animations.*;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	Image rifts, abysss;
	Cursor Cursor;
	ImageIcon imageicon = new ImageIcon();
	Image snowani = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/snow_ani.gif"));
	Buttons button1 = new Buttons();
	Random rd = new Random();
	JRadioButton PoroButton = new JRadioButton();
	JRadioButton RengarButton = new JRadioButton();
	JRadioButton AhriButton = new JRadioButton();
	JRadioButton NidaleeButton = new JRadioButton();
	JRadioButton EliseButton = new JRadioButton();
	JRadioButton NasusButton = new JRadioButton();
	JRadioButton PatrolButton = new JRadioButton();
	JRadioButton MoveButton = new JRadioButton();
	JRadioButton StopButton = new JRadioButton();
	JRadioButton DeleteButton = new JRadioButton();
	JRadioButton rift = new JRadioButton();
	JRadioButton abyss = new JRadioButton();
	public ButtonGroup Group1 = new ButtonGroup();
	public ButtonGroup Group2 = new ButtonGroup();
	ButtonGroup Group3 = new ButtonGroup();
	JLabel name = new JLabel();
	ButtonIcons bti = new ButtonIcons();

	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border compound = BorderFactory.createCompoundBorder(raisedbevel,
			loweredbevel);

	PatrolAction action_poro = new PatrolAction();
	PatrolAction action_rengar = new PatrolAction();
	PatrolAction action_elise = new PatrolAction();
	PatrolAction action_ahri = new PatrolAction();
	PatrolAction action_nidalee = new PatrolAction();
	PatrolAction action_nasus = new PatrolAction();

	PoroPatrol poro_pat;
	RengarPatrol rengar_pat;
	ElisePatrol elise_pat;
	AhriPatrol ahri_pat;
	NidaleePatrol nidalee_pat;
	NasusPatrol nasus_pat;

	Image blank = ImageIO.read(getClass().getResource("/blank.png"));
	RiftThread rift_animate;
	AbyssThread abyss_animate;
	SnowThread snow_animate;
	RiftBackground rift_resource = new RiftBackground();
	AbyssBackground abyss_resource = new AbyssBackground();
	SnowAnimate snowanimate = new SnowAnimate();
	LoginAnimation la = new LoginAnimation();
	int rift_ani_check = 1;
	int abyss_ani_check = 0;
	int snow_ani_check = 0;

	Renga rg = new Renga();
	Poro poro = new Poro();
	Spider elise = new Spider();
	Ahri ahri = new Ahri();
	Nidalee nidalee = new Nidalee();
	Dog nasus = new Dog();

	MouseListen Patroler = new MouseListen();

	public int check_poro = 0;
	public int check_rengar = 0;
	public int check_elise = 0;
	public int check_ahri = 0;
	public int check_nidalee = 0;
	public int check_nasus = 0;
	public int check_bg = 1;
	public int x1, y1, x2, y2;
	public int ChampionMove, mousepress = 0, clickcount = 0;

	int i;
	int Only_One = 0;
	int poro_patrol_check = 0;
	int rengar_patrol_check = 0;
	int elise_patrol_check = 0;
	int ahri_patrol_check = 0;
	int nidalee_patrol_check = 0;
	int nasus_patrol_check = 0;

	int bgm = 1;
	MoveSounds sounds = new MoveSounds();
	AudioClip audio = Applet.newAudioClip(getClass().getResource("/button_click.wav"));
	AudioClip audio2 = Applet.newAudioClip(getClass().getResource("/Summoner_Rift_bgm.wav"));
	AudioClip audio1 = Applet.newAudioClip(getClass().getResource("/Howling_Abyss_bgm.wav"));

	public ArrayList<Integer> data = new ArrayList<Integer>();

	public MainPanel() throws IOException
	{
		playbgm();
		setLayout(new BorderLayout());
		myCursor();
		Group1.add(PoroButton);
		Group1.add(RengarButton);
		Group1.add(AhriButton);
		Group1.add(NidaleeButton);
		Group1.add(EliseButton);
		Group1.add(NasusButton);
		Group2.add(PatrolButton);
		Group2.add(MoveButton);
		Group2.add(StopButton);
		Group2.add(DeleteButton);
		Group3.add(rift);
		Group3.add(abyss);
		PoroButton.setBackground(new Color(60, 60, 60));
		RengarButton.setBackground(new Color(60, 60, 60));
		AhriButton.setBackground(new Color(60, 60, 60));
		EliseButton.setBackground(new Color(60, 60, 60));
		NidaleeButton.setBackground(new Color(60, 60, 60));
		NasusButton.setBackground(new Color(60, 60, 60));
		MoveButton.setBackground(new Color(60, 60, 60));
		PatrolButton.setBackground(new Color(60, 60, 60));
		StopButton.setBackground(new Color(60, 60, 60));
		DeleteButton.setBackground(new Color(60, 60, 60));
		rift.setBackground(new Color(60, 60, 60));
		abyss.setBackground(new Color(60, 60, 60));
		name.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/name_label.png"))));
		name.setBackground(new Color(60, 60, 60));
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
					if (poro_patrol_check == 0 && ChampionMove == 101)
					{
						poro.x1 = x1 - 60;
						poro.y1 = y1 - 40;
						break;
					}
				}
				case 102:
				{
					if (rengar_patrol_check == 0 && ChampionMove == 102)
					{
						rg.x1 = x1 - 50;
						rg.y1 = y1 - 50;
						break;
					}
				}
				case 103:
				{
					if (elise_patrol_check == 0 && ChampionMove == 103)
					{
						elise.x1 = x1 - 70;
						elise.y1 = y1 - 70;
					}
				}
				case 104:
				{
					if (ahri_patrol_check == 0 && ChampionMove == 104)
					{
						ahri.x1 = x1 - 70;
						ahri.y1 = y1 - 70;
					}
				}
				case 105:
				{
					if (nidalee_patrol_check == 0 && ChampionMove == 105)
					{
						nidalee.x1 = x1 - 70;
						nidalee.y1 = y1 - 70;
					}
				}
				case 106:
				{
					if (nasus_patrol_check == 0 && ChampionMove == 106)
					{
						nasus.x1 = x1 - 70;
						nasus.y1 = y1 - 70;
					}
				}
				}
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				Icons();
				setCursor(Cursor);
			}
		});
		button_action();
		rifts = ImageIO.read(getClass().getResource("/Background.png"));
		abysss = ImageIO.read(getClass().getResource("/Background2.png"));

		add(button1, BorderLayout.NORTH);
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 4));
		p1.setBorder(compound);
		p1.add(PatrolButton);
		p1.add(MoveButton);
		p1.add(StopButton);
		p1.add(DeleteButton);
		p1.setBackground(new Color(60, 60, 60));
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 3));
		p2.setBorder(compound);
		p2.add(PoroButton);
		p2.add(RengarButton);
		p2.add(NidaleeButton);
		p2.add(AhriButton);
		p2.add(EliseButton);
		p2.add(NasusButton);
		p2.setBackground(new Color(60, 60, 60));
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		p3.setBorder(compound);
		p3.add(rift);
		p3.add(abyss);
		p3.setBackground(new Color(60, 60, 60));
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(2, 1));
		p5.setBorder(compound);
		p5.add(p1);
		p5.add(name, FlowLayout.CENTER);
		p5.setBackground(new Color(60, 60, 60));
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 3));
		p4.add(p3);
		p4.add(p2);
		p4.add(p5);
		p4.setBackground(Color.black);
		add(p4, BorderLayout.SOUTH);
		repaint();
	}

	public class MouseListen implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) // 클릭해서 패트롤을 작동시킴
		{
			if (clickcount == 2)
			{
				clickcount = 0;
				mousepress = 0;
				if (PoroButton.isSelected() && PatrolButton.isSelected())
				{
					action_poro = new PatrolAction(x1, y1, x2, y2);
					poro_patrol_check = 1;
					poro_pat = new PoroPatrol();
					poro_pat.start();

				}
				if (RengarButton.isSelected() && PatrolButton.isSelected())
				{
					int i = rd.nextInt(3);
					sounds.rengar_move_sound.get(i).play();
					action_rengar = new PatrolAction(x1, y1, x2, y2);
					rengar_patrol_check = 1;
					rengar_pat = new RengarPatrol();
					rengar_pat.start();
				}
				if (EliseButton.isSelected() && PatrolButton.isSelected())
				{

					int i = rd.nextInt(3);
					sounds.elise_move_sound.get(i).play();
					action_elise = new PatrolAction(x1, y1, x2, y2);
					elise_patrol_check = 1;
					elise_pat = new ElisePatrol();
					elise_pat.start();
				}
				if (AhriButton.isSelected() && PatrolButton.isSelected())
				{
					int i = rd.nextInt(3);
					sounds.ahri_move_sound.get(i).play();
					action_ahri = new PatrolAction(x1, y1, x2, y2);
					ahri_patrol_check = 1;
					ahri_pat = new AhriPatrol();
					ahri_pat.start();
				}
				if (NidaleeButton.isSelected() && PatrolButton.isSelected())
				{
					int i = rd.nextInt(3);
					sounds.nidalee_move_sound.get(i).play();
					action_nidalee = new PatrolAction(x1, y1, x2, y2);
					nidalee_patrol_check = 1;
					nidalee_pat = new NidaleePatrol();
					nidalee_pat.start();
				}
				if (NasusButton.isSelected() && PatrolButton.isSelected())
				{
					int i = rd.nextInt(3);
					sounds.nasus_move_sound.get(i).play();
					action_nasus = new PatrolAction(x1, y1, x2, y2);
					nasus_patrol_check = 1;
					nasus_pat = new NasusPatrol();
					nasus_pat.start();
				}
				removeMouseListener(Patroler);
				Group2.clearSelection();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0)
		{
		}

		@Override
		public void mouseExited(MouseEvent arg0)
		{
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			if (mousepress == 0)
			{
				x1 = e.getX();
				y1 = e.getY();
				mousepress++;
				clickcount = 1;
			} else
			{
				x2 = e.getX();
				y2 = e.getY();
				mousepress = 0;
				clickcount = 2;
			}

		}

		@Override
		public void mouseReleased(MouseEvent arg0)
		{
		}

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		if (Only_One == 0)
		{
			g.drawImage(blank, 0, 0, null);
			la.ani_draw(g);
		}
		if (check_bg == 1)
		{
			if (Only_One == 1)
			{
				snow_animate.stop();
				snow_animate.interrupt();
				g.drawImage(abysss, 0, 0, null);
				if (rift_ani_check == 1)
				{
					rift_animate = new RiftThread();
					rift_animate.start();
					rift_ani_check = 0;
				}
				rift_resource.draw(g);
			}

		} else
		{
			Only_One = 1;
			g.drawImage(rifts, 0, 0, null);
			if (abyss_ani_check == 1)
			{
				abyss_animate = new AbyssThread();
				snow_animate = new SnowThread();
				snow_animate.start();
				abyss_animate.start();
				abyss_ani_check = 0;
			}
			abyss_resource.draw(g);
			snowanimate.draw(g);
		}

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
		if (check_nasus == 1)
		{
			nasus.draw(g2);
		}
		if (check_bg == 0)
		{
			
		}
	}

	public void myCursor() throws IOException
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image lol = ImageIO.read(getClass().getResource("/LoL_cursor.png"));
		Cursor = tk.createCustomCursor(lol, new Point(10, 10), "OUR CURSOR");
	}

	public void button_action()
	{
		button1.character_select.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
					Group1.clearSelection();
					Group2.clearSelection();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}

				Object[] Field1 =
				{ button1.character1, button1.character2, button1.character3,
						button1.character4, button1.character5,
						button1.character6, };
				JOptionPane.showOptionDialog(null, "Select Character",
						"Select Character", JOptionPane.DEFAULT_OPTION, 0,
						null, Field1, Field1[i]);
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		button1.load_select.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String value;
				MenuUI menu;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					e2.printStackTrace();
				}
				try
				{
					menu = new MenuUI();
					JFileChooser c = new JFileChooser();
					int rVal = c.showOpenDialog(menu);
					if (rVal == JFileChooser.APPROVE_OPTION)
					{
						menu.filename.setText(c.getSelectedFile().getName());
						menu.dir.setText(c.getCurrentDirectory().toString());
						Scanner sc = new Scanner(c.getSelectedFile());
						data.removeAll(data);
						while (sc.hasNext())
						{
							value = sc.next();
							data.add(Integer.parseInt(value));
						}
						sc.close();
						output();
					}
					if (rVal == JFileChooser.CANCEL_OPTION)
					{
						menu.filename.setText("You pressed cancel");
						menu.dir.setText("");
					}
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

			}

		});

		button1.save_select.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					e2.printStackTrace();
				}
				MenuUI menu;
				try
				{
					input();
					menu = new MenuUI();
					int count = 0;
					JFileChooser c = new JFileChooser();
					// Demonstrate "Open" dialog:
					int rVal = c.showSaveDialog(menu);
					FileWriter fw = new FileWriter(c.getSelectedFile()
							+ ".savelz");
					if (rVal == JFileChooser.APPROVE_OPTION)
					{
						menu.filename.setText(c.getSelectedFile().getName());
						menu.dir.setText(c.getCurrentDirectory().toString());
						for (int i = 0; i < data.size(); i++)
						{
							fw.write(Integer.toString(data.get(count)));
							fw.write(" ");
							count++;
						}
						fw.close();
						count = 0;
					}
					if (rVal == JFileChooser.CANCEL_OPTION)
					{
						menu.filename.setText("You pressed cancel");
						menu.dir.setText("");
					}
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});

		button1.character1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_poro = 1;
				repaint();
			}

		});

		button1.character2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_rengar = 1;
				repaint();
			}
		});

		button1.character3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_elise = 1;
				repaint();
			}

		});

		button1.character4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_ahri = 1;
				repaint();
			}

		});

		button1.character5.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_nidalee = 1;
				repaint();
			}

		});

		button1.character6.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				check_nasus = 1;
				repaint();
			}
		});

		PatrolButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				clickcount = 0;
				PatrolActions();
			}
		});

		MoveButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					BtnSound();
				} catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
				MoveActions();
			}
		});

		StopButton.addActionListener(new ActionListener() // StopButton은 초기화를
															// 해줌으로써 멈추는것을 유도한다.
				{
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						try
						{
							BtnSound();
						} catch (MalformedURLException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (PoroButton.isSelected() && StopButton.isSelected()
								&& poro_patrol_check == 1)
						{
							poro_patrol_check = 0;
							poro_pat.stop();
							poro_pat.interrupt();
						}
						if (RengarButton.isSelected()
								&& StopButton.isSelected()
								&& rengar_patrol_check == 1)
						{
							rengar_patrol_check = 0;
							rengar_pat.stop();
							rengar_pat.interrupt();
						}
						if (EliseButton.isSelected() && StopButton.isSelected()
								&& elise_patrol_check == 1)
						{
							elise_patrol_check = 0;
							elise_pat.stop();
							elise_pat.interrupt();
						}
						if (AhriButton.isSelected() && StopButton.isSelected())
						{
							ahri_patrol_check = 0;
							ahri_pat.stop();
							ahri_pat.interrupt();
						}
						if (NidaleeButton.isSelected()
								&& StopButton.isSelected()
								&& nidalee_patrol_check == 1)
						{
							nidalee_patrol_check = 0;
							nidalee_pat.stop();
							nidalee_pat.interrupt();
						}
						if (NasusButton.isSelected() && StopButton.isSelected()
								&& nidalee_patrol_check == 1)
						{
							nasus_patrol_check = 0;
							nasus_pat.stop();
							nasus_pat.interrupt();
						}

						x1 = 0;
						y1 = 0;
						x2 = 0;
						y2 = 0;
						clickcount = 0;
						mousepress = 0;
						PatrolActions(); // 한번더 호출해줘서 지우도록함
						MoveActions(); // Stop시 한번더 호출해서 초기상태로 되돌린다.
						Group2.clearSelection();
					}

				});

		DeleteButton.addActionListener(new ActionListener() // ������ư
				{

					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						try
						{
							BtnSound();
						} catch (MalformedURLException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// TODO Auto-generated method stub
						if (PoroButton.isSelected() && check_poro == 1)
						{
							check_poro = 0;
							if (poro_patrol_check == 1)
							{
								poro_pat.stop();
								poro_pat.interrupt();
							}
						}

						if (RengarButton.isSelected() && check_rengar == 1)
						{
							check_rengar = 0;
							if (rengar_patrol_check == 1)
							{
								rengar_pat.stop();
								rengar_pat.interrupt();
							}
						}

						if (EliseButton.isSelected() && check_elise == 1)
						{

							check_elise = 0;
							if (elise_patrol_check == 1)
							{
								elise_pat.stop();
								elise_pat.interrupt();
							}
						}

						if (AhriButton.isSelected() && check_ahri == 1)
						{

							check_ahri = 0;
							if (ahri_patrol_check == 1)
							{
								ahri_pat.stop();
								ahri_pat.interrupt();
							}
						}

						if (NidaleeButton.isSelected() && check_nidalee == 1)
						{

							check_nidalee = 0;
							if (nidalee_patrol_check == 1)
							{
								nidalee_pat.stop();
								nidalee_pat.interrupt();
							}
						}
						if (NasusButton.isSelected() && check_nidalee == 1)
						{

							check_nasus = 0;
							if (nasus_patrol_check == 1)
							{
								nasus_pat.stop();
								nasus_pat.interrupt();
							}
						}
						ChampionMove = 0;
						Group1.clearSelection();
						Group2.clearSelection();
						PatrolActions();
						repaint();
					}

				});

		rift.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					check_bg = 1;
					bgm = 1;
					playbgm();
					BtnSound();

				} catch (MalformedURLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				rift_ani_check = 1;
				abyss_resource.x1 = 0;
				repaint();
			}

		});

		abyss.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					check_bg = 0;
					bgm = 0;
					BtnSound();
					playbgm();
				} catch (MalformedURLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				abyss_ani_check = 1;
				rift_resource.y1 = 0;
				repaint();
			}

		});

		PoroButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		RengarButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		EliseButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		AhriButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});

		NidaleeButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		NasusButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Group2.clearSelection();
				ChampionMove = 0;
				try
				{
					BtnSound();
				} catch (MalformedURLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
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
		if (NasusButton.isSelected() && MoveButton.isSelected())
		{
			ChampionMove = 106;
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
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			poro_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (PoroButton.isSelected() && PatrolButton.isSelected())
				poro_patrol_check = 1;
		}

		if (RengarButton.isSelected() && PatrolButton.isSelected()
				&& rengar_patrol_check == 0)
		{
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			rengar_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (RengarButton.isSelected() && PatrolButton.isSelected())
				rengar_patrol_check = 1;
		}

		if (EliseButton.isSelected() && PatrolButton.isSelected()
				&& elise_patrol_check == 0)
		{
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			elise_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (EliseButton.isSelected() && PatrolButton.isSelected())
				elise_patrol_check = 1;
		}

		if (AhriButton.isSelected() && PatrolButton.isSelected()
				&& ahri_patrol_check == 0)
		{
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			ahri_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (AhriButton.isSelected() && PatrolButton.isSelected())
				ahri_patrol_check = 1;
		}

		if (NidaleeButton.isSelected() && PatrolButton.isSelected()
				&& nidalee_patrol_check == 0)
		{
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			nidalee_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (NidaleeButton.isSelected() && PatrolButton.isSelected())
				nidalee_patrol_check = 1;
		}
		if (NasusButton.isSelected() && PatrolButton.isSelected()
				&& nasus_patrol_check == 0)
		{
			addMouseListener(Patroler); // 자주쓰니까 InnerClass로 바꿔서 코드를 이쁘게함
			// 딱 한번만 작동할수 있도록 함. 계속누르면 에러가나므로
		} else if (MoveButton.isSelected() || StopButton.isSelected())
		{ // 마우스리스너가 삭제됨에 따라 드래그는 불가능해진다.
			removeMouseListener(Patroler);
			nasus_patrol_check = 0;

		} else
		// 패트롤버튼을 계속눌렀을경우, 아무일도 일어나지 않게한다.
		{
			if (NasusButton.isSelected() && PatrolButton.isSelected())
				nasus_patrol_check = 1;
		}
		ChampionMove = 0;

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
		// //////////////////////나서스//////////////////////////////
		if (NasusButton.isSelected() == false && check_nasus == 0)
		{
			NasusButton.setIcon(new ImageIcon(bti.nasus_disable));
		} else if (NasusButton.isSelected() == false && check_nasus == 1)
		{
			NasusButton.setIcon(new ImageIcon(bti.nasus_active));
		} else if (NasusButton.isSelected() && check_nasus == 1)
		{
			NasusButton.setIcon(new ImageIcon(bti.nasus_selected));
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
		// ///////////////////////Delete//////////////////////////////
		if (DeleteButton.isSelected())
		{
			DeleteButton.setIcon(new ImageIcon(bti.delete_active));
		} else
			DeleteButton.setIcon(new ImageIcon(bti.delete_icon));
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

	class PoroPatrol extends Thread
	{
		public void run()
		{
			if (PoroButton.isSelected() && PatrolButton.isSelected()
					|| poro_patrol_check == 1)
			{
				while (true)
				{
					action_poro.PatrolActions();
					poro.x1 = action_poro.getX1();
					poro.y1 = action_poro.getY1();
					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	class RengarPatrol extends Thread
	{
		public void run()
		{

			if (RengarButton.isSelected() && PatrolButton.isSelected()
					|| rengar_patrol_check == 1)
			{
				while (true)
				{
					action_rengar.PatrolActions();
					rg.x1 = action_rengar.getX1();
					rg.y1 = action_rengar.getY1();

					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	class ElisePatrol extends Thread
	{
		public void run()
		{

			if (EliseButton.isSelected() && PatrolButton.isSelected()
					|| elise_patrol_check == 1)
			{
				while (true)
				{
					action_elise.PatrolActions();
					elise.x1 = action_elise.getX1();
					elise.y1 = action_elise.getY1();

					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	class AhriPatrol extends Thread
	{
		public void run()
		{

			if (AhriButton.isSelected() && PatrolButton.isSelected()
					|| ahri_patrol_check == 1)
			{
				while (true)
				{
					action_ahri.PatrolActions();
					ahri.x1 = action_ahri.getX1();
					ahri.y1 = action_ahri.getY1();

					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	class NidaleePatrol extends Thread
	{
		public void run()
		{

			if (NidaleeButton.isSelected() && PatrolButton.isSelected()
					|| nidalee_patrol_check == 1)
			{
				while (true)
				{
					action_nidalee.PatrolActions();
					nidalee.x1 = action_nidalee.getX1();
					nidalee.y1 = action_nidalee.getY1();

					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	class NasusPatrol extends Thread
	{
		public void run()
		{

			if (NasusButton.isSelected() && PatrolButton.isSelected()
					|| nasus_patrol_check == 1)
			{
				while (true)
				{
					action_nasus.PatrolActions();
					nasus.x1 = action_nasus.getX1();
					nasus.y1 = action_nasus.getY1();

					try
					{
						sleep(100);
						repaint();
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	class RiftThread extends Thread
	{

		@SuppressWarnings("deprecation")
		public void run()
		{
			for (int i = 600; i >= 0; i -= 50)
			{
				rift_resource.y1 = i;
				try
				{
					sleep(100);
					if (rift_resource.y1 == 0)
					{
						rift_animate.stop();
						rift_animate.interrupt();
					}
					repaint();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	class AbyssThread extends Thread
	{

		@SuppressWarnings("deprecation")
		public void run()
		{
			for (int i = 0; i <= 400; i += 50)
			{
				abyss_resource.x1 = i;
				try
				{
					sleep(100);
					if (abyss_resource.x1 == 400 && rift_ani_check == 1)
					{
						rift_animate.stop();
						rift_animate.interrupt();
					}
					repaint();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				} catch (NullPointerException e)
				{
				}
			}
		}
	}

	public void input()
	{
		data.removeAll(data);
		data.add(abyss_ani_check);
		data.add(ahri_patrol_check);
		data.add(ChampionMove);
		data.add(check_ahri);
		data.add(check_bg);
		data.add(check_elise);
		data.add(check_nidalee);
		data.add(check_poro);
		data.add(check_rengar);
		data.add(clickcount);
		data.add(elise_patrol_check);
		data.add(mousepress);
		data.add(nidalee_patrol_check);
		data.add(rengar_patrol_check);
		data.add(rift_ani_check);
		data.add(x1);
		data.add(x2);
		data.add(y1);
		data.add(y2);
		data.add(poro.x1);
		data.add(poro.y1);
		data.add(action_poro.x1);
		data.add(action_poro.y1);
		data.add(rg.x1);
		data.add(rg.y1);
		data.add(action_rengar.x1);
		data.add(action_rengar.y1);
		data.add(elise.x1);
		data.add(elise.y1);
		data.add(action_elise.x1);
		data.add(action_elise.y1);
		data.add(ahri.x1);
		data.add(ahri.y1);
		data.add(action_ahri.x1);
		data.add(action_ahri.y1);
		data.add(nidalee.x1);
		data.add(nidalee.y1);
		data.add(action_nidalee.x1);
		data.add(action_nidalee.y1);
		data.add(bgm);
		data.add(Only_One);
		data.add(check_nasus);
		data.add(nasus_patrol_check);
		data.add(nasus.x1);
		data.add(nasus.y1);
		data.add(action_nasus.x1);
		data.add(action_nasus.y1);
	}

	public void output()
	{
		int count = 0;
		abyss_ani_check = data.get(count);
		count++;
		ahri_patrol_check = data.get(count);
		count++;
		ChampionMove = data.get(count);
		count++;
		check_ahri = data.get(count);
		count++;
		check_bg = data.get(count);
		count++;
		check_elise = data.get(count);
		count++;
		check_nidalee = data.get(count);
		count++;
		check_poro = data.get(count);
		count++;
		check_rengar = data.get(count);
		count++;
		clickcount = data.get(count);
		count++;
		elise_patrol_check = data.get(count);
		count++;
		mousepress = data.get(count);
		count++;
		nidalee_patrol_check = data.get(count);
		count++;
		rengar_patrol_check = data.get(count);
		count++;
		rift_ani_check = data.get(count);
		count++;
		x1 = data.get(count);
		count++;
		x2 = data.get(count);
		count++;
		y1 = data.get(count);
		count++;
		y2 = data.get(count);
		count++;
		poro.x1 = data.get(count);
		count++;
		poro.y1 = data.get(count);
		count++;
		action_poro.x1 = data.get(count);
		count++;
		action_poro.y1 = data.get(count);
		count++;
		rg.x1 = data.get(count);
		count++;
		rg.y1 = data.get(count);
		count++;
		action_rengar.x1 = data.get(count);
		count++;
		action_rengar.y1 = data.get(count);
		count++;
		elise.x1 = data.get(count);
		count++;
		elise.y1 = data.get(count);
		count++;
		action_elise.x1 = data.get(count);
		count++;
		action_elise.y1 = data.get(count);
		count++;
		ahri.x1 = data.get(count);
		count++;
		ahri.y1 = data.get(count);
		count++;
		action_ahri.x1 = data.get(count);
		count++;
		action_ahri.y1 = data.get(count);
		count++;
		nidalee.x1 = data.get(count);
		count++;
		nidalee.y1 = data.get(count);
		count++;
		action_nidalee.x1 = data.get(count);
		count++;
		action_nidalee.y1 = data.get(count);
		count++;
		bgm = data.get(count);
		count++;
		Only_One = data.get(count);
		count++;
		check_nasus = data.get(count);
		count++;
		nasus_patrol_check = data.get(count);
		count++;
		nasus.x1 = data.get(count);
		count++;
		nasus.y1 = data.get(count);
		count++;
		action_nasus.x1 = data.get(count);
		count++;
		action_nasus.y1 = data.get(count);
		count++;
		poro_patrol_check = 0;
		rengar_patrol_check = 0;
		elise_patrol_check = 0;
		ahri_patrol_check = 0;
		nidalee_patrol_check = 0;
		nasus_patrol_check = 0;
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		clickcount = 0;
		mousepress = 0;
		Only_One = 1;
		PatrolActions(); // 한번더 호출해줘서 지우도록함
		MoveActions(); // Stop시 한번더 호출해서 초기상태로 되돌린다.
		Group2.clearSelection();
		if (bgm == 1)
		{
			rift_ani_check = 1;
		} else
			abyss_ani_check = 1;
		repaint();
	}

	public void playbgm() throws MalformedURLException
	{

		if (bgm == 1)
		{
			audio1.stop();
			audio2.play();

		} else
		{
			audio2.stop();
			audio1.play();
		}

	}

	public void BtnSound() throws MalformedURLException
	{

		audio.play();
	}

	class LoginAnimation extends Thread
	{
		public int x1;

		public LoginAnimation()
		{
			repaint();

			start();
		}

		public void run()
		{
			for (int i = 0; i <= 400; i += 25)
			{
				x1 = i;
				try
				{
					sleep(100);
					if (x1 == 400)
					{
						this.stop();
						this.interrupt();
					}
					repaint();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void ani_draw(Graphics g)
		{
			g.drawImage(rifts, 0, 0, null);
			try
			{
				Image img1 = ImageIO.read(getClass().getResource("/login_bg_left.png"));
				Image img2 = ImageIO.read(getClass().getResource("/login_bg_right.png"));
				g.drawImage(img1, (-x1) + 0, 0, null);
				g.drawImage(img2, x1 + 400, 0, null);
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class SnowThread extends Thread
	{

		@SuppressWarnings("deprecation")
		public void run()
		{
			for (int i = 0; i < 700; i += 10)
			{
				snowanimate.y1 = i;
				try
				{
					sleep(100);
					if (snowanimate.y1 == 600)
					{
						i = 100;
					}
					repaint();
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}