package Main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class MoveSounds
{
	ArrayList<AudioClip>ahri_move_sound = new ArrayList<AudioClip>();
	ArrayList<AudioClip>elise_move_sound = new ArrayList<AudioClip>();
	ArrayList<AudioClip>nasus_move_sound = new ArrayList<AudioClip>();
	ArrayList<AudioClip>nidalee_move_sound = new ArrayList<AudioClip>();
	ArrayList<AudioClip>rengar_move_sound = new ArrayList<AudioClip>();
	
	public MoveSounds() throws MalformedURLException
	{
		ahri_sounds();
		elise_sounds();
		nasus_sounds();
		nidalee_sounds();
		rengar_sounds();
	}
	
	
	public void ahri_sounds() throws MalformedURLException
	{
		File file1 = new File(".\\Resource\\Sound\\Ahri\\Ahri_move1.wav");
		File file2 = new File(".\\Resource\\Sound\\Ahri\\Ahri_move2.wav");
		File file3 = new File(".\\Resource\\Sound\\Ahri\\Ahri_move6.wav");
		AudioClip ahri_move_sound1 = Applet.newAudioClip(file1.toURI().toURL());
		AudioClip ahri_move_sound2 = Applet.newAudioClip(file2.toURI().toURL());
		AudioClip ahri_move_sound3 = Applet.newAudioClip(file3.toURI().toURL());
		ahri_move_sound.add(ahri_move_sound1);
		ahri_move_sound.add(ahri_move_sound2);
		ahri_move_sound.add(ahri_move_sound3);
	}
	
	public void elise_sounds() throws MalformedURLException
	{
		File file1 = new File(".\\Resource\\Sound\\Elise\\Elise_move1.wav");
		File file2 = new File(".\\Resource\\Sound\\Elise\\Elise_move3.wav");
		File file3 = new File(".\\Resource\\Sound\\Elise\\Elise_move5.wav");
		AudioClip elise_move_sound1 = Applet.newAudioClip(file1.toURI().toURL());
		AudioClip elise_move_sound2 = Applet.newAudioClip(file2.toURI().toURL());
		AudioClip elise_move_sound3 = Applet.newAudioClip(file3.toURI().toURL());
		elise_move_sound.add(elise_move_sound1);
		elise_move_sound.add(elise_move_sound2);
		elise_move_sound.add(elise_move_sound3);
	}
	
	public void nasus_sounds() throws MalformedURLException
	{
		File file1 = new File(".\\Resource\\Sound\\Nasus\\Nasus_move1.wav");
		File file2 = new File(".\\Resource\\Sound\\Nasus\\Nasus_move2.wav");
		File file3 = new File(".\\Resource\\Sound\\Nasus\\Nasus_move3.wav");
		AudioClip nasus_move_sound1 = Applet.newAudioClip(file1.toURI().toURL());
		AudioClip nasus_move_sound2 = Applet.newAudioClip(file2.toURI().toURL());
		AudioClip nasus_move_sound3 = Applet.newAudioClip(file3.toURI().toURL());
		nasus_move_sound.add(nasus_move_sound1);
		nasus_move_sound.add(nasus_move_sound2);
		nasus_move_sound.add(nasus_move_sound3);
	}
	
	public void nidalee_sounds() throws MalformedURLException
	{
		File file1 = new File(".\\Resource\\Sound\\Nidalee\\Nidalee_move1.wav");
		File file2 = new File(".\\Resource\\Sound\\Nidalee\\Nidalee_move2.wav");
		File file3 = new File(".\\Resource\\Sound\\Nidalee\\Nidalee_move3.wav");
		AudioClip nidalee_move_sound1 = Applet.newAudioClip(file1.toURI().toURL());
		AudioClip nidalee_move_sound2 = Applet.newAudioClip(file2.toURI().toURL());
		AudioClip nidalee_move_sound3 = Applet.newAudioClip(file3.toURI().toURL());
		nidalee_move_sound.add(nidalee_move_sound1);
		nidalee_move_sound.add(nidalee_move_sound2);
		nidalee_move_sound.add(nidalee_move_sound3);
	}
	
	public void rengar_sounds() throws MalformedURLException
	{
		File file1 = new File(".\\Resource\\Sound\\Rengar\\Rengar_move1.wav");
		File file2 = new File(".\\Resource\\Sound\\Rengar\\Rengar_move2.wav");
		File file3 = new File(".\\Resource\\Sound\\Rengar\\Rengar_move4.wav");
		AudioClip rengar_move_sound1 = Applet.newAudioClip(file1.toURI().toURL());
		AudioClip rengar_move_sound2 = Applet.newAudioClip(file2.toURI().toURL());
		AudioClip rengar_move_sound3 = Applet.newAudioClip(file3.toURI().toURL());
		rengar_move_sound.add(rengar_move_sound1);
		rengar_move_sound.add(rengar_move_sound2);
		rengar_move_sound.add(rengar_move_sound3);
	}
}
