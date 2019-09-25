package strategypattern;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author han
 * @Date 2019-09-02 14:34
 **/
@Component
public class InspectionSolverChooser implements ApplicationContextAware {

    private Map chooseMap = new HashMap<String,InspectionSolver>();

    public InspectionSolver choose(String type) {
        return (InspectionSolver)chooseMap.get(type);
    }

    private ApplicationContext context;

    //被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init（）方法之前执行。PreDestroy（）方法在destroy（）方法知性之后执行
    @PostConstruct
    public void register() {
        Map solverMap = context.getBeansOfType(InspectionSolver.class);
        //for (InspectionSolver solver : solverMap.values()) {
        for (Object objectSolver : solverMap.values()) {
            InspectionSolver solver = (InspectionSolver)objectSolver;
            for (String support : solver.supports()) {
                chooseMap.put(support,solver);
            }
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
