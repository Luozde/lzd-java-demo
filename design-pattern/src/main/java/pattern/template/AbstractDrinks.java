package pattern.template;

public abstract class AbstractDrinks {
    /**
     * 1. 把水煮沸
     */
    void boilWater() {
        System.out.println("将水煮沸");
    }

    /**
     * 2. 冲泡
     */
    abstract void brew();

    /**
     * 3. 倒入杯子
     */
    void pourInCup() {
        System.out.println("倒入杯子");
    }

    /**
     * 4. 加料
     */
    abstract void addCondiments();

    /**
     * 制作模版方法
     */
    public final void makingDrinks() {
        //热水
        boilWater();
        //冲泡
        brew();
        //倒进杯子
        pourInCup();
        //加料
        addCondiments();
    }
}
