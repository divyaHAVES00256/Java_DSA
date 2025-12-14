public class Reorder {
    // static void reorderArray(int arr[],int index[]){
    //     int [] ans = new int[arr.length];
    //     for(int i = 0; i<arr.length; i++){
    //         ans[index[i]] = arr[i];
    //     }

    //     for(int i = 0; i < ans.length; i++) {
    //         arr[i] = ans[i];
    //     }
    // }

    static void reorderArray(int arr[],int index[]){
        for(int i = 0 ; i<arr.length; i++){
            //swap in arr
            int temp = arr[i];
            arr[i] = arr[index[i]];
            arr[index[i]]=temp;

            //swap index too
            int temp2 = index[i];
            index[i] = index[temp2];
            index[temp2] = temp2;

        //     for (int j = 0; j < arr.length; j++) {
        //     System.out.print(arr[j] + " ");
        // }
        System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 11, 12};
        int[] index = {1, 0, 2};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        reorderArray(arr, index);

        // Print the updated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
