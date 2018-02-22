import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MetroPlan m = new MetroPlan();
        try {
            m.loadFromFile("C:\\Users\\michlg\\Dropbox\\ESILV 2017-2018\\S2\\PTS\\metro.gr");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(m.getHeight());
        System.out.println(m.getWidth());
        System.out.println(m.getListArcs());
        System.out.println(m.getListStations());

    }
}
