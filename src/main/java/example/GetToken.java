package example;

/**
 * Class for getting your Grade API token.
 */
public class GetToken {

    /**
     * Run to get your token after you complete the code.
     * @param args unused arguments
     */
    public static void main(String[] args) throws java.io.IOException {
        GetExample example = new GetExample();
        String gradeAPISignUpURL = "https://grade-apis.panchen.ca/signUp";
        String username = "kasu123";

        String response = example.run(gradeAPISignUpURL, "username", username);

        System.out.println(response);
    }
}
