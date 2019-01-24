import java.util.StringTokenizer;
public class Name implements Sortable{

	private String firstName = "";
	private String middleName = "";
	private String lastName = "";

	public Name(String inputName){
		StringTokenizer splitName = new StringTokenizer(inputName);
		int numTokens = splitName.countTokens();

		firstName = splitName.nextToken();
		if(numTokens == 3){
			middleName = splitName.nextToken();
		}
		else{
			middleName = null;
		}
		lastName = splitName.nextToken();
	}
	
	public Name(Name nameCopy){
		this.firstName = nameCopy.firstName;
		this.middleName = nameCopy.middleName;
		this.lastName = nameCopy.lastName;
	}
	
	public void setName(String newFirstName, String newMiddleName, String newLastName){
		this.firstName = newFirstName;
		this.middleName = newMiddleName;
		this.lastName = newLastName;	
	}

	public String toString(){
		if(middleName != null){
			return (lastName +", " + firstName + " " + middleName.charAt(0) + ".");
		}
		else
			return (lastName +", " + firstName);
	}

	@Override
	public boolean lessThan(Sortable a) {
		Name temp;
		temp = (Name) a;
		if (this.lastName.compareTo(temp.lastName)<0) {
			return true;
			
		}
		if (this.lastName.compareTo(temp.lastName)==0) {
			if (this.firstName.compareTo(temp.firstName)<0) {
				return true;
			}
		}
		
		return false;
	}

	


	
}