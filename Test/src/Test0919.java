class TestTest{
	private String text;
	public TestTest(String s) {
		this.text = s;
	}
}
public class Test0919 {

	public static void main(String[] args) {
		TestTest test = new TestTest("ABC");
		System.out.println(test.text.toLowerCase());

	}

}
