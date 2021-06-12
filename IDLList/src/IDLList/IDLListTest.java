package IDLList;

public class IDLListTest {

	

	public static void main(String[] args) {
		
		IDLList<Integer> IDLLIST= new IDLList<Integer>();
		
		System.out.println("Below, we run some tests.");
		System.out.println("");
		
		IDLLIST.add(1);
        System.out.println("The first element in the list is: " + IDLLIST.toString());
        System.out.println("");
        
        IDLLIST.add(0,0);
        System.out.println("After 0 is added at the head, the list is: " + IDLLIST.toString());
        System.out.println("");
        
        IDLLIST.add(1,1);
        System.out.println("After adding 1 at index 1, the list is: " + IDLLIST.toString());
        System.out.println("");
        
        IDLLIST.append(3);
        System.out.println("After 3 is appended to the list, the list is: " + IDLLIST.toString());
        System.out.println("");
        
        System.out.println("Current list is: " + IDLLIST.toString());
        System.out.println("Get element at position 1 in list: " + IDLLIST.get(1));
        System.out.println("");
        
        System.out.println("Current list is: " + IDLLIST.toString());
        System.out.println("Get head object in the list: " + IDLLIST.getHead());
        System.out.println("");
        
        System.out.println("Current list is: " + IDLLIST.toString());
        System.out.println("Get tail object in the list: " + IDLLIST.getLast());
        System.out.println("Size of the current list is: " + IDLLIST.size());
        System.out.println("");
        
        System.out.println("Current list is: " + IDLLIST.toString());
        System.out.println("Removed Head is: " + IDLLIST.remove());
        System.out.println("After removing, the current list is: " + IDLLIST.toString());
        System.out.println("");
        
        System.out.println("Current list is: " + IDLLIST.toString());
        System.out.println("Removed Tail is: " + IDLLIST.removeLast());
        System.out.println("After removing, the current list is: " + IDLLIST.toString());
        System.out.println("");
        
        IDLLIST.append(4);
        IDLLIST.add(2, 4);
        System.out.println("Current list is: " + IDLLIST.toString());
        IDLLIST.remove(4);
        System.out.println("Current list after removing first occurrence of 4 is: "+ IDLLIST.toString());
    }	
}


