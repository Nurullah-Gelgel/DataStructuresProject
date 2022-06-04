public class Demand {

    public double data;
    Demand next;
    Demand previous;

    //Constructor
    public Demand(double d){
        this.data =d;
        this.next=null;
        this.previous=null;
    }

    //Getter method
    public double getData(){
        return this.data;
    }

    public void setData(double data){
        this.data = data;
    }

}
