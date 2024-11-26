package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

// 테스트 시 사용할 properties 설정 가능
@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private JdbcTemplate jdbc;

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

    @Test
    public void isStudentNullCheck() {
        Assertions.assertTrue(studentService.checkIfStudentIsNull(1));
        Assertions.assertFalse(studentService.checkIfStudentIsNull(0));
    }

    @BeforeEach
    public void setUpDatabase() {
        jdbc.execute(
                "insert into student(id, firstname, lastname, email_address) values (1, 'Eric', 'Roby', 'eric.roby@luv2code_school.com')");
    }

    @Test
    public void deleteStudentService() {
        Optional<CollegeStudent> deletedCollegeStudent = studentDao.findById(1);
        Assertions.assertTrue(deletedCollegeStudent.isPresent(), "Return True");

        studentService.deleteStudent(1);

        deletedCollegeStudent = studentDao.findById(1);
        Assertions.assertFalse(deletedCollegeStudent.isPresent(), "Return false");
    }

    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("delete from student");
    }
}
