package pattern.template;

/**
 * 测试内容
 * 参考资料：https://xie.infoq.cn/article/a1bc72d3f480c25eb716bc806
 */
public class TestTemplateApp {
    public static void main(String[] args) {
        Drinks coffee = new Coffee();
        coffee.makingDrinks();
        System.out.println();
        Drinks tea = new Tea();
        tea.makingDrinks();
    }
}
