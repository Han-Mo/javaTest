package iterator;

/**
 * @author han
 * @Date 2019-09-23 16:59
 **/
public class NameRepository implements Container {
    String[] names;

    public NameRepository(String[] names) {
        this.names = names;
    }


    @Override
    public Iterator getIterator() {
        return new StringArrayIterator(this.names);
    }
}
