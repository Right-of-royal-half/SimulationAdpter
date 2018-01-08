package jingou.jo.com.simulationadpter.mdoel;

import jingou.jo.com.simulationadpter.bean.ShoppingBean;
import jingou.jo.com.simulationadpter.net.NetWorklistener;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public interface IShoppingModel {
    public void getxpbean(NetWorklistener<ShoppingBean> shoppingBeanNetWorklistener);
}
