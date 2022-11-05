import java.util.Scanner;
public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int count = 0;
        for( int i = 0; i< s.length() ; i++ ){
            char nextCharacter = s.charAt (i);
            if (nextCharacter == 'a' || nextCharacter =='e'|| nextCharacter =='i' || nextCharacter =='o' || nextCharacter =='u'){
             count ++;
            }
        }
        return count;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        int count = 0;
        for( int i = 0; i< s.length() -2 ; i++ ){
            char nextCharacter = s.charAt (i);
            if ( nextCharacter == 'b') {
                String subString = s.substring (i, i+3);
                if ( subString.equals ("bob")){
                    count ++;

                }
            }
        }
        return count;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        String longestString = "";
        for ( int i = 0; i < s.length() ; i++){
            String currentLongestString = "";
            currentLongestString += s.charAt (i);
            for ( int j = i+1 ; j < s.length(); j++){
                if (s.charAt(j) >= s.charAt (j -1)){
                    currentLongestString += s.charAt(j);
                }
                else{
                    break;
                }
            }
            if (currentLongestString.length() > longestString.length()){
                longestString = currentLongestString;
            }

        }
        return longestString;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */



    }
}
