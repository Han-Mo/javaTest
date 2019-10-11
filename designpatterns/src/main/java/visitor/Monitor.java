package visitor;

/**
 * @author han
 * @date 2019-10-10 11:28
 **/
public class Monitor  implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
