import java.util.*;
public class EasyClass
{
    public static void main(String[] args) {
        //
        //get inputs from user until user enters 0
        Helpers myhelper = new Helpers();
        
        int user_input = 0;
        String strOutputRange1 = "  1 - 10  | ";
        String strOutputRange2 = "  11 - 20 | ";
        String strOutputRange3 = "  21 - 30 | ";
        String strOutputRange4 = "  31 - 40 | ";
        String strOutputRange5 = "  41 - 50 | ";
        String strOutputRange6 = "  51 - 60 | ";
        String strOutputRange7 = "  61 - 70 | ";
        String strOutputRange8 = "  71 - 80 | ";
        String strOutputRange9 = "  81 - 90 | ";
        String strOutputRange10 ="  91 - 100| ";

        do
        {
            user_input = myhelper.getInput();
            if(user_input != 0){
                //inputList.add(user_input);
                if(user_input < 11) {
                    strOutputRange1 += "*";
                }
                else if (user_input < 21) {
                    strOutputRange2 += "*";
                }
                else if (user_input < 31) {
                    strOutputRange3 += "*";
                }
                else if (user_input < 41) {
                    strOutputRange4 += "*";
                }
                 else if (user_input < 51) {
                    strOutputRange5 += "*";
                }
                else if (user_input < 61) {
                    strOutputRange6 += "*";
                }
                else if (user_input < 71) {
                    strOutputRange7 += "*";
                }
                else if (user_input < 81) {
                    strOutputRange8 += "*";
                }
                else if (user_input < 91) {
                    strOutputRange9 += "*";
                }
                else if (user_input < 100) {
                    strOutputRange10 += "*";
                }
            }
        } while (user_input != 0);       
        System.out.println(strOutputRange1);
        System.out.println(strOutputRange2);
        System.out.println(strOutputRange3);
        System.out.println(strOutputRange4);
        System.out.println(strOutputRange5);
        System.out.println(strOutputRange6);
        System.out.println(strOutputRange7);
        System.out.println(strOutputRange8);
        System.out.println(strOutputRange9);
        System.out.println(strOutputRange10);
        
        System.out.println("Demonstration concluded");
        
    }
}
