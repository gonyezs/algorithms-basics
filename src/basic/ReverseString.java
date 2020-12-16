package basic;

/**
 * Csak a feleig iteralunk es csereljuk az elso es az utolso elemeket
 */
public class ReverseString {

    public static String reverse ( String s ) {
        int length = s.length();
        int last = length - 1;
        char[] chars = s.toCharArray();
        for ( int i = 0; i < length/2; i++ ) {
            char c = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = c;
        }
        return new String(chars);
    }

}
