package spring.react.jugtours.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "user_group")
public class Group {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @NonNull
    private String name;

    private String address;

    private String city;

    private String stateOrProvince;

    private String country;

    private String postalCode;

    private Set<Event> events;
}
