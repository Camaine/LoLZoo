package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
}
