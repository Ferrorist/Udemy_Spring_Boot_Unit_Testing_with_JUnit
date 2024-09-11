package pdm.studyjunit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pdm.studyjunit.Utils.DemoUtils;

@SpringBootTest
// @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
class ApplicationTests {

	DemoUtils demoUtils;

	@BeforeEach
	void setUp() {
		demoUtils = new DemoUtils();
	}

	@Test
	@DisplayName("Equals And Not Equals")
	void testEqualsAndNotEquals() {
		assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
		assertNotEquals(8, demoUtils.add(2, 4), "2+4 must be not 8");
	}

	@Test
	@DisplayName("Null and Not Null")
	void testNullAndNotNull() {
		String str1 = null;
		String str2 = "luv2code";

		assertNull(demoUtils.checkNull(str1), "Object should be null");
		assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
	}


	@Test
	@DisplayName("Same and Not Same")
	void testSameAndNotSame() {
		String str = "luv2code";

		assertSame(
			demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(),
			"Objects should refer to same object");

		assertNotSame(str, demoUtils.getAcademy(),
			"Objects should not refer to same object");
	}


	@Test
	@DisplayName("True and False")
	void testTrueFalse() {
		int gradeOne = 10;
		int gradeTwo = 5;

		assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
		assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
	}


	@Test
	@DisplayName("Array Equals")
	void testArrayEquals() {
		String[] stringArray = {"A", "B", "C"};
		assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(),
			"Arrays should be the same");
	}


	@Test
	@DisplayName("Iterable equals")
	void testIterableEquals() {
		List<String> list = List.of("luv", "2", "code");
		assertIterableEquals(list, demoUtils.getAcademyInList(),
			"Expected list should be same as actual list");
	}

	@Test
	@DisplayName("Lines Match")
	void testLinesMatch() {
		List<String> list = List.of("luv", "2", "code");

		assertLinesMatch(list, demoUtils.getAcademyInList(),
			"Lines should match");
	}

	@Test
	@DisplayName("Throws and Does Not Throw")
	void testThrowsAndDoesNotThrow() {
		assertThrows(Exception.class, () -> demoUtils.throwException(-1) ,
			"Should throw exception");
		assertDoesNotThrow(() -> demoUtils.throwException(1),
			"Should not throw exception");
	}


	// @BeforeAll
	// static void beforeAll() {
	// 	System.out.println("@BeforeAll print!");
	// }
	//
	// @AfterEach
	// void tearDown() {
	// 	System.out.println("@AfterEach print!");
	// }
	//
	// @AfterAll
	// static void afterAll() {
	// 	System.out.println("@AfterAll print!");
	// }
}
