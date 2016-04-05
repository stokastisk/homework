import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class letterGrades{
  public static void main (String[] args){
    int arrayParameter = 0;
    boolean loopingParameter = false;
    double[] gradeArray = null;
    DecimalFormat df = new DecimalFormat("#.00");
    Scanner input = new Scanner(System.in);
    while (!loopingParameter){
      try{
        System.out.println("Please enter your grades (separated by spaces and/or commas).");
        String inputLine = input.nextLine();
        StringTokenizer st = new StringTokenizer(inputLine, "%, *");
        gradeArray = new double[st.countTokens()];
        while (st.hasMoreTokens()){
          gradeArray[arrayParameter] = Double.parseDouble(st.nextToken());
          arrayParameter++;
        }
        for (double value : gradeArray){
          if (!(value >= 0 && value <= 100)){ // returns question mark if tokens were empty...already tried Double.isNaN() and Double.toString().trim().isEmpty()
            throw new java.util.InputMismatchException();
          }
        }
        loopingParameter = true;
      }
      catch (Exception e){
        System.err.println(e);
        System.out.println("You did not enter a valid set of grades. Each grade must be in valid decimal and between 0 and 100.\n");
        arrayParameter = 0;
      }
    }
    for (int i = 0; i < gradeArray.length; ++i){
      String numericIndicator = "";
      if ((i+1) % 10 == 1){
        numericIndicator = "st";
      }
      else if ((i+1) % 10 == 2){
        numericIndicator = "nd";
      }
      else if ((i+1) % 10 == 3){
        numericIndicator = "rd";
      }
      else{
        numericIndicator = "th";
      }
      System.out.println("Your " + (i+1) + numericIndicator + " grade was: " + df.format(gradeArray[i]) + "%");
    }
    System.out.println("Your grade average was: " + df.format(arrayAverage(gradeArray)) + "%\nYour letter grade was: " + returnGradeLetter(arrayAverage(gradeArray)));
  }
  public static double arrayAverage(double... vars){
    double sum = 0;
    for (int i = 0; i < vars.length; ++i){
      sum += vars[i];
    }
    return sum/vars.length;
  }
  public static char returnGradeLetter(double value){
    char gradeLetter = '\0';
    if (value >= 90){
      gradeLetter = 'A';
    }
    else if (value >= 80){
      gradeLetter = 'B';
    }
    else if (value >= 70){
      gradeLetter = 'C';
    }
    else if (value >= 60){
      gradeLetter = 'D';
    }
    else{
      gradeLetter = 'F';
    }
    return gradeLetter;
  }
}