package pl.kubie.catalogue;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gladus on 08.02.2018.
 */
public class Searcher {

    static MovieDatabase movieDatabase= new MovieDatabase();
    static MovieService movieService= new MovieService(movieDatabase);
static View view = new View();
    public static void search() {
        int numberChoice = view.getUserNumber("Do you want to search by title (1), rate (2), type(3) or date(4).");
        if (numberChoice == 1) {

            String titleToSearch = view.getUserChoice(( "You are searching by title, input text:"));
            System.out.println( movieDatabase.findByTitle(titleToSearch));
        } else if (numberChoice == 2) {
            System.out.println( "You are searching by rate");
            int smalerRate = view.getUserNumber("First please input smaller number");
            int bigerRate = view.getUserNumber("Now input bigger number");
            if (smalerRate>bigerRate){
                int temp=smalerRate;
                smalerRate=bigerRate;
                bigerRate=temp;
            }
            System.out.println(movieDatabase.findByAverageRate(smalerRate,bigerRate));

        } else if (numberChoice == 3) {
            movieService.getCategories();
            String titleToSearch = view.getUserChoice( "You are searching by type, chose your type:");
//pobrać porównać wypisać pasujące
        }
        else if (numberChoice == 4) {
//Dorobić opcje wyszukującą

        } else {
            System.out.println("Bad chose");
        }

    }
}
