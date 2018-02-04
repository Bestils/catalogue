package pl.kubie.catalogue;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Gladus on 04.02.2018.
 */
public class MovieService {
    private MovieDatabase movieDatabase;

    public MovieService(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    private void createMovie() {
        System.out.println("#############################################################");
        System.out.println("#                                                           #");
        System.out.println("#                   ***Adding Movieu***                   #");
        System.out.println("#                                                           #");
        System.out.println("#############################################################");

        Scanner sc = new Scanner(System.in);


        System.out.println("title");
        String movieTitle = sc.nextLine();
        System.out.println("type");
        String type = sc.nextLine();
        System.out.println("comment");
        String comment = sc.nextLine();
        System.out.println("rate");
        Integer rate = Integer.parseInt(sc.nextLine());
        Movie movie = new Movie(-1, movieTitle, type, comment, rate);
        movieDatabase.save(movie);


    }


    public void DeleteMovie(Integer Index) {


        movieDatabase.remove(Index);
        System.out.println("Movie  deleted" + "\n");
    }
    public void AddComment(Integer index) {
        Scanner sc = new Scanner(System.in);

        String comment = sc.nextLine();
        movieDatabase.findById(index).setComment(comment);
    }

    public void SetRate(Integer indeksMovieu) {
        Scanner sc = new Scanner(System.in);
        Pattern wzóroceny = Pattern.compile("[0-9]?");
        String OcenaPobrana;
        do {
            System.out.print("Give a rating [0-9]: ");
            OcenaPobrana = sc.nextLine();

            if (wzóroceny.matcher(OcenaPobrana).matches()) {
                movieDatabase.get(indeksMovieu).setRate(Integer.valueOf(OcenaPobrana));
            }
        } while (movieDatabase.get(indeksMovieu).getRate() == null);

    }

    public void SetCategory(Integer MovieIndex) {
        Scanner sc = new Scanner(System.in);


        Map<Integer, String> MovieCategorys = new HashMap<>();


        MovieCategorys.put(1, "Dramat");
        MovieCategorys.put(2, "Komedia");
        MovieCategorys.put(3, "Romans");
        MovieCategorys.put(4, "Akcji");
        MovieCategorys.put(5, "Thriler");
        MovieCategorys.put(6, "Dokumentalny");
        MovieCategorys.put(7, "Fantasy");
        MovieCategorys.put(8, "Kriminał");
        MovieCategorys.put(9, "Psychologiczny");
        MovieCategorys.put(10, "Przygodowy");
        MovieCategorys.put(11, "Rodzinny");

        System.out.println("Chose number with category of movie");
        for (Map.Entry<Integer, String> entry : MovieCategorys.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        Integer Gatunek = sc.nextInt();

        movieDatabase.get(MovieIndex).setType(MovieCategorys.get(Gatunek));

    }

}