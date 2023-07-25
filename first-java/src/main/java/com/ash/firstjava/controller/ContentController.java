package com.ash.firstjava.controller;

import com.ash.firstjava.model.Content;
import com.ash.firstjava.model.Status;
import com.ash.firstjava.model.Type;
import com.ash.firstjava.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentCollectionRepository repository;

    @Autowired
  public ContentController(ContentCollectionRepository contentRepository){
      this.repository = contentRepository;
  }


  // Get request for getting all the content
    @GetMapping("")
    public List<Content> getAll(){
        return this.repository.findAll();
    }

    // Create Read Update Delete

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "content Not found"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Validated @RequestBody Content content)
    {
        Content c = new Content(content.id, content.title, content.desc, content.status, content.contentType, content.dateCreated, content.dateUpdated);
        System.out.println(content.id);
        System.out.println(c);
        repository.save(c);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id)
    {
        if(repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "content not found");
        }
        Content c = new Content(content.id, content.title, content.desc, content.status, content.contentType, content.dateCreated, content.dateUpdated);

        repository.save(c);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id)
    {
        if(repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "content not found");
        }
        // Do Something
    }


}
