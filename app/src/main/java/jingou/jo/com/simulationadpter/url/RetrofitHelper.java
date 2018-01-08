package jingou.jo.com.simulationadpter.url;

import jingou.jo.com.simulationadpter.net.ShoppingAPI;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private static ServiceApi serviceApi;
    static {
        initOkhttp();
    }

    private static void initOkhttp() {
        if (okHttpClient==null){
            synchronized (RetrofitHelper.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder()
                            .build();
                }
            }
        }
    }
    public static ServiceApi getservice(){
        if (serviceApi==null){
            synchronized (RetrofitHelper.class){
                if (serviceApi==null){
                    serviceApi = onCreatApi(ServiceApi.class, ShoppingAPI.HOST);
                }
            }
        }
        return serviceApi;
    }
    public static <T> T onCreatApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
