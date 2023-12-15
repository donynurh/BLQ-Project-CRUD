public class Nomor12 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,7,1,1,5,6,1,8};

        System.out.print("Input : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    int wadah = arr[j];
                    arr[j] = arr[i];
                    arr[i] = wadah;
                }
            }
        }

        System.out.print("Output : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
