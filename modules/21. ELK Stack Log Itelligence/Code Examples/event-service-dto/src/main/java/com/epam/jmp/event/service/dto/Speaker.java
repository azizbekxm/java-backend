package com.epam.jmp.event.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Objects;

@NoArgsConstructor
@Document(collection = "speakers")
public class Speaker {

    @Id
    @Setter
    @Getter
    private BigInteger id;

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    private String lastName;

    @Indexed(unique = true)
    private Email email;

    /**
     * Creates a new {@link Speaker} from the given firstName, lastName and email.
     *
     * @param firstName must not be {@literal null} or empty.
     * @param lastName  must not be {@literal null} or empty.
     */
    public Speaker(String firstName, String lastName, Email email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return firstName.equals(speaker.firstName) &&
                lastName.equals(speaker.lastName) &&
                email.equals(speaker.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}