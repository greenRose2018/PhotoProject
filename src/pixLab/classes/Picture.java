package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////Data members
  private BufferedImage bufferedImage;
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for(int col = 0; col < pixels[0].length; col++)
	  {
		  for (int row = 0; row < height/2; row++)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height -1 - row][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorAnything()
  {
	  int mirrorPoint = 270;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int count = 0;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 88; row < 160; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 13; col < mirrorPoint; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row]                       
	                         [mirrorPoint - col + mirrorPoint];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
  }
 
  public void gengarFilter(int startRow, int startCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Picture gengar = new Picture("gengar.png");
	  Pixel [][] toPixels = this.getPixels2D();
	  Pixel [][] fromPixels = gengar.getPixels2D();
	  
	  int fromRow = 0;
	  for(int toRow = startRow; toRow < toPixels.length && fromRow < fromPixels.length; toRow++)
	  {
		  int fromCol = 0;
		  for (int toCol = 0; toCol < toPixels[0].length && fromCol < fromPixels[0].length; toCol++)
		  {
			  fromPixel = fromPixels[fromRow][fromCol];
			  toPixel = toPixels[toRow][toCol];
			  
			  if(!fromPixel.isTransparent())
			  {
				  toPixel.setRed(fromPixel.getRed());
				  toPixel.setBlue(fromPixel.getBlue());
				  toPixel.setGreen(fromPixel.getGreen());
			  }
			  fromCol++;
		  }
		  fromRow++;
	  }
  }
  
  public void bobRossFilter(int startRow, int startCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Picture bob = new Picture("BobRoss.png");
	  Pixel [][] toPixels = this.getPixels2D();
	  Pixel [][] fromPixels = bob.getPixels2D();
	  
	  int fromRow = 0;
	  for(int toRow = startRow; toRow < toPixels.length && fromRow < fromPixels.length; toRow++)
	  {
		  int fromCol = 0;
		  for (int toCol = 0; toCol < toPixels[0].length && fromCol < fromPixels[0].length; toCol++)
		  {
			  fromPixel = fromPixels[fromRow][fromCol];
			  toPixel = toPixels[toRow][toCol];
			  
			  if(!fromPixel.isTransparent())
			  {
				  if(toPixel.getGreen() <= 215 && toPixel.getBlue() < 80)
				  {
					  toPixel.setRed(fromPixel.getRed());
					  toPixel.setBlue(fromPixel.getBlue());
					  toPixel.setGreen(fromPixel.getGreen());
				  }
				  
			  }
			  fromCol++;
		  }
		  fromRow++;
	  }
  }
  
 
  public void glitchFilter()
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel midPixel = null;
	  Pixel endPixel = rightPixel;
	  Pixel [][] pixels = this.getPixels2D();
	  double percentage = .2;
	  int shift = (int)(percentage * pixels[0].length);
	  int width = pixels[0].length;
	  
	  for(int rows = 0; rows < pixels.length;rows++)
	  {
		  for(int cols = 0; cols < pixels[0].length; cols++)
		  {
			  leftPixel = pixels[rows][cols];
			  rightPixel = pixels[rows][(width - shift + cols ) % width];
			  midPixel = pixels[rows][(cols + shift) % width];
			  endPixel = pixels[rows][(width - shift + cols - 1) % (width)];
			  
			  Color leftColor = leftPixel.getColor();
			  Color rightColor = rightPixel.getColor();
			  Color midColor = midPixel.getColor();
			  Color endColor = endPixel.getColor();
			  
			  leftPixel.setColor(rightColor);
			  rightPixel.setColor(midColor);
			  midPixel.setColor(leftColor);
			  endPixel.setColor(endColor);
		  }
	  }
  }
  
  public void glitchArt()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  int shiftAmount = (int) (.2 * pixels[0].length);
	  int width = pixels[0].length;
	  
	  for (int row = 0 ; row < pixels.length; row++)
	  {
		  Color [] currentColor = new Color[pixels[0].length];
		  
		  for(int col = 0; col < pixels[row].length; col++)
		  {
			currentColor[col] = pixels[row][col].getColor();  
		  }
		  
		  for (int col = 0; col < pixels[0].length; col++)
		  {
			  pixels[row][col].setColor(currentColor[(col + shiftAmount) % width]);
		  }
	  }
  }
  
  public void mirrorPercentage()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int width = (int) (pixels[0].length * .8) ;
	  int count = 21;
	  
	  for(int row = 0; row < 21; row++)
	  {
		  for (int col = 0; col < width + 1; col++ )
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[count - row + count][col];
			  bottomPixel.setColor(topPixel.getColor());
			  
		  }
	  }
  }
  
  public void colorRedAndBlue()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel redPixel = null;
	  Pixel bluePixel = null;
	  Pixel redPixelSec = null;
	  Pixel bluePixelSec = null;
	  
	  int colorRed = 0;
	  int colorBlue = 0;
	  for (int row = 50 ; row < 171; row++)
	  {
		  for (int col = 50; col < 171; col++)
		  {
			  redPixel = pixels[row][col];
			  bluePixel = pixels[row][col];
			  colorRed = redPixel.getRed();
			  colorBlue = bluePixel.getBlue();
			  
			  redPixelSec = pixels[row + 150][col+150];
			  bluePixelSec = pixels[row + 150][col+150];
			  redPixelSec.setRed(colorRed);
			  bluePixelSec.setBlue(colorBlue);
		  }
	  }
  }
  
  public void randomColor()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel thirdRPixel = null;
	  Pixel thirdBPixel = null;
	  Pixel fourthRPixel = null;
	  Pixel fourthBPixel = null;
	  Pixel secondRPixel = null;
	  Pixel secondBPixel = null;
	  
	  int red = (int) (Math.random() * 256);
	  int blue = (int) (Math.random() * 256);
	  int green = (int) (Math.random() * 256);
	  for(int row = 100; row< 150; row++)
	  {
		  for(int col=0; col< 50;col++)
		  {
			  secondRPixel = pixels[row][col];
			  secondBPixel = pixels[row][col];
			  thirdRPixel = pixels[row + 150][col+150];
			  thirdBPixel = pixels[row + 150][col+150];
			  fourthRPixel = pixels[row + 50][col+50];
			  fourthBPixel = pixels[row + 50][col+50];
			  
			  secondRPixel.setBlue(blue);
			  secondBPixel.setGreen(green);
			  thirdRPixel.setRed(red);
			  thirdBPixel.setBlue(blue);
			  fourthRPixel.setRed(red);
			  fourthBPixel.setGreen(green);
		  }
	  }
  }
  
  public void addMessage(String message, int xPos, int yPos, Color name)
  {
    // get a graphics context to use to draw on the buffered image
    Graphics2D graphics2d = getBufferedImage().createGraphics();
    
    Color[] colors = {Color.black, Color.blue, Color.cyan,Color.darkGray, Color.gray,
    		Color.green, Color.lightGray, Color.magenta,Color.orange, Color.pink,Color.red, Color.white, Color.yellow};
    
    Color color = name;
    
    for(int i = 0; i < colors.length; i++)
    {
	    if(colors[i]==color )
	    {
	    		graphics2d.setPaint(name);
	    		i+= 13;
	    }
	    else
	    {
	    		graphics2d.setPaint(Color.white);
	    }
	    
    }
    // set the font to Helvetica bold style and size 16
    graphics2d.setFont(new Font("Helvetica",Font.BOLD,16));
    
    // set the color for the font
    
    // draw the message
    graphics2d.drawString(message,xPos,yPos);
    
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
