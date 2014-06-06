package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuUI extends JFrame
{
	JMenuBar menubar = new JMenuBar();
	JMenu menu1 = new JMenu("File");
	JMenuItem item1 = new JMenuItem("Load");
	JMenuItem item2 = new JMenuItem("Save");
	JMenuItem item3 = new JMenuItem("Exit");
	JTextField filename = new JTextField(), dir = new JTextField();
	Renga rg = new Renga();
	Poro poro = new Poro();
	Spider elise = new Spider();
	Ahri ahri = new Ahri();
	Nidalee nidalee = new Nidalee();
	PatrolAction action_poro  = new PatrolAction();
	PatrolAction action_rengar = new PatrolAction();
	PatrolAction action_elise = new PatrolAction();
	PatrolAction action_ahri = new PatrolAction();
	PatrolAction action_nidalee = new PatrolAction();
	ArrayList<Integer> data = new ArrayList<Integer>();
	
	int count = 0;
	
	public MenuUI() throws IOException
	{
		menubar.add(menu1);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		JPanel p = new JPanel();
		
		item1.addActionListener(new OpenL());
		item2.addActionListener(new SaveL());
		Container cp = getContentPane();
		cp.add(p, BorderLayout.SOUTH);
		dir.setEditable(false);
		filename.setEditable(false);
		p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(filename);
		p.add(dir);
		cp.add(p, BorderLayout.NORTH);
		
		
	}
	class OpenL implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(MenuUI.this);
			if (rVal == JFileChooser.APPROVE_OPTION)
			{
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if (rVal == JFileChooser.CANCEL_OPTION)
			{
				filename.setText("You pressed cancel");
				dir.setText("");
			}
		}
	}

	class SaveL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			JFileChooser c = new JFileChooser();
			// Demonstrate "Save" dialog:
			int rVal = c.showSaveDialog(MenuUI.this);
			if (rVal == JFileChooser.APPROVE_OPTION)
			{
				System.out.println("savede");
				filename.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
				try
				{
					MainPanel main = new MainPanel();
					FileWriter fw = new FileWriter(c.getSelectedFile()+".txt");
					for(int i = 0 ; i < main.data.size() ; i++)
					{
						System.out.println("save");
						main.input();
						fw.write(Integer.toString(main.data.get(count)));
						System.out.println(main.data.get(count));
						fw.write(" ");
						count++;
					}
					fw.close();
					count = 0;
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (rVal == JFileChooser.CANCEL_OPTION)
			{
				filename.setText("You pressed cancel");
				dir.setText("");
			}
		}
	}
	
	/*public void input()
	{
		data.add(main.abyss_ani_check);
		data.add(main.ahri_patrol_check);
		data.add(main.ChampionMove);
		data.add(main.check_ahri);
		data.add(main.check_bg);
		data.add(main.check_elise);
		data.add(main.check_nidalee);
		data.add(main.check_poro);
		data.add(main.check_rengar);
		data.add(main.clickcount);
		data.add(main.elise_patrol_check);
		data.add(main.mousepress);
		data.add(main.nidalee_patrol_check);
		data.add(main.rengar_patrol_check);
		data.add(main.rift_ani_check);
		data.add(main.x1);
		data.add(main.x2);
		data.add(main.y1);
		data.add(main.y2);
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
		data.add(main.ahri.x1);
		data.add(main.ahri.y1);
		data.add(action_ahri.x1);
		data.add(action_ahri.y1);
		data.add(nidalee.x1);
		data.add(nidalee.y1);
		data.add(action_nidalee.x1);
		data.add(action_nidalee.y1);
	}*/
}
