import java.io.*;

public class TaskPerform6 {
  private static String strC_UserName, strC_PassWord;

  public static void main(String[] args) throws IOException {
    final String FILENAME = "records.txt";

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader read = new BufferedReader(input);

    System.out.println("Select 2 Method: press 1 to register and press 2 to login ");
    System.out.print("Answer: ");
    String strAnswer = read.readLine();

    // if statement for register:
    if (strAnswer.equalsIgnoreCase("1")) {
      System.out.print("Enter Desire Username: ");
      strC_UserName = read.readLine();
      System.out.print("Enter Desire PassWord: ");
      strC_PassWord = read.readLine();
      try (BufferedWriter writter = new BufferedWriter(new FileWriter(FILENAME))) {
        writter.write(strC_UserName + "\n");
        writter.write(strC_PassWord + "\n");
        System.out.println("You are now Registered!");
      } catch (IOException e) {
        System.out.println("An error occured while to the file.");
        e.printStackTrace();
      }
    }

    if (strAnswer.equalsIgnoreCase("2")) {
      try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
        System.out.print("Enter Username: ");
        strC_UserName = read.readLine();
        System.out.print("Enter Password: ");
        strC_PassWord = read.readLine();

        String savedUsername = reader.readLine();
        String savedPassword = reader.readLine();

        if (strC_UserName.equalsIgnoreCase(savedUsername) && strC_PassWord.equalsIgnoreCase(savedPassword)) {
          System.out.println("Successfully Logged in! ");
        } else {
          System.out.println("Incorrect username or password");
        }

      } catch (IOException e) {
        System.out.println("An error occured while to the file.");
        e.printStackTrace();
      } //end of catch

    }
  }
}