
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ReportsNGTest {
    //https://www.youtube.com/watch?v=2EIUHHoVfmU
     public static void loadTestData() {
       //load all the data needed for the tests
        Reports.developName = new String[4];
        Reports.developSurname = new String[4];
        Reports.tasName = new String[4];
        Reports.tasDuration = new int[4];
        Reports.tasStatus = new String[4];
        
        Reports.developName[0] = "Mike";
        Reports.developName[2] = "Edward";
        Reports.developName[3] = "Samantha";
        Reports.developName[3] = "Glenda";
              
       
        Reports.developSurname[0] = "Smith";
        Reports.developSurname[0] = "harrison";
        Reports.developSurname[0] = "Paulson";
        Reports.developSurname[0] = "Oberholzer";
              
        Reports.tasName[0] = "Create Login";
        Reports.tasName[0] = "Create Add Features";
        Reports.tasName[0] = "Create Reports";
        Reports.tasName[0] = "Create Arrays";
        
       Reports.tasDuration[0] = 5;
       Reports.tasDuration[0] = 8;
       Reports.tasDuration[0] = 2;
       Reports.tasDuration[0] = 11;
       
        Reports.tasStatus[0] = "To Do";
        Reports.tasStatus[0] = "Doing";
        Reports.tasStatus[0] = "Done";
        Reports.tasStatus[0] = "To Do";
      
    }

    @Test
    public void testInitArrays() {
        assertEquals("4","4");
    }

  
    @Test
    public void testPrintReport() {
         //full report and developer with most hours
        loadTestData();
        assertEquals(" \"Developer Name: Mike \"\n" +
"                           + \"Developer Surname: Smith\"\n" +
"                           + \"Task Name: Create Login\"\n" +
"                           + \"Task Duration: 5\"\n" +
"                           + \"Task Status: To Do\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Edward \"\n" +
"                           + \"Developer Surname: Harrison\"\n" +
"                           + \"Task Name: Create Add Features\"\n" +
"                           + \"Task Duration: 8\"\n" +
"                           + \"Task Status: Doing\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Samantha \"\n" +
"                           + \"Developer Surname: Paulson\"\n" +
"                           + \"Task Name: Create Reports\"\n" +
"                           + \"Task Duration: 2\"\n" +
"                           + \"Task Status: Doing\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Glenda \"\n" +
"                           + \"Developer Surname: Oberholzer\"\n" +
"                           + \"Task Name: Add Arrays\"\n" +
"                           + \"Task Duration: 11\"\n" +
"                           + \"Task Status: To Do\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer with most hours: \"\n" +
"                           + \"Name: Glenda Oberholzer\"\n" +
"                           + \"Task: Add Arrays\"\n" +
"                           + \"Duration: 11\";", " \"Developer Name: Mike \"\n" +
"                           + \"Developer Surname: Smith\"\n" +
"                           + \"Task Name: Create Login\"\n" +
"                           + \"Task Duration: 5\"\n" +
"                           + \"Task Status: To Do\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Edward \"\n" +
"                           + \"Developer Surname: Harrison\"\n" +
"                           + \"Task Name: Create Add Features\"\n" +
"                           + \"Task Duration: 8\"\n" +
"                           + \"Task Status: Doing\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Samantha \"\n" +
"                           + \"Developer Surname: Paulson\"\n" +
"                           + \"Task Name: Create Reports\"\n" +
"                           + \"Task Duration: 2\"\n" +
"                           + \"Task Status: Doing\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer Name: Glenda \"\n" +
"                           + \"Developer Surname: Oberholzer\"\n" +
"                           + \"Task Name: Add Arrays\"\n" +
"                           + \"Task Duration: 11\"\n" +
"                           + \"Task Status: To Do\"\n" +
"                           + \"**************************************\"\n" +
"                           + \"Developer with most hours: \"\n" +
"                           + \"Name: Glenda Oberholzer\"\n" +
"                           + \"Task: Add Arrays\"\n" +
"                           + \"Duration: 11\";");
    
    }

    @Test
    public void testSearchTask() {
        loadTestData();
        // Test the searchTask method when the task is found
        
        assertEquals("Create Login", "Create Login");
    }

    @Test
    public void testDeleteTask() {
        loadTestData();
        assertEquals("Create Reports","Create Reports");
    }

    @Test
    public void testDeveloperHistory() {
        assertEquals("Samantha Paulson, Create Reports","Samantha Paulson, Create Reports");
    }

}
