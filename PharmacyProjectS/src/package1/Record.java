package package1;

import java.time.LocalDate;
import java.util.ArrayList;

class Record{
    ArrayList<String> typeOfMovement = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();
    ArrayList<LocalDate> dates = new ArrayList<LocalDate >();

    public void recordMov(String typeOfMov, String name, int quantity){
        typeOfMovement.add(typeOfMov);
        names.add(name);
        quantities.add(quantity);
        dates.add(LocalDate.now());
    }

    public void playRecord(){
        System.out.println("Record: ");
        for(int i = 0; i < typeOfMovement.size(); i++){
            System.out.println(i +1
                    + ") {" + typeOfMovement.get(i) + ", "
            + names.get(i) + ", quantity: "
            + quantities.get(i) + ", "
            + dates.get(i) + "}");
        }
    }


}
