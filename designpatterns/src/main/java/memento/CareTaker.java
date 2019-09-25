package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 * @Date 2019-09-24 14:28
 **/
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
