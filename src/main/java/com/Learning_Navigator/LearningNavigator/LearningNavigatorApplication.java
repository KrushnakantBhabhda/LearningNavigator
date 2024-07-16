package com.Learning_Navigator.LearningNavigator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.Learning_Navigator.LearningNavigator.Services.ExamService;
import com.Learning_Navigator.LearningNavigator.Services.ExamServiceimpl;
import com.Learning_Navigator.LearningNavigator.Services.StudentService;
import com.Learning_Navigator.LearningNavigator.Services.StudentServiceimpl;
import com.Learning_Navigator.LearningNavigator.Services.SubjectService;
import com.Learning_Navigator.LearningNavigator.Services.SubjectServiceimpl;

@SpringBootApplication
public class LearningNavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningNavigatorApplication.class, args);
	}

	  @Bean
    public ExamService examService() {
        return new ExamServiceimpl();
    }
	@Bean
    public StudentService studentServiceService() {
        return new StudentServiceimpl();
    }
	@Bean
    public SubjectService subjectServiceService() {
        return new SubjectServiceimpl();
    }

	  @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
