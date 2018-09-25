package com.example.demodiy.repository;

import com.example.demodiy.model.Mark;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MarkRepository {
    private Map<Mark.Subject, List<Integer>> markMap = new HashMap<>();

    public void save(Mark mark) {
        List<Integer> marks = markMap.get(mark.getSubject());
        if (marks == null) {
            marks = new ArrayList<>();
            markMap.put(mark.getSubject(), marks);
        }
        marks.add(mark.getMark());
    }

    public List<Integer> findBySubject(Mark.Subject subject) {
        return markMap.entrySet().stream()
                .filter(x -> x.getKey() == subject)
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
