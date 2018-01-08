package jingou.jo.com.simulationadpter.mdoel;

import jingou.jo.com.simulationadpter.bean.ShoppingBean;
import jingou.jo.com.simulationadpter.net.NetWorklistener;
import jingou.jo.com.simulationadpter.url.RetrofitHelper;
import jingou.jo.com.simulationadpter.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public class  ShoppingModel implements IShoppingModel{
    @Override
    public void getxpbean(final NetWorklistener<ShoppingBean> shoppingBeanNetWorklistener) {
        ServiceApi serviceApi = RetrofitHelper.getservice();
        serviceApi.Shoppingcar("android")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ShoppingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShoppingBean shoppingBean) {
                        shoppingBeanNetWorklistener.OnSuccess(shoppingBean);
                    }
                });
    }
}
