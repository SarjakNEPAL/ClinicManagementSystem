/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import dao.OwnerDao;
/**
 *
 * @author sarjak
 */
public class PsgChg{
    public String Oldpass;
    public String NewPass;
    public String CPass;
    private boolean isLong(){
        if(CPass.length()>7){return true;}
        else{return false;}
        }
    private boolean OpNpnotSame(){
         if(Oldpass.equals(NewPass)){
             return false;
         }
         return true;
     }
    private boolean NpCpSame(){       
            if(NewPass.equals(CPass)){
             return true;
         }
         return false;
     }
    private boolean isPassMatch(){ 
         OwnerDao a=new OwnerDao();
         return this.Oldpass.equals(a.getOwnerPass());
     }    
    public String chgPass(){
        if(!(this.Oldpass.isEmpty())&&!(this.NewPass.isEmpty())&& !(this.CPass.isEmpty())){
            if(this.OpNpnotSame()){
                if(this.NpCpSame()){
                    if(this.isPassMatch()){
                       if(this.isLong()){
                        OwnerDao a=new OwnerDao();
                        if(a.chgPasAdmn(NewPass)){return "Success";}
                        else{return "Failed";}
                       }
                       else{
                           return "NTLG";
                       }
                    }
                    else{
                        return "PSMC";
                    }
                }
                else{
                    return "NPCP";
                }
               }
            else{
                return "OPNP";
            }
        }
        else{
            return "EMPTY";
        }        
     }
}




