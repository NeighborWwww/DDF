import java.util.ArrayList;

public class MyInformationSystem <T> {
	ArrayList<Pair> myList;
	private class Pair{
		private T value;
		private String key;
		
		public Pair(T v,String k){
			value = v;
			key = k;
		}
		public Pair(){
			value = null;
			key = null;
		}
		public boolean keyMatches(String k){		
			if (key==k)
				return true;
			return false;
		}
	}
	
	public MyInformationSystem(){
		ArrayList<Pair> myList  = new ArrayList<Pair>();
	}
	public void insert (T v, String key){
		myList.add(new Pair(v, key));
	}
}
