package Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.awt.*;
import java.applet.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrame
{
	public static void main(String[] args) throws IOException
	{
		LoginPanel login = new LoginPanel();

	}

}

class LoginPanel extends JFrame 
{
	AudioClip audio1 = Applet.newAudioClip(getClass().getResource("/LoginScreenLoop.wav"));
	Register regit = new Register();
	public LoginPanel()throws  MalformedURLException
	{

		play_bgm();
		setSize(800, 600);
		setTitle("LoL Zoo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final LoginStat ls = new LoginStat();
		add(ls);
		setResizable(false);
		setVisible(true);

		ls.login_btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				regit.IdCheck(ls.username.getText());
				regit.PwCheck(ls.password.getText());
				if (regit.regit_check == 1)
				{
					audio1.stop();
					ls.setVisible(false);
					MainPanel img;
					try
					{
						img = new MainPanel();
						add(img);
											
					} catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else
					JOptionPane.showMessageDialog(null,
							"Wrong Password or Username");

			}

		});
		
		ls.regit_btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String value1, value2;
				JTextField idinput = new JTextField(5);
				JPasswordField pwinput = new JPasswordField(5);
				Object[] Field = { "Your Username :", idinput, "Your Password :",
						pwinput };
				int option2 = JOptionPane.showConfirmDialog(null, Field);
				value1 = idinput.getText();
				value2 = pwinput.getText();
				regit.IdAdd(value1);
				regit.PwAdd(value2);
				
							
			}
			
		});
	}
	
	public void play_bgm()
	{
		audio1.play();
	}

}

class LoginStat extends JPanel
{
	JButton login_btn = new JButton();
	JButton regit_btn = new JButton();
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(10);

	public LoginStat()
	{
		setLayout(null);
		login_btn.setBounds(330, 380, 145, 32);
		username.setBounds(325, 270, 150, 25);
		password.setBounds(325, 340, 150, 25);
		regit_btn.setBounds(330, 420, 145, 32);

		try
		{
			Image img1 = ImageIO.read(getClass().getResource("/login_btn.png"));
			Image img2 = ImageIO.read(getClass().getResource("/register_btn.png"));
			login_btn.setIcon(new ImageIcon(img1));
			regit_btn.setIcon(new ImageIcon(img2));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repaint();
		add(username);
		add(password);
		add(login_btn);
		add(regit_btn);

	}

	public void paintComponent(Graphics g)
	{
		try
		{
			Image bg = ImageIO.read(getClass().getResource("/login_bg.png"));
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


