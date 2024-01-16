public class ArrayOps {
    public static void main(String[] args) {
        // System.out.println(findMissingInt(new int[] {4, 2, 1, 3}));
        // System.out.println(findMissingInt(new int[] {0}));
        // System.out.println(findMissingInt(new int[] {0, 1, 2, 5, 4, 6}));
        System.out.println(secondMaxValue(new int[] {2,8,3,7,8}));
        // System.out.println(secondMaxValue(new int[] {4, 2, 1, 3}));
        // System.out.println(secondMaxValue(new int[] {0, 1}));
        // System.out.println(containsTheSameElements(new int[] {1,2,3,4,5}, new int[] {1,2,3,4,5}));
        // System.out.println(containsTheSameElements(new int[] {2,2,3,7,8,3,2}, new int[] {8,2,7,7,3}));
        // System.out.println(containsTheSameElements(new int[] {1,2,3,-4,5}, new int[] {1,3,-4,5}));
        // System.out.println(isSorted(new int[] {1, 2, -3}));
        // System.out.println(isSorted(new int[] {3, 2, -1}));
        // System.out.println(isSorted(new int[] {1, -2, 3, 4}));
        // System.out.println(isSorted(new int[] {1, 2, 4, 3}));
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

    public static int secondMaxValue(int [] array) {
        int n = array.length;
        int max = 0;
        int max2 = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] >= max) {
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
