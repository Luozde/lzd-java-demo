package pattern.template.callback;

/**
 * 饮料制作模版
 */
public class Drinks {
    /**
     * 1. 把水煮沸
     */
    void boilWater() {
        System.out.println("将水煮沸");
    }

    /**
     * 3. 倒入杯子
     */
    void pourInCup() {
        System.out.println("倒入杯子");
    }

    /**
     * 制作模版方法
     */
    public final void makingDrinks(Callback customDrink) {
        //1.热水
        boilWater();
        //2.冲泡
        customDrink.brew();
        //3.倒进杯子
        pourInCup();
        //4.加料
        customDrink.addCondiments();
    }
}
