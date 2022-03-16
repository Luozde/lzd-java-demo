package pattern.template.callback;

/**
 * Coffee饮料特殊工艺实现
 */
public class Coffee implements Callback {

    @Override
    public void brew() {
        System.out.println("冲咖啡粉");
    }

    @Override
    public void addCondiments() {
        System.out.println("加奶加糖");
    }
}
