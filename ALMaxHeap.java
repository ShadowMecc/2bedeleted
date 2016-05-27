/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALMaxHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALMaxHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
	String ans = "";
	for (int a: _heap)
	    ans += a + " ";
	return ans;
    }//O(n)-one loop



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    {
	return (_heap.size() == 0);
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMax() 
    {
	if (isEmpty())
	    return null;
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    { 
	if (isEmpty()){
	    _heap.add(addVal);
	    return;
	}
	int lastPos = _heap.size();
	int parent = (lastPos - 1)/2;
	_heap.add(addVal);
	while (lastPos != 0){
	    if (addVal < _heap.get(parent))
		break;
	    swap(lastPos,parent);
	    lastPos = parent;
	    parent = (parent - 1) / 2;
	}
    } //O(log(n)): The worst case scenario is when the newVal is the smallest value and has to travel all the way to the root. Therefore, the farthest distance it has to travel is height of the tree, which is log(total elements in the tree).



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMax() 
    {
	if (isEmpty())
	    return null;
        swap(0,_heap.size()-1);
	int save = _heap.remove(_heap.size()-1);
	int pos = 0;
	int maxPos = maxChildPos(pos);
	while (maxPos != -1 && _heap.get(maxPos) > _heap.get(pos)){
	    swap (pos, maxPos);
	    pos = maxPos;
	    maxPos = maxChildPos(pos);
	}
	return save;
    }//O(?)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int maxChildPos( int pos ) 
    {
	int leftPos = 2 * pos + 1;
	int rightPos = 2 * pos + 2;
	if (_heap.size()-1< leftPos)
	    return -1;
	if (_heap.size()-1< rightPos)
	    return leftPos;
	int max = maxOf(_heap.get(leftPos),_heap.get(rightPos));
	if (_heap.get(rightPos) == max)
	    return rightPos;
	return leftPos;
    }//O(1)



    //************ aux helper fxns ***************
    private Integer maxOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) > 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************

    public int size(){
	return _heap.size();
    }

    //main method for testing
    public static void main( String[] args ) {

	  ALMaxHeap pile = new ALMaxHeap();
	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);

    }//end main()

}//end class ALHeap
