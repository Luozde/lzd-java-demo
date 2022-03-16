package pattern.template.callback;

/**
 * 测试内容
 * 参考资料：https://xie.infoq.cn/article/a1bc72d3f480c25eb716bc806
 */
public class TestTemplateApp {
    public static void main(String[] args) {
        Drinks drinks = new Drinks();
        Tea tea = new Tea();
        drinks.makingDrinks(tea);
        System.out.println();
        Coffee coffee = new Coffee();
        drinks.makingDrinks(coffee);
    }
}
