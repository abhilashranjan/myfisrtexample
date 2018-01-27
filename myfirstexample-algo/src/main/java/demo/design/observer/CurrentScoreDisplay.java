package demo.design.observer;

/**
 * Created by anya on 17/1/18.
 */
public class CurrentScoreDisplay {
    private int runs, wickets;
    private float overs;

    public void update(int runs,int wickets,float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    public void display()
    {
        System.out.println("\nCurrent Score Display: \n" +
                "Runs: " + runs +"\nWickets:"
                + wickets + "\nOvers: " + overs );
    }
}
