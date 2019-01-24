public abstract class Person implements Sortable, HighIncome{
	private Name personName;
	private Person spouse;

	public Person(String fullName){
		personName = new Name(fullName);
	}

	public void setSpouse(Person spouse){
		this.spouse = spouse;		
	}
	
	public Name getPersonName(){
		return new Name(personName);
	}
	
	public Name getSpouseName(){
		return new Name(spouse.personName);
	}
	
	public double getFamilyIncome(){
		
		return this.getSalary() + spouse.getSalary();
	}

	public String toString(){
		if(spouse != null){
			return "Name is " + getPersonName() + "\nMarried to " + getSpouseName();
		}
		else
			return "Name is " + getPersonName();
	}
	
	public abstract double getSalary();
	public boolean lessThan(Sortable a) {
		Person taker = (Person) a;
		return this.getPersonName().lessThan(taker.getPersonName());
		
		
	}
	public boolean fatCat() {
		if (this.getSalary()>3000) {
			return true;
		}
		return false;
		
	}
}