package sort;

/**
 * Big-O time of O(n*n)
 *
 * @author 55jphillip
 */
public class SimpleSorts {

    public static void bubbleSort(int[] a, String direction) {
        int out, in;
        boolean moreChanges = true;

        for (out = a.length - 1; out > 0 && moreChanges; out--) {
            moreChanges = false;
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1] && direction.equalsIgnoreCase("A")
                        || a[in] < a[in + 1] && direction.equalsIgnoreCase("D")) {
                    int temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                    moreChanges = true;
                }
            }
        }
    }

    public static void selectionSort(int[] a, String direction) {
        if (direction.equalsIgnoreCase("A")) {
            int smallest, smallestIndex;
            for (int i = 0; i < a.length; i++) {
                smallestIndex = i;
                smallest = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < smallest) {
                        smallest = a[j];
                        smallestIndex = j;
                    }
                }
                int temp = a[i];
                a[i] = a[smallestIndex];
                a[smallestIndex] = temp;
            }
        } else if (direction.equalsIgnoreCase("D")) {
            int highest, highestIndex;
            for (int i = 0; i < a.length; i++) {
                highestIndex = i;
                highest = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] > highest) {
                        highest = a[j];
                        highestIndex = j;
                    }
                }
                int temp = a[i];
                a[i] = a[highestIndex];
                a[highestIndex] = temp;
            }
        }
    }
    
    public static void insertionSort(int[] a, String direction) {
        if(direction.equalsIgnoreCase("A")) {
            for(int i = 2; i < a.length; i++) {
                int key = a[i];
                int j = i - 1;
                while(j >= 0 && a[j] > key) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = key;
            }
        } 
        else if(direction.equalsIgnoreCase("D")) {
            for(int i = a.length-2; i >= 0; i--) {
                int key = a[i];
                int j = i + 1;
                while(j < a.length && a[j] > key) {
                    a[j-1] = a[j];
                    j++;
                }
                a[j-1] = key;
            }
        }
    }
}
