package com.thymeleaf.thymeleaf.presentation;

import com.thymeleaf.thymeleaf.logic.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class ButtonsController {


    @GetMapping("/searchResults")
    public String showResults(@RequestParam(required = false) String title, Model model){
        List<Movie> movies = getMoviesByTitle(title);
        model.addAttribute("movies", movies);
        model.addAttribute("searchRequest", new SearchRequest());
        return "searchResults";
    }

    private List<Movie> getMoviesByTitle(String title) {
        return Arrays.asList(new Movie("Batman", "action", "1998"), new Movie("Terminator", "action", "1997"));
    }
}
