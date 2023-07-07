
import javax.swing.JOptionPane;

public class Reports {
          //report class that contains variables and methods for showReport
         //Represents size of all arrays
    public static int numDevelopers; 
    public static String[] developName;
    public static String[] developSurname;
    public static String[] tasName;
    public static int[] tasDuration;
    public static String[] tasStatus;

    
        public static void showReportMenu() {
        //menu to be displayed when option 2 is selected
        int option;
        do{
            //https://stackoverflow.com/questions/2660110/what-does-do-do-here-java
            //do loops once
             //https://www.javatpoint.com/java-integer-parseint-method
                    option = Integer.parseInt(JOptionPane.showInputDialog(null, "Select function by entering: "
                 + "\n1. Load developer details "
                 + "\n2. Show report "
                 + "\n3. Search task"
                 + "\n4. Delete task"
                 + "\n5. Developer history "
                 + "\n6. Back to main menu"));
            //https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example
            switch (option) {
                case 1:
                    initArrays();
                    loadDeveloperDetails();
                    break;
                    //break statement used to terminate the loop and move on to the next statement. avoids an infinite loop
                    //https://www.programiz.com/java-programming/break-statement#:~:text=The%20break%20statement%20in%20Java,...else%20Statement).
                case 2:
                    printReport();
                    break;
                case 3:
                    searchTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                   developerHistory();
                   break;
                case 6:
                    backToMainMenu();
                    //option 6 takes the user back to the main menu
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    //message displayed when an invalid number has been entered(number out of the 1-6 range)
                    break;
            }
        } while (option != 6);
        //while loop because we dont know how many times the user will need to add new tasks and be taken back to the menu.
        //https://stackoverflow.com/questions/7951690/how-do-i-exit-a-while-loop-in-java
        }
         public static void initArrays() {
             //initArrays stores the information of all the developers in an array
        numDevelopers = Integer.parseInt(JOptionPane.showInputDialog("Enter number of developers: "));
        developName = new String[numDevelopers];
        developSurname = new String[numDevelopers];
        tasName = new String[numDevelopers];
        tasDuration = new int[numDevelopers];
        tasStatus = new String[numDevelopers];
    }
          
    public static void loadDeveloperDetails() {
        // loadDeveloperDetails loads data into arrays
        for (int index = 0; index < numDevelopers; index++) {
            developName[index] = JOptionPane.showInputDialog(null, "Enter developer name " + (index + 1) + " of " + numDevelopers + ":");
            developSurname[index] = JOptionPane.showInputDialog(null, "Enter developer surname " + (index + 1) + " of " + numDevelopers + ":");
            tasName[index] = JOptionPane.showInputDialog(null, "Enter task name " + (index + 1) + " of " + numDevelopers + ":");
            tasDuration[index] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter task duration " + (index + 1) + " of " + numDevelopers + ":"));
            tasStatus[index] = (String) JOptionPane.showInputDialog(null, "Select Task Status " + (index + 1) + " of " + numDevelopers + ":" , "Task Status", JOptionPane.QUESTION_MESSAGE, null, new String[]{"To Do", "Doing", "Done"}, "To Do");
        }
    }
    
    public static void printReport() {
        // Print full report for all the developers and displays the developer with the most hours
           String output = "Report summary:\n";
    int highestIndex = -1;
    int mostHours = tasDuration[0];
     //prints full task report
    for (int index = 0; index < numDevelopers; index++) {
        output += "\nDeveloper Name: " + developName[index];
        output += "\nDeveloper Surname: " + developSurname[index];
        output += "\nTask Name: " + tasName[index];
        output += "\nTask Duration: " + tasDuration[index];
        output += "\nTask Status: " + tasStatus[index];
        output += "\n**************************************";
//looks for developer with most hours
        if (tasDuration[index] > mostHours) {
            mostHours = tasDuration[index];
            highestIndex = index;
        
    }
    }
    //displays task report
    JOptionPane.showMessageDialog(null, output);
    
    if (highestIndex != -1) {
        //displays developer with most hours
        JOptionPane.showMessageDialog(null, "Developer with most hours:\n"
                + "Name: " + developName[highestIndex] + " " + developSurname[highestIndex] + "\n"
                + "Task: " + tasName[highestIndex] + "\n"
                + "Duration: " + tasDuration[highestIndex]);
    
    }
    }
      
    public static void searchTask() {
        //https://stackoverflow.com/questions/12496038/searching-in-a-arraylist-with-custom-objects-for-certain-strings
        // Search for a task by name and displays the task name, developer and task status
        String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search for:");
        boolean found = false;
        //loops until it finds the task
        for (int index = 0; index < numDevelopers; index++) {
            if (tasName[index].equalsIgnoreCase(searchTaskName)) {
                //message to be displayed if task has been found
                JOptionPane.showMessageDialog(null, "Task found:\n"
                        + "Task Name: " + tasName[index] + "\n"
                        + "Developer: " + developName[index] + " " + developSurname[index] + "\n"
                        + "Task Status: " + tasStatus[index]);
                found = true;
                break;
            }
        }

        if (!found) {
            //message to be displayed if task isnt found
            JOptionPane.showMessageDialog(null, "Task not found");
          
                }
    }
     public static void deleteTask(){
         //https://stackoverflow.com/questions/5767325/how-can-i-remove-a-specific-item-from-an-array-in-javascript
         //deletes a task using the task name
        String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");

    int deleteIndex = -1;
    for (int index = 0; index < numDevelopers; index++) {
        //ignores the 
        if (tasName[index].equalsIgnoreCase(deleteTaskName)) {
            deleteIndex = index;
            break;
        }
    }

    if (deleteIndex != -1) {
        // Delete the task by decrementing each index by 1
        developName[deleteIndex] = developName[numDevelopers - 1];
        developSurname[deleteIndex] = developSurname[numDevelopers - 1];
        tasName[deleteIndex] = tasName[numDevelopers - 1];
        tasDuration[deleteIndex] = tasDuration[numDevelopers - 1];
        tasStatus[deleteIndex] = tasStatus[numDevelopers - 1];

        // Decrement the number of developers
        numDevelopers--;

        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
    } else {
        //message to be displayed if task wasnt found
        JOptionPane.showMessageDialog(null, "Task not found.");
         }
              }
     // Search for tasks by developer
    public static void developerHistory() {
        //displays all the tasks assigned to a specific developer
        String searchDeveloper = JOptionPane.showInputDialog("Enter the developer name to search for tasks:");
        boolean found = false;
        String output = "Tasks assigned to developer " + searchDeveloper + ":\n";
        
        for (int index = 0; index < numDevelopers; index++) {
            if (developName[index].equalsIgnoreCase(searchDeveloper)) {
                output += "\nTask Name: " + tasName[index];
                output += "\nTask Status: " + tasStatus[index];
                output += "\n-----------------------";
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, output);
        } else {
            //message to be displayed if no tasks were found
            JOptionPane.showMessageDialog(null, "No tasks found for developer " + searchDeveloper);
        }
    }
     public static void backToMainMenu(){
         //goes back to main menu, menuOptions
        Task.menuOptions();
    }
    }
    

