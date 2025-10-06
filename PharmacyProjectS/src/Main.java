import package1.WarehouseMovements;

//In order to use properly, please create only one instance of WarehouseMovements.
//Trying to create more will result in exemption
//Only through WarehouseMovements everything can be accessed. It is the only public class.
//All other classes cannot be accessed beyond the boundaries of the package.

//code of a medicine is a String created by the number of medicines on stock, when adding the new medicine.
//For example 00001 is the first added, 00002 the second, 000010 the tenth and so on. SO there is a limitation of up to 999999 different medicine on stock.
//When removing from stock all the codes from that index and onwards change in order to match the list index.

/*Type can be anything. Only Antibiotic, Pain Reliever or Supplement will be recognised
* anything else will get GeneralMed type.*/

//Next comment is a list with info about allowed actions.
/*
From WarehouseMovements
allowed actions:
(void) .addNewMedicine(String type, String name, double price) <- When you add a new medicine, you always get 1000 pills.
(void) .removeMedicine(String name) <- use with caution it can change a lot of the codes
because it changes the positions within the arraylist

(void) .restock(String name, int numberOfPills) <- need numberOfPills > 0, otherwise does nothing
(void) .usePills(String name, int numberOfPills) <- only allowed to use pills you have. otherwise prints warning. need numberOfPills > 0, otherwise does nothing

(void) .checkAvailabilityByName(String name)
(void) .checkAvailabilityByCode(String code)

(double) .costByName(String name)
(double) .costByCode(String code)

(String) .locateCodeByName(String name)
(String) .locateNameByCode(String code)

(int) .amountOfMeds()
(int) .amountOfAntibiotics()
(int) .amountOfPainRelievers()
(int) .amountOfSupplements()
(int) .amountOfGeneralMeds()

(void) .detailedAllStock()
(void) .detailedAmountOfAntibiotics()
(void) .detailedAmountOfPainRelievers()
(void) .detailedAmountOfSupplements()
(void) .detailedAmountOfGeneralMeds()

(void) .playRecord() -> only adding, removing, restocking and using is recorded.
This action shows everything ins the record.
*/
public class Main {
    public static void main(String[] args) {

        WarehouseMovements movements = new WarehouseMovements();

        movements.addNewMedicine("Antibiotic", "zinadol 300", 22);
        movements.addNewMedicine("Antibiotic", "zinadol 500", 27);
        movements.addNewMedicine("Pain reliever", "depon 500", 8);
        movements.restock("zinadol300", 150);
        movements.playRecord();
        movements.detailedAllStock();
        movements.removeMedicine("zinadol300");
        movements.detailedAllStock();
        







    }
}
