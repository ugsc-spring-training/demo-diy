package com.example.demodiy.service;

import com.example.demodiy.model.Mark;
import com.example.demodiy.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    private final MarkRepository markRepository;
    private ParentService parentService;

    @Autowired
    public void setParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public void giveMark(Mark mark) {

        if (parentService != null && mark.getMark() > 3) {
            parentService.notify(mark);
        }

        markRepository.save(mark);
    }
}
