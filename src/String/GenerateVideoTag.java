package String;

public class GenerateVideoTag {
    public static String generateTag(String caption) {
        String[] arr = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(arr[0].toLowerCase());
        for (int i = 1; i < arr.length; i++) {
            String wrd = arr[i];
            if (!wrd.isEmpty()) {
                sb.append(Character.toUpperCase(wrd.charAt(0)))
                        .append(wrd.substring(1).toLowerCase());
            }
        }
        return sb.length() > 100 ? sb.substring(0, 100) : sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Normal sentence
        System.out.println("Test 1: " + generateTag("hello world from java"));
        // Output: #helloWorldFromJava

        // Test Case 2: Multiple spaces
        System.out.println("Test 2: " + generateTag("   open   ai   rocks  "));
        // Output: #openAiRocks

        // Test Case 3: Single word
        System.out.println("Test 3: " + generateTag("ChatGPT"));
        // Output: #chatgpt

        // Test Case 4: Mixed case input
        System.out.println("Test 4: " + generateTag("tHis is A tEsT"));
        // Output: #thisIsATest

        // Test Case 5: Very long caption
        System.out.println("Test 5: " + generateTag("this is a very long caption that should be truncated if it exceeds the hundred character limit imposed by the system"));
        // Output: 100-character truncated tag
    }
}