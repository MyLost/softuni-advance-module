package generics;

public class Main {
    public static void main(String[] args) {
        Jar<Pickle> jarOfPickles = new Jar<>();
        jarOfPickles.add(new Pickle());
        jarOfPickles.add(new Pickle());

        Pickle pickle = jarOfPickles.remove();
    }
}
