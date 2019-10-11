package visitor;

/**
 * @author han
 * @date 2019-10-10 11:20
 **/
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
