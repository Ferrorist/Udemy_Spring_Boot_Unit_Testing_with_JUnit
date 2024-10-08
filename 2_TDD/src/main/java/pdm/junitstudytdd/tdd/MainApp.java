package pdm.junitstudytdd.tdd;

public class MainApp {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 100; i++) {
			sb.append(FizzBuzz.compute(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
