package visitor;

/**
 * @author han
 * @date 2019-10-10 11:24
 **/
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
