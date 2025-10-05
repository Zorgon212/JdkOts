package package1;

class Medicine {

    private final String name;
    private final String code;
    private final double price;
    private int reserve;

    private static int numberOfMedicines;

    Medicine(){
        this.name = "";
        this.code = "";
        this.price = 0;
    }
    Medicine(String name, double price) {
        this.name = name;
        numberOfMedicines++;
        //unique code creation for up to 99999 different medicines
        this.code = "0".repeat(5 - Integer.toString(numberOfMedicines).length()) + Integer.toString(numberOfMedicines);
        this.price = price;
        //we get drugs in a bunch of 1000 every time a new intance (order) is created
        this.reserve += 1000;

    }

    public void reduceNumberOfMedicines() {
        numberOfMedicines--;
    }

    public static int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", reserve=" + reserve +
                '}';
    }
}



