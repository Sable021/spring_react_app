package spring.react.jugtours;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.react.jugtours.model.Event;
import spring.react.jugtours.model.Group;
import spring.react.jugtours.repositories.GroupMongoRepository;

@Component
class Initialiser implements CommandLineRunner {
    private final GroupMongoRepository repository;

    public Initialiser(GroupMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Seattle JUG", "Denver JUG", "Dublin JUG", "London JUG")
                .forEach(name -> repository.save(new Group(name)));

        Group djug = repository.findByName("Seattle JUG");
        Event e = Event.builder().id(1L)
                .title("Micro Frontends for Java Developers")
                .description("JHipster now has microfrontend support!").date(Instant.parse("2022-09-13T17:00:00Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        Group ldjug = repository.findByName("London JUG");
        Event el = Event.builder().id(1L).title("Spring One")
                .description("Some description").date(Instant.parse("2023-02-23T15:00:00Z")).build();
        ldjug.setEvents((Collections.singleton(el)));
        repository.save(ldjug);

        repository.findAll().forEach(System.out::println);
    }
}
