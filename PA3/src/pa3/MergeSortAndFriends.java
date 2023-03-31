package pa3;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAndFriends {

    private static int[] binaryMerge(int A[], int B[], int lenA, int lenB) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] C = new int[lenA + lenB];
        while (i < lenA && j < lenB) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        while (i < lenA) {
            C[k] = A[i];
            i++;
            k++;
        }

        while (j < lenB) {
            C[k] = B[j];
            j++;
            k++;
        }

        return C;
    }

    public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < lenA && j < lenB) {
            if (A[i] == B[j]) {
                result.add(A[i]);
                while(i < lenA && B[j] == A[i]){
                    i++;
                }
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static int[] kWayMerge(int lists[][], int listLengths[], int k) {
        if (k == 1) {
        return lists[0];
    } else {
        int[] list1 = kWayMerge(Arrays.copyOfRange(lists, 0, k/2), Arrays.copyOfRange(listLengths, 0, k/2), k/2);
        int[] list2 = kWayMerge(Arrays.copyOfRange(lists, k/2, k), Arrays.copyOfRange(listLengths, k/2, k), k - k/2);
        return binaryMerge(list1, list2, list1.length, list2.length);
        }
    }
    

    public static void mergesort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(array, left, mid);
            mergesort(array, mid + 1, right);
            int A[] = Arrays.copyOfRange(array, left, mid + 1);
            int B[] = Arrays.copyOfRange(array, mid + 1, right + 1);
            int mergedArray[] = binaryMerge(A, B, A.length, B.length);
            int i = left;
            int j = 0;
            while (j <= right - left) {
                array[i++] = mergedArray[j++];
            }
        }
    }
}
