import java.util.Scanner;


public class Main {

    public static void main (String args[]){
        System.out.println("\nHi! This is simple calculator. You can calculate any simple math expression by using it.");
        System.out.println("Please, use numbers and + - / * chars for calculations. For example: 1.5 * 2");
        System.out.println("To get result of your calculation press ENTER button on your keyboard \n");
        System.out.print("YOUR EXPRESSION: ");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        testRegExp(expression);
    }

    public static void testRegExp (String e){
        String e_clean = e.replace(" ","");
        if (e_clean.matches("(([\\d]+(.[\\d]+)?)([+-\\/\\*])){1,10}([\\d]+(.[\\d]+)?)$")){
            System.out.println("Correct");
        } else{
            System.out.println("Please check your expression, it seems that it is has mistake");
        }
    }

    public static Double calculate (String e){
        return 0.0;
    }


}
