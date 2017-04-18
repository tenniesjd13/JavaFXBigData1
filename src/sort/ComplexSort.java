package sort;

import java.util.Arrays;

/**
 *
 * @author Joshua Tennies
 */
public class ComplexSort {


    public static void mergeSort(int[] a, String direction) {
        int nElems = a.length;
        int[] workSpace = new int[nElems]; //=workSpace was in the middle
        recMergeSort(a, direction, workSpace, 0, nElems - 1);
    }

    public static void recMergeSort(int[] a, String direction, int[] workSpace,
            int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(a, direction, workSpace, lowerBound, mid);
            recMergeSort(a, direction, workSpace, mid + 1, upperBound);
            merge(a, direction, workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    public static void merge(int[] a, String direction, int[] workSpace, int lowPtr,
            int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (a[lowPtr] < a[highPtr] && direction.equalsIgnoreCase("A")
                    || a[lowPtr] > a[highPtr] && direction.equalsIgnoreCase("D")) {
                workSpace[j++] = a[lowPtr++];
            } else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = a[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = a[highPtr++];
        }
        for (j = 0; j < n; j++) {
            a[lowerBound + j] = workSpace[j];
        }
    }

    public static void quickSort(int a[], int left, int right, String direction) {
        if (direction.equalsIgnoreCase("A")) {
            if (right > left) {
                int i = left, j = right, tmp;
                //we want j to be right, not right-1 since that leaves out a number during recursion

                int v = a[right]; //pivot

                do {
                    while (a[i] < v) {
                        i++;
                    }
                    while (a[j] > v) //no need to check for 0, the right condition for recursion is the 2 if statements below.
                    {
                        j--;
                    }

                    if (i <= j) {            //your code was i<j
                        tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                        i++;
                        j--;
                        //we need to +/- both i,j, else it will stick at 0 or be same number
                    }
                } while (i <= j);           //your code was i<j, hence infinite loop on 0 case

                //you had a swap here, I don't think it's needed.
                //this is the 2 conditions we need to avoid infinite loops
                // check if left < j, if it isn't, it's already sorted. Done
                if (left < j) {
                    quickSort(a, left, j, direction);
                }
                //check if i is less than right, if it isn't it's already sorted. Done
                // here i is now the 'middle index', the slice for divide and conquer.

                if (i < right) {
                    quickSort(a, i, right, direction);
                }
            }
        } else if(direction.equalsIgnoreCase("D")) {
            int i = left, j = right, tmp;
                //we want j to be right, not right-1 since that leaves out a number during recursion

                int v = a[right]; //pivot

                do {
                    while (a[i] > v) {
                        i++;
                    }
                    while (a[j] < v) //no need to check for 0, the right condition for recursion is the 2 if statements below.
                    {
                        j--;
                    }

                    if (i <= j) {            //your code was i<j
                        tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                        i++;
                        j--;
                        //we need to +/- both i,j, else it will stick at 0 or be same number
                    }
                } while (i <= j);           //your code was i<j, hence infinite loop on 0 case

                //you had a swap here, I don't think it's needed.
                //this is the 2 conditions we need to avoid infinite loops
                // check if left < j, if it isn't, it's already sorted. Done
                if (left < j) {
                    quickSort(a, left, j, direction);
                }
                //check if i is less than right, if it isn't it's already sorted. Done
                // here i is now the 'middle index', the slice for divide and conquer.

                if (i < right) {
                    quickSort(a, i, right, direction);
                }
        }
    }
}
