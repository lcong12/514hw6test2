package edu.cmu.cs.cs214.hw4.core;

import java.util.HashSet;
import java.util.Set;

/**
 * The segment class.
 * @author Cong Liao, cliao1
 */
public class Segment {
    private SegmentType type;
    //Borders that belongs to the segment.
    private Set<Integer> borderSet;
    private int tileNum;
    //Set of neighbor city if the segment is a field.
    private Set<Segment> neighborCity;
    private int open;
    private String coordinate;
    //Whether has a pennant if the segment is a city.
    private boolean hasPennant;

    /**
     * Constructor of the class.
     * @param type type of the segment
     * @param tileNum tile number the segment belongs to
     * @param set borderSet
     * @param open open number of the segment
     */
    public Segment(SegmentType type, int tileNum, Set<Integer> set, int open) {
        this.type = type;
        this.tileNum = tileNum;
        borderSet = set;
        neighborCity = new HashSet<>();
        this.open = open;
    }

    /**
     * Create a Segment based on another segment(deepcopy).
     * @param seg another segment
     */
    public Segment(Segment seg) {
        type = seg.getType();
        borderSet = new HashSet<>();
        borderSet.addAll(seg.getBorderSet());
        tileNum = seg.tileNum;
        neighborCity = new HashSet<>();
        neighborCity.addAll(seg.getNeighborCity());
        open = seg.getOpen();
        coordinate = seg.getCoordinate();
        hasPennant = seg.getHasPennant();
    }

    /**
     * Set whether the segment has a pennant.
     * @param has whether the segment has a pennant
     */
    public void setPennant(boolean has) {
        hasPennant = has;
    }

    /**
     * Add a border to the border set of the segment.
     * @param borderNum border to be added
     */
    public void addBorderSet(int borderNum) {
        borderSet.add(borderNum);
    }

    /**
     * Remove a border from the border set.
     * @param borderNum the border to be remove
     */
    public void  removeBorderSet(int borderNum) {
        borderSet.remove(borderNum);
    }

    /**
     * Get the border set.
     * @return border set
     */
    public Set<Integer> getBorderSet() {
        return new HashSet<>(borderSet);
    }

    /**
     * Get the type of the segment.
     * @return type of the segment
     */
    public SegmentType getType() {
        return type;
    }

    /**
     * Add a city segment to the neighbor city set.
     * @param neighborCity city segment to be add
     */
    public void addNeighborCity(Segment neighborCity) {
        this.neighborCity.add(neighborCity);
    }

    /**
     * Get the neighbor city set.
     * @return neighbor city set
     */
    public Set<Segment> getNeighborCity() {
        return neighborCity;
    }

    /**
     * Get the open number of the segment.
     * @return open number
     */
    public int getOpen() {
        return open;
    }

    /**
     * Set the coordinate of the segment.
     * @param coordinate coordinate string
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Get the coordinate of the segment.
     * @return coordinate
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     * Check whether the segment has a pennant.
     * @return True if the semgent has a pennant.
     */
    public boolean getHasPennant() {
        return hasPennant;
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append(type)
                .append(borderSet.toString()).append("open: ").append(Integer.toString(open));
        if (type == SegmentType.FIELD) {
            toPrint.append("\t").append("neighbor city").append(neighborCity.toString());
        }

        if (coordinate != null) {
            toPrint.append("\t").append("coordinate: " + coordinate);
        }

        if (hasPennant) {
            toPrint.append("\t").append("has pennant");
        }
        return toPrint.toString();
    }
}
