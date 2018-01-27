package demo.design.observer;

/**
 * Created by anya on 17/1/18.
 */
public class Main {

    public static void main(String[] args) {
        // Create objects for testing
        AverageScoreDisplay averageScoreDisplay =
                new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay =
                new CurrentScoreDisplay();


        // Pass the displays to Cricket data
        CricketData cricketData = new CricketData(currentScoreDisplay,
                averageScoreDisplay);


//        currentScoreDisplay.update(100,2,20);
        // In real app you would have some logic to call this
        // function when data changes
        cricketData.dataChanged();
//        cricketData.currentScoreDisplay=currentScoreDisplay;
//        cricketData.dataChanged();
    }
}
