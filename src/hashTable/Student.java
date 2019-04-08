
	package hashTable;

	public class Student implements Hashable{
	    private String name;
	    private String enrollment;
	    
    public Student(){
        String[] name = null;
        String[] enrollment = null;
    }
    
    public Student(String enrollment, String name) {
        this.enrollment = enrollment;
        this.name = name;
    }
    
    public String getName(String name){
        return this.name;
    }
    
    public String getEnrollment(String enrollment){
        return this.enrollment;
    }
    
    public void setEnrollment(String enrollment){
        this.enrollment = enrollment;
    }
    
    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int hash(int tablesize){
        int hashValue = 0; 
        hashValue = enrollment.hashCode()%tablesize;
        if(hashValue<0){
            hashValue+=tablesize;
        }
        return hashValue;
    }
}
