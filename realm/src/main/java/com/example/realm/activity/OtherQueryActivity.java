package com.example.realm.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.TextView;

import com.example.realm.R;
import com.example.realm.bean.Dog;

import io.realm.Realm;

/**
 * 其他查询
 */
public class OtherQueryActivity extends BaseActivity {
    TextView mToolbar;
    TextView tvAverage;//平均年龄
    TextView tvSumAge;//总年龄
    TextView tvMaxId;

    private Realm mRealm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_other_query;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        tvAverage = (TextView) this.findViewById(R.id.tv_average_age);
        tvSumAge = (TextView) this.findViewById(R.id.tv_sum_age);
        tvMaxId = (TextView) this.findViewById(R.id.tv_max_id);

        mToolbar.setText("其他查询");

        mRealm = Realm.getDefaultInstance();

        getAverageAge();

        getSumAge();

        getMaxId();
    }

    /**
     * 查询平均年龄
     */
    private void getAverageAge() {
        double avgAge = mRealm.where(Dog.class).findAll().average("age");
        tvAverage.setText(avgAge + "岁");
    }

    /**
     * 查询总年龄
     */
    private void getSumAge() {
        Number sum = mRealm.where(Dog.class).findAll().sum("age");
        int sumAge = sum.intValue();
        tvSumAge.setText(sumAge + "岁");
    }

    /**
     * 查询最大年龄
     */
    private void getMaxId() {
        Number max = mRealm.where(Dog.class).findAll().max("age");
        if (max == null) {
            return;
        }
        int maxAge = max.intValue();
        tvMaxId.setText(maxAge + "岁");
    }
}
