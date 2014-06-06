package Main;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Spider extends JPanel
{
	int x1, y1;
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);
	}

	public void draw(Graphics2D g2)
	{
		BasicStroke Stokehand = new BasicStroke(3);

		// Color Setting //
		Color ColorSetting = new Color(255, 0, 0);
		Color ColorSetting2 = new Color(0, 0, 0);
		// Color Setting //

		// Spider's Constructor (Body + Eyes) //
		Ellipse2D.Double SpiderBody = new Ellipse2D.Double(30+x1, 35+y1, 65, 47.5);
		Ellipse2D.Double SpiderEyes1 = new Ellipse2D.Double(45+x1, 45+y1, 5, 5);
		Ellipse2D.Double SpiderEyes2 = new Ellipse2D.Double(45+x1, 55+y1, 5, 5);
		Ellipse2D.Double SpiderEyes3 = new Ellipse2D.Double(45+x1, 65+y1, 5, 5);
		Ellipse2D.Double SpiderEyes4 = new Ellipse2D.Double(75+x1, 45+y1, 5, 5);
		Ellipse2D.Double SpiderEyes5 = new Ellipse2D.Double(75+x1, 55+y1, 5, 5);
		Ellipse2D.Double SpiderEyes6 = new Ellipse2D.Double(75+x1, 65+y1, 5, 5);

		// Spider's Constructor (Left Hand) //
		Line2D.Double SpiderHand1 = new Line2D.Double(42.5+x1, 42.5+y1, 30+x1, 30+y1);
		Line2D.Double SpiderHand2 = new Line2D.Double(30+x1, 30+y1, 15.5+x1, 45+y1);
		Line2D.Double SpiderHand3 = new Line2D.Double(20.5+x1, 45.5+y1, 35.5+x1, 55+y1);
		Line2D.Double SpiderHand4 = new Line2D.Double(20.5+x1, 45.5+y1, 8.5+x1, 60.5+y1);
		Line2D.Double SpiderHand5 = new Line2D.Double(40.5+x1, 72.5+y1, 20.5+x1, 60.5+y1);
		Line2D.Double SpiderHand6 = new Line2D.Double(20.5+x1, 60.5+y1, 8.5+x1, 72.5+y1);

		// Spider's Constructor (Right Hand) //
		Line2D.Double SpiderHand7 = new Line2D.Double(80.5+x1, 42.5+y1, 92.5+x1, 30+y1);
		Line2D.Double SpiderHand8 = new Line2D.Double(92.5+x1, 30+y1, 107+x1, 40+y1);
		Line2D.Double SpiderHand9 = new Line2D.Double(92.5+x1, 48.5+y1, 100.5+x1, 40.5+y1);
		Line2D.Double SpiderHand10 = new Line2D.Double(100.5+x1, 40.5+y1, 112+x1, 52.5+y1);
		Line2D.Double SpiderHand11 = new Line2D.Double(95.5+x1, 58.5+y1, 102.5+x1, 52.5+y1);
		Line2D.Double SpiderHand12 = new Line2D.Double(102.5+x1, 52.5+y1, 115.5+x1, 65.5+y1);

		// Spider's Constructor //

		// Spider Body Setting //
		g2.setColor(ColorSetting2);
		g2.fill(SpiderBody);
		g2.draw(SpiderBody);
		// Spider Body Setting //

		g2.setColor(ColorSetting);

		// Spider Eyes Setting //
		g2.fill(SpiderEyes1);
		g2.fill(SpiderEyes2);
		g2.fill(SpiderEyes3);
		g2.fill(SpiderEyes4);
		g2.fill(SpiderEyes5);
		g2.fill(SpiderEyes6);

		g2.draw(SpiderEyes1);
		g2.draw(SpiderEyes2);
		g2.draw(SpiderEyes3);
		g2.draw(SpiderEyes4);
		g2.draw(SpiderEyes5);
		g2.draw(SpiderEyes6);
		// Spider Eyes Setting //

		// Spider LeftHand Setting //
		g2.setColor(ColorSetting2);
		g2.setStroke(Stokehand);
		g2.draw(SpiderHand1);
		g2.draw(SpiderHand2);
		g2.draw(SpiderHand3);
		g2.draw(SpiderHand4);
		g2.draw(SpiderHand5);
		g2.draw(SpiderHand6);

		// Spider RightHand Setting //
		g2.setColor(ColorSetting2);
		g2.setStroke(Stokehand);
		g2.draw(SpiderHand7);
		g2.draw(SpiderHand8);
		g2.draw(SpiderHand9);
		g2.draw(SpiderHand10);
		g2.draw(SpiderHand11);
		g2.draw(SpiderHand12);
	}
}
