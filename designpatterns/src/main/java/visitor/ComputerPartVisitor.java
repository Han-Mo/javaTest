package visitor;

/**
 * @author han
 * @date 2019-10-10 11:25
 **/
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
