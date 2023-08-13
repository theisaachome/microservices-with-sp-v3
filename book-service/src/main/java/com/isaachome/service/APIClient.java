package com.isaachome.service;

import com.isaachome.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AUTHOR-SERVICE")
public interface APIClient {
    // build get Author rest api
    @GetMapping("api/authors/{id}")
    AuthorDTO getAuthor(@PathVariable("id")long author_id);
}
