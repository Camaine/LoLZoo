import javax.swing.*;


public class MenuUI extends JPanel
{
	JMenuBar menubar = new JMenuBar();
	JMenu menu1 = new JMenu("File");
	JMenu menu2 = new JMenu("Edit");
	JMenuItem item1 = new JMenuItem("Load");
	JMenuItem item2 = new JMenuItem("Save");
	JMenuItem item3 = new JMenuItem("Exit");
	JMenuItem item4 = new JMenuItem("Select Animal");
	
	public MenuUI()
	{
		menubar.add(menu1);
		menubar.add(menu2);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu2.add(item4);
	}
}
