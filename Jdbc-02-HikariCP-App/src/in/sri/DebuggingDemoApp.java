package in.sri;

public class DebuggingDemoApp {
	public static void main(String[] args) {
		DebuggingDemoApp app = new DebuggingDemoApp();
		int sum = app.add(2, 3);
		System.out.println(sum);
	}

	public int add(int a, int b) {
		int sum=a + b;
		return sum;
	}
}
