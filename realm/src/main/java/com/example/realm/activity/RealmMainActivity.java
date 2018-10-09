package com.example.realm.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.realm.R;
import com.example.realm.async.AsyncActivity;

/**
 *Realm 数据库的简单使用
 *https://blog.csdn.net/hedong_77/article/details/53167774
 * realm 英文文档：
 * https://realm.io/docs/java/latest/
 */
public class RealmMainActivity extends BaseActivity {
    TextView mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        mToolbar.setText("DemoRealm");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main_realm;
    }

    void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_add) {
            startActivity(new Intent(RealmMainActivity.this, DogListActivity.class));
        } else if (i == R.id.btn_query) {
            startActivity(new Intent(RealmMainActivity.this, QueryActivity.class));
        } else if (i == R.id.btn_async) {
            startActivity(new Intent(RealmMainActivity.this, AsyncActivity.class));
        }
    }
}
