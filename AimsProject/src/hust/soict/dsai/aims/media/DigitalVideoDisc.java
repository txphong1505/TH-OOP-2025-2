package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() { return director; }
    public int getLength() { return length; }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength() + " mins");
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " mins: " + getCost() + " $";
    }

    public void setTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }
}