public class 打印乘法表 {
    public static void main(String[] args) {
        for (int i = 0; i <=9; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("j"+"X"+"i"+"="+(j*i)+"\t");
            }
            System.out.println();
        }
    }
}
