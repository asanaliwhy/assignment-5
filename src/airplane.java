package Assignment_3;

public class Airplane {
    private int id;
    private String name;
    private String model;
    private int age;
    private String status;

    public Airplane(int id, String name, String model, int age, String status) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.age = age;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String toString() {
        return "Airplane {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", model='" + getModel() + '\'' +
                ", age=" + getAge() +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
