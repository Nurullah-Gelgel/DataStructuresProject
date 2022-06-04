import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperation {

    int data;
    int count = 1;
    File file = new File("src\\resources\\Dataset1.txt");
    Linkedlist linkedlist1 = new Linkedlist();
    Linkedlist linkedlist2 = new Linkedlist();
    static Linkedlist dataset1 = new Linkedlist();
    static Linkedlist dataset2 = new Linkedlist();

    {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 24; i++) {
            data = sc.nextInt();
            linkedlist1.insert(data);
        }
        for (int i = 24; i < 48; i++) {
            data = sc.nextInt();
            linkedlist2.insert(data);
        }

        sc.close();
    }

    public static Linkedlist printList(FileOperation f) {
        Linkedlist res4 = f.linkedlist1;
        for (int i = 0; i < 24; i++) {
            System.out.print((int) res4.getByPosition(i).getData()+",  ");

    }return res4;
    }
    public static Linkedlist printList2(FileOperation f) {
        Linkedlist res5 = f.linkedlist2;
        for (int i = 0; i < 24; i++) {
            System.out.print((int) res5.getByPosition(i).getData()+",  ");

        }return res5;
    }
}
