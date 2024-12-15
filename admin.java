public class admin {
    private String password ;
    public  boolean test(String pwd){
        if(pwd.equals(password)){
            return  true;
        }
        else{
            return false;
        }
    }

    public void change(String newpwd){
        if(getPassword().equals(newpwd)){
            System.out.println("Password is the same, please change the password again");
        }
        else{
            String pwd =newpwd;
            setPassword(pwd);
            System.out.println("Password changed successfully");
        }
    }
    public admin() {
    }

    public admin(String password, String ID, String task) {
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
