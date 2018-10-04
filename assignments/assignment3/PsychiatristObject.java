package Assignment3;

public class PsychiatristObject {

    public void examine(MoodyObject moodyObject) {
        System.out.println("How are you feeling today?");
        moodyObject.queryMood();
    }

    public void observe(MoodyObject moodyObject) {
        moodyObject.expressMood();
        System.out.println("Observation: "+moodyObject);
    }


    /**
	 *  Test main function
	 *
     */
    public static void main(String[] args) {
        PsychiatristObject psychiatristObject = new PsychiatristObject();
        MoodyObject happyObject = new HappyObject();
        MoodyObject sadObject = new SadObject();
        
        psychiatristObject.examine(happyObject);
        psychiatristObject.observe(happyObject);
        System.out.println();
        psychiatristObject.examine(sadObject);
        psychiatristObject.observe(sadObject);

        System.out.println(reverse("    The sky    is blue   "));
    }

    /**
     * Extra Credit reverse a string word by word
     * @param string
     */

    public static String reverse(String string) {
    	if (string == null || string.equals("")) return "";
        String[] words = string.trim().split("\\s++");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0 ; i--) {
            stringBuilder.append(" ");
            stringBuilder.append(words[i]);
        }
        return stringBuilder.toString();
    }
}
