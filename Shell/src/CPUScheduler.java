import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Process 
{
	   int ProcessId;
		int ArrivalTime;
		int BurstLength;
		
	   Process(){
		   this.ProcessId = 0;
		   this.ArrivalTime = 0;
		   this.BurstLength = 0;
	   }
	   Process(int ProcessId, int ArrivalTime, int BurstLength)
	   {
		   this.ProcessId = ProcessId;
		   this.ArrivalTime = ArrivalTime;
		   this.BurstLength = BurstLength;
	   }
	
	   public int GetProcessId() {
		   return ProcessId;
	   }
	   
	   public int GetArrivalTime() {
		   return ArrivalTime;
	   }
	   public int GetBurstLength() {
		   return BurstLength;
	   }
	   
	   public void SetProcessId(int processId) {
		   this.ProcessId = processId;
	   }
	   
	   public void SetArrivalTime(int arrivalTime) {
		   this.ArrivalTime = arrivalTime;
	   }
	   
	   public void SetBurstLength(int burstLength) {
		   this.BurstLength = burstLength;
	   }
	   
}

class Scheduler
{
	
	public static void FIFOQueueArrange(List<Process> processes) 
	{
		int time = 0;
		
		int totalNumberofProcesses = processes.size();
		int allProcessCompleteCounter = 0;
		int burstTime[] = new int[totalNumberofProcesses]; 
	    boolean check = false;
	    int shortestArrivalTime = 0;
       for (int i = 0; i < totalNumberofProcesses; i++) 
       {
    	   burstTime[i] = processes.get(i).BurstLength; 
       }
       
       while(allProcessCompleteCounter != totalNumberofProcesses)
       {
    	   for (int j = 0; j < totalNumberofProcesses; j++)  
           { 
    		   if ((processes.get(j).ArrivalTime <= time) && burstTime[j] > 0)
               { 
    			   shortestArrivalTime = j;
    			   check = true;
               }
           }
    	   
    	   if (check == false) 
    	   { 
              	System.out.println(time +"     "+ shortestArrivalTime);
              	time++; 
                  
                continue; 
           } 
    	   
    	   while(burstTime[shortestArrivalTime] != 0) 
    	   {
    		   burstTime[shortestArrivalTime]--; 
               
               System.out.println(time +"     "+ processes.get(shortestArrivalTime).ProcessId);
               
               time++;
               
               if (burstTime[shortestArrivalTime] == 0) { 
            	      
            	   allProcessCompleteCounter++; 
                   check = false; 
               } 
    	   }
    	   
       }
		
	}
	
   public static void FIFOQueue(List<Process> processes) 
   {
	   
	   System.out.println("Time " +" -   "+ " Process ");  
	   
	   FIFOQueueArrange(processes);
  
   }
 
   
   public static void SRJFQueue(List<Process> processes) 
   {
	   
	   int totalNumberofProcesses = processes.size();
	   int runtime[] = new int[totalNumberofProcesses]; 
       
       for (int i = 0; i < totalNumberofProcesses; i++) 
    	   runtime[i] = processes.get(i).BurstLength; 
      
       int allProcessCompleteCounter = 0; 
       int time = 0; 
       int processWithMinimumRemainingTime = Integer.MAX_VALUE; 
       int shortest = 0;
       boolean check = false; 
      
       while (allProcessCompleteCounter != totalNumberofProcesses)
       { 
           for (int j = 0; j < totalNumberofProcesses; j++)  
           { 
               if ((processes.get(j).ArrivalTime <= time) && (runtime[j] < processWithMinimumRemainingTime) && runtime[j] > 0)
                  { 
            	   processWithMinimumRemainingTime = runtime[j]; 
                   shortest = j; 
                   check = true; 
               } 
           } 
      
           if (check == false) { 
           	System.out.println(time +"     "+ shortest);
           	time++; 
               
               continue; 
           } 
      
           runtime[shortest]--; 
           
           System.out.println(time +"     "+ processes.get(shortest).ProcessId);
          
           processWithMinimumRemainingTime = runtime[shortest]; 
           if (processWithMinimumRemainingTime == 0) 
        	   processWithMinimumRemainingTime = Integer.MAX_VALUE; 
     
           if (runtime[shortest] == 0) { 
      
        	   allProcessCompleteCounter++; 
               check = false; 
           } 
           time++; 
       }  
	 }
   }




public class CPUScheduler 
{
  public static boolean CheckUniqueProcessId(int processId , List<Process> list) 
  {
    boolean isUnique = true;
	for(int i = 0; i < list.size(); i++) 
	{
		if(list.get(i).ProcessId == processId) 
		{
			isUnique = false;
			break;
		}
	}
	return isUnique;
  }
  
  public static Process AskForInput() {
	  Scanner input = new Scanner(System.in);
	  Process p = new Process();
	   System.out.print("ENTER PROCESS ID (-1 TO END: )");
	   int processId = input.nextInt();
	   p.SetProcessId(processId);
	   if(processId != -1) 
	   {
		 
		   System.out.print("ENTER PROCESS ARRIVAL TIME: ");
		   int arrivalTime = input.nextInt();
		   p.SetArrivalTime(arrivalTime);
		   System.out.print("ENTER PROCESS BURST TIME: ");
		  int BurstTime =  input.nextInt();
		  p.SetBurstLength(BurstTime);
	   }
	  
	  return p;
  }
    
   public static void main(String[] args)
   {
	   List<Process> processes = new ArrayList<Process>();
	   Scheduler s = new Scheduler();
	   boolean isRunning = true;
	  
	   Scanner input = new Scanner(System.in);
	   
	   while(isRunning) 
	   {
		  Process p =  AskForInput();
		  if(p.ProcessId != -1 ) 
		  {
			  if(CheckUniqueProcessId(p.ProcessId, processes))
			  {
				  processes.add(p);
			  }
			  else
			  {
				  System.out.println("The process Id has to be unique. Please try unique process Id.");
					 continue;
			  }
		  }
		  else 
		  {
			  
			  isRunning = false;
		  }
		 
	   }
	  
	   System.out.print("SELECT ALGORITHM: 1 - FCFS, 2 - SRJF: ");
	   int algorithm = input.nextInt();
	   
	   switch(algorithm) 
	   {
	   case 1 :
		   s.FIFOQueue(processes);
		   break;
	   
	   case 2:
		  s.SRJFQueue(processes);
		   break;
	   
	   } 
   }
}



