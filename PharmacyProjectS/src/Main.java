public class Main {
    public static void main(String[] args) {

        WarehouseMovements movements = new WarehouseMovements();

        movements.addNewMedicine("Antibiotic", "zinadol", 22);
        movements.addNewMedicine("antibiotic", "minoxidil 300", 10);
        movements.addNewMedicine("antibiotic", "minoxidil 500", 10);


        System.out.println(movements.getNames());
        System.out.println(movements.getCodes());
        System.out.println(movements.getPrices());
        System.out.println(movements.getStock());
        movements.usePills("minoxidil 300", 500);
        movements.restock("Zinadol", 200);
        System.out.println(movements.getStock());
        movements.playRecord();

        movements.checkAvailabilityByCode("00002");
        movements.checkAvailabilityByName("ZINADOL");
        movements.usePills("minoxidil300", 500);
        movements.checkAvailabilityByCode("00002");

        movements.addNewMedicine("antibiotic", "minoxidil500", 10);



    }
}
