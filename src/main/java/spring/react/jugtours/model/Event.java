package spring.react.jugtours.model;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Event {
    @Id
    @Setter(AccessLevel.NONE)
    private Long id;

    private Instant date;

    private String title;

    private String description;

    private Set<User> attendees;
}
