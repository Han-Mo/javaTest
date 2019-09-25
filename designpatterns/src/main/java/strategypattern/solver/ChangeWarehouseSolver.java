package strategypattern.solver;

import org.springframework.stereotype.Component;
import strategypattern.InspectionConstant;
import strategypattern.InspectionSolver;

/**
 * @author han
 * @Date 2019-09-02 14:56
 **/
@Component
public class ChangeWarehouseSolver extends InspectionSolver {
    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("订单"+orderId+"开始进行批量转仓了。。");
    }

    @Override
    public String[] supports() {
        return new String[] {InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_WAREHOUSE};
    }
}
