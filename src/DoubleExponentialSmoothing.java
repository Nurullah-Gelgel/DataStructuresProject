public class DoubleExponentialSmoothing {
    static Linkedlist guess2 = new Linkedlist();
    static double alpha = 0.2;
    static double beta = 0.2;
    static Linkedlist Mse = new Linkedlist();
    FileOperation f = new FileOperation();

    public static Linkedlist getLinkedDES(Linkedlist linkedlist) {
        //(𝛼=0.2,𝛽=0.2,𝑆0=200,𝐺0=50)
        double[] St = new double[24];
        double[] Gt = new double[24];

        St[0] = 200;
        Gt[0] = 50;
        guess2.clear();
        guess2.insert(St[0] + Gt[0]);
        for (int i = 1; i < linkedlist.size(); i++) {
            St[i] = (alpha * linkedlist.getByPosition(i - 1).getData()) + ((1 - alpha) * (St[i - 1] + Gt[i - 1]));
            Gt[i] = (beta * (St[i] - St[i - 1]) + (1 - beta) * Gt[i - 1]);

            guess2.insert((int) St[i] + Gt[i]);
        }

        return guess2;
    }

    public static Linkedlist Mse(Linkedlist linkedlist) {
        getLinkedDES(linkedlist);
        for (int i = 0; i < linkedlist.size(); i++) {
          //  System.out.println(guess2.getByPosition(i).getData());
            Mse.insert(((linkedlist.getByPosition(i).getData() - guess2.getByPosition(i).getData()) * (linkedlist.getByPosition(i).getData() - guess2.getByPosition(i).getData()) / linkedlist.size()));
        }
        return Mse;
    }
    public Linkedlist calculateDES(Linkedlist linkedlist){
        Linkedlist res1 =getLinkedDES(linkedlist);

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
