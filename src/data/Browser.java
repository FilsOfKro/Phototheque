/**
 * 
 */
package data;

import java.util.ArrayList;

/**
 * @author Owenn
 *
 */
public class Browser {
	private ArrayList<Image> list;
	private int current;

	public Browser(ArrayList<Image> list) {
		this.list = list;
	}

	public void next() {
		this.current++;
	}

	public void previous() {
		this.current--;
	}
	
	public boolean hasNext() {
		return this.list.iterator().hasNext();
	}

}
