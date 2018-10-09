package com.example.realm.async;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.realm.R;
import com.example.realm.activity.BaseActivity;

public class AsyncActivity extends BaseActivity {
    TextView mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_async;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        mToolbar.setText("异步操作");
    }

    void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_add_delete) {
            startActivity(new Intent(AsyncActivity.this, AddDeleteActivity.class));
        } else if (i == R.id.btn_update_query) {
            startActivity(new Intent(AsyncActivity.this, AsyncQueryActivity.class));
        }

    }
}
