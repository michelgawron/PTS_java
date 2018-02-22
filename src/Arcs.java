/**
 * This class represents links between our stations
 */
public class Arcs {
    /**
     * Two stations makes an arc
     */
    private int firstStationId;
    private int secondStationId;

    /**
     * Distance between two stations
     */
    private int distance;

    /**
     * Constructor we are going to use to create our arcs
     *
     * @param firstStation
     * @param secondStation
     * @param distance
     */
    public Arcs(int firstStation, int secondStation, int distance) {
        this.firstStationId = firstStation;
        this.secondStationId = secondStation;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Arcs{" +
                "firstStationId=" + firstStationId +
                ", secondStationId=" + secondStationId +
                ", distance=" + distance +
                '}';
    }
}
