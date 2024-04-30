package 面向对象电影;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Movie[] movies = new Movie[4];
        Movie m1 = new Movie();
        movies[0] = m1;
        MovieOperator operator = new MovieOperator(movies);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    operator.printAllMovies();
                    break;
                case 2:
                    int id = sc.nextInt();
                    operator.searchMovieById(id);
                default:
                    System.out.println("输错了");
            }
        }
    }
}
