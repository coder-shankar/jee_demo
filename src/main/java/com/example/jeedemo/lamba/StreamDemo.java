package com.example.jeedemo.lamba;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class StreamDemo {

    @Test
    @SneakyThrows
    public void mapDemo() {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/java/com/example/jeedemo/lamba"
            + "/movies.json"));
        Movie[] movies = new Gson().fromJson(bufferedReader, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);
    // print all movies name
//    movieList.parallelStream().map(movie -> movie.getTitle()).forEach(System.out::println);

    //filter out all the movies before 2010
//        movieList.parallelStream().filter(movie -> Integer.parseInt(movie.getYear())>2010).map(movie -> movie.getYear()).forEach(System.out::println);

        //filter out movies in 2018
        movieList.parallelStream().filter(movie -> Integer.parseInt(movie.getYear())==2018).map(movie -> movie.getTitle()).forEach(System.out::println);

    }
}
