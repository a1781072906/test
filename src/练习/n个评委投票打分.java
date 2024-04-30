import java.util.Scanner;

public class n个评委投票打分 {
    public n个评委投票打分() {
    }

    public static void main(String[] args) {
        System.out.println(getScore(4));
    }

    public static double getScore(int number) {
        int[] scores = new int[number];
        Scanner sc = new Scanner(System.in);

        int sum;
        int min;
        for(sum = 0; sum < scores.length; ++sum) {
            System.out.println("请输出第" + (sum + 1) + "个评委的分数");
            min = sc.nextInt();
            scores[sum] = min;
        }

        sum = 0;
        min = scores[0];
        int max = scores[0];

        for(int i = 0; i < scores.length; ++i) {
            int score = scores[i];
            sum += score;
            if (score > max) {
                max = score;
            }

            if (score < min) {
                min = score;
            }
        }

        return 1.0 * (double)(sum - min - max) / (double)(number - 2);
    }
}