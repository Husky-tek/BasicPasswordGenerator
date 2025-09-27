import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class PasswordGen {
    public static Random rand = new Random();
   public static Scanner in = new Scanner(System.in);
   public static String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static String lowercase = "abcdefghijklmnopqrstuvwxyz";
   public static String numbs = "123456789";
   public static String specialchars = "!@#$%^&*()";
   public static int passLength = 10;
   public static boolean numbers = true;
   public static boolean specialChars = true;
   public static boolean upper = true;
   public static boolean lower = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the password generator.");
        while (true) {
            System.out.println("1.generate password\n2.settings\n3.Exit");
            String input = in.nextLine();
            switch (input) {
                case "1": //generates password
                    System.out.println("Here is your new password \n" + "\nplease write this down and put it in a safe place\n" );
                    generatePass();
                    System.out.println();
                    
                    break;
                case "2":// prints settings
                    viewSettings();
                    break;
                case "3":
                    System.exit(0);
                    break;
                
                case "length":
                    System.out.println("How long should the password be?");
                    int l = Integer.parseInt(in.nextLine());
                    passLength = l;
                    break;
                
                case "lowercase":
                    lower = !lower;
                    break;

                case "uppercase":
                    upper = !upper;
                    break;

                case "numbers":
                    numbers = !numbers;
                    break;
                
                case "special":
                    specialChars = !specialChars;
                    break;
            
                default:
                    System.out.println("invalid input");
                    break;
            }
            
        }
       
    }

    public static void generatePass(){
        String genPassString = "";
        if (numbers) {
            genPassString += numbs;
        }
        if (lower) {
            genPassString += lowercase;
        }
        if (upper) {
            genPassString += uppercase;
        }
        if (specialChars) {
            genPassString += specialchars;
        }

        for (int i = 0; i < passLength; i++) {
            System.out.print(genPassString.charAt(rand.nextInt(genPassString.length()-1)));
        }
        
        

    }

    public static void viewSettings(){ //replace this with a way to toggle without having going to the settings
        System.out.println("=============[SETTINGS]=============");
        System.out.println("Length: " + passLength);
        if (lower) {
            System.out.println("lowercase letters: Active ");
        }else{
            System.out.println("Lowercase letters: Disabled");
        }
        if (upper) {
            System.out.println("uppercase letters: Active ");
        }else{
            System.out.println("uppercase letters: Disabled");
        }
        if (numbers) {
            System.out.println("numbers: Active ");
        }else{
            System.out.println("numbers: Disabled");
        }
        if (specialChars) {
            System.out.println("Special Characters: Active ");
        }else{
            System.out.println("Special Characters: Disabled");
        }

        System.out.println("If you would like to change the settings\n please type which one you want to change");
        System.out.println("====================================");
    }


}