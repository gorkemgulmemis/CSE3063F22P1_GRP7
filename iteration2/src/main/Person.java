
class Person{

    private String name;
    private String department;
    private String title;

    public Person(){
        super();
    }

    public Person(String name,String department,String title){
        this.name=name;
        this.department=department;
        this.title=title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
