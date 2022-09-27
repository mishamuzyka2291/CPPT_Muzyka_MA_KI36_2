package Lab3;
import java.io.*;
public class VideoPlayer {
    private Power power;
    private Video video;
    private static Volume volume;
    protected static PrintWriter fout;
    public boolean pause;
    public VideoPlayer() throws FileNotFoundException {
        power = new Power();
        video = new Video();
        volume = new Volume();
        pause = false;
        fout = new PrintWriter(new File("Log.txt"));
    }

    /* Constructor
    * @param name - назва відео
    * @param volume - гучність відео
    */ 
    public VideoPlayer(String name, int volume) throws FileNotFoundException {
        video = new Video(name);
        VideoPlayer.volume = new Volume(volume);
        power = new Power();
        pause = false;
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Method вмикає/вимикає живлення
     */
    public void turnPower() {
        boolean value = power.getPower() == true ? false : true;
        power.setPower(value);
        System.out.println(power.getPower() == true ? "Power on" : "Power off");
        fout.println(power.getPower() == true ? "Power on" : "Power off");
        fout.flush();
    }

    /**
     * Method збільшує гучність відео
     */
    public static void increaseVideoVolume() {
        int videoVolume = volume.getVolume();
        if(videoVolume < 100) {
            volume.setVolume(videoVolume++);
            System.out.println("Increase audio volume to: " + videoVolume);
            fout.println("Increase audio volume to: " + videoVolume);
            fout.flush();
        }
        else{
            System.out.println("Can't increase. Max volume!");
            fout.println("Can't increase. Max volume!");
            fout.flush();
        }
    }

    /**
     * Method зменшує гучність video
     */
    public void decreaseVideoVolume() {
        int videoVolume = volume.getVolume();
        if(videoVolume > 0) {
            volume.setVolume(videoVolume--);
            System.out.println("Decrease audio volume to: " + videoVolume);
            fout.println("Decrease audio volume to: " + videoVolume);
            fout.flush();
        }
        else {
            System.out.println("Can't decrease. Min volume!");
            fout.println("Can't decrease. Min volume!");
            fout.flush();
        }
    }

    
    /** 
     * @return гучність video
     */
    public int getVideoVolume() {
        return volume.getVolume();
    }

    
    /**
     * Method змінює гучність video
     * @param videoVolume - гучність
     */
    public void setVideoVolume(int videoVolume) {
        volume.setVolume(videoVolume);
        System.out.println("Set audio volume to: " + videoVolume);
        fout.println("Set audio volume to: " + videoVolume);
        fout.flush();
    }

    
    /**
    * Method змінює назву відео
    * @param  name назва відео
    */ 
    public void setVideoName(String name){
        video.setVideo(name);
        System.out.println("Change video to: " + name);
        fout.println("Change video to: " + name);
        fout.flush();
    }

    
    /** 
     * @return назву відео
     */
    public String getVideoName(){
        return video.getVideo();
    }

    /**
    * Method, який відповідає за включення відеоплеєра
    */ 
    public void play(){
        if(video.getVideo() != "..." && power.getPower() == true) {
            pause = false;
            System.out.println("This video playing: " + video.getVideo());
            fout.println("This video playing: " + video.getVideo());
            fout.flush();
        }
        else if(video.getVideo() == "..." && power.getPower() == true) {
            System.out.println("video isn't loaded");
            fout.println("video isn't loaded");
            fout.flush();
        }
        else {
            System.out.println("Power is off. Turn on power");
            fout.println("Power is off. Turn on power");
            fout.flush();
        }

    }
    /**
    * Method, який відповідає за паузу відеоплеєра
    */ 
    public void stop(){
        if(power.getPower() == true && video.getVideo() != "...") {
            pause = true;
            System.out.println("Pause");
            fout.println("Pause");
            fout.flush();
        }
        else if(video.getVideo() == "..." && power.getPower() == true) {
            System.out.println("Video isn't loaded");
            fout.println("Video isn't loaded");
            fout.flush();
        }
        else {
            System.out.println("Power is off. Turn on power");
            fout.println("Power is off. Turn on power");
            fout.flush();
        }
    }

    /**
    * Method releases used recourses
    */
    public void dispose() {
        fout.close();
    }
}

class Power {
    private boolean power;

    /* 
    *Constructor
    */ 
    public Power() {
        power = true;
    }

    /**
    * Method sets power
    * */
    public void setPower(boolean power){
        this.power = power;
    }

    /** 
     * @return power
     */
    public boolean getPower(){
        return power;
    }
}

class Video {
    private String videoName;
    
    /* 
    * Constructor
    */ 
    public Video() {
        videoName = "...";
    }

    public String getVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setVideo(String name) {
		// TODO Auto-generated method stub
		
	}

	/* Constructor
    * @param name - назва треку
    */ 
    public Video(String name) {
        videoName = name;
    }

    /**
    * Method sets track
    * */
    public void setVideo1(String name) {
        videoName = name;
    }

    /** 
     * @return song
     */
    public String getVideo1() {
        return videoName;
    }
}

class Volume {
    private int volume;

    /* 
    * Constructor
    */ 
    public Volume() {
        volume = 100;
    }

    /* Constructor
    * @param volume - гучність
    */ 
    public Volume(int volume) {
        this.volume = volume;
    }

    /** 
     * @return volume
     */
    public int getVolume() {
        return volume;
    }

    /**
    * Method sets volume
    * */
    public void setVolume(int volume) {
        this.volume = volume;
    }

}