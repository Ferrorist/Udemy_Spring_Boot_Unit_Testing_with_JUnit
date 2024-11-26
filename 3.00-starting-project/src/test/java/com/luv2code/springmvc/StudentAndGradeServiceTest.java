package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// 테스트 시 사용할 properties 설정 가능
@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void createStudentService() {
        studentService.createStudent("Chad", "Darby", "chad.darby@luv2code_school.com");

         CollegeStudent student = studentDao.findByEmailAddress("chad.darby@luv2code_school.com");

         Assertions.assertEquals("chad.darby@luv2code_school.com", student.getEmailAddress(), "find by email");
    }

}
