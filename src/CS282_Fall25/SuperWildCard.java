package CS282_Fall25;

import java.util.*;

class VideoContent {
    String title;
    VideoContent(String title) { this.title = title; }
}

class ShortVideo extends VideoContent {
    ShortVideo(String title) { super(title); }
}

public class SuperWildCard {

    // We can add ShortVideos into any List<? super ShortVideo>
    public static void loadShorts(List<? super ShortVideo> playlist) {
        playlist.add(new ShortVideo("AI vs Human Chess"));
        playlist.add(new ShortVideo("30-sec Tech News"));

        // Reading gives only Object
        for (Object obj : playlist) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<VideoContent> general = new ArrayList<>();
        List<Object> veryGeneral = new ArrayList<>();

        loadShorts(general);
        loadShorts(veryGeneral);
    }
}
