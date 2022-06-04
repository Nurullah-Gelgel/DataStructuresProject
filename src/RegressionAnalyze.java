public class RegressionAnalyze {

    static Linkedlist guessForRegression = new Linkedlist();
    static Linkedlist Mse = new Linkedlist();
    FileOperation f = new FileOperation();

    public static Linkedlist regressionAnalysis(Linkedlist linkedlist) {//Calculating method 3
        double b = getB(linkedlist);
        double a = getA(linkedlist, b);
        guessForRegression.clear();
        for (int i = 0; i <linkedlist.size(); i++)
            guessForRegression.insert(a + b * (i ));
        return guessForRegression;
    }
    private static double getB(Linkedlist linkedlist) {
        double datasum = 0; // sum
        double periodSum = 0; // sum2
        double ty = 0; // sum3
        double periodSquareSum = 0; // sum4
        for (int i = 0; i < linkedlist.size(); i++) {
            ty += linkedlist.getByPosition(i).getData() * (i + 1);
            periodSquareSum += (i+1) * (i+1);
        }
        for (int i = 0; i < linkedlist.size(); i++) {
            double first = linkedlist.getByPosition(i).getData();
            datasum = first + datasum;
        }
        for (int i = 1; i < linkedlist.size()+1; i++) {
            periodSum = i + periodSum;
        }
        double b1 = ty *linkedlist.size();
        double bthird = linkedlist.size() * periodSquareSum;
        return (b1 - (datasum * periodSum)) / (bthird - (periodSum * periodSum));
    }
    private static double getA(Linkedlist linkedlist, double b) {
        double sum = 0;
        double sum2 = 0;
        for (int i = 0; i < linkedlist.size(); i++) {
            double first = linkedlist.getByPosition(i).getData();
            sum = first + sum;
        }
        double yAvg = sum /linkedlist.size();

        for (int i = 0; i <linkedlist.size(); i++) {
            sum2 = i + sum2;
        }
        double xAvg = sum2 / linkedlist.size();
        return yAvg - b * xAvg;
    }

    public static Linkedlist Mse(Linkedlist linkedlist) {
        regressionAnalysis(linkedlist);
        for (int i = 0; i < linkedlist.size(); i++) {
         //   System.out.println(guessForRegression.getByPosition(i).getData());
            Mse.insert(((linkedlist.getByPosition(i).getData() - guessForRegression.getByPosition(i).getData()) * (linkedlist.getByPosition(i).getData() - guessForRegression.getByPosition(i).getData()) / linkedlist.size()));
        }
        return Mse;
    }
    public Linkedlist calculateRA(Linkedlist linkedlist){
        Linkedlist res1 =regressionAnalysis(linkedlist);

        for (int i = 0; i < linkedlist.size(); i++) {
            System.out.print((int) res1.getByPosition(i).getData()+",  ");


        }
        return null;}
    public static double calculateMse(Linkedlist linkedlist){
        Linkedlist res4 = Mse(linkedlist);
        double mse = 0;
        for (int i = 0; i < linkedlist.size(); i++) {
            mse += res4.getByPosition(i).getData();

        }return  mse;
    }

}

