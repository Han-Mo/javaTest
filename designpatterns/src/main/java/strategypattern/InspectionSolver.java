package strategypattern;

/**
 * @author han
 * @Date 2019-09-02 14:33
 **/
public abstract class InspectionSolver {
    public abstract void solve(Long orderId, Long userId);

    public abstract String[] supports();
}
