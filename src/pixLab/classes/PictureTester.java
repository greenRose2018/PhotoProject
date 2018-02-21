package pixLab.classes;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testGengar()
  {
	  Picture beach = new Picture("CumberlandIsland.jpg");
	  beach.explore();
	  beach.gengarFilter(beach.getHeight() / 2, beach.getWidth() /2);
	  beach.explore();
  }
  
  public static void testMirrorPercentage()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrorPercentage();
	  beach.addMessage("Hello", 10, 10, Color.GREEN);
	  beach.explore();
  }
  
  public static void testGlitchFilter()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.glitchArt();
	  beach.explore();
  }
  
  public static void testColorRedAndBlue()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.colorRedAndBlue();
	  beach.randomColor();
	  beach.glitchArt();
	  beach.explore();
  }
  public static void testRandomColor()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.randomColor();
	  beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontal();
	  caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  public static void testMirrorAnything()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.mirrorAnything();
	  temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    
    swan.edgeDetection(10);
    swan.explore();
    Picture gengar = new Picture("gengar.png");
    gengar.edgeDetection(10);
    gengar.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
	//testGengar();
	//testGlitchFilter();
	//testColorRedAndBlue();
	testMirrorPercentage();
	//testRandomColor();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorAnything();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}