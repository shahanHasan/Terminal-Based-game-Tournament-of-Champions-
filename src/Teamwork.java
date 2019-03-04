package toc;


/**
 * Details of your team
 * 
 *@author Md Mohidul Hasan,wenda
 *@version 01.12.2018
 */
public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "hackslash";
        details[1] = "Hasan";
        details[2] = "Md Mohidul ";
        details[3] = "15071717";
        details[4] = "Wenda";
        details[5] = "Ruan";
        details[6] = "16063887";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
