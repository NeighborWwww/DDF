public class NewWorker extends Person{
	private static int howManyWorkers;
	private int workerNumber;
	private MyDate dateJoiningCompany;
	private double salary;
	private NewWorker supervisor;


	public NewWorker(String nameOfWorker, String joiningDate, double workerSalary){
		super(nameOfWorker);
		this.dateJoiningCompany = new MyDate(joiningDate);
		this.salary = workerSalary;
		howManyWorkers++;
		this.workerNumber = howManyWorkers;
	}

	public NewWorker(String nameOfWorker, String joiningDate){
		super(nameOfWorker);
		this.dateJoiningCompany = new MyDate(joiningDate);
		this.salary = 0;
		howManyWorkers++;
		this.workerNumber = howManyWorkers;
	}

	public void setSalary(double setWorkerSalary){
		this.salary = setWorkerSalary;
	    
	}

	public double getSalary(){
		return salary;
	}

	public void setSupervisor(NewWorker setWorkerSupervisor){
	this.supervisor = setWorkerSupervisor;
	}

	public static int getHowManyWorkers(){
		return howManyWorkers;
	}
	
	public Name getSupervisor(){
		return new Name(supervisor.getPersonName());
	}

	public String toString(){ 
		if(this.supervisor!= null){
			return("Worker Number " + workerNumber + "\n" + "Worker Name " + getPersonName() + "\n" + "Date Joined: " + dateJoiningCompany  + "\n" + "Supervisor: " + getSupervisor() + "\n"+ "Salary: $" + getSalary()+"\n");
		}
		else
			return("Worker Number " + workerNumber + "\n" + "Worker Name " + getPersonName() + "\n" + "Date Joined: " + dateJoiningCompany  +" \nNo Supervisor\n" + "Salary: $" + getSalary()+"\n");

	}

	@Override
	public int Prior() {
		// TODO Auto-generated method stub
		return 0;
	}


}