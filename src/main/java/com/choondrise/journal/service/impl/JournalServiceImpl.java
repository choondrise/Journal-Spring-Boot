package com.choondrise.journal.service.impl;

import com.choondrise.journal.model.Day;
import com.choondrise.journal.repository.DayRepository;
import com.choondrise.journal.service.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class JournalServiceImpl implements JournalService {

    private DayRepository dayRepository;

    @Override
    public String createDay(Day day) throws ExecutionException, InterruptedException {
        return dayRepository.createDay(day);
    }

    @Override
    public Day getDay(String dayId) throws ExecutionException, InterruptedException {
        return dayRepository.findDayByDayId(dayId);
    }

    @Override
    public List<Day> getAllDays() throws ExecutionException, InterruptedException {
        return dayRepository.findAll();
    }
}
