package jingou.jo.com.simulationadpter.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import jingou.jo.com.simulationadpter.R;
import jingou.jo.com.simulationadpter.adpter.ShoppingAdpter;
import jingou.jo.com.simulationadpter.bean.ShoppingBean;
import jingou.jo.com.simulationadpter.eventbus.MessageEvent;
import jingou.jo.com.simulationadpter.eventbus.PriceCountEvent;
import jingou.jo.com.simulationadpter.presenter.ShoppingPresenter;

public class MainActivity extends AppCompatActivity implements ShoppingActivity{


    private ExpandableListView mElv;

    /**

     * 全选

     */

    private CheckBox mCb;

    /**

     * 数量:

     */

    private TextView mTvCount;

    /**

     * 结算（0）

     */

    private TextView mTvPrice;

    private ShoppingAdpter shoppingAdpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        initView();

        ShoppingPresenter presenter = new ShoppingPresenter(this);

        presenter.getShoppingCar();

        mCb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                shoppingAdpter.changeAllListState(mCb.isChecked());
            }

        });
    }
    @Override

    protected void onDestroy() {

        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }



    private void initView() {

        mElv = (ExpandableListView) findViewById(R.id.elv);

        mCb = (CheckBox) findViewById(R.id.cb);

        mTvCount = (TextView) findViewById(R.id.tv_count);

        mTvPrice = (TextView) findViewById(R.id.tv_price);

    }



    @Subscribe

    public void onMessageEvent(MessageEvent event) {

        mCb.setChecked(event.isChecked());

    }



    @Subscribe

    public void onMessageEvent(PriceCountEvent event) {

        mTvCount.setText("总计：" + event.getCount() + "");

        mTvPrice.setText("结算(" + event.getPrice() + ")");

    }


    @Override
    public void ShowXp(List<ShoppingBean.DataBean> groupList, List<List<ShoppingBean.DataBean.ListBean>> childlist) {
        shoppingAdpter = new ShoppingAdpter(groupList, childlist, this);
        mElv.setAdapter(shoppingAdpter);
        mElv.setGroupIndicator(null);
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);

        }
    }
}
