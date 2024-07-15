package Model;


public class Staff {
    protected int id;
    protected String Name;
    protected String Type;
    protected String password;

    public void setId(int id){
        this.id=id;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public void setType(String Type){
        this.Type=Type;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.Name;
    }
    public String getType(){
        return this.Type;
    }
    public String getPassword(){return this.password;}
    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + Name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

