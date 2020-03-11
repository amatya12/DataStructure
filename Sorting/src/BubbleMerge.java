import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BubbleMerge {
	static int comparisons = 0;

	public int[] BubbleSort(int[] array) {

		boolean done = false;

		int count = 0;
		while (!done) {

			done = true;
			for (int i = 0; i < array.length - 1; i++) {
				comparisons++;
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					done = false;
					count++;
				}
			}
		}
		return array;

	}

	public int[] merge(int[] array1, int[] array2, int startofarray1 ,  int startofarray2) {
		/*int lengthoffirstarray = firstarray.length;
		int lengthofsecondarray = secondarray.length;
		int[] mergedarray = new int[(lengthoffirstarray + lengthofsecondarray) - 1];
		int k = 0;

		int indexoffirstarray = 0;
		int indexofsecondarray = 0;
		int indexofmergingarray = 0;

		while (indexoffirstarray < lengthoffirstarray && indexofsecondarray < lengthofsecondarray) {
			comparisons++;
			if (firstarray[indexoffirstarray] <= secondarray[indexofsecondarray]) {
				mergedarray[indexofmergingarray] = firstarray[indexoffirstarray];
				indexoffirstarray++;
				indexofmergingarray++;
			} else {
				mergedarray[indexofmergingarray] = secondarray[indexofsecondarray];
				indexofsecondarray++;
				indexofmergingarray++;
			}

		}
		System.arraycopy(firstarray, indexoffirstarray, mergedarray, indexofmergingarray, lengthoffirstarray - indexoffirstarray+1);
		System.arraycopy(secondarray, indexofsecondarray, mergedarray, indexofmergingarray, lengthofsecondarray - indexoffirstarray+1);

		while (indexoffirstarray < lengthoffirstarray - 1) {
			mergedarray[indexofmergingarray] = firstarray[indexoffirstarray];
			indexofmergingarray++;
			indexoffirstarray++;
		}
		while (indexofsecondarray < lengthofsecondarray - 1) {
			mergedarray[indexofmergingarray] = secondarray[indexofsecondarray];
			indexofmergingarray++;
			indexofsecondarray++;
		}

		return mergedarray;

	}*/
		int[] temp = new int[(array1.length + array2.length)];
		int leftend = array1.length - 1;
		int rightend = array2.length - 1;
		int index = 0;

		while (startofarray1 <= leftend && startofarray2 <= rightend) {
			comparisons++;

			if (array1[startofarray1] <= array2[startofarray2]) {
				temp[index] = array1[startofarray1];
				startofarray1++;
			} else {
				temp[index] = array2[startofarray2];
				startofarray2++;
			}
			index++;
		}

		System.arraycopy(array1, startofarray1, temp, index, leftend - startofarray1 + 1);
		System.arraycopy(array2, startofarray2, temp, index, rightend - startofarray2 + 1);
		return temp;
	}
	
	public int[] mergeall(int[]first, int[] second , int[] third, int[] fourth, int[] fifth) {
		int[] fs = merge(first , second, 0,0);
		int[] fst = merge(fs, third,0 , 0);
		int[] fstf = merge(fst , fourth, 0, 0);
		int[]fstff = merge(fstf , fifth, 0, 0);
		return fstff;
		
	}

	public void show(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	public int[] sortallfiveandmerge(int[]first , int[] second , int[] third, int[] fourth, int[]fifth) {
		int []sort1 = BubbleSort(first);
		int []sort2 = BubbleSort(second);
		int []sort3 = BubbleSort(third);
		int []sort4 = BubbleSort(fourth);
		int []sort5 = BubbleSort(fifth);
		int[] finalarray = mergeall(sort1, sort2,sort3,sort4,sort5);
		/*ArrayList a = new ArrayList();
		a.add(sort1);
		a.add(sort2);
		a.add(sort3);
		a.add(sort4);
		a.add(sort5);*/
		return finalarray;
		
		
	}

	public static void main(String[] args) throws IOException {
		BubbleMerge bm = new BubbleMerge();
		int[] array1 = new int[2000];
		int[] array2 = new int[2000];
		int[] array3 = new int[2000];
		int[] array4 = new int[2000];
		int[] array5 = new int[2000];

		String target_dir = "listofnumbers";
		File dir = new File(target_dir);
		File[] files = dir.listFiles();

		// for (File f : files) {
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				BufferedReader inputStream = null;

				try {
					inputStream = new BufferedReader(new FileReader(files[i]));
					String line;

					if (i == 0) {
						int a = 0;
						while ((line = inputStream.readLine()) != null) {
							array1[a] = Integer.parseInt(line);
							a++;
						}
					}
					if (i == 1) {
						int a = 0;
						while ((line = inputStream.readLine()) != null) {
							array2[a] = Integer.parseInt(line);
							a++;
						}
					}
					if (i == 2) {
						int a = 0;
						while ((line = inputStream.readLine()) != null) {
							array3[a] = Integer.parseInt(line);
							a++;
						}
					}
					if (i == 3) {
						int a = 0;
						while ((line = inputStream.readLine()) != null) {
							array4[a] = Integer.parseInt(line);
							a++;
						}
					}
					if (i == 4) {
						int a = 0;
						while ((line = inputStream.readLine()) != null) {
							array5[a] = Integer.parseInt(line);
							a++;
						}
					}

				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}
			}
		}
		int[] sorted1 = bm.BubbleSort(array1);
		int[] sorted2 = bm.BubbleSort(array2);
		int[] sorted3 = bm.BubbleSort(array3);
		int[] sorted4 = bm.BubbleSort(array4);
		int[] sorted5 = bm.BubbleSort(array5);
		int[]finalarray=bm.mergeall(sorted1, sorted2, sorted3, sorted4, sorted5);
		
		/*int[]a = {43,45};
		int[]b = {32,5,};
		int[]c = {2,};
		int[] d = {32,5};
		int[] e = {32,5432};
		*/
	//int[] finalarray=	bm.sortallfiveandmerge(array1, array2, array3, array4, array5);
		//int[] finalarray=	bm.sortallfiveandmerge(a,b,c,d,e);
	bm.show(finalarray);
	System.out.println("The number of comparisons are :"+ comparisons);
		
		

	}

}
