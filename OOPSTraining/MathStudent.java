
public class MathStudent extends Ogr implements Computer {
	
	
	
	
	public MathStudent() {
		super();
		
	}
	
	public void multiply() {
		
		System.out.println("I can multiply");
		
	}

	@Override
	public void tellDept() {
	System.out.println("My department MathStudent");
	}

	@Override
	public void tellName() {
		System.out.println("My name is Math department");
		
	}

	@Override
	public void compute() {
	System.out.println("MAthsudent using computer");
		
	}

	@Override
	public void excel() {
		// TODO Auto-generated method stub
		
	}
	
	

}
