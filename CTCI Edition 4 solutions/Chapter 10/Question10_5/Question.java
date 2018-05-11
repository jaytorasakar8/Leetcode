package Question10_5;

public class Question {

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Square s1 = new Square(randomInt(5), randomInt(5), randomInt(4) + 1);
			Square s2 = new Square(randomInt(5), randomInt(5), randomInt(4) + 1);
			System.out.println("Square: " + s1.toString());
			System.out.println("Square: " + s2.toString());
			Line line = s1.cut(s2);
			System.out.println(line.toString());
		}
	}

}
