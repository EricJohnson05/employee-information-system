public class admindo {
    private String task;

    public admindo() {
    }

    public admindo( String task) {

        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    public String toString(){
        return this.task;
    }
}
