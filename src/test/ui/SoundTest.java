package ui;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class SoundTest extends CenterPanel {

    @Test
    void testPlaySoundExceptionExpected() {
        try {
            Sound s = new Sound();
            s.playSound("SomethingThatDoesntExist.wav");
            fail("Should have threw an exception!!");
        } catch (Exception ex){

        }
    }

    @Test
    void testPlaySoundExceptionNotExpected() {
        try {
            Sound s = new Sound();
            s.playSound("ding.wav");
        } catch (Exception ex) {
            fail("Should NOT have thrown an exception :(");
        }

    }



}
