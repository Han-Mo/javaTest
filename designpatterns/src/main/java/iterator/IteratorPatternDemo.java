package iterator;

/**
 * @author han
 * @Date 2019-09-23 17:07
 **/
public class IteratorPatternDemo {
    public static void main(String[] args) {
        String[] names = {"Robert" , "John" ,"Julie" , "Lora"};
        NameRepository namesRepository = new NameRepository(names);

        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
