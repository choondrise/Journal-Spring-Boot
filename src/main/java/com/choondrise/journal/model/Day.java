package com.choondrise.journal.model;

import com.choondrise.journal.config.DayId;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Day {

    @DayId
    private String dayId;

    private double rating;
    private String start;
    private String end;
    private String events;
    private int spent;
    // TODO: create enumeration
    private String type;

}
