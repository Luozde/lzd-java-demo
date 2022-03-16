package pattern.template.callback;

/**
 * 奶茶饮料特殊工艺实现
 */
public class Tea implements Callback {

    @Override
    public void brew() {
        System.out.println("冲茶叶");
    }

    @Override
    public void addCondiments() {
        System.out.println("加柠檬片");
    }
}
