//对密码拆分之后每一位+5，之后对10取余，之后倒序
public class 加密 {
    public 加密() {
    }

    public static void main(String[] args) {
        System.out.println(password(1983));
    }

    public static String password(int num) {
        int[] numbers = split(num);

        for(int i = 0; i < numbers.length; ++i) {
            numbers[i] = (numbers[i] + 5) % 10;
        }

        reverse(numbers);
        String data = "";

        for(int i = 0; i < numbers.length; ++i) {
            data = data + numbers[i];
        }

        return data;
    }

    private static void reverse(int[] numbers) {
        int i = 0;

        for(int j = numbers.length - 1; i < j; --j) {
            int temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
            ++i;
        }

    }

    public static int[] split(int number) {
        int[] numbers = new int[]{number / 1000, number / 100 % 10, number / 10 % 10, number % 10};
        return numbers;
    }
}