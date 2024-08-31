package pdm.studyjunit.Utils;

import java.util.List;

public class DemoUtils {
	private String academy = "Luv2Code Academy";
	private String academyDuplicate = academy;
	private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
	private List<String> academyInList = List.of("luv", "2", "code");

	public String getAcademy() {
		return academy;
	}

	public String getAcademyDuplicate() {
		return academyDuplicate;
	}

	public String[] getFirstThreeLettersOfAlphabet() {
		return firstThreeLettersOfAlphabet;
	}

	public List<String> getAcademyInList() {
		return academyInList;
	}

	public int add(int a, int b) {return a + b;}

	public int multiply(int a, int b) {return a * b;}

	public Object checkNull(Object obj){
		if(obj != null){
			return obj;
		}
		return null;
	}

	public Boolean isGreater(int n1, int n2) {
		if(n1 > n2)	return true;
		return false;
	}
}