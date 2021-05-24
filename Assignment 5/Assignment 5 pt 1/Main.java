import java.util.*;
/*
 * Write a method named findMin that accepts an ArrayList of Person objects named list. 
Each Person object has private myAge and myName properties and corresponding public getAge and getName accessors. 
The method must return the name of the youngest person. 
*/

public class Main {
    public static void main(String[] args) {
        int age = 0;
        String name = "";               
        Scanner userInput = new Scanner(System.in); 
        ArrayList<Person> list = new ArrayList<Person>();
        do{
            try
            {
                System.out.println("Enter person's name (or Done when done)");  
                name = userInput.nextLine();

                if(! name.equals("Done")){                           
                    System.out.println("Enter person's Age");   
                    age = Integer.parseInt(userInput.nextLine());

                    Person p = new Person(age, name);

                    list.add(p);
                }
            } catch (Exception e) { //stop it crashing when i enter name for age again
                System.out.println("ERROR: Sheeeeeeeeesh " + e.toString());   
            }            
        } while(! name.equals("Done"));
        
        for(int i = 0; i < list.size(); i++){ 
            System.out.println("Name = " + list.get(i).getName());
            System.out.println("Age = " + list.get(i).getAge());
        }
        System.out.println("Person with the youngest age is: " + findMin(list));
    }
    
    public static String findMin(ArrayList<Person> personList){
        /*
            go thru list item by item
                check if current item is less than lowest so far 
                if it is then update lowest            
        */
        if(personList.size() < 1) {
            return "ERROR! No people at this party!!";
        }
        
        String nameOfLowestPerson = personList.get(0).getName();
        int lowestAge  = personList.get(0).getAge(); // strore the lowest age found so far 
        
        for(int i = 1; i < personList.size(); i++){ 
            Person curPerson = personList.get(i);
            if(curPerson.getAge() < lowestAge) {
                lowestAge = curPerson.getAge();
                nameOfLowestPerson = curPerson.getName();
            }             
         }
        return nameOfLowestPerson;
    }
}
