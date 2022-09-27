package Lab3;
import java.io.*;

import Lab3.VideoPlayer;
/**
* Клас AudioPlayerApp реалізує програму-драйвер до аудіоплеєра
*
*/
@SuppressWarnings("unused")
public class VideoPlayerApp {
    
    /** 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
    VideoPlayer videoplayer = new VideoPlayer("5 facts of Ukraine", 60);
    videoplayer.play();
    VideoPlayer.increaseVideoVolume();
    videoplayer.stop();
    videoplayer.turnPower();
    videoplayer.play();
    videoplayer.turnPower();
    videoplayer.play();
    videoplayer.setVideoName("10 facts of Ukraine");
    videoplayer.play();
    }
}