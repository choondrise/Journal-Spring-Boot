package com.choondrise.journal.repository.impl;

import com.choondrise.journal.model.Day;
import com.choondrise.journal.repository.DayRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
@AllArgsConstructor
public class DayRepositoryImpl implements DayRepository {

    private Firestore firestore;

    @Override
    public Day findDayByDayId(String dayId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore.collection("day").document(dayId);
        ApiFuture<DocumentSnapshot> getDay = documentReference.get();

        if (getDay.get().exists()) {
            return getDay.get().toObject(Day.class);
        }

        return null;
    }

    @Override
    public List<Day> findAll() throws ExecutionException, InterruptedException {
        List<Day> allDays = new ArrayList<>();
        for (DocumentReference documentReference : firestore.collection("day").listDocuments()) {
            if (documentReference.get().get().exists()) {
                allDays.add(documentReference.get().get().toObject(Day.class));
            }
        }

        return allDays;
    }

    @Override
    public String createDay(Day day) throws ExecutionException, InterruptedException {
        CollectionReference collectionReference = firestore.collection("day");
        ApiFuture<WriteResult> createDay = collectionReference.document(day.getDayId()).set(day);
        return createDay.get().getUpdateTime().toString();
    }
}
