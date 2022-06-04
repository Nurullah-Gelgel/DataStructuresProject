public class DSA {
    static Linkedlist guess = new Linkedlist();
  static Linkedlist getLinkedDSA= new Linkedlist();
    static Linkedlist Mse = new Linkedlist();
   static FileOperation f = new FileOperation();


    public static Linkedlist dsa(Linkedlist linkedlist) {
        FileOperation fileOperation = new FileOperation();

        double Overall = 0;
        for (int i = 0; i < 24; i++) {
            Overall = fileOperation.linkedlist1.getByPosition(i).getData() + Overall;
        }
        Overall = Overall / 24;
        double[] Seasonal = new double[12];
        for (int i = 0; i < 12; i++) {

            Seasonal[i] = ((fileOperation.linkedlist1.getByPosition(i).getData() + fileOperation.linkedlist1.getByPosition(i + 12).getData()) / 2) / Overall;


        }

        double[] Deseason = new double[24];
        for (int i = 0; i < 24; i++) {
            Deseason[i] = fileOperation.linkedlist1.getByPosition(i).getData() / Seasonal[i % 12];


        }
        double sumY = 0;
        for (int i = 0; i < 24; i++) {
            sumY = Deseason[i] + sumY;


        }
        int sumX = 0;
        for (int i = 0; i < 24; i++) {
            sumX = sumX + i + 1;

        }

        double[] xy = new double[24];
        int[] xx = new int[24];

        int sumXx = 0;
        for (int i = 0; i < 24; i++) {
            xx[i] = (i + 1) * (i + 1);
            sumXx = sumXx + xx[i];

        }

        double sumXY = 0;
        for (int i = 0; i < 24; i++) {
            xy[i] = Deseason[i] * (i + 1);
            sumXY = sumXY + xy[i];

        }

        double b = (fileOperation.linkedlist1.size() * sumXY - sumX * sumY) / (fileOperation.linkedlist1.size() * sumXx - sumX * sumX);

        double aa = sumY / fileOperation.linkedlist1.size() - b * sumX / fileOperation.linkedlist1.size();

        guess.clear();
        for (int i = 0; i < 24; i++) {
            guess.insert( ((aa + b * (i + 1)) * Seasonal[i % 12]));

        }

        return guess;

    }
    public static Linkedlist Mse(Linkedlist linkedlist) {
        dsa(f.linkedlist1);
        for (int i = 0; i < 24; i++) {
          //  System.out.println(guess.getByPosition(i).getData());
            Mse.insert(((linkedlist.getByPosition(i).getData() - guess.getByPosition(i).getData()) * (linkedlist.getByPosition(i).getData() - guess.getByPosition(i).getData()) / 24));
        }
        return Mse;
    }
    public Linkedlist calculateDSA(Linkedlist linkedlist){
        Linkedlist res1 =dsa(linkedlist);

        for (int i = 0; i < 24; i++) {
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
