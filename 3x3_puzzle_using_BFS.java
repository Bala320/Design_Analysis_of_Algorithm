import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;


public class Main 
{
    
    Map<String,Integer> stateDepth = new HashMap<String, Integer>();    // relates each position to its predecessor
    
    Map<String,String> stateHistory = new HashMap<String,String>();      // HashMap is used to ignore repeated nodes
    
    Queue<String> BFSQueue = new LinkedList<String>();                   // Use of Queue Implemented using LinkedList for Storing All the Nodes in BFS.
    
    List<String> steps = new ArrayList<>();                             //to visualise all the steps of algorithm
    
    public static void main(String[] args) 
    {
        
        Main e = new Main();
        String str = e.generate();               
        System.out.println("\n19BCN7193- M. BALA SUBRAMANIYAN\n");
        System.out.println("In Matrix:");
        e.print(str);
        e.initialize(str);                                     
        System.out.println("--------------------------------->");
        while(!e.BFSQueue.isEmpty())
        {                           //BFS             
            String current = e.BFSQueue.remove();         
            e.move(current);                  
        }
        
        System.out.println("Error!, Couldn’t find Solution");    
    }
    
void initialize(String str)
{
    
    stateDepth.put(str, 0);
    BFSQueue.add(str);
    stateHistory.put(str, null);
}

void add(String old, String next)
{                                                       //add new nodes to tree
    
    if(!stateDepth.containsKey(next))
    {                   
        
        int newPosition = stateDepth.get(old) + 1;            
        stateDepth.put(next, newPosition);
        BFSQueue.add(next);
        stateHistory.put(next, old);
    } 
}

void check(String old, String next) 
{                                                                 //check completion
    
    add(old,next);  
    
    if(next.equals("123405678")) 
    {                                             //solution is found
        
        String solution = next;
        
        while (solution != null) 
        {                                       //get all the steps 
            steps.add(solution);
            solution = stateHistory.get(solution);
        }
        
        Collections.reverse(steps);
        
        for(int i = 0; i < steps.size(); i++)
        {                                                //print steps
            System.out.println("Step #"+i+":");
            print(steps.get(i));
        }
        
        System.out.println("Executed Successfully using BFS");
        System.exit(0);
    }
}

void move(String current){
    
    String next;
    int a = current.indexOf("0");             
    
    if(a>2)
    {                                   
        next = swap(a, a-3, current);          // Move the blank space up and add new state to queue
        check(current, next);                 
    }
    if(a<6)
    {                                    
        next = swap(a,a+3,current);             // Move the blank space down
        check(current, next);
    }
    if(a!=0 && a!=3 && a!=6)
    {                                        // Move the blank space left
        next = swap(a,a-1,current);
        check(current, next);
    }
    if(a!=2 && a!=5 && a!=8)
    {                   
        next = swap(a,a+1,current);             // Move the blank space right
        check(current, next);
    }
    }

void print(String s)
{                                           //print string as 3x3 matrix
    
    int x = 0;
    for(int i = 0; i<9; i++)
    {
        System.out.print(s.charAt(i)+"\t");
        x++;
        if(x % 3 == 0)
        {
            System.out.println("");
            System.out.println("");
        }
    }
    System.out.println();
}

String swap(int a, int b, String s)
{                                                  //move blank space to next position
    
    String r;
    char[] rarr = s.toCharArray();
    rarr[b]=s.charAt(a);
    rarr[a]=s.charAt(b);
    r = String.valueOf(rarr);
    return r;
}

String generate(){                              //generate random matrix by moving blank space to random positions 1000 times 
    
    String s="654102378";
   /* for(int i = 0; i<2; i++){
        
        int a = s.indexOf("0");
        Random R = new Random();
        int x = R.nextInt();
        
        switch(x%4){
            
            case 0: if (a>2)                       //if blank space isn't in first row
                        s=swap(a,a-3,s);
                    break;
            case 1: if (a<6)                        //if blank space isn't in last row
                        s=swap(a,a+3,s);
                    break;
            case 2: if (a!=0 && a!=3 && a!=6)       //if blank space isn't in first column
                        s=swap(a,a-1,s);
                    break;
            case 3: if (a!=2 && a!=5 && a!=8)       //if blank space isn't in last column
                        s=swap(a,a+1,s);
                    break;            
        }
    }*/
    return s;
}

}