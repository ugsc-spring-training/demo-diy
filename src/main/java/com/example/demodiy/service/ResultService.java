package com.example.demodiy.service;

import com.example.demodiy.model.Mark;
import com.example.demodiy.repository.MarkRepository;

import java.util.List;
import java.util.OptionalDouble;

public class ResultService {
    private final MarkRepository markRepository;

    private ParentService parentService;

    public ResultService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    public void average(Mark.Subject subject) {
        List<Integer> marks = markRepository.findBySubject(subject);

        OptionalDouble average = marks.stream().mapToDouble(m -> m).average();

        if (average.isPresent() && (int)average.getAsDouble() > 3 && parentService != null) {
            parentService.notify(new Mark(subject, (int)average.getAsDouble()));
        }
    }
}
