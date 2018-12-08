package edu.cmu.cs.cs214.hw4.core;

/**
 * The CityFeature class.
 * @author Cong Liao, cliao1
 */
public class CityFeature extends Feature{

    /**
     * Constructor used super class's constructor.
     * @param type the type of the feature.
     */
    public CityFeature(SegmentType type) {
        super(type);
    }

    //Score function for city feature.
    @Override
    protected int score(int tileNum, int pennant, boolean iscomplete) {
        if (iscomplete) {
            return 2 * tileNum + 2 * pennant;
        } else {
            return tileNum + pennant;
        }
    }
}
