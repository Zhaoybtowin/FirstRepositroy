package test;

public class TestExtends {
    public static void main(String[] args) {
        son s = new son(1);

        s.setId1(1);
        //s.sl();
    }
}

class son extends dad{
    private int age;

    public son(int id){
        this.setId1(id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void sl(){

    }
}


class dad{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId1(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void sl(){

    }
}