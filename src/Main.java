import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //You can calculate the new data by entering the Dataset.txt file
        ExponentialSmoothing ex = new ExponentialSmoothing();
        DoubleExponentialSmoothing dex = new DoubleExponentialSmoothing();
        RegressionAnalyze re = new RegressionAnalyze();
        DSA dsa = new DSA();
        FileOperation f = new FileOperation();
        HomePage homePage = new HomePage();

        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println();
            System.out.println("What do you want to do ");
            System.out.println("1-)Calculate methods with Dataset 1 and Dataset 2");
            System.out.println("2-)Calculate MSE ");
            System.out.println("3-)List all datasets");
            System.out.println("4-)Exit");
            int answer = scanner.nextInt();
            if (answer == 1) {
                homePage.calculateMethods();
            } else if (answer == 2) {
                double mseForESD1 = ex.calculateMse(f.linkedlist1);
                double mseForESD2 = ex.calculateMse(f.linkedlist2);
                double mseForDESD1 = dex.calculateMse(f.linkedlist1);
                double mseForDESD2 = dex.calculateMse(f.linkedlist2);
                double mseForRAD1 = re.calculateMse(f.linkedlist1);
                double mseForRAD2 = re.calculateMse(f.linkedlist2);
                double mseForDRAD1 = dsa.calculateMse(f.linkedlist1);
                double mseForDRAD2 = dsa.calculateMse(f.linkedlist2);
                double[] array = {mseForDRAD1, mseForESD1, mseForRAD1, mseForDESD1};
                System.out.println("Exponential smoothing mse for Dataset1 "+mseForESD1);
                System.out.println("Exponential smoothing mse for Dataset2 "+mseForESD2);
                System.out.println("Double exponential smoothing mse for Dataset1 "+mseForDESD1);
                System.out.println("Double exponential smoothing mse for Dataset2 "+mseForDESD2);
                System.out.println("Regression analysis mse for Dataset1 "+mseForRAD1);
                System.out.println("Regression analysis smoothing mse for Dataset2 "+mseForRAD2);
                System.out.println("Deseasonalized regression analysis mse for Dataset1 "+mseForDRAD1);
                System.out.println("Deseasonalized regression analysis mse for Dataset2 "+mseForDRAD2);

                double smallValue = 0;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        smallValue = array[i];
                    }
                    if (array[i] < smallValue) {
                        smallValue = array[i];
                    }
                }
                System.out.println("The min value for Dataset1:" + smallValue);

                    if (smallValue == mseForESD1) {
                        System.out.println("The smallest method Exponential smoothing method.");
                    } else if (smallValue == mseForDESD1) {
                        System.out.println("The smallest method Double exponential smoothing method. ");
                    } else if (smallValue == mseForRAD1) {
                        System.out.println("The smallest method  Regression analyses method method. ");
                    } else if (smallValue == mseForDRAD1) {
                        System.out.println("The smallest method Deseasonalized regression analysis method. ");
                    } else {
                        System.out.println("It hasn't been calculated. ");
                    }
                      double[] array2 = {mseForDRAD2, mseForESD2, mseForRAD2, mseForDESD2};
                double smallValue2 = 0;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        smallValue2 = array2[i];
                    }
                    if (array2[i] < smallValue) {
                        smallValue2 = array2[i];
                    }
                }
                System.out.println("The min value for Dataset2:" + smallValue2);
                    if (smallValue2 == mseForESD1) {
                        System.out.println("The smallest value Exponential smoothing method.");
                    } else if (smallValue2 == mseForDESD1) {
                        System.out.println("The smallest value Double exponential smoothing method. ");
                    } else if (smallValue2 == mseForRAD1) {
                        System.out.println("The smallest value  Regression analyses method method. ");
                    } else if (smallValue2 == mseForDRAD1) {
                        System.out.println("The smallest value Deseasonalized regression analysis method. ");
                    } else {
                        System.out.println("It hasn't been calculated.");
                    }


            } else if (answer == 3) {
                f.printList(f);
                System.out.println();
                f.printList2(f);
            } else if (answer == 4) {
                break;
            } else {
                System.out.println("Invalid value try again...");

            }


        }

    }
}


