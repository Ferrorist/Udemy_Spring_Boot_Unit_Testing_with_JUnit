package pdm.junitstudytdd.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

	// If number is divisible by 3, print Fizz
	@Test
	@DisplayName("Divisible by Three")
	@Order(1)
	void testForDivisibleByThree() {
		String expected = "Fizz";

		assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
	}

	// If number is divisible by 5, print Buzz
	@Test
	@DisplayName("Divisible by Five")
	@Order(2)
	void testForDivisibleByFive() {
		String expected = "Buzz";

		assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
	}

	// If number is divisible by 3 and 5, print FizzBuzz
	@Test
	@DisplayName("Divisible by Three and Five")
	@Order(3)
	void testForDivisibleByThreeAndFive() {
		String expected = "FizzBuzz";

		assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
	}

	// If number is NOT divisible by 3 or 5, then print the number
	@Test
	@DisplayName("NOT Divisible by Three or Five")
	@Order(4)
	void testForNotDivisibleByThreeOrFive() {
		String expected = "4";

		assertEquals(expected, FizzBuzz.compute(4), "Should return 4");
	}

}
