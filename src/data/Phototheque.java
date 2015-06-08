/**
 * 
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Owenn
 *
 */
public class Phototheque {
	private HashMap<String, Image> content;
	
	public Phototheque() {
		
	}
	
	public void slide(HashMap<String, Image> content) {
		ArrayList<Image> list = new ArrayList<Image>();
		
		for (Image im:content.values()) { //We are only interested in the Image and we keep the order. Much lighter for Java
			list.add(im);
		}
		Browser browser = new Browser(list);
		
		while (browser.hasNext()) {
			browser.next();
		}
	}
	
	public void addImage(Image image) {
		//this.content.put(image.get, image);
		//TODO get path or get name?
	}
	
	public void deleteImage(String ref) {
		this.content.remove(ref);
	}
	
	public Image search(String keyword) {
		//TODO
		return null;
	}
	
	public HashMap<String, Image> orderByName() {
		//TODO
		return null;
		
	}
	
	public HashMap<String, Image> orderByDate() {
		//TODO
		return null;
	}

	//orderBy
	
}
