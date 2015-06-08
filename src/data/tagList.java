/**
 * 
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Owenn
 *
 */
public class tagList {
	private static ArrayList<String> existingTags;
	private static HashMap<String, ArrayList<Image>> link;
	
	public static void createTag(String tag) {
		existingTags.add(tag);
	}
	
	public void deleteTag(String tag) {
		this.existingTags.remove(tag);
	}
	
	public static boolean exists(String tag) {
		return existingTags.contains(tag);
	}
	
	public HashMap<String, Image> getImages(String tag) {
		HashMap<String, Image> ret = new HashMap<String, Image>();
		Iterator tagIterator = this.existingTags.listIterator();

		
		return null;
	}
}
