package Lab3;
import java.io.*;

interface MicrophoneSensitivity {
    void setMicrophoneSensitivity(int sensitivity);
    int getMicrophoneSensitivity();
}

interface Recording extends MicrophoneSensitivity {
    void record ();
}

/**
* Клас VideoRecording реалізує запис відео
*
*/

public class VideoRecording extends VideoPlayer implements Recording{
    public void VideoRecording1() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
	}


	private int sensitivity;
     
    /* Constructor
    * @throws FileNotFoundException
    */ 
    public VideoRecording() throws FileNotFoundException {
        super();
        sensitivity = 100;
    }  

     /**
     * Method вмикає і зберігає запис камери
     */
    public void record() {
        int random = (int)(Math.random() * 100 + 1);
        String name = "My VIdeo Record - " + random; 
        setVideoName(name);
        System.out.println("Save recording...\n Set track to:  " + name);
        fout.println("Save recording...\n Set track to:  " + name);
        fout.flush();
    }

    
    /** 
     * @return sensitivity
     */
    public int getMicrophoneSensitivity() {
        System.out.println(sensitivity);
        return sensitivity;
    }

    
    /**
     * Method змінює чутливість мікрофону
     * @param audioVolume - гучність
     */
    public void setMicrophoneSensitivity(int sensititivity) {
        this.sensitivity = sensititivity;
        System.out.println("Set microphone sensitivity to: " + sensititivity);
        fout.println("Set microphone sensitivity to: " + sensititivity);
        fout.flush();
    }
}