package String;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length();//length of word 1
        int l2=word2.length();//length of word 2
        StringBuilder sb = new StringBuilder();
        if(l1==l2){
            for(int i=0;i<l1;i++){
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
        }
        else if(l1>l2){
            for(int i=0;i<l2;i++){
                sb.append((word1.charAt(i)));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(l2));
        }
        else{
            for(int i=0;i<l1;i++){
                sb.append((word1.charAt(i)));
                sb.append(word2.charAt(i));
            }
            sb.append(word2.substring(l1));
        }
        return sb.toString();
    }
}
