package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String director, String artist, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added.");
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track " + track.getTitle() + " removed.");
        } else {
            System.out.println("Track not found.");
        }
    }

    public int getLength() {
        int total = 0;
        for (Track t : tracks) {
            total += t.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        for (Track t : tracks) {
            t.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - Length: " + getLength() + " mins: " + getCost() + " $";
    }
}