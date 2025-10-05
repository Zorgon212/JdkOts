import package1.WarehouseMovements;

public class Main {
    public static void main(String[] args) {

        WarehouseMovements movements = new WarehouseMovements();

        movements.addNewMedicine("Antibiotic", "zinadol", 22);
        movements.addNewMedicine("antibiotic", "minoxidil 300", 10);
        movements.addNewMedicine("antibiotic", "minoxidil 500", 10);
        movements.addNewMedicine("Pain reliever", "depon 500", 4);
        movements.addNewMedicine("Pain reliever", "depon Max", 8);
        movements.addNewMedicine("Supplement", "omega 3", 18);
        movements.addNewMedicine("Immunotherapy", "HormonalTypeC", 1500);

        movements.detailedAllStock();

        movements.playRecord();

        movements.costByName("xanax");
        movements.removeMedicine("Minoxidil 500");
        System.out.println("");
        movements.playRecord();
        movements.detailedAllStock();





    }
}
