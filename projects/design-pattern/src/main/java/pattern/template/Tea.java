package pattern.template;

/**
 * 奶茶饮料特殊工艺实现
 */
public class Tea extends AbstractDrinks {

    @Override
    void brew() {
        System.out.println("冲茶叶");
    }

    @Override
    void addCondiments() {
        System.out.println("加柠檬片");
    }
}
