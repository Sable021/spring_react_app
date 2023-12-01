package spring.react.jugtours;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.react.jugtours.model.Event;
import spring.react.jugtours.model.Group;
import spring.react.jugtours.model.GroupRepository;

@Component
class Initialiser implements CommandLineRunner {
    private final GroupRepository repository;

    public Initialiser(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Seattle JUG", "Denver JUG", "Dublin JUG", "London JUG")
                .forEach(name -> repository.save(new Group(name)));

        Group djug = repository.findByName("Seattle JUG");
        Event e = Event.builder().title("Micro Frontends for Java Developers")
                .description("JHipster now has microfrontend support!").date(Instant.parse("2022-09-13T17:00:00Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}
