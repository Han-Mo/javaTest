package visitor;

/**
 * @author han
 * @date 2019-10-10 11:44
 **/
public class VisitorPatternDemo {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
