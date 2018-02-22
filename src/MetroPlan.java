import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MetroPlan {
    private ArrayList<Station> listStations;
    private ArrayList<Arcs> listArcs;

    private int height;
    private int width;

    /**
     * Default constructor
     */
    public MetroPlan() {
        listStations = new ArrayList<Station>();
        listArcs = new ArrayList<Arcs>();
    }

    /**
     * Load data from a .gr file that was given to us
     *
     * @param path Path where the file is located
     */
    public void loadFromFile(String path) throws IOException {
        ArrayList<String> strLines = new ArrayList<String>();
        Stream<String> lines = Files.lines(Paths.get(path), Charset.forName("ISO-8859-1"));
        // Reading lines and then storing it in a list
        lines.forEach(strLines::add);

        // Getting height and with from first line
        this.height = Integer.parseInt(strLines.get(0).split(" ")[0]);
        this.width = Integer.parseInt(strLines.get(0).split(" ")[1]);

        // Now getting information about arcs and stations starting from the third line
        int i = 2;
        while (!strLines.get(i).equals("coord sommets")) {
            // Getting a line
            String singleLine = strLines.get(i);

            // Parsing values and creating the station
            int numeroStation = Integer.parseInt(singleLine.substring(0, 4));
            String stationName = singleLine.substring(5);
            this.listStations.add(new Station(stationName, numeroStation));
            i++;
        }

        i++;
        while (!strLines.get(i).equals("arcs values")) {
            // Getting a line and splitting it
            String[] singleLine = strLines.get(i).split(" ");

            // Searching for the right station to be updated and exiting the loop
            for (Station s :
                    listStations) {
                if (Integer.parseInt(singleLine[0]) == s.getStationNumber()) {
                    s.setCoordX(Integer.parseInt(singleLine[1]));
                    s.setCoordY(Integer.parseInt(singleLine[2]));
                    break;
                }
            }
            i++;
        }

        i++;
        // Going until the end of the file
        while (i != strLines.size() - 1) {
            String[] singleLine = strLines.get(i).split(" ");

            // Creating the arcs list
            listArcs.add(new Arcs(Integer.parseInt(singleLine[0]),
                    Integer.parseInt(singleLine[1]),
                    Integer.parseInt(singleLine[2].equals("120.0") ? "120" : singleLine[2])));
            i++;
        }

    }

    //region Getters and Setters
    public ArrayList<Station> getListStations() {
        return listStations;
    }

    public void setListStations(ArrayList<Station> listStations) {
        this.listStations = listStations;
    }

    public ArrayList<Arcs> getListArcs() {
        return listArcs;
    }

    public void setListArcs(ArrayList<Arcs> listArcs) {
        this.listArcs = listArcs;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    //endregion
}
