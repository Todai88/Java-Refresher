public class One {

    public void readAndPrint(int number){
        System.out.println(String.format("Binary: %s", Integer.toBinaryString(number)));
        System.out.println(String.format("Octal: %o", number));
        System.out.println(String.format("Hex: %s", Integer.toHexString(number)));
    }
}
