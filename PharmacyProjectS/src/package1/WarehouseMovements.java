package package1;

import java.util.ArrayList;

public class WarehouseMovements {

    ArrayList<String> types = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> codes = new ArrayList<String>();
    ArrayList<Double> prices = new ArrayList<Double>();
    ArrayList<Integer> stock =  new ArrayList<Integer>();
    Record record =  new Record();
    private static int x = 0;

    /* Only one WarehouseMovement object is allowed to be created
    in order for the algorithm to function properly*/
    public WarehouseMovements(){
        if (x == 1) throw new UnsupportedOperationException("You can only create one Warehouse Movement. " +
                "Please continue working with the one that has already been created.");
        this.x++;
    }


    public void addNewMedicine(String type, String name, double price){
        boolean exists = false;

        String nameL = name.replace(" ", "").toLowerCase();

        if (names.contains(nameL)) {
            exists = true;
        }
        if (exists == false) {
            switch (type.replace(" ", "").toLowerCase()) {
                case "antibiotic":
                    Antibiotic antibiotic = new Antibiotic(name, price);
                    codes.add(antibiotic.getCode());
                    types.add("Antibiotic");
                    break;
                case "painreliever":
                    PainReliever painReliever = new PainReliever(name, price);
                    codes.add(painReliever.getCode());
                    types.add("Painreliever");
                    break;
                case "supplement":
                    Supplement supplement = new Supplement(name, price);
                    codes.add(supplement.getCode());
                    types.add("Supplement");
                    break;

                default:
                    GeneralMed generalMed = new GeneralMed(name, price);
                    codes.add(generalMed.getCode());
                    types.add("Generalmed");

            }
            names.add(nameL);
            prices.add(price);
            stock.add(1000);
            record.recordMov("new addition", name, 1000);
        } else {
            System.out.println(name + " has already been added.");
            System.out.println("Try restocking");
        }

    }
    public void removeMedicine(String name){
        System.out.println("By removing medicine you are changing the codes of other medicine. Be careful!");

        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch (index) {
            case -1:
                System.out.println("Medicine not found.");
            default:
                Medicine medicine = new Medicine();
                medicine.reduceNumberOfMedicines();
                record.recordMov("Removal", names.get(index), stock.get(index));
                types.remove(index);
                names.remove(index);
                codes.remove(index);
                prices.remove(index);
                stock.remove(index);
                for (int i = index; i < types.size(); i++) {
                    codes.set(i, "0".repeat(5 - Integer.toString(i+1).length()) + Integer.toString(i+1));
                }
        }

    }

    public void restock(String name, int numberOfPills){

        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch (index) {
            case -1:
                System.out.println("Medicine not found.");
                break;
            default:
                stock.set(index, stock.get(index) + numberOfPills);
                record.recordMov("restock", name, numberOfPills);
        }
    }
    public void usePills(String name, int numberOfPills) {

        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch (index) {
            case -1:
                System.out.println("Medicine not found.");
                break;
            default:
                if (stock.get(index) - numberOfPills >= 0) {
                    stock.set(index, stock.get(index) - numberOfPills);
                    record.recordMov("outbound", name, numberOfPills);
                } else {
                    System.out.println("Pills not enough");
                    System.out.println("No movement was completed");
                    System.out.println("Please consider restocking with the .restock(name, numberOfPills) function");
                    record.recordMov("unable to fulfil outbound", name, 0);
                }
        }
    }

    public void checkAvailabilityByName(String name){
        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch(stock.get(index)){
            case 0: System.out.println(types.get(index) +
                    " " + names.get(index) +
                    " not available.");
            break;
            default: System.out.println(types.get(index) +
                    " " + names.get(index) +" in stock. Amount left: " + stock.get(index));
        }
    }
    public void checkAvailabilityByCode(String code){
        int index = codes.indexOf(code);
        switch(stock.get(index)){
            case 0: System.out.println(types.get(index) +
                    " " + names.get(index) +
                    " not available.");
                break;
            default: System.out.println(types.get(index) +
                    " " + names.get(index) +" in stock. Amount left: " + stock.get(index));
        }
    }

    public double costByName(String name){
        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch (index) {
            case -1:
                System.out.println("Medicine not found.");
                return -1;
            default:
                return prices.get(index);
        }
    }
    public double costByCode(String code){
        int index = codes.indexOf(code);
        switch (index) {
            case -1:
                System.out.println("Medicine not found.");
                return -1;
            default:
                return prices.get(index);
        }
    }

    public String locateCodeByName(String name){
        String nameL = name.replace(" ", "").toLowerCase();
        int index = names.indexOf(nameL);
        switch (index) {
            case -1:
                return "Medicine not found.";
            default:
                return codes.get(index);
        }

    }
    public String locateNameByCode(String code){
        int index = codes.indexOf(code);
        switch (index) {
            case -1:
                return "Medicine not found.";
            default:
                return names.get(index);
        }
    }

    public int amountOfMeds(){
        return names.size();
    }
    public int amountOfAntibiotics(){
        int k = 0;
        for(int i = 0; i < types.size(); i++){
            if(types.get(i).equals("Antibiotic")){k++;}
        }
        return k;
    }
    public int amountOfPainRelievers(){
        int k = 0;
        for(int i = 0; i < types.size(); i++){
            if(types.get(i).equals("Painreliever")){k++;}
        }
        return k;
    }
    public int amountOfSupplements(){
        int k = 0;
        for(int i = 0; i < types.size(); i++){
            if(types.get(i).equals("Supplement")){k++;}
        }
        return k;
    }
    public int amountOfGeneralMeds(){
        int k = 0;
        for(int i = 0; i < types.size(); i++){
            if(types.get(i).equals("Generalmed")){k++;}
        }
        return k;
    }

    public void detailedAllStock(){
        detailedAmountOfAntibiotics();
        detailedAmountOfSupplements();
        detailedAmountOfPainRelievers();
        detailedAmountOfGeneralMeds();
    }
    public void detailedAmountOfAntibiotics() {
        System.out.println("There are " + amountOfAntibiotics() + " different antibiotics.");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals("Antibiotic")) {
                System.out.println("Name: " + names.get(i)
                        + ", Code: " + codes.get(i)
                        + ", Price: " + prices.get(i));
            }
        }
    }
    public void detailedAmountOfPainRelievers() {
        System.out.println("There are " + amountOfPainRelievers() + " different pain relievers.");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals("Painreliever")) {
                System.out.println("Name: " + names.get(i)
                        + ", Code: " + codes.get(i)
                        + ", Price: " + prices.get(i));
            }
        }
    }
    public void detailedAmountOfSupplements() {
        System.out.println("There are " + amountOfSupplements() + " different supplements.");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals("Supplement")) {
                System.out.println("Name: " + names.get(i)
                        + ", Code: " + codes.get(i)
                        + ", Price: " + prices.get(i));
            }
        }
    }
    public void detailedAmountOfGeneralMeds() {
        System.out.println("There are " + amountOfGeneralMeds() + " general medicines.");
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals("Generalmed")) {
                System.out.println("Name: " + names.get(i)
                        + ", Code: " + codes.get(i)
                        + ", Price: " + prices.get(i));
            }
        }
    }

    public void playRecord(){
        record.playRecord();
    }







}
