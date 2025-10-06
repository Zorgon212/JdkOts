//In order to use properly, please create only one instance of WarehouseMovements.
//Trying to create more will result in exemption
//Only through WarehouseMovements everything can be accessed. It is the only public class.
//All other classes cannot be accessed beyond the boundaries of the package.



//Next comment is a list with info about allowed actions.
/*
From WarehouseMovements
allowed actions:
(void) .addNewMedicine(String type, String name, double price) <- When you add a new medicine, you always get 1000 pills.
(void) .removeMedicine(String name) <- use with caution it can change a lot of the codes
because it changes the positions within the arraylist

(void) .restock(String name, int numberOfPills)
(void) .usePills(String name, int numberOfPills) <- only allowed to use pills you have. otherwise prints warning

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