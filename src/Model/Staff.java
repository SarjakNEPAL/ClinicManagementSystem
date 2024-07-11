package Model;


public class Staff {
    private int id;
    private String Name;
    private String Type;
    private String password; 

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
    public String getPassword(){
        return this.password;
    }   
    
}


