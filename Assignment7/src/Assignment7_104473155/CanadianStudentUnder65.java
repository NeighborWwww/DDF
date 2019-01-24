public class CanadianStudentUnder65 extends CanadianStudent {

	public CanadianStudentUnder65(String studentName, int numberOfCoursesTaken) {
		super(studentName, numberOfCoursesTaken);
	}
	
	public CanadianStudentUnder65(String studentName) {
		this(studentName, 5);
	}

	@Override
	public double computeFees() {
		if(numberOfCoursesTaken >= 4) {
			return 800.0;
		} else {
			return numberOfCoursesTaken * 200.0;
		}
	}

	@Override
	public boolean lessThan(Sortable anotherStudent) {
		if(anotherStudent instanceof ForeignStudent || anotherStudent instanceof SeniorStudent) {
			return false;
		} else if(anotherStudent instanceof CanadianStudentUnder65) {
			return studentName.compareTo(((CanadianStudentUnder65) anotherStudent).studentName) < 0;
		} else {
			return true;
		}
	}
	
}