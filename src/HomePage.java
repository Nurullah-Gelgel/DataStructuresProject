import java.util.Scanner;

public class HomePage {
    Linkedlist linkedlist = new Linkedlist();
    ExponentialSmoothing ex = new ExponentialSmoothing();
    DoubleExponentialSmoothing dex = new DoubleExponentialSmoothing();
    RegressionAnalyze re = new RegressionAnalyze();
    DSA dsa = new DSA();
    FileOperation f = new FileOperation();

    Scanner scanner = new Scanner(System.in);

    public void calculateMethods() {
        while (true) {
            System.out.println();
            System.out.println("Which method would you like to calculate?  \n" +
                    " 1: Exponential Smoothing          2: Double Exponential Smoothing \n" +
                    " 3: Regression Analysis            4: Deseasonalized Regression Analysis \n" +
                    " 5: exit \n");
            int value = scanner.nextInt();
            if (value == 1) {

                while (true) {
                    System.out.println();
                    System.out.println("Which dataset would you like to calculate?  \n" +
                            " 1: Dataset 1          2: Dataset 2 \n" +
                            " 3: exit \n");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        ex.calculateES(f.linkedlist1);
                    } else if (choice == 2) {
                        ex.calculateES(f.linkedlist2);
                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid value try again...");
                    }


                }

            } else if (value == 2) {

                while (true) {
                    System.out.println();
                    System.out.println("Which dataset would you like to calculate?  \n" +
                            " 1: Dataset 1          2: Dataset 2 \n" +
                            " 3: exit \n");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        dex.calculateDES(f.linkedlist1);
                    } else if (choice == 2) {
                        dex.calculateDES(f.linkedlist2);
                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid value try again...");
                    }


                }

            } else if (value == 3) {

                while (true) {
                    System.out.println();
                    System.out.println("Which dataset would you like to calculate?  \n" +
                            " 1: Dataset 1          2: Dataset 2 \n" +
                            " 3: exit \n");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        re.calculateRA(f.linkedlist1);
                    } else if (choice == 2) {
                        re.calculateRA(f.linkedlist2);
                    } else if (choice == 3) {
                        break;
                    } else {
                    }


                }

            } else if (value == 4) {

                while (true) {
                    System.out.println("");
                    System.out.println("Which dataset would you like to calculate? : \n" +
                            " 1: Dataset 1          2: Dataset 2 \n" +
                            " 3: exit \n");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        dsa.calculateDSA(f.linkedlist1);
                    } else if (choice == 2) {
                        dsa.calculateDSA(f.linkedlist2);
                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid value try again...");
                    }


                }

            } else if (value == 5) {
                break;
            } else {
                System.out.println("Invalid value try again...");
            }


        }
    }
}
