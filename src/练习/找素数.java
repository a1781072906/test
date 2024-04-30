public class 找素数 {
    public static void main(String[] args) {
        System.out.println("当前素数的个数是"+search(101,200));
    }
    public static int search(int start, int end) {
        int count = 0;
        //定义一个for循环遍历所有数据
        for (int i = start; i <= end; i++) {
            boolean sign = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                    //当前记住的不是素数
                }
            }
            if (sign) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
}