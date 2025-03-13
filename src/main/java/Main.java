import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // get instance of Scanner class
        Scanner scn = new Scanner(System.in);

        // Exception Handling
        try{
            System.out.print("Lutfen taban sayisini giriniz: ");
            byte floorNumb = scn.nextByte();

            System.out.print("Lutfen tavan sayisini giriniz: ");
            byte powNumb = scn.nextByte();

            System.out.println("Sonuc: " + recursivePow(floorNumb,powNumb));
        }catch (InputMismatchException exception){
            System.out.println("Hatali veri girişi");
        }catch (NullPointerException exception){
            System.out.println("Nesne oluşturulamadı !");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }finally {
            scn.close();
        }
    }
    // Creating recursive method for calculating power of the number.
    public static double recursivePow(int floorNumb,int powNumb){
        if (powNumb == 0) {
            return 1;
        } else {
            return floorNumb * recursivePow(floorNumb, powNumb - 1);
        }
    }
}
