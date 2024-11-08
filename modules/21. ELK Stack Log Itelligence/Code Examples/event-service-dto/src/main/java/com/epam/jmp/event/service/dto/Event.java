package com.epam.jmp.event.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Document(collection = "events")
public class Event {

    @Id
    @Setter
    @Getter
    private BigInteger id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private Address address;

    @Getter
    @Setter
    @Field("type")
    private EventType eventType;

    @Getter
    @Setter
    @DBRef
    private Speaker speaker;

    @Getter
    @Setter
    @Field("date")
    private LocalDateTime dateTime;

    public Event(String title,
                 Address address,
                 Speaker speaker,
                 EventType eventType,
                 LocalDateTime dateTime) {
        this.title = title;
        this.address = address;
        this.speaker = speaker;
        this.eventType = eventType;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return title.equals(event.title) &&
                address.equals(event.address) &&
                eventType == event.eventType &&
                speaker.equals(event.speaker) &&
                dateTime.equals(event.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address, eventType, speaker, dateTime);
    }
}
