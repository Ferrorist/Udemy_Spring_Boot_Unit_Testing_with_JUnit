package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.models.HistoryGrade;
import com.luv2code.springmvc.models.MathGrade;
import com.luv2code.springmvc.models.ScienceGrade;
import com.luv2code.springmvc.repository.HistoryGradesDao;
import com.luv2code.springmvc.repository.MathGradesDao;
import com.luv2code.springmvc.repository.ScienceGradesDao;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

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

    @Autowired
    private MathGradesDao mathGradeDao;

    @Autowired
    private ScienceGradesDao scienceGradeDao;

    @Autowired
    private HistoryGradesDao historyGradeDao;

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

    @Sql("/insertData.sql") // BeforeEach가 먼저 실행되고 이후 @Sql이 실행됨.
    @Test
    public void getGradebookService() {
        Iterable<CollegeStudent> iterableCollegeStudents = studentService.getGradebook();

        List<CollegeStudent> collegeStudents = new ArrayList<>();

        for (CollegeStudent collegeStudent : iterableCollegeStudents) {
            collegeStudents.add(collegeStudent);
        }

        Assertions.assertEquals(6, collegeStudents.size());
    }

    @Test
    public void createGradeService() {

        //Create the grade
        Assertions.assertTrue(studentService.createGrade(80.50, 1, "math"));
        Assertions.assertTrue(studentService.createGrade(80.50, 1, "science"));
        Assertions.assertTrue(studentService.createGrade(80.50, 1, "history"));

        // Get all grades with studentId
        Iterable<MathGrade> mathGrades = mathGradeDao.findGradeByStudentId(1);
        Iterable<ScienceGrade> scienceGrades = scienceGradeDao.findGradeByStudentId(1);
        Iterable<HistoryGrade> historyGrades = historyGradeDao.findGradeByStudentId(1);


        // Verify there is grades
        Assertions.assertTrue(mathGrades.iterator().hasNext(), "Student has math grades");
        Assertions.assertTrue(scienceGrades.iterator().hasNext(), "Student has science grades");
        Assertions.assertTrue(historyGrades.iterator().hasNext(), "Student has history grades");
    }

    @Test
    public void createGradeServiceReturnFalse() {
        Assertions.assertFalse(studentService.createGrade(105, 1, "math"));
        Assertions.assertFalse(studentService.createGrade(-5, 1, "math"));

        Assertions.assertFalse(studentService.createGrade(80.50, 2, "math"));

        Assertions.assertFalse(studentService.createGrade(80.50, 1, "literature"));
    }

    @AfterEach
    public void setupAfterTransaction() {
        jdbc.execute("delete from student");
    }
}
