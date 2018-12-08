package edu.cmu.cs.cs214.hw4.core;

/**
 * The follower class.
 * @author Cong Liao, cliao1
 */
public class Follower {
    private int playerNum;

    /**
     * Constructor of player class.
     * @param playerNum the number that the follower belongs to
     */
    public Follower(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * Get the player number
     * @return player number
     */
    public int getPlayerNum() {
        return playerNum;
    }

    @Override
    public String toString() {
        return "Belong to player: " + Integer.toString(playerNum);
    }
}
