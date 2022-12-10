import java.util.Arrays;

public class Task03 {

    public static void main(String[] args) {
        int[] myArray = {12, 11, 312, 13, 25, 66, 7, 8, 123, 2};
        System.out.println(Arrays.toString(myArray));
        myArray = heapSort(myArray);
        System.out.println(Arrays.toString(myArray));

    }

    public static int[] heapSort(int myArray[])
    {
        int myLength = myArray.length;

        for (int i = myLength / 2 - 1; i >= 0; i--) {
            createHeap(myArray, myLength, i);
        }

        for (int i = myLength-1; i >= 0; i--)
        {
            int temp = myArray[0];
            myArray[0] = myArray[i];
            myArray[i] = temp;

            createHeap(myArray, i, 0);
        }
        return myArray;
    }


    public static void createHeap(int myArray[], int myLength, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < myLength && myArray[left] > myArray[largest])
            largest = left;

        if (right < myLength && myArray[right] > myArray[largest])
            largest = right;

        if (largest != i)
        {
            int temp = myArray[i];
            myArray[i] = myArray[largest];
            myArray[largest] = temp;
            createHeap(myArray, myLength, largest);
        }
    }

}