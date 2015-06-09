/**
 * 
 */
package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

/**
 * The Class Image.
 *
 * @author Owenn
 */
public class Image extends BufferedImage{
	
	/** The name of the image. */
	private String name;
	
	/** The keywords describing the Image. */
	private ArrayList<String> keywords;
	
	/** The path of the Image. */
	private String path;
	
	/**
	 * Instantiates a new image.
	 *
	 * @param completeName the complete name of the file (ie path+name).
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Image(String completeName) throws IOException {
		super();
		File f = new File(completeName);
		
		if (f.isAbsolute()) {
			this.path = completeName.substring(0, completeName.lastIndexOf(File.separator));
			this.name = completeName.substring(completeName.lastIndexOf(File.separator) + 1);
		}
		else {
			throw new IOException("Path is absolute");
		}
	}
	
	/**
	 * Instantiates a new image.
	 *
	 * @param completeName the complete name of the file (ie path+name).
	 * @param keywords the keywords
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see Image.Image(String)
	 */
	public Image(String completeName, ArrayList<String> keywords) throws IOException {
		new Image(completeName);

		for (String keyword:keywords) {
			this.addTag(keyword);
		}
	}
	
	/**
	 * Adds the tag to the image. If the tag does not exists in the tag list, it is created.
	 *
	 * @param tag the tag
	 */
	public void addTag(String tag) {
		tagList.getInstance().addTag(this, tag);
	}
	
	/**
	 * Delete tag.
	 */
	public void deleteTag(String tag) {
		//TODO the removing
	}
	
	/**
	 * Alter.
	 */
	public void alter() {
		
	}
	
	/**
	 * Save.
	 */
	public void save() {
		
	}
}
