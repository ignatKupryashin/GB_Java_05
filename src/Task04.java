//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

import java.util.*;

public class Task04 {

    public static void main(String[] args) {
        int[][] deck = new int[8][8];
        Stack<int[]> queens = new Stack<>();
        queens = putQueen(deck,0,queens);
        printDeck(deck);
        System.out.println();
        for (int i = 0; i < queens.size(); i++) {
            System.out.print(Arrays.toString(queens.get(i)));
        }
    }

    public static Stack putQueen(int[][] deck, int currentNumber, Stack <int[]> queens) {
        if (queens.size() < 8) {
            for (int i = 0; i < 8; i++) {
                deck[currentNumber][i] = 1;
                if(checkFigures(deck,currentNumber,i)) {
                    int[] currentPosition = {currentNumber, i};
                    queens.push(currentPosition);
                    queens = putQueen(deck, ++currentNumber, queens);
                    if (queens.size() == 8) {
                        return queens;
                    }
                    else {
                        currentNumber--;
                        queens.pop();
                        deck[currentNumber][i] = 0;
                    }
                }
                else {
                    deck[currentNumber][i] = 0;
                }
            }
        }
        return queens;
    }



    public static boolean checkLines(int[][] deck) {
        for (int i = 0; i < 8; i++) {
            if (Arrays.stream(deck[i]).sum() > 1) {
                return false;
            }
        }
        int column = 0;
        for (int i = 0; i < 8; i++) {
            column = 0;
            for (int j = 0; j < 8; j++) {
                column = column + deck[j][i];
            }
            if (column > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFigures(int[][] deck, int i, int j) {
        return checkLines(deck) && checkMainDiagonale(deck,i,j) && checkSideDiagonale(deck, i, j);
    }

    public static boolean checkMainDiagonale(int[][] deck, int mainI, int mainJ) {
        boolean answer = true;
        int i = mainI;
        int j = mainJ;

        while (i < 7 && j < 7)  {
            i++; j++;
            if (deck[i][j] == 1) {
                answer = false;
                break;
            }
        }

        if (answer) {

        i = mainI;
        j = mainJ;

        while (i > 0 && j > 0) {
            i--; j--;
            if (deck[i][j] == 1) {
                answer = false;
                break;
            }
        }
        }
        return answer;
    }


    public static boolean checkSideDiagonale(int[][] deck, int mainI, int mainJ) {
        boolean answer = true;
        int i = mainI;
        int j = mainJ;

        while (i < 7 && j > 0)  {
            i++; j--;
            if (deck[i][j] == 1) {
                answer = false;
                break;
            }
        }

        if (answer) {

            i = mainI;
            j = mainJ;

            while (i > 0 && j < 7) {
                i--; j++;
                if (deck[i][j] == 1) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void printDeck(int[][] deck) {
        for (int i = 0; i < deck.length; i++) {
            System.out.println(Arrays.toString(deck[i]));
        }
    }

}
