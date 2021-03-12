# javaSpringBootPratice
A java maven pratice Project created by following https://www.youtube.com/watch?v=vtPkZShrvXQ&amp;t=1178s

TO DO:
- yet to pack into docker runnable image
- docker-compose running postgres and make the configration read from environment variable is not yet complete.


HOW TO USE:
- using intelliJ IDE
- postman collection is named as javaTesting.postman_collection, this can make it simply test it out, the application will running on localhost:8080 as default
- build the docker image `docker build -t pratice-app .`
- running docker image `docker run -p 8085:8080 pratice-app`
- the postgres structure, database: demodb, 

```
Table "public.person"
 Column |          Type          | Collation | Nullable | Default 
--------+------------------------+-----------+----------+---------
 id     | uuid                   |           | not null | 
 name   | character varying(100) |           | not null | 
```

