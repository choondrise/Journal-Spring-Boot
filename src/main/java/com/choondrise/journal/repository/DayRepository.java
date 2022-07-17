package com.choondrise.journal.repository;

import com.choondrise.journal.model.Day;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DayRepository {

    Day findDayByDayId(String dayId) throws ExecutionException, InterruptedException;

    List<Day> findAll() throws ExecutionException, InterruptedException;

    String createDay(Day day) throws ExecutionException, InterruptedException;

}
