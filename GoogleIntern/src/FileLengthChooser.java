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
 *    - Average O(n)
 *    - Worst O(n^2)
 *  
 * @author Yuyang He
 * @date 8:42:10 AM, Nov 18, 2015
 * @version 1.0
 */
public class FileLengthChooser
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

		// each element in the list will be a root folder containg everything it
		// has
		List<List<String>> folderList = new ArrayList<List<String>>();
		List<String> singleFolder = null;

		for (int i = 0; i < folderLine.length; ++i)
		{
			// meaning a new root folder
			if (!folderLine[i].startsWith(" "))
			{
				// the first time list is null
				if (null != singleFolder)
				{
					folderList.add(singleFolder);
				}
				singleFolder = new ArrayList<String>();
			}

			// add every line into the single root folder
			singleFolder.add(folderLine[i]);
		}

		// for the last folder
		folderList.add(singleFolder);

		int maxLength = -1, singleFoelderMaxLength = -1;

		for (List<String> tmp : folderList)
		{
			if (1 < tmp.size())
			{
				singleFoelderMaxLength = dealSingleFolder(tmp);
			}
			if (maxLength < singleFoelderMaxLength)
			{
				maxLength = singleFoelderMaxLength;
			}
		}

		return maxLength;
	}

	/**
	 * This function will handle a single root folder and get the maximum length
	 * if any jpg files are in it. Otherwise, -1 will be returned.
	 * 
	 * @param singFolderStructure
	 *            A single folder structure containing folders and photos. See
	 *            requirements for details.
	 * @return the maximum length of a jpg file. If no photos, -1 will be
	 *         returned.
	 */
	private static int dealSingleFolder(List<String> singFolderStructure)
	{
		int maxLength = -1, folderLength = singFolderStructure.size(), tmpSize = -1, lastTimeblanks = -1,
		        currentTimeBlanks = -1;

		// root folder
		String rootFolder = singFolderStructure.get(0), currentPath = null, tmp = null;

		boolean isEnd = false;

		while (!isEnd)
		{
			currentPath = rootFolder;
			for (int i = 1; i < folderLength; ++i)
			{
				tmp = singFolderStructure.get(i);

				// check if is another folder parallel to this folder
				// e.g.
				// fol0
				// fol1
				// fol2
				if (1 == i)
				{
					lastTimeblanks = 1;
				} else
				{
					String[] tmpBlanks = tmp.split(" ");
					currentTimeBlanks = tmpBlanks.length - 1;

					// parallel
					if (lastTimeblanks >= currentTimeBlanks)
					{
						singFolderStructure.remove(i - 1);
						--folderLength;
						break;
					} else
					{
						lastTimeblanks = currentTimeBlanks;
					}
				}

				currentPath += "/";
				currentPath += tmp.trim();

				if (folderLength - 1 == i)
				{
					isEnd = true;
				}

				// delete this line for next possible photo
				if (tmp.endsWith(".jpg"))
				{
					singFolderStructure.remove(tmp);
					--folderLength;
					break;
				}
			}

			if (currentPath.endsWith(".jpg"))
			{
				tmpSize = currentPath.length();
			}

			if (maxLength < tmpSize)
			{
				maxLength = tmpSize;
			}
		}

		return maxLength;
	}

	/**
	 * Main function.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		String testFolder = "fol0\n fol1\n fol2\n  photo.jpg\n  morning.jpg\n fol3\nfol4\n fol4\nfol5\n fol6\n  hello.jpg";
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
