import java.util.*;

class Operators {
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DELETE = "/";    
}

public class CalculatorWithoutRegex {
    static void calculate(String s) {
        char[] c = s.toCharArray();
        
        List<String> o = new ArrayList<>();
        List<String> a0 = new ArrayList<>();
        List<String> a1 = new ArrayList<>();
        boolean gotChar = false;
    
        String a0asString = "";
        Float a0asFloat;
        String a1asString = "";
        Float a1asFloat;
        String operator = "";
        Float output = -1.0f;
        
        for (int i = 0; i < c.length; i++) {
            Character curr = Character.valueOf(c[i]);
            String c2s = String.valueOf(curr);
            
            boolean isOperator = c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/';
            boolean isSeparator = c[i] == '.';
            
            if ((Character.isDigit(curr) || isSeparator) && !gotChar) a0.add(c2s);
            else if (isOperator) {
              o.add(c2s); 
              gotChar = true; 
            }  
            else if ((Character.isDigit(curr) || isSeparator) && gotChar) a1.add(c2s);
        }

        for (String s0: a0) a0asString += s0;
        for (String s1: a1) a1asString += s1;

        if (o.size() == 0) throw new IllegalArgumentException("Missing operator.");
        else operator = o.get(0);

        if (operator.isEmpty()) throw new IllegalArgumentException("Missing operator.");
        if (a0asString.isEmpty() || a1asString.isEmpty()) throw new NumberFormatException("Missing addend.");

        a0asFloat = Float.parseFloat(a0asString);
        a1asFloat = Float.parseFloat(a1asString);
        
        switch(operator) {
          case Operators.ADD:
            output = a0asFloat + a1asFloat;
            break;
          case Operators.SUBTRACT:
            output = a0asFloat - a1asFloat;
            break;
          case Operators.MULTIPLY:
            output = a0asFloat * a1asFloat;
            break;
          case Operators.DELETE:
            if (a1asFloat.intValue() == 0) throw new IllegalArgumentException("You can not divide by zero.");
            else output = a0asFloat / a1asFloat;
            break;
        }
        
        System.out.println("Output: " + output);
    }
    
    public static void main(String args[]) {
      // Scanner scanner = new Scanner(System.in);
      String expression = "**.34"; // scanner.nextLine();

      CalculatorWithoutRegex.calculate(expression);
    }
}
