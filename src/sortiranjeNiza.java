import java.util.Arrays;

public class sortiranjeNiza {
    public static void main(String[] args) {
        String [] strings = {"k", "j","a", "b", "c" ,"c", "d", "e", "f", "g",
                "h", "i"};

//        Arrays.sort(strings);
        String temp;
        for ( int i = 0; i < strings.length; i++ ) {
            for ( int j = i + 1; j < strings.length; j++ ) {
                if(strings[i].compareTo(strings[j])>0)
                {
                    temp = strings[i];
                    strings[i]=strings[j];
                    strings[j]=temp;
                }
            }
        }
        brisiduplikati(strings);
        for ( int i = 0; i < strings.length; i++ ) {
            if(strings[i]!=null)
            {
                System.out.print(strings[i] + " ");
            }
        }
    }

    private static void brisiduplikati(String[] strings) {
        for ( int i = 0; i < strings.length; i++ ) {
            if(strings[i] !=null) {
                for ( int j = i + 1; j < strings.length; j++ ) {
                    if (strings[i].equals(strings[j]))
                        strings[j] = null;
                }
            }
        }

    }
}
