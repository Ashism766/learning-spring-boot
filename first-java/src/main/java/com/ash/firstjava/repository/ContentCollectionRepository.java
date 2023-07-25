package com.ash.firstjava.repository;


import com.ash.firstjava.model.Content;
import com.ash.firstjava.model.Status;
import com.ash.firstjava.model.Type;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private  final List<Content> content = new ArrayList<>();

    public  ContentCollectionRepository(){}

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id)
    {
        return content.stream().filter(c -> c.id.equals(id)).findFirst();
    }
    public void save(Content c)
    {
        content.add(c);
    }


    @PostConstruct
    private void init(){
        Content c = new Content(1, "My first Post", "this is the description", Status.IDEA, Type.ARTICLE, LocalDateTime.now(),null );
        content.add(c);
    }

    public boolean existsById(Integer id) {
        return content.stream().filter(c->c.id.equals(id)).count() == 1;

    }
}
