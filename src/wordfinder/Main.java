
package wordfinder;
public class Main {
    public static void main(String[] args) 
    {
            String name1 = "Imbibe";

        String name2 = "Lock";
        String name3 = "Taxation";
         
        System.out.println(name1 + Soundex.getGode(name1));
        System.out.println(name2);
        System.out.println(name3 + Soundex.getGode(name3));
        
    }
}
 