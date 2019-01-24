public class University {

	private Student[] listOfStudents;
	private int totalStudents = 0;
	private final int maximumNumberOfStudents;
	
	public University(int maximumNumberOfStudents) {
		this.maximumNumberOfStudents = maximumNumberOfStudents;
		listOfStudents = new Student[maximumNumberOfStudents];
	}
	
	public boolean insertStudent(Student aStudent) {
		
		// Safeguard
		if(totalStudents >= maximumNumberOfStudents) {
			return false;
		}
		
		listOfStudents[totalStudents] = aStudent;
		totalStudents++;
		
		return true;
	}
	
	public int numberOfStudents(String nameOfCountry) {
		int total = 0;
		
		for(int i = 0; i < totalStudents; i++) {
			if(listOfStudents[i].findCountry().equals(nameOfCountry)) {
				total++;
			}
		}
		
		return total;
	}
	
	public String toString() {
		String desc = "";
		
		desc += "Number of students in university = " + totalStudents + "\n";
		
		for(int i = 0; i < totalStudents; i++) {
			desc += listOfStudents[i].toString() + "\n";
		}
		
		return desc;
	}
	
	public void sortStudents(boolean dec) {
		Sort.setDescending(dec);
		Sort.sortAnything(listOfStudents, totalStudents);
	}
	
}