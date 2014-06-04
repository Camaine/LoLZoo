import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Buttons extends JPanel
{
	JButton character_select = new JButton("Character Select");
	JButton character1 = new JButton();
	JButton character2 = new JButton();
	JButton character3 = new JButton();
	JButton character4 = new JButton();
	JButton character5 = new JButton();
	JButton character6 = new JButton();
	JButton play = new JButton("Play");
	MainPanel main;
	
	
	int i;

	public Buttons()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(new Color(9, 20, 61));
		select_button();
		
		select_poro();
		select_rengar();
		select_elise();
		select_ahri();
		select_nidalee();
		add(character_select);
		add(play);
		

	}

	public void select_button()
	{
		Font pt1 = new Font("Serif", Font.BOLD, 15);
		character_select.setFont(pt1);
		character_select.setForeground(Color.WHITE);
		character_select.setBackground(new Color(125, 16, 16));
		character_select.setFocusPainted(false);
	}

	public void select_poro()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\poro_icon.jpg"));
			character1.setIcon(new ImageIcon(img));
		} catch (IOException ex)
		{

		}
		character1.setPreferredSize(new Dimension(50, 50));
	}

	public void select_rengar()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\Rengar_Square_0.png"));
			character2.setIcon(new ImageIcon(img));
		}catch(IOException ex)
		{
			
		}
		character2.setPreferredSize(new Dimension(50, 50));
	}
	
	public void select_elise()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\elise_icon.png"));
			character3.setIcon(new ImageIcon(img));
		}catch(IOException ex)
		{
			
		}
		character3.setPreferredSize(new Dimension(50, 50));
	}
	
	public void select_ahri()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\Ahri_icon.png"));
			character4.setIcon(new ImageIcon(img));
		}catch(IOException ex)
		{
			
		}
		character4.setPreferredSize(new Dimension(50, 50));
	}
	
	public void select_nidalee()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\Nidalee_icon.png"));
			character5.setIcon(new ImageIcon(img));
		}catch(IOException ex)
		{
			
		}
		character5.setPreferredSize(new Dimension(50, 50));
	}

	
}
