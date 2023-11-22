import java.util.*;
import java.util.regex.*;

public class Calculator {
    static void calculate(String str) {
        Pattern pattern =
          Pattern.compile(
            "(\\-*\\d+\\.?\\d*)(\\s*)(\\+|\\-|\\*|\\/)(\\s*)(\\-*\\d+\\.?\\d*)"
        );
        Matcher matcher = pattern.matcher(str);
        List<Float> numbers = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        Float output = -1.00f;
        
        while (matcher.find()) {
            numbers.add(Float.parseFloat(matcher.group(1)));
            operator.add(matcher.group(3));
            numbers.add(Float.parseFloat(matcher.group(5)));
        }

        if (operator.size() == 0) {
            System.err.println("Illegal operator.");
            return;
        }
        
        if (numbers.get(0).intValue() < 0 || numbers.get(1).intValue() < 0) {
            System.err.println("Addends must be positive.");
            return;
        }
        
        if (numbers.size() != 2) {
            System.err.println("Missing addend.");
            return;
        }
        
        switch(operator.get(0)) {
            case "+":
              output = numbers.get(0) + numbers.get(1);    
              break;
            case "-":
              output = numbers.get(0) - numbers.get(1);    
              break;
            case "*":
              output = numbers.get(0) * numbers.get(1);    
              break;
            case "/":
              if (numbers.get(1).intValue() == 0) {
                throw new IllegalArgumentException("Illegal divisor:\t" + numbers.get(1));
              }                
              else {
                output = numbers.get(0) / numbers.get(1);    
              }
              
              break;  
              
        }
        
        System.out.println("Output = " + output);
    }
    
    public static void main(String args[]) {
      Scanner scanner = new Scanner(System.in);
      String expression = scanner.nextLine();

      Calculator.calculate(expression);
    }
}
