public class Student extends Person {
	
	private String major;

	public Student(String fullName, String major) {
		super(fullName);
		this.major = new String(major);
		
	}

	//@Override
	public double getSalary() {
		
		return 0.0;
	}
	
	public String toString(){
		
		return super.toString() + "\nMajor: " + major + "\n";
		
	}

	@Override
	public boolean lessThan(Sortable a) {
		Person taker = (Person) a;
		return this.getPersonName().lessThan(taker.getPersonName());
		
	}

	@Override
	public boolean fatCat() {
		return false;
	}

	@Override
	public int Prior() {
		
		return 0;
	}

	
	


}