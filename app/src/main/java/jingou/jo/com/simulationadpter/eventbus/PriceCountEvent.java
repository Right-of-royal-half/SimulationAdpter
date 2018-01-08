package jingou.jo.com.simulationadpter.eventbus;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public class PriceCountEvent {
    private int price;
    private int count;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
