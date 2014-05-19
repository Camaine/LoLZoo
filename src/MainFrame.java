import javax.swing.JFrame;


public class MainFrame extends JFrame
{
	public MainFrame()
	{
		setSize(800,640);
		setTitle("LoL Zoo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuUI menu = new MenuUI();
		Background img = new Background();
		setJMenuBar(menu.menubar);
		add(img);
		setVisible(true);
	}
}
