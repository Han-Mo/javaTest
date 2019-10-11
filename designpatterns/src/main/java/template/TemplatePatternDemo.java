package template;

/**
 * @author han
 * @date 2019-10-09 14:59
 **/
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
