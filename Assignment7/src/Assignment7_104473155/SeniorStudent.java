public class SeniorStudent extends CanadianStudent {

	private double pension;
	
	public SeniorStudent(String studentName, int numberOfCoursesTaken, double pension) {
		super(studentName, numberOfCoursesTaken);
		this.pension = pension;
	}

	@Override
	public double computeFees() {
		return 50.0;
	}

	@Override
	public boolean lessThan(Sortable anotherStudent) {
		
		if(anotherStudent instanceof SeniorStudent) {
			return studentName.compareTo(((SeniorStudent) anotherStudent).studentName) < 0;
		} else {
			return true;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", senior citizen who gets pension $" + pension;
	}
	
	
	
}