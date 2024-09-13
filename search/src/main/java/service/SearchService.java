package service;

import com.example.search.dto.StudentDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class SearchService {
    @Value("${university.url}")
    private String url;
    private final RestTemplate restTemplate;

    @Autowired
    public SearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackGetData")
    public CompletableFuture<ResponseEntity<GeneralResponse>> getSearchResults() throws ExecutionException, InterruptedException {

        // Call the university service asynchronously (returning a list of students)
        CompletableFuture<List<StudentDTO>> universityFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject("http://students", List.class)  // Assuming this is the endpoint for fetching students
        );

        // Call the details service asynchronously
        CompletableFuture<String> detailsFuture = CompletableFuture.supplyAsync(() ->
                restTemplate.getForObject("http://details/port", String.class)
        );

        CompletableFuture<GeneralResponse> combinedFuture = universityFuture.thenCombine(detailsFuture, (studentDTOList, detailsResult) -> {
            // Create GeneralResponse
            GeneralResponse response = new GeneralResponse();
            response.setCode(200); // Example code
            response.setTimestamp(LocalDateTime.now());
            response.setDetails(detailsResult);  // Add details if necessary
            response.setStudentDTOList(studentDTOList);  // Add list of StudentDTOs directly

            return response;
        });
        return combinedFuture.thenApply(response ->ResponseEntity.ok(response));
    }




}
