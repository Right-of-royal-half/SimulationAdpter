package jingou.jo.com.simulationadpter.net;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public class ShoppingAPP extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
