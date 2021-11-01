import java.util.*;

class graph<T>
{
    private Map<T, List<T>> m=new HashMap<>();
    
    public void addvert(T s)
    {
        m.put(s,new LinkedList<T>());
    }
    public void addedge(T src, T dest, boolean bidirec)
    {
        if(!m.containsKey(src))
        {
            addvert(src);
        }
        if(!m.containsKey(dest))
        {
            addvert(dest);
        }
        if(bidirec==true)
        {
            m.get(dest).add(src);
        }
    }
    
    public void countvert()
    {
        System.out.println("No. of Vertices: "+ m.keySet().size());
    }
     public void countedge(boolean bidirec)
     {
         int count=0;
         for(T v:m.keySet())
         {
             count=count+m.get(v).size();
         }
         if(bidirec==true)
         {
             count=count/2;
         }
         System.out.println("No. of edges: "+count);
     }
     
     public void containsvert(T s)
     {
         if(m.containsKey(s))
         {
             System.out.println("Graph contains vert "+s);
         }
         else   
         {
              System.out.println("Graph doesn't contains vert "+s);
         }
     }
     
     public void containsedge(T s, T d)
     {
         if(m.get(s).contains(d))
         {
             System.out.println("Graph contains edge between "+s+ " and "+d);
         }
         else
         {
             System.out.println("Graph does't contains edge between "+s+ " and "+d);
         }
     }
     
     public String toString()
     {
         StringBuilder b= new StringBuilder();
         
         for(T v:m.keySet())
         {
             b.append(v.toString()+" ");
             
             for(T w:m.get(v))
             {
                 b.append(w.toString()+ " ");
             }
             b.append("\n");
         }
         return(b.toString());
     }
    
}
public class Main
{
	public static void main(String[] args)
	{
	    graph g=new graph();
	    g.addedge(0, 1, true);   
        g.addedge(0, 4, true);   
        g.addedge(1, 2, true);   
        g.addedge(1, 3, false);   
        g.addedge(1, 4, true);   
        g.addedge(2, 3, true);   
        g.addedge(2, 4, true);   
        g.addedge(3, 0, true);   
        g.addedge(2, 0, true);
        
        System.out.println("Adjacency List for the graph:\n"+ g.toString());   

       g.countvert();   

       g.countedge(true);   

       g.containsedge(3, 4);   
       g.containsedge(2, 4);   

       g.containsvert(3);   
       g.containsvert(5);   
		//System.out.println("Hello World");
	}
}
