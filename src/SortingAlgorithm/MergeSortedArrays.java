package SortingAlgorithm;

public class MergeSortedArrays {

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public int[] merge(int[] arr1, int[] arr2, int n, int m) {
		int[] result = new int[m + n];
		int i = 0; //traverse arr1
		int j = 0; //traverse arr2
		int k = 0; //traverse result

		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				i++;
			} else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}
		//either arr1 or arr2 got exhausted
		while (i < n) {
			result[k] = arr1[i];
			i++;
			k++;
		}
		while (j < m) {
			result[k] = arr2[j];
			j++;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = new int[]{0, 1, 8, 10};
		int[] arr2 = new int[]{2, 4, 11, 15, 20};
		MergeSortedArrays msa = new MergeSortedArrays();
		msa.printArray(arr1);
		msa.printArray(arr2);
		int[] result = msa.merge(arr1, arr2, arr1.length, arr2.length);
		msa.printArray(result);
	}
}
