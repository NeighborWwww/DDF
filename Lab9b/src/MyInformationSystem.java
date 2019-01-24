import java.util.ArrayList;

public class MyInformationSystem <T> {
	private ArrayList<Pair> myList;
	public MyInformationSystem() {
		myList = new ArrayList<Pair>();
	}
	private class Pair{
		private T value;
		private String key;
		
		public Pair(T v,String k){
			value = v;
			key = k;
		}

		public boolean keyMatches(String k){		
			if (key==k)
				return true;
			return false;
		}
	}
	public void insert (T v, String key){
		myList.add(new Pair(v, key));
	}
	public T retrieve (String k) {
		for (int i = 0; i<myList.size(); i++) {
			if (myList.get(i).keyMatches(k)) {
				return myList.get(i).value;
			}
		}
		return null;
	}
	
	public static void main(String a[]){
		System.out.println("*****Testing with String values! *****");
		String result;
		String keyList[] = {"126", "536", "428", "245"};
		MyInformationSystem<String> nameStudentNumberList;
		nameStudentNumberList = new MyInformationSystem<String>();
		nameStudentNumberList.insert("John", "245");// John has
		// student number 245
		nameStudentNumberList.insert("Tom", "126");
		nameStudentNumberList.insert("Mary", "536");
		nameStudentNumberList.insert("Mark", "821");
		for (int i = 0; i < keyList.length; i++){
			result = nameStudentNumberList.retrieve(keyList[i]);
			if (result != null){
				System.out.println("For key " + keyList[i] +
						" the matching value is " + result);
			}else{
				System.out.println("No Match with " + keyList[i]);
			}
		}

		System.out.println("*****Testing with Integer values! *****");
		Integer resultValue;
		MyInformationSystem<Integer> numberNumberList;
		numberNumberList = new MyInformationSystem<Integer>();
		numberNumberList.insert(542, "245"); //mapping key 245 to value 542
		numberNumberList.insert(621, "126");
		numberNumberList.insert(635, "536");
		numberNumberList.insert(128, "821");
		for (int i = 0; i < keyList.length; i++){
			resultValue = numberNumberList.retrieve(keyList[i]);
			if (resultValue != null){
				System.out.println("For key " + keyList[i] +
						" the matching value is " + resultValue);
			}else{
				System.out.println("No Match with " + keyList[i]);
			}
		}
	}


}
