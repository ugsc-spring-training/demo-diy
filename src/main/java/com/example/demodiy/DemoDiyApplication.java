package com.example.demodiy;

import com.example.demodiy.model.Mark;
import com.example.demodiy.repository.MarkRepository;
import com.example.demodiy.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:/diy.properties")
//@ImportResource("classpath:/appContext.xml")
public class DemoDiyApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DemoDiyApplication.class);
		// set profile:
		springApplication.setAdditionalProfiles("test");
		ApplicationContext ctx = springApplication.run();

		MarkService markService= ctx.getBean(MarkService.class);
		ResultService resultService = ctx.getBean(ResultService.class);

		markService.giveMark(new Mark(Mark.Subject.ENGLISH, 4));
		markService.giveMark(new Mark(Mark.Subject.ENGLISH, 5));

		resultService.average(Mark.Subject.ENGLISH);
	}

//	@Bean
//	public MessageSender messageSender() {
//		return new MessageSender();
//	}
//
//	@Bean
//	public ParentService parentService() {
//		return new ParentService("Rodic", messageSender());
//	}
//
//	@Bean
//	public MarkRepository markRepository() {
//		return new MarkRepository();
//	}
//
//	@Bean
//	public MarkService markService() {
//		MarkService markService = new MarkService(markRepository());
//		markService.setParentService(parentService());
//		return markService;
//	}
//
//	@Bean
//	public ResultService resultService() {
//		ResultService resultService = new ResultService(markRepository());
//		resultService.setParentService(parentService());
//		return resultService;
//	}
}

//@Configuration
//class SenderConfig {
//
//	@Bean
//	@Profile("prod")
//	public IMessageSender iMessageSender() {
//		return new RealMessageSender();
//		}
//	}

