package 面向对象电影;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    //展示系统全部电影信息
    public void printAllMovies() {
        System.out.println("系统全部电影信息如下");
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println("编号" + m.getId());
            System.out.println("名称" + m.getName());
            System.out.println("价格" + m.getPrice());
        }

    }

    public void searchMovieById(int id) {
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            if (m.getId() == id) {
                System.out.println("编号" + m.getId());
                System.out.println("名称" + m.getName());
                System.out.println("价格" + m.getPrice());
                return;
            }
        }
        System.out.println("没找到");
    }
}
