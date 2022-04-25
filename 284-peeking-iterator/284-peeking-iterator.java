class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> itr = null;
    private Integer nextVal = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    
        itr = iterator;
        if(hasNext())
            nextVal = itr.next();
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextVal;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	
	public Integer next() {
	    Integer val = nextVal;
        if(itr.hasNext()){
            nextVal = itr.next();
        }else{
            nextVal = null;
        }
        return val;
	}
	
	
	public boolean hasNext() {
	    return nextVal != null || itr.hasNext();
	}
}