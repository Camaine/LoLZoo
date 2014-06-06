package Main;
import java.io.IOException;

import javax.swing.JFrame;


public class MainFrame 
{
	public static void main(String[] args) throws IOException
	{
		JFrame jf =new JFrame();
		jf.setSize(800,600);
		jf.setTitle("LoL Zoo");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel img = new MainPanel();
		//setJMenuBar(menu.menubar);
		jf.add(img);
		jf.setVisible(true);
	}
	
}
