package Main;
import java.io.IOException;

import javax.swing.JFrame;


public class MainFrame extends JFrame
{
	public MainFrame() throws IOException
	{
		setSize(800,600);
		setTitle("LoL Zoo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuUI menu = new MenuUI();
		MainPanel img = new MainPanel();
		//setJMenuBar(menu.menubar);
		add(img);
		setVisible(true);
	}
}
