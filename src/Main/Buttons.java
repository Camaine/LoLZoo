package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Buttons extends JPanel
{
	JButton character_select = new JButton();
	JButton save_select = new JButton();
	JButton load_select = new JButton();
	JButton character1 = new JButton();
	JButton character2 = new JButton();
	JButton character3 = new JButton();
	JButton character4 = new JButton();
	JButton character5 = new JButton();
	JButton character6 = new JButton();
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
		select_nasus();
		add(character_select);
		add(save_select, FlowLayout.LEFT);
		add(load_select, FlowLayout.RIGHT);
				

	}

	public void select_button()
	{
		Font pt1 = new Font("Serif", Font.BOLD, 15);
		try
		{
			Image img1 = ImageIO.read(new File(".\\Resource\\character_btn.png"));
			character_select.setIcon(new ImageIcon(img1));
			Image img2 = ImageIO.read(new File(".\\Resource\\save_btn.png"));
			save_select.setIcon(new ImageIcon(img2));
			Image img3 = ImageIO.read(new File(".\\Resource\\load_btn.png"));
			load_select.setIcon(new ImageIcon(img3));
		} catch (IOException ex)
		{

		}
		character_select.setFont(pt1);
		character_select.setForeground(Color.WHITE);
		character_select.setBackground(new Color(125, 16, 16));
		character_select.setFocusPainted(false);
		character_select.setPreferredSize(new Dimension(145, 32));
		
		save_select.setFont(pt1);
		save_select.setForeground(Color.WHITE);
		save_select.setBackground(new Color(0, 80, 92));
		save_select.setFocusPainted(false);
		save_select.setPreferredSize(new Dimension(107, 32));
		
		load_select.setFont(pt1);
		load_select.setForeground(Color.WHITE);
		load_select.setBackground(new Color(0, 80, 92));
		load_select.setFocusPainted(false);
		load_select.setPreferredSize(new Dimension(107, 32));
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
			Image img = ImageIO.read(new File(".\\Resource\\Rengar_icon.png"));
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
	
	public void select_nasus()
	{
		try
		{
			Image img = ImageIO.read(new File(".\\Resource\\Nasus_icon.png"));
			character6.setIcon(new ImageIcon(img));
		}catch(IOException ex)
		{
			
		}
		character6.setPreferredSize(new Dimension(50, 50));
	}

	
}
