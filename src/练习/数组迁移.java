public class 数组迁移 {
    public 数组迁移() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11, 22, 33};
        int[] arr2 = copy(arr);
        print(arr2);
    }

    public static void print(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length; ++i) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ",");
        }

        System.out.print("]");
    }

    public static int[] copy(int[] arr) {
        int[] arr2 = new int[arr.length];

        for(int i = 0; i < arr.length; ++i) {
            arr2[i] = arr[i];
        }

        return arr2;
    }
}
