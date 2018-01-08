package jingou.jo.com.simulationadpter.presenter;

import java.util.ArrayList;
import java.util.List;

import jingou.jo.com.simulationadpter.bean.ShoppingBean;
import jingou.jo.com.simulationadpter.mdoel.IShoppingModel;
import jingou.jo.com.simulationadpter.mdoel.ShoppingModel;
import jingou.jo.com.simulationadpter.net.NetWorklistener;
import jingou.jo.com.simulationadpter.view.ShoppingActivity;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public class ShoppingPresenter {
    IShoppingModel iShoppingModel;
    final ShoppingActivity shoppingActivity;

    public ShoppingPresenter(ShoppingActivity shoppingActivity) {
        this.shoppingActivity = shoppingActivity;
        iShoppingModel = new ShoppingModel();
    }

    public void getShoppingCar() {
        iShoppingModel.getxpbean(new NetWorklistener<ShoppingBean>() {
            @Override
            public void OnSuccess(ShoppingBean shoppingBean) {
                List<ShoppingBean.DataBean> data = shoppingBean.getData();
                ArrayList<List<ShoppingBean.DataBean.ListBean>> childList = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<ShoppingBean.DataBean.ListBean> datas = data.get(i).getList();
                    childList.add(datas);
                }
                shoppingActivity.ShowXp(data, childList);
            }

            @Override
            public void OnFailed(Exception e) {

            }
        });
    }
}
