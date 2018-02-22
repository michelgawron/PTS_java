/**
 * This class represents our stations
 */
public class Station implements Comparable<Station> {
    /**
     * Station's name
     */
    private String name;

    /**
     * Station's number
     */
    private int stationNumber;

    /**
     * Station's coordinates
     */
    private int coordX;
    private int coordY;

    public Station() {

    }

    /**
     * Constructor we are going to use when creating our stations from the file
     *
     * @param name          Station's name
     * @param stationNumber Station's number
     */
    public Station(String name, int stationNumber) {
        this.name = name;
        this.stationNumber = stationNumber;
    }

    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    //endregion

    /**
     * Implementing compareTo in order to be able to compare two stations
     * @param o
     * @return
     */
    @Override
    public int compareTo(Station o) {
        return Integer.compare(this.stationNumber, o.stationNumber);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", stationNumber=" + stationNumber +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }
}
