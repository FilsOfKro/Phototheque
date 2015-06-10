/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 * @author Owenn
 *
 */
// La classe utilise le patron de conception Singleton
// Le code ci-dessous est issu de Wikip�dia
// La classe est final, car un singleton n'est pas cens� avoir d'h�ritier.
public final class TagList {
	/* L'utilisation du mot cl� volatile, en Java version 5 et sup�rieur, permet d'�viter 
	 * le cas o� "Singleton.instance" est non-nul, mais pas encore "r�ellement" instanci�.
	 */
    private static volatile TagList instance = null;
	private ArrayList<String> existingTags;
	private HashMap<String, ArrayList<Image>> link;
	private final File file = new File("data/tags.xml");
	
	/**
     * Constructeur de l'objet.
     */
    private TagList() {
        // La pr�sence d'un constructeur priv� supprime le constructeur public par d�faut.
        // De plus, seul le singleton peut s'instancier lui-m�me.
    	try {
			XMLDecoder d = new XMLDecoder(
					new BufferedInputStream(
							new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	
    /**
     * M�thode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static TagList getInstance() {
    	//Le "Double-Checked Singleton"/"Singleton doublement v�rifi�" permet 
    	//d'�viter un appel co�teux � synchronized, 
    	//une fois que l'instanciation est faite.
    	if (TagList.instance == null) {
    		// Le mot-cl� synchronized sur ce bloc emp�che toute instanciation
    		// multiple m�me par diff�rents "threads".
    		// Il est TRES important.
    		synchronized(TagList.class) {
        		if (TagList.instance == null) {
        			TagList.instance = new TagList();
        		}
        	}
        }
        return TagList.instance;
    }

    private void createTag(String tag) {
		this.existingTags.add(tag);
	}
	
	public void addTag(Image caller, String tag) {
		if (!this.exists(tag)) {
			this.createTag(tag);
		}
		//Get the hashMap, and with the key, get the ArrayList corresponding to the tag, then add the Image to it.
		this.link.get(tag).add(caller);
		this.save();
	}
	
	private void save() {
		// TODO Auto-generated method stub
		XMLEncoder e;
		try {
			e = new XMLEncoder(
			        new BufferedOutputStream(
			            new FileOutputStream(file)));
			e.writeObject(this.link);
			e.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deleteTag(String tag) {
		this.link.remove(tag);
		this.existingTags.remove(tag);
		this.save();
	}
	
	public boolean exists(String tag) {
		return this.existingTags.contains(tag);
	}
	
	public HashMap<String, Image> getImages(String tag) {
		HashMap<String, Image> ret = new HashMap<String, Image>();
		Iterator tagIterator = this.existingTags.listIterator();

		return null;
	}
}