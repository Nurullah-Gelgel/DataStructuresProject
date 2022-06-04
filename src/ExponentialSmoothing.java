public class ExponentialSmoothing {
    static Linkedlist guess = new Linkedlist();
    static Linkedlist Mse = new Linkedlist();
    static double alpha = 0.2;
    FileOperation f = new FileOperation();

    public static Linkedlist eS(Linkedlist linkedlist) {    //method 1
        guess.clear();

        guess.insert(linkedlist.getByPosition(0).getData(), 0);
        for (int i = 0; i < linkedlist.size(); i++)
            guess.insert((alpha * linkedlist.getByPosition(i).getData() + (1 - alpha) * guess.getByPosition(i).getData()));

        return guess;
    }


    public static Linkedlist Mse(Linkedlist linkedlist) {
        eS(linkedlist);
        Mse.clear();
        for (int i = 0; i <linkedlist.size(); i++) {
           // System.out.println(guess.getByPosition(i).getData());
            Mse.insert(((linkedlist.getByPosition(i).getData() - guess.getByPosition(i).getData()) * (linkedlist.getByPosition(i).getData() - guess.getByPosition(i).getData()) / linkedlist.size()));
        }

        return Mse;
    }
    public static double calculateMse(Linkedlist linkedlist){
        Linkedlist res4 = Mse(linkedlist);
       double mse = 0;
        for (int i = 0; i < linkedlist.size(); i++) {
            mse += res4.getByPosition(i).getData();

        }return  mse;
    }

    public Linkedlist calculateES(Linkedlist linkedlist){
    Linkedlist res1 =eS(linkedlist);

        for (int i = 0; i < linkedlist.size(); i++) {
        System.out.print((int) res1.getByPosition(i).getData()+",  ");


    }
        return null;}
}
