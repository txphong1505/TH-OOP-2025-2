package hust.soict.dsai.aims;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class PolymorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> mediae = new ArrayList<Media>();

        Book book = new Book(1, "Java Core", "Programming", 10.5f);
        book.addAuthor("John Smith");

        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Interstellar", "Sci-fi", "Christopher Nolan", 169, 20.0f);

        CompactDisc cd = new CompactDisc(3, "Best Hits", "Music", "Director A", "Artist A", 15.0f);
        cd.addTrack(new Track("Song A", 3));
        cd.addTrack(new Track("Song B", 4));

        mediae.add(book);
        mediae.add(dvd);
        mediae.add(cd);

        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
}