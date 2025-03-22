package ArrayDSA;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
            int[][] arr ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
for(int[] r: arr){   System.out.println(Arrays.toString(r));
        }
        int size=arr.length;
        int rot[][]=new int[size][size];
        // Transpose the initial array
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                rot[j][i]=arr[i][j];
            }
        }
        //Swap the last 2 rows
        for(int i=0;i<rot.length;i++){
            int x=size-1;
            for(int j=0;j<x;j++){
                int temp=rot[i][j];
                rot[i][j]=rot[i][x];
                rot[i][x]=temp;
                x--;
            }
        }
        System.out.println("Rotated Array");
        for(int i[] : rot){
            System.out.println(Arrays.toString(i));
        }

    }

}