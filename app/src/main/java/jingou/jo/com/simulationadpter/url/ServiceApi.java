package jingou.jo.com.simulationadpter.url;

import jingou.jo.com.simulationadpter.bean.ShoppingBean;
import jingou.jo.com.simulationadpter.net.ShoppingAPI;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public interface ServiceApi {
    @GET(ShoppingAPI.URL)
    Observable<ShoppingBean> Shoppingcar(@Query("source") String source);
}
