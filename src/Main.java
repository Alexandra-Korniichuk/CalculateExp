import java.util.Scanner;


public class Main {

    public static void main (String args[]){
        System.out.println("\nHi! This is simple calculator. You can calculate any simple math expression by using it.");
        System.out.println("Please, use numbers and + - / * chars for calculations. For example: 1.5 * 2");
        System.out.println("To get result of your calculation press ENTER button on your keyboard \n");
        System.out.print("YOUR EXPRESSION: ");
        Scanner scan = new Scanner(System.in);
        String expression = scan.nextLine();
        if(testRegExp(expression)){
        System.out.println("Result of the calculation is: "+calculate(expression));}
    }

    private static Boolean testRegExp(String e){
        String e_clean = e.replace(" ","");
        if (!e_clean.matches("(([\\d]+(.[\\d]+)?)([+-/*])){1,10}([\\d]+(.[\\d]+)?)$")){
            System.out.println("Please check your expression, it seems that it is has mistake");
            return false;
        } else {return true;}
    }

    private static Double calculate(String e){
        int y = 0;
        int k = 0;
        String e1 = e;
        Double n2 = 0.0;
        // Calculation for high level operators: / *
        for(int i = 1; i < e1.length(); i++){
            String valueOfChar = String.valueOf(e1.charAt(i));
            if (valueOfChar.equals("*") || valueOfChar.equals("/")){
                    Double n1 = Double.parseDouble(e1.substring(y,i));
                    int    j;
                    for (j = i+1; j < e1.length(); j++){
                        String valueOfChar2 = String.valueOf(e1.charAt(j));
                        if (j==e1.length()-1){
                            n2 = Double.parseDouble(e1.substring(i+1));
                            break;
                        }
                        else if (valueOfChar2.equals("+")|| valueOfChar2.equals("-")||
                                valueOfChar2.equals("/")||valueOfChar2.equals("*")){
                                n2 = Double.parseDouble(e1.substring(i+1,j));
                            break;
                        }
                    }
                    if (valueOfChar.equals("*")){
                        e1 = e1.substring(0,y)+(n1*n2)+e1.substring(j);
                    } else {
                        e1 = e1.substring(0,y)+(n1/n2)+e1.substring(j);
                    }
            }
            if (valueOfChar.equals("+") || valueOfChar.equals("-")){
                y = i+1;
            }
        }
        // Calculation for low level operators
        while(e1.matches("([-])?(([\\d]+(.[\\d]+)?)([+-/*])){1,10}([\\d]+(.[\\d]+)?)$")){
            String valueOfChar3 = String.valueOf(e1.charAt(k));
            int p;
            if (valueOfChar3.equals("+")||valueOfChar3.equals("-")){
                for (p=k+1; p<e1.length(); p++){
                    if (p==e1.length()-1){
                        n2 = Double.parseDouble(e1.substring(p));
                        if (valueOfChar3.equals("-")){
                             return (Double.parseDouble(e1.substring(0,k))-n2);
                        } else {
                            return (Double.parseDouble(e1.substring(0,k))+n2);
                        }
                    }
                    else if (String.valueOf(e1.charAt(p)).equals("+")|| String.valueOf(e1.charAt(p)).equals("-")){
                        n2 = Double.parseDouble(e1.substring(k+1,p));
                        break;
                    }
                }
                if (valueOfChar3.equals("-")){
                    e1 = (Double.parseDouble(e1.substring(0,k))-n2)+e1.substring(p);
                } else {
                    e1 = (Double.parseDouble(e1.substring(0,k))+n2)+e1.substring(p);
                }
                k = 0;
            }
            k++;
        }
        return Double.parseDouble(e1);
    }
}
