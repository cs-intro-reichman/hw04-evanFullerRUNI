public class ArrayOps {
    public static void main(String[] args) {
    }
    
    // findMissingInt function that works with loops
    //but isn't as efficient as the next, math-based version
    /*public static int findMissingInt (int [] array) {
        int n = array.length;
        //System.out.println(n);
        boolean isFound = true;
        int i = 0;
        while (i <= n && isFound == true) {
            isFound = false;
            for (int j = 0; j < n && isFound == false; j++) {
                if (array[j] == i) {
                    isFound = true;
                }
            }
            i++;
        }
        return (i - 1);
    }*/

    // findMissingInt function that works with math to find the missing integer
    // via subtracting from the sum of all integers
    public static int findMissingInt (int [] array) {
        int n = array.length;
        int sum  = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum-= array[i];
        }
        return sum;
    }

    // finds the second largest value in an array by use of two max variables
    public static int secondMaxValue(int [] array) {
        int n = array.length;
        int max = 0;
        int max2 = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] >= max) { // greater than or equal to is essential
                max2 = max;
                max = array[i];
            }
        }
        return max2;
    }

    // containsTheSameElements function that works with only one loop,
    // but it is not very readable and has the same time complexity as the next version
    /*public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int n = array1.length;
        int m = array2.length;
        //boolean firstCheck = false;
        int tempLength = 0;
        //int[] arrayBig = new int[n + m];

        for (int i = 0, j = 0; i < n; i++) {
            if (tempLength == 0) {
                if (array1[i] != array2[j] && j < m - 1) {
                    j++;
                    i--;
                } else if (array1[i] != array2[j] && (j == m - 1 || i == n - 1)) {
                    return false;
                } else if (j == m - 1 || i == n - 1) {
                    j = 0;
                    i = -1;
                    tempLength = n;
                    n = m;
                    m = tempLength;
                } else {
                    j = 0;
                }
            } else {
                if (array2[i] != array1[j] && j < m - 1) {
                    j++;
                    i--;
                } else if (array2[i] != array1[j] && (j == m - 1 || i == n - 1)) {
                    return false;
                } else {
                    j = 0;
                }
            }
        }
        return true;
    }*/

    // containsTheSameElements function that works with two pairs of nested loops,
    // but it is much more readable and has the same time complexity as the previous version
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int n = array1.length;
        int m = array2.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array1[i] == array2[j]) {
                    break;
                }
                else if (j == m - 1) {
                    return false;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (array2[j] == array1[i]) {
                    break;
                }
                else if (i == n - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // checks to see if array is increasing or NOT increasing
    // and returns false if a change in behavior is detected
    public static boolean isSorted(int [] array) {
        int n = array.length;
        boolean increasing = array[0] < array[1];

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1] && increasing == true) {
                return false;
            } else if (array[i] < array[i + 1] && increasing == false) {
                return false;
            }
        }
        return true;
    }

}
