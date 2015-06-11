/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import model.Image;
import model.TagList;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Owenn
 *
 */
public class TagListTest {
	TagList tl = TagList.getInstance();
	static Image im1;
	
	@BeforeClass
	public static void init() throws IOException {
		im1 = new Image("D:\\data\\im1.jpg");
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("tag");
		im1 = new Image("D:\\data\\im2.jpg", ar);
	}
	
	
	/**
	 * Test method for {@link model.TagList#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		
		assertNotNull("Verify that if not instance exists, object is intanciated", tl);
		assertEquals("Verify that if we call method again, no instance is created", tl, TagList.getInstance());
	}

	/**
	 * Test method for {@link model.TagList#addTag(model.Image, java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testAddTag() {
		tl.addTag(im1, "tag1");
		assertTrue(tl.exists("tag1"));
	}

	/**
	 * Test method for {@link model.TagList#deleteTag(java.lang.String)}.
	 */
	@Test
	public void testDeleteTag() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.TagList#exists(java.lang.String)}.
	 * @throws IOException 
	 */
	@Test
	public void testExists(){
		assertTrue(tl.exists("tag1"));
	}

	/**
	 * Test method for {@link model.TagList#getImages(java.lang.String)}.
	 */
	@Test
	public void testGetImages() {
		fail("Not yet implemented");
	}

}
