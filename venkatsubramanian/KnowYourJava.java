package venkatsubramanian;

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
    public static void main(String[] args) {
        //Mistake1.mistake();

    }
}
