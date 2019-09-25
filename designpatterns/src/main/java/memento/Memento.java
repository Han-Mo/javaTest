package memento;

/**
 * @author han
 * @Date 2019-09-24 14:25
 **/
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
