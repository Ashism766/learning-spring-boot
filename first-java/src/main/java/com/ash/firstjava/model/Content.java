package com.ash.firstjava.model;

import java.time.LocalDateTime;

public class Content {
    public Integer id;
    public String title;
    public String desc;
    public Status status;
    public Type contentType;
    public LocalDateTime dateCreated;
    public  LocalDateTime dateUpdated;


    public Content(Integer id, String title, String desc, Status s, Type t, LocalDateTime c, LocalDateTime u){
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = s;
        this.contentType = t;
        this.dateCreated = c;
        this.dateUpdated = u;
    }

}
