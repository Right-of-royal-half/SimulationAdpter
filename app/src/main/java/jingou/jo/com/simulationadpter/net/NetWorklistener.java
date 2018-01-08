package jingou.jo.com.simulationadpter.net;

/**
 * Created by 杨杰 on 2018/1/6.
 */

public interface NetWorklistener<T> {
    public void OnSuccess(T t);
    public void OnFailed(Exception e);
}
