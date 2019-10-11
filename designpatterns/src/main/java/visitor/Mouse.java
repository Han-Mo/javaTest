package visitor;

/**
 * @author han
 * @date 2019-10-10 11:29
 **/
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
