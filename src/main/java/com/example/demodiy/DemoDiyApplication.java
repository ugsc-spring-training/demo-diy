package com.example.demodiy;

import com.example.demodiy.model.Mark;
import com.example.demodiy.repository.MarkRepository;
import com.example.demodiy.service.*;

public class DemoDiyApplication {

	public static void main(String[] args) {
		IMessageSender messageSender = new MessageSender();
		ParentService parentService = new ParentService("Red Forman", messageSender);

		MarkRepository markRepository = new MarkRepository();

		MarkService markService = new MarkService(markRepository);
		markService.setParentService(parentService);

		markService.giveMark(new Mark(Mark.Subject.ENGLISH, 4));
		markService.giveMark(new Mark(Mark.Subject.ENGLISH, 5));

		ResultService resultService = new ResultService(markRepository);
		resultService.setParentService(parentService);

		resultService.average(Mark.Subject.ENGLISH);
	}
}
