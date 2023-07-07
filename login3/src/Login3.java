
import javax.swing.JOptionPane;

public class Login3 {
    //decalre necessary variables 
    static String username;
    private static String password;
    private static String firstName;
    private static String lastName;

    public static void main(String[] args) {
        if (registerUser())
        {
              //method to execute register user
       
             if (loginUser()) 
             {
            
                //method to execute login user
                 Task.menuOptions();
                //main method to execute all the methods within the menu itself
                
            }
        }
    }

    public static boolean checkUserName(String username) {
        //https://stackoverflow.com/questions/65926273/how-to-set-a-character-limit-in-java
        //add the username requirements
        return username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        //add the password requirements 
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&()].*");
       //*\\d.* is a meta chatracter that matches any didgit from 0-9. useful in code that requires integers
       // https://stackoverflow.com/questions/47341745/java-password-checker-with-strings
       //https://stackoverflow.com/questions/12885821/checking-if-a-character-is-a-special-character-in-java
    }
    

    public static boolean registerUser() {
        //Ibironke, A. (2021). Java Code: Login System. [Source code]. GitHub. https://gist.github.com/oyinibosi/a7cbce720d925f2c3a3a9aa90d1bf317
        firstName = JOptionPane.showInputDialog(null, "Enter first name:");
         //prompt user to enter first name
        lastName = JOptionPane.showInputDialog(null, "Enter last name:");
          //prompt user to enter last name
        username = JOptionPane.showInputDialog(null, "Enter username:");
          //prompt user to enter username

        if (checkUserName(username)) {
            //https://stackoverflow.com/questions/36392749/if-statements-and-usernames-password
            //message to be displayed if username matches requirements 
            JOptionPane.showMessageDialog(null, "Username successfully captured");

        } else {
              //error message to be displayed if username doesnt meet requirements 
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }

        password = JOptionPane.showInputDialog(null, "Enter password:");

        if (checkPasswordComplexity(password)) {
            //https://java2blog.com/validate-password-java/ 
             //message to be displayed if password matches requirements 
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            return true;
        } else {
              //error message to be displayed if username doesnt meet the requirements 
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a lowercase letter, a number, and a special character.");
            return false;
        }
    }

    public static boolean loginUser() {
       //prompt user to confirm username and password. if they do not match then the code wont allow them to proceed further
        String enteredUsername = JOptionPane.showInputDialog(null, "Confirm username:");
        String enteredPassword = JOptionPane.showInputDialog(null, "Confirm password:");

        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            //message to be displayed if the login has been successful
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban" + " , " + firstName + " " + lastName + " ! ");
            return true;
        } else {
            //error message to be displayed if the login was unsuccessful
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
            return false;
        }
    }
}

class Task {
    //task class containing methods needed by the program 
    //declare the variables 
   //initialize the count to 0
    private static int taskCount = 0;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String CreateTaskID;
    private String taskStatus;
    private static double totalHours;

    public Task(String taskName, String taskDescription, String developerDetails, double taskDuration, String taskStatus) {
     
        this.taskName = taskName;
        this.taskNumber = taskCount++;
        //increment the task number by 1 for each new task added
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.CreateTaskID = CreateTaskID();
        this.taskStatus = taskStatus;

    }

    String CreateTaskID() {
        //method for creating the task ID
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        //https://stackoverflow.com/questions/42217815/extract-first-two-characters-of-a-string-in-java
        //uses first 2 letters of the task name and converts them to uppercase
        String lastThreeLetters = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        //https://stackoverflow.com/questions/15253406/get-the-last-three-chars-from-any-string-java
        //uses last 3 letters of the developer details and converts them to uppercase
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
        //the task number is automatically generated and incremented by 1 for each task starting from 0
    }

    public void PrintTaskDetails() {
        //method for displaying the task details in the order that they are entered 
        String message = "Task Status: " + taskStatus + "\n"
                       + "Developer Details: " + developerDetails + "\n"
                       + "Task Number: " + taskNumber + "\n"
                       + "Task Name: " + taskName + "\n"
                       + "Task Description: " + taskDescription + "\n"
                       + "Task ID: " + CreateTaskID + "\n"
                       + "Task Duration: " + taskDuration + " hours";
        JOptionPane.showMessageDialog(null, message);
        //JOptionPane to display all the details of the task entered by the user
    }

    public double getTaskDuration() {
        //method to get the task duration from the user. This method is defined in the public static void
        return taskDuration;
        }

    public String getTaskStatus() {
        //method to get the task status from the user. This method is defined in the public static void
        return taskStatus;
    }

    public static void menuOptions() {
        //menu options main method contains all the methods that need to be executed.
        int option;
        do {
            //do is a loop that only executes once. it is similar to a while loop
            //https://stackoverflow.com/questions/2660110/what-does-do-do-here-java
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Select function by entering: \n1. Add Tasks \n2. Show Report menu \n3. Quit"));
            //https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example
            //menu options that can utilized by entering 1, 2, or 3
            switch (option) {
                case 1:
                    addTasks();
                    break;
                    //break statement used to terminate the loop and move on to the next statement. avoids an infinite loop
                    //https://www.programiz.com/java-programming/break-statement#:~:text=The%20break%20statement%20in%20Java,...else%20Statement).
                case 2:
                    Reports.showReportMenu();
                    break;
                case 3:
                    quit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    //message displayed when an invalid number has been entered(number out of the 1-3 range)
                    break;
            }
        } while (option != 3);
        //while loop because we dont know how many times the user will need to add new tasks and be taken back to the menu. program will terminate after user enters the number 3
        //https://stackoverflow.com/questions/7951690/how-do-i-exit-a-while-loop-in-java
    }

    public static boolean checkTaskDescription(String description){
        //https://stackoverflow.com/questions/65926273/how-to-set-a-character-limit-in-java
        //statement to check how many characters are in the description
            return description.length() <= 50;
        
    }

  public static void addTasks() {
      //https://www.javatpoint.com/java-integer-parseint-method
    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
    Task[] tasks = new Task[numTasks];
//https://stackoverflow.com/questions/31439524/declare-an-array-in-java-without-size
//this will make the option 1 loop for the amount of tasks that user entered 
    for (int i = 0; i < numTasks; i++) {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        
        while (!checkTaskDescription(taskDescription)) {
            //error message to be displayed if description exceeds 50 characters
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            //user can enter task descriprion again making the application more forgiving
            taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        }
        
        String developerDetails = JOptionPane.showInputDialog("Enter Developer Details:");
        double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
         //https://www.delftstack.com/howto/java/java-drop-down-menu/
         //this form of JOptionPane displays a dropdown menu displaying to do, doing, done
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");
        
        Task newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        tasks[i] = newTask;
        //this displays the full details of the task after it is entered
        newTask.PrintTaskDetails();
        totalHours += taskDuration;
        //calculates total number of hours
    }
    

    JOptionPane.showMessageDialog(null, "Total number of hours: " + totalHours);
}

    
    public static void quit() {
        //message to be displayed when option 3 is selected. Application will terminate once option 3 is selected.
        JOptionPane.showMessageDialog(null, "Goodbye! :)" );
        System.exit(0);
        //https://linuxhint.com/end-java-program/#:~:text=You%20can%20end%20a%20Java,terminates%20the%20currently%20running%20JVM.&text=Here%2C%20the%20System.,will%20terminate%20without%20any%20error.
        //exits the application
    }
}

 
