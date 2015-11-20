import java.util.ArrayList;
import java.util.List;

/**
 * Requirement:
 * 
 * 1 Given a string in such format:
 *   fol0
 *    fol1
 *    fol2 
 *     photo.jpg
 *     morning.jpg
 *    fol3
 *   fol4
 *   fol5
 *    fol6
 *     hello.jpg
 *  
 *  2 Find out the longest length of a file(jpg), and if
 *  there are only directories, return -1. Other wise, return the length
 *  like 
 *  	fol0/fol2/morning.jpg
 *  
 *  3 Time Constraint
 *    - Best O(n)
 *    - Average O(nlogn)
 *    - Worst O(nlogn)
 *    
 * @author Yuyang He
 * @date Nov 20, 2015
 * @version 1.0
 * @since
 */
public class UpdatedFileLengthChooser
{
	/**
	 * The function will satisfy the requirement.
	 * 
	 * @param folderStructure
	 *            see requirements above
	 * @return the longest length in the folder, see requirements above
	 */
	public static int lengthChooser(String folderStructure)
	{
		String[] folderLine = folderStructure.split("\n");
		int currentMaxLength = -1, currentBlanks = -1, currentLength = -1;
		
		//in this list
		//every level will contain a path
		//the smaller of the level
		//the folder will be closer to the root
		List<String> currentPath = null, tmp = null;		
		
		for(String oneLine : folderLine)
		{
			String [] blanks = oneLine.split(" ");
			//how many blanks are in the current line before any other characters start
			currentBlanks = blanks.length - 1;
			
			//root folder
			if(0 == currentBlanks)
			{
				currentPath = new ArrayList<String>();
			}
			else
			{
				if(currentBlanks < currentPath.size())
				{
					//delete level
					//where the number of level remained == the number of blanks
					tmp = new ArrayList<String>();
					
					for(int i = 0 ; i < currentBlanks; i++)
					{
						tmp.add(currentPath.get(i));
					}
					
					currentPath = tmp;
				}
			}
			
			currentPath.add(oneLine.trim());
			
			if(oneLine.endsWith(".jpg"))
			{
				currentLength = getLength(currentPath);
				
				if(currentMaxLength < currentLength)
				{
					currentMaxLength = currentLength;
				}
			}
		}
		
		return currentMaxLength;
	}

	/**
	 * This function will get the length of the whole path. Between
	 * each folder or file, a "/" will be added.
	 * @param currentPath the list of the current path
	 * @return the length of the path
	 */
	private static int getLength(List<String> currentPath)
	{
		int length = 0;
		
		for(String eachLevel : currentPath)
		{
			length += eachLevel.length();
		}
		
		//add "/" between each folder or file
		length += currentPath.size() - 1;
		
		return length;
	}
	
	/**
	 * Main function.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String testFolder = "fol0\n fol1\n fol2\n  photo.jpg\n  morning.jpg\n fol3\nfol4\n fol4\nfol5\n fol6\n  hello.jpg\n aaaaaaaaaaaaaaaaaaaaaa.jpg";
		int maxLength = lengthChooser(testFolder);

		System.out.println("The folder structure is: ");
		System.out.println(testFolder);
		System.out.println("----------");
		
		if (-1 != maxLength)
		{
			System.out.println("In current file structure, the maximum length of a file is " + maxLength + ".");
		} else
		{
			System.out.println("No jpg files found.");
		}
	}
}
