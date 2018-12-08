package edu.cmu.cs.cs214.hw1;

import java.util.ArrayList;
import java.util.List;

/**
 * Takes a list of URLs on the command line and prints the closest match to each document in the set.
 * Prints a stack trace if any of the URLs are invalid, or if an exception occurs while reading data from
 * the URLs.
 */
public class FindClosestMatches {

    /**
     * Method that is called when this program is run.
     *
     * @param args several document.
     */
    public static void main(String[] args) {
        int numDocs = args.length;
        Document[] allPages = new Document[numDocs];
        double[][] similarities = new double[numDocs][numDocs];
        List<int[]> similarityPairs = new ArrayList<>();

        for (int i = 0; i < numDocs; i++) {
            allPages[i] = new Document(args[i]);
        }

        for (int i = 0; i < numDocs; i++) {
            double maxSimilarity = 0.0;
            int[] pair = {-1, -1};
            double curSimilarity;
            for (int j = 0; j < numDocs; j++) {
                if (i == j) {
                    continue;
                } else if (i > j) {
                    curSimilarity = similarities[j][i];
                } else {
                    curSimilarity = allPages[i].similarity(allPages[j]);
                    similarities[i][j] = curSimilarity;
                }

                if (curSimilarity > maxSimilarity) {
                    maxSimilarity = curSimilarity;
                    pair[0] = i;
                    pair[1] = j;
                }
            }
            similarityPairs.add(pair);
        }

        for (int[] pair : similarityPairs) {
            System.out.println(allPages[pair[0]].toString() + " " + allPages[pair[1]].toString());
        }
    }
}
