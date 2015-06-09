/**
 * 
 */
package model;

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

	public Image next() {
		this.current++;
		return this.list.get(current);
	}

	public void previous() {
		this.current--;
	}
	
	public boolean hasNext() {
		return this.list.iterator().hasNext();
	}

}
