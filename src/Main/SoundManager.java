package Main;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundManager {

    Clip clip;
    public URL audioUrl[] = new URL[10];
    public URL audioBattle;
    public URL audioIntro;

    public SoundManager() {
        audioUrl[0] = getClass().getResource("/Music/Pokemon Emerald Intro.wav");
        audioUrl[1] = getClass().getResource("/Music/Pokemon Emerald Menu.wav");
        audioUrl[2] = getClass().getResource("/Music/Pokemon Emerald Battle.wav");
    }

    /**
     * Gets and Sets
     */
    public void SetClip(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            if(i < 3)
                clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }
    }

    public void PlayClip() {
        clip.start();
    }

    public void StopClip() {
        clip.stop();
    }
}
