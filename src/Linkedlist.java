
public class Linkedlist {
    Demand head; //head of list
    Demand tail; //tail of list
    int size;


    //Constructor
    public Linkedlist() {
        this.head = null;
        this.tail = null;
        size = 0;

    }    public boolean isEmpty() {
        return head==null;
    }

    public void insert(double demand) {
        //Write your codes here
        if (isEmpty()) {
            head = tail = new Demand(demand);
        } else {
            Demand temp = tail;
            tail.next = new Demand(demand);
            tail = tail.next;
            tail.previous = temp;
        }

    }
    public int size() {
        size = 0;
        Demand temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
    public void print() {

        if (this.isEmpty())
            return;
        Demand linkedlist = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (linkedlist != null) {
            System.out.println(index++ + ". " + linkedlist.getData());

            linkedlist = linkedlist.next;  // iterate to next node
        }

    }

    public void clear() {
        Demand trav = head;
        while (trav != null) {
            Demand next = trav.next;
            trav.previous = trav.next = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    public Demand getByPosition(int pos) {
        if (this.isEmpty())
            return new Demand(0);
        Demand current = this.head;
        int index = 0;

        while (current != null) {
            if (index++ == pos)
                break;
            current = current.next;
        }

        if (current == null)
            return new Demand(0);

        return current;
    }
    public void insert(double data, int pos) {
        Demand willBeAdded = new Demand(data);
        if (isEmpty()) {
            head = tail = willBeAdded;
        } else {
            Demand temp = getByPosition(pos);
            if (temp.previous == null) {
                temp.previous = willBeAdded;
                willBeAdded.next = temp;
                this.head = willBeAdded;
            } else {
                temp = temp.previous;
                Demand nextOfInsert = temp.next;
                willBeAdded.next = nextOfInsert;
                nextOfInsert.previous = willBeAdded;
                temp.next = willBeAdded;
                willBeAdded.previous = temp;

            }
        }
    }


}
