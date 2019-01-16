import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will calculate the best achievable result using 10 matches in L2 revolution arena and will prompt
 * them out.
 *
 * @author ecammarota
 * */

public class ArenaCalculator {

    private static final double kLess100 = 0.4;
    private static final double kOver100 = 0.68;


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il tuo rank arena attuale: ");
        String s = br.readLine();
        Integer startingPoint = Integer.parseInt(s);

        List<Integer> listOfSteps = new ArrayList<Integer>();
        Integer prevStep = startingPoint;
        Integer newStep = 0;
        int totalCounter = 0;

        do {
            newStep = (int) Math.round(prevStep * kOver100);
            listOfSteps.add(newStep);
            prevStep = newStep;
            totalCounter++;
        } while (newStep >= 100 && totalCounter < 10);

        do {
            newStep = (int) Math.round(prevStep * kLess100);
            listOfSteps.add(newStep);
            prevStep = newStep;
            totalCounter++;
        } while (prevStep != 1 && totalCounter < 10);

        int count = 0;
        System.out.println("!! Lista scontri e posizioni conseguibili !!");
        for (int i : listOfSteps) {
            count++;
            System.out.println(" Fight number " + count + " - New Rank: " + i + "   ");
        }
    }
}
