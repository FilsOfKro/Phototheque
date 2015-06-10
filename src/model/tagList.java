/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

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
public final class tagList {
	/* L'utilisation du mot cl� volatile, en Java version 5 et sup�rieur, permet d'�viter 
	 * le cas o� "Singleton.instance" est non-nul, mais pas encore "r�ellement" instanci�.
	 */
    private static volatile tagList instance = null;
	private ArrayList<String> existingTags;
	private HashMap<String, ArrayList<Image>> link;
	private final File file = new File("data/tags.xml");
	
	/**
     * Constructeur de l'objet.
     */
    private tagList() {
        // La pr�sence d'un constructeur priv� supprime le constructeur public par d�faut.
        // De plus, seul le singleton peut s'instancier lui-m�me.
	
		
    }
	
    /**
     * M�thode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static tagList getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement v�rifi�" permet 
        //d'�viter un appel co�teux � synchronized, 
        //une fois que l'instanciation est faite.
        if (tagList.instance == null) {
           // Le mot-cl� synchronized sur ce bloc emp�che toute instanciation
           // multiple m�me par diff�rents "threads".
           // Il est TRES important.
           synchronized(tagList.class) {
             if (tagList.instance == null) {
               tagList.instance = new tagList();
             }
           }
        }
        return tagList.instance;
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
		//for ();
				
				import org.w3c.dom.Document;

				
	}

	public void deleteTag(String tag) {
		this.existingTags.remove(tag);
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