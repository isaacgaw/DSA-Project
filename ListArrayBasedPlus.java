public class ListArrayBasedPlus<T> extends ListArrayBased<T> {

	
	public void reverse()
	{
		
		Object temp = null;
		Object temp1 = null;
		for (int x = (super.items.length - 1), y = 0; y < x; x--, y++){
			temp = items[x];
			temp1 = items[y];
			super.items[x] = temp1;
			super.items[y] = temp;
		}
	}
	
	public String toString()
	{
		String lists = "";
    	for (int x = 0; x < super.items.length; x++) {
    		if (super.items[x] != null)
    			lists += super.items[x] + " ";
    	}
    	return lists ;
	}
	
	public void resize() 
	{
		Object []sizing = new Object[super.items.length + 1];
			for(int x = 0; x < super.items.length; x++) {
				sizing[x] = super.items[x];
			}
			super.items = sizing;
	}
	public void add(int index, Object item) throws  ListIndexOutOfBoundsException
	{
		if (super.numItems == super.items.length)
		{
			resize();
		}
		super.add(index, item);
	}
}
