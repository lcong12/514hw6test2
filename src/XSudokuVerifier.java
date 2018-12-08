package edu.cmu.cs.cs214.hw2;

import java.util.HashSet;
import java.util.Set;

/**
 * The spacial verifier class extends SudokuVerifier class which also check diagonal.
 * Verify whether the solution is correct.
 */
public class XSudokuVerifier extends SudokuVerifier {
    private int[][] solution = getSolMatrix();

    /**
     * Use constructor if super class.
     * @param problemFile file contains problem sudoku
     * @param solutionFile file contains solution sudoku
     */
    public XSudokuVerifier(String problemFile, String solutionFile) {
        super(problemFile, solutionFile);
    }

    private boolean specialCheck() {
        return checkFirstDia() && checkSecondDia();
    }

    private boolean checkFirstDia() {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < getLength(); i++) {
            int num = solution[i][i];
            if (num > getLength() || num < 0 || numSet.contains(num)) {
                System.out.println("First Diagonal check fail");
                return false;
            } else {
                numSet.add(num);
            }
        }
        System.out.println("first diagonal success");
        return true;
    }

    private boolean checkSecondDia() {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < getLength(); i++) {
            int num = solution[i][getLength() - 1 - i];
            if (num > getLength() || num < 0 || numSet.contains(num)) {
                System.out.println("Second Diagonal check fail");
                return false;
            } else {
                numSet.add(num);
            }
        }
        System.out.println("second diagonal success");
        return true;
    }

    @Override
    public boolean getSolution() {
        return super.getSolution() && this.specialCheck();
    }
}
