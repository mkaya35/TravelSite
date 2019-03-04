
public class OgrApp {

	public static void main(String[] args) {
		
	//	Ogr O1=new Ogr

		MathStudent o1=new MathStudent();
		o1.iD=111;
		o1.name="tim";
		
		
		
		Ogr o2=new MathStudent();
		Ogr o3=new ScienceStudent();
		
		o1.tellDept();
		o2.tellDept();
		o3.tellDept();
		
		((MathStudent) o2).multiply();
		
		o2.tellName();
		o3.tellName();
		
		((MathStudent) o2).compute();
		
		((ScienceStudent) o3).safety();
		
		
		
		
		
			
		
	}

}
