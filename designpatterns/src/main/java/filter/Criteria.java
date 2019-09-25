package filter;

import java.util.List;

/**
 * @author han
 * @Date 2019-09-11 11:46
 **/
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
