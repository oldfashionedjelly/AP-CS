public class Main {
    static void decicmalToBinary(int num) {
        if(num>0) {
            System.out.print(num%2);
            decicmalToBinary(num/2);
        }
    }
    static public void main(String[] args)
    { 
        decimalToBinary(100);
    }
    
}