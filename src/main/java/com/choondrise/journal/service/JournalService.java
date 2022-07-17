package com.choondrise.journal.service;

import com.choondrise.journal.model.Day;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface JournalService {

    String createDay(Day day) throws ExecutionException, InterruptedException;

    Day getDay(String dayId) throws ExecutionException, InterruptedException;

    List<Day> getAllDays() throws ExecutionException, InterruptedException;
}
