package pattern.template;

/**
 * Coffee饮料特殊工艺实现
 */
public class Coffee extends Drinks {

    @Override
    void brew() {
        System.out.println("冲咖啡粉");
    }

    @Override
    void addCondiments() {
        System.out.println("加奶加糖");
    }
}
