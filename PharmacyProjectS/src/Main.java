import package1.WarehouseMovements;

//In order to use properly, please create only one instance of movements.
//Trying to create more will result in exemption
//Only through WarehouseMovements everything can be accessed. It is the only public class.
//All other classes cannot be accessed beyond the boundaries of the package



//Next comment is a list with a little bit of info about allowed actions.
/*
allowed actions:
.addNewMedicine(String type, String name, double price)
.removeMedicine(String name) <- use with caution it can change a lot of the codes
because it changes the positions within the arraylist

.restock(String name, int numberOfPills)
.usePills(String name, int numberOfPills) <- only allowed to use pills you have. otherwise prints warning

.checkAvailabilityByName(String name)
.checkAvailabilityByCode(String code)

.costByName(String name)
.costByCode(String code)

.locateCodeByName(String name)
.locateNameByCode(String code)

.amountOfMeds()
.amountOfAntibiotics()
.amountOfPainRelievers()
.amountOfSupplements()
.amountOfGeneralMeds()

.detailedAllStock()
.detailedAmountOfAntibiotics()
.detailedAmountOfPainRelievers()
.detailedAmountOfSupplements()
.detailedAmountOfGeneralMeds()

.playRecord() -> only adding, removing, restocking and using is recorded.
This action shows everything ins the record.
*/
public class Main {
    public static void main(String[] args) {

        WarehouseMovements movements = new WarehouseMovements();

        movements.addNewMedicine("Antibiotic", "zinadol", 22);
        







    }
}
