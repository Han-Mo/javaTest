package iterator;

/**
 * @author han
 * @Date 2019-09-23 17:02
 **/
public class StringArrayIterator implements Iterator {
    int index = 0;
    String[] names;

    public StringArrayIterator(String[] names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        if (index < names.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if(index < names.length){
            return names[index++];
        }
        return null;
    }
}
