package controller;

import com.example.search.service.GeneralResponse;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/weather/search")
    public ResponseEntity<?> getDetails() {
        try{
            ResponseEntity<GeneralResponse> response =  searchService.getSearchResults().get();
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error at Controller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
