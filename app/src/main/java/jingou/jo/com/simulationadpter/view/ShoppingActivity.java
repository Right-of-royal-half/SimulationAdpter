package jingou.jo.com.simulationadpter.view;

import java.util.List;

import jingou.jo.com.simulationadpter.bean.ShoppingBean;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public interface ShoppingActivity {
    public void ShowXp(List<ShoppingBean.DataBean> groupList, List<List<ShoppingBean.DataBean.ListBean>>childlist);
}
