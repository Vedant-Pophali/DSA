package ArrayDSA;
import java.util.ArrayList;
import java.util.Arrays;

/*
   While declaring an arraylist, it ensures that 2 varibles capaity & size are declared
   Capaity is initialized to 2 and tells the user how many elements the arraylist can store , it keeps increasing with 2,4,8,16,...(2^n)
   Size is the number of elements that are stored in the arraylist
   All this is abstracted and user knows nothing
 */

public class ResizableArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.addAll(Arrays.asList(2,3,4));
        System.out.println("Size = "+ arr.size());
        System.out.println(arr);

        //Sorting arrays
        int arrays[]={10,5,4,8,9,3};
        Arrays.sort(arrays,0,4);//excluded element at toIndex
        System.out.println(Arrays.toString(arrays));
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays)); 
    }
}