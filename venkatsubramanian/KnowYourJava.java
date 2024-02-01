package venkatsubramanian;

import java.util.Arrays;
import java.util.List;

public class KnowYourJava {
   static class Mistake1{
        public static void mistake(){
            int[] factor = new int[]{2};
            var numbers = List.of(1,2,3);

            var stream = numbers.stream()
                    .map(number -> number*factor[0]);

            factor[0] = 0;

            stream.forEach(System.out::print);



            //due to lazy evaluation line 10 executes after
            // terminal operation is performed at line no 15.
        }
    }

    static class Mistake2 {
       public static void mistake() {
           List<String> weekdays = Arrays.asList("Monday","Tuesday","Wednesday");
           try{
               weekdays.add("Thursday");
           }catch (Exception e){
               System.out.println("Exception occured!!! asList while being immutable doesn't allow add operation " +
                       "but allows set operation");
           }
           try{
               weekdays.set(2,"Thursday");
               System.out.println("Executed");
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

       }
    }
    public static void main(String[] args) {
        //Mistake1.mistake();
        Mistake2.mistake();

    }
}
