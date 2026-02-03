
/*
    Course: 33600
    Name : Dermot Hickey
    Email: hickey36@pnw.edu
    Assignment: Homework 1

*/
import java.util.*;
import java.lang.ProcessBuilder;
import java.io.IOException;
import java.lang.Process;
import java.time.Duration;
import java.util.Optional;
/**
 * A program to launch the default windows exe files
 */
public class Launcher{

    private final static Scanner scanner = new Scanner(System.in);
    private final static String[] cmds = 
    {
        "Quit",
        "Taskmgr.exe",
    
        "notepad.exe",
    
        "charmap.exe",
    
        "SnippingTool.exe",
    
        "winver.exe",
    
        "msinfo32.exe",
    
        "nslookup.exe",
    
        "cmd.exe"
    };

/**
 * Controls the text printed to the terminal
 * Uses a simple for loop to iterate over the options and if-else for edge cases
 * @return void
 */
    private static void promptUser()
    {
        System.out.println("Please make a choice from the following list.");

        for(int i = 0; i < cmds.length; i++)
            {
                if(i == 7 || i == 8)
                {
                    System.out.println(" *" + i + ": " + cmds[i]);
                }
                else
                {
                    System.out.println("  "+i+": "+ cmds[i]);
                }
                
            } 
    }
    
    /**
     * A method to handle user input
     * Uses simple scanner functions to parse from a string and verify a valid selection
     * 
     * @return user's selection as input
     */
    private static int getInput()
    {
        System.out.print("Enter your choice: ");
        int parsedInput;
        String userInput = scanner.nextLine();
        try
        {
            parsedInput = Integer.parseInt(userInput);
            if(parsedInput == 0)
            {
                return parsedInput;
            }
            if(parsedInput > 8 || parsedInput < 0)
            {
                return getInput();
            }
            else
            {
                return parsedInput;
            }
        }
        catch(NumberFormatException e)
        {
            //System.out.print("Enter your choice: ");
            return getInput();
        }
        
        
    }
    /**
     * Calls various methods for functionality, controls the looping logic
     * Prints the PID of every process created
     * Ends loop if input ==0
     * @param args
     */
    public static void main(String[] args) throws IOException , InterruptedException
    {
        int userInput; 
        do
        {
            promptUser();
            userInput = getInput();
            if(userInput != 0)
            {
            Process processStarted = startProcess(userInput);
            System.out.println("Started program "+userInput+ " with PID = "+processStarted.pid());
            //handles cases where the console needs to switch I/O
            if(userInput == 7 || userInput == 8)
            {
                System.out.println("Launcher waiting on program "+ userInput);
                processStarted.waitFor();
                 ProcessHandle.Info info  = processStarted.toHandle().info();
                Optional<Duration> cpuDuration = info.totalCpuDuration();
                if(cpuDuration.isPresent())
                {
                    System.out.print(("Program "+ userInput + " ran for " + cpuDuration.get().toMillis() + " cpu milliseconds"));
                }
                
                System.out.println(  "and exited with code "+processStarted.exitValue());
                
            }
            }
           
        } while(userInput != 0);
        
        
        /**
         * The sstartProcess method handles the processbuilder and acts appropriatley in the case of I/O inheritance
         * uses simple if else logic blocks
         * @returns Process
         */
    }
    private static Process startProcess(int userSelect) throws IOException , InterruptedException
    {
        String selection = cmds[userSelect];
        ProcessBuilder pb = new ProcessBuilder(selection);
        if(userSelect == 7 || userSelect == 8)
           {
               pb.inheritIO();
               Process p = pb.start();
               return p;
           }
        else
           {
               Process p = pb.start();
               return p;
           } 
        
    }

}
