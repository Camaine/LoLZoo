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
	public LoginPanel()throws  MalformedURLException
	{

		play_bgm();
		setSize(800, 600);
		setTitle("LoL Zoo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final LoginStat ls = new LoginStat();
		add(ls);

		setVisible(true);

		ls.login_btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				if (ls.username.getText().equals("nosang")
						&& ls.password.getText().equals("1234"))
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
		// setJMenuBar(menu.menubar);
	}
	
	public void play_bgm()
	{
		audio1.play();
	}

}

class LoginStat extends JPanel
{
	JButton login_btn = new JButton();
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(10);

	public LoginStat()
	{
		setLayout(null);
		login_btn.setBounds(330, 380, 145, 32);
		username.setBounds(325, 270, 150, 25);
		password.setBounds(325, 340, 150, 25);

		try
		{
			Image img1 = ImageIO.read(getClass().getResource("/login_btn.png"));
			login_btn.setIcon(new ImageIcon(img1));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repaint();
		add(username);
		add(password);
		add(login_btn);

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


