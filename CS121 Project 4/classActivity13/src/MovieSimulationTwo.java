import java.util.*;
public class MovieSimulationTwo {
    public static void main(String[] args){
        String movieNames [] = {"Hunger Games", "Percy Jackson", "Intertellar", "Shrek"};
        String movieTypes [] = {"2D", "3D" , "3D", "2D"};
        double moviePrices [] = {19.90, 18.80, 16.70, 15.50};
        final int ROW = 5;
        final int COL = 10;
        int [][] movieAvailability = new int[ROW][COL];
        output(movieNames, moviePrices, movieTypes);
        setSeatAvailability(movieAvailability);
        displayMovieDetails(movieAvailability, ROW, COL);
        System.out.println();
        randomAvailability(movieAvailability);
        displayMovieDetails(movieAvailability, ROW, COL);
        System.out.println();

    }
    public static void output(String[] movieNames, double[] moviePrices, String[] movieTypes){
        System.out.printf("Movie Name                      Movie Type        Movie Price\n");
        for (int i = 0; i < movieNames.length; i++) {
            System.out.printf("Movie %d: ", i + 1);
            System.out.printf("%-25s", movieNames[i]);
            System.out.printf("Type: %-10s", movieTypes[i]);
            System.out.printf("Price: %.2f", moviePrices[i]);
            System.out.println();
        }
    }

    public static void setSeatAvailability(int[][] movieAvailability) {
        for (int i = 0; i < movieAvailability.length; i++) {
            for (int j = 0; j < movieAvailability[i].length; j++) {
                movieAvailability[i][j] = 0;
            }
        }
    }
    public static void randomAvailability(int[][] movieAvailability) {
        for (int i = 0; i < movieAvailability.length; i++) {
            for (int j = 0; j < movieAvailability[i].length; j++) {
                Random rand = new Random();
                int randNum = rand.nextInt(0,2);
                movieAvailability[i][j] = randNum;
            }
        }
    }
    public static void displayMovieDetails(int [][] movieAvailability, int ROW, int COL){
        System.out.println("\nSeating Availability: [1 = unavailable ; 0 = available]");
        for(int i =0; i < ROW; i++) {
            System.out.println();
            for(int j = 0; j < COL; j++) {
                System.out.printf("%-5s",movieAvailability[i][j]);
            }
        }
    }
}
