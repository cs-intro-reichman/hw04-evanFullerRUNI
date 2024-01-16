public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(camelCase("Hello World"));
        System.out.println(camelCase("HELLO   world"));
        System.out.println(camelCase(" tWo    wordS"));
    }

    public static String capVowelsLowRest (String string) {
        int n = string.length();
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) != 'A' && string.charAt(i) != 'E' && string.charAt(i) != 'I' && string.charAt(i) != 'O' && string.charAt(i) != 'U') {
                if (string.charAt(i) != 'a' && string.charAt(i) != 'e' && string.charAt(i) != 'i' && string.charAt(i) != 'o' && string.charAt(i) != 'u' && string.charAt(i) != ' ') {
                    if ( string.charAt(i) >= 65 && string.charAt(i) <= 90) {
                        string = string.substring(0, i) + (char) (string.charAt(i) + 32) + string.substring(i + 1);
                    }
                } else if (string.charAt(i) != ' ') {
                    string = string.substring(0, i) + (char) (string.charAt(i) - 32) + string.substring(i + 1);
                }
            }
        }
        return string;
    }

    public static String camelCase (String string) {
        int n = string.length();
        boolean newWord = false;
        boolean firstWord = true;
        for (int i = 0; i < n; i++) {
            if (newWord == true && string.charAt(i) != ' ') {
                if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
                    string = string.substring(0, i) + (char) (string.charAt(i) - 32) + string.substring(i + 1);
                }
                newWord = false;
            } else if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
                    string = string.substring(0, i) + (char) (string.charAt(i) + 32) + string.substring(i + 1);
                    firstWord = false;
            } else if (string.charAt(i) == ' ' && firstWord == false) {
                string = string.substring(0, i) + string.substring(i + 1);
                n--;
                i--;
                newWord = true;
            } else if (string.charAt(i) == ' ') {
                string = string.substring(0, i) + string.substring(i + 1);
                n--;
                i--;
            }
        }
        return string;
    }

    public static int[] allIndexOf (String string, char chr) {
        int n = string.length();
        int size = 0;

        for (int i = 0; i < n; i++) {
            if (string.charAt(i) == chr) {
                size++;
            }
        }
        int[] array = new int[size];
        for (int i = 0, j = 0; i < n; i++) {
            if (string.charAt(i) == chr) {
                array[j++] = i;
            }
        }

        return array;
    }
}
