import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.sql.SQLOutput;
import java.sql.SQLRecoverableException;
import java.text.Format;

public class dataBase {
    public admindo admindo=new admindo();
    int count = 0;
    public employ[] employs;
    public admindo[] employtask;
    public void system(int number) {
        employs = new employ[number];
        employtask = new admindo[number];
    }
    public boolean isFull() {
        return count == employs.length;
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean add(employ employ1) {

        if (isFull()) {
            if (employs[count - 1] == null) {
                employs[count - 1] = employ1;
                return true;
            }
            return false;
        }
        else {
            for (int i = 0; i < employs.length; i++) {
                employs[count] = employ1;

                count++;
                break;
            }
            return true;
        }
    }
    public String list(){
        String listOfEmployeeInformation="";
        if(isEmpty()){
            return ("nothing");
        }
        else {
            for (int i=0;i<count;i++) {
                if (employs[i] != null) {
                    listOfEmployeeInformation += i + 1 + ":" + "name:" + employs[i].getName() + " gender:" + employs[i].getGender() + " ID:" + employs[i].getID() +  " dateOfbirth:" + employs[i].getDateOfBirth()+  " phoneNumber:" + employs[i].getPhoneNumber()+  " position:" + employs[i].getPosition()+"\n";
                }
            }
        }
        return listOfEmployeeInformation;
    }
    public void deleteEmployee(String ID){
        for (int i = 0; i < employs.length; i++) {
            if(employs[i]!=null) {
                if (employs[i].getID().equals(ID)) {
                    employs[i] = null;
                    employtask[i]= null;
                    if (i < employs.length - 1) {
                        for (int j = i + 1; j < employs.length; j++) {
                            employs[j - 1] = employs[j];
                            employtask[j - 1] = employtask[j];
                        }
                    }
                    employs[employs.length - 1] = null;
                    System.out.println("Successfully delete!");
                    break;
                }

            }
            if(!changeInformation(ID)){
                System.out.println("nothing is deleted!");
                break;
            }
        }
    }
    public employ find(String ID){
        employ queryEmployee=null;
        if(isEmpty()){
            return null;
        }
        else{
            for(int i=0;i<count;i++){
                boolean result;
                result= employs[i].getID().contains(ID);
                if(result) {
                    queryEmployee =  employs[i];
                    System.out.print("name:" + queryEmployee.getName() + " gender:" + queryEmployee.getGender() + " ID:" + queryEmployee.getID() +  " dateOfbirth:" + queryEmployee.getDateOfBirth()+  " phoneNumber:" + queryEmployee.getPhoneNumber()+  " position:" + queryEmployee.getPosition()+"\n");
                }
            }
        }
        return queryEmployee;
    }
    public void changephnumber(String phonenumber){
        for (int i = 0; i < employs.length; i++) {
            if(employs[i]!=null){
                if(employs[i].getPhoneNumber().equals(phonenumber)){
                    employs[i].setPhoneNumber(phonenumber);
                    break;
                }
            }
        }
    }
    public void changeposition(String position){
        for (int i = 0; i < employs.length; i++) {
            if(employs[i]!=null){
                if(employs[i].getPosition().equals(position)){
                    employs[i].setPosition(position);
                    break;
                }
            }
        }
    }
    public boolean changeInformation(String ID){
        for (int i = 0; i < employs.length; i++) {
            if(employs[i]!=null){
                if(employs[i].getID().equals(ID)){
                    return true;
                }
            }
        }
        return false;
    }
    public employ taskIDtest(String employeeID){
        employ IDtask=null;
        if(isEmpty()){
            return null;
        }
        else{
            for(int i=0;i<employs.length;i++){

                if(employs[i] != null && employs[i].getID().equals(employeeID)) {
                    IDtask =  employs[i];
                    System.out.print("The presence of this colleague, please continue");
                    break;
                }
            }
        }
        return IDtask;
    }
    public void release(String tasks,String ID){
        for (int i = 0; i <employs.length; i++) {
            if(employs[i] != null &&employs[i].getID().equals(ID)) {
                employtask[i]= new admindo(tasks);
                System.out.println("Task added successfully");
            }
        }
    }
    public void update(admindo origin){
        for(int j=0;j<employs.length;j++){
            employtask[j]=origin;


        }

    }
    //user
    public admindo taskquery(String employeeID){
        admindo IDtask=null;
        if(isEmpty()){
            return null;
        }
        else{
            for(int i=0;i<employtask.length;i++){
                if(employs[i] != null &&employs[i].getID().equals(employeeID)) {
                    IDtask =  employtask[i];
                    System.out.println("The task is "+ IDtask.getTask());
                }
            }
        }
        return IDtask;
    }









}






