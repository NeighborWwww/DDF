public class Household {
  private Person[] householdMembers;
  private int totalMember = 0;
  private int maxMember;



  public Household(){
    householdMembers = new Person [10];
    maxMember = 10;

  }
  public Household(int num){
    householdMembers = new Person [num];
    maxMember = num;

  }

  public boolean insertNewHouseholdMember(Person a){
    if (totalMember < maxMember){
      householdMembers[totalMember] = a;
      totalMember++;
    }
    else{
      return false;
    }
    return true;

  }
  public String toString (){
    String re = "";
    for (int i = 0; i<totalMember; i++){
      re += householdMembers [i].toString()+"\n";
    }
    return re;

  }
  public String sortHouseholdMembers() {
	  Sortable temp;
	  int indexsmall, indexA, indexB;
	  for (indexA = 0 ; indexA<totalMember-1 ; indexA++) {
		  indexsmall = indexA;
		  for (indexB = indexA +1; indexB < totalMember; indexB ++) {
			  if(householdMembers[indexB].lessThan(householdMembers[indexsmall])) {
				  indexsmall = indexB;
				  
			  }
		  }
		  temp = householdMembers[indexA];
		  householdMembers[indexA] = householdMembers[indexsmall];
		  householdMembers[indexsmall] = (Person) temp;
		  
	  }
	  return toString();
	  
	  
  }
  public int findNumberOfFatCats() {
	  
	  int count = 0;
	  for (int i = 0; i < totalMember; i++) {
		  if (householdMembers[i].fatCat())
			  count++;
		  
	  }
	  return count;
  }
}