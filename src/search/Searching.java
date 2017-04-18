
package search;

/**
 *
 * @author Joshua Tennies
 */
public class Searching {
    public static int sequentialSearch(int[] a, int key) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
