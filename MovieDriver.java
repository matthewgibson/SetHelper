import java.util.*;

/**
 * Created by khang on 1/22/2015.
 */
public class MovieDriver {

    public static void main(String[] args) {

        System.out.println("Welcome to Moviefone");

        Movie m1 = new Movie("Frozen", 2014);
        Movie m2 = new Movie("Star Trek", 1979);
        Movie m3 = new Movie("Rumble in the Bronx", 1996);
        Movie m4 = new Movie("Rainman", 1989);
        Movie m5 = new Movie("Flashdance", 1989);

        Set<Movie> library = new HashSet<Movie>();  // HashSet or TreeSet
        Set<Movie> favorites = new HashSet<Movie>();
        Set<Movie> watched = new HashSet<Movie>();

        Set<Movie> recentlyWatched = new HashSet<Movie>();
        Set<Movie> comedy = new HashSet<Movie>();
        Set<Movie> drama = new HashSet<Movie>();
        Set<Movie> action_comedy = new HashSet<Movie>();


        library.add(m1);
        library.add(m2);
        library.add(m3);
        library.add(m4);
        library.add(m5);

        favorites.add(m2);
        favorites.add(m3);

        Iterator<Movie> currentFav = favorites.iterator();
        System.out.println(currentFav.next());
        System.out.println(currentFav.next());
        //System.out.println(currentFav.next());

        watched.add(m1);
        watched.add(m3);
        watched.add(m4);

        comedy.add(m1);
        comedy.add(m3);

        drama.add(m2);
        drama.add(m4);

        favorites.clear();  // empty out the favorites set

        System.out.println("Library is " + library);
        System.out.println("Favorites is " + favorites);

        //Part 3: Set helper instance and SetHelper questions for movies genres.
        SetHelper helper = new SetHelper();

        // calc the intersection of watched and dramas
        Set<Movie> watchedDramas = helper.intersect(watched, drama);

        System.out.println("Watched Dramas: " + watchedDramas);
        // what movies have I not watched?
        Set<Movie> unwatched = helper.difference(library, watched);
        System.out.println("Unwatched movies: " + unwatched);
        // comedies that I haven't seen
        Set<Movie> unwatchedComs = helper.difference(unwatched, comedy);
        System.out.println("Unwatched comedies: " + unwatchedComs);
        // favorite movies that are comedies
        Set<Movie> favoriteComs = helper.intersect(favorites, comedy);
        System.out.println("Favorite comedies: " + favoriteComs);
        // movies after 2010 that I haven't watched
        Set<Movie> unwatchedNewReleases = new HashSet<Movie>();
        System.out.println("New Releases I haven't seen: " + unwatchedNewReleases);
        // unwatched action comedies
        Set<Movie> unwatchedActionComedies = helper.difference(unwatched, action_comedy);
        System.out.println("Action Comedies I haven't seen: " + unwatchedActionComedies);


        //Part 4: Create a Map to associate an int number of views along with a Movie
        Map<Movie, Integer> movieViews = new HashMap<Movie, Integer>();
        movieViews.put(m1, 2); // represents 2 views of movie m1
        movieViews.put(m2, 5);
        movieViews.put(m5, 1);

        Iterator<Movie> currMovie = unwatched.iterator();
        while (currMovie.hasNext()) {
            Movie temp = currMovie.next();
            if (temp.getYear() >= 2010) {
                unwatchedNewReleases.add(temp);
            }
        }


        //Part 5: Create a Queue (first-in, first-out) to hold a movie playlist
        Queue<Movie> playList = new LinkedList<Movie>();  //created a new Queue for LinkedList
        playList.add(m1);  // adds movies (m1) etc to the end of list
        playList.add(m3);
        playList.add(m5);
        playList.add(m2);
        playList.add(m4);
        Movie firstToPlay = playList.element();// peek at the first movie in the playList
        System.out.println("First movie in the list is: " + firstToPlay);
        playList.remove();  // removes the first movie in the playList
        playList.remove();
    }

}
