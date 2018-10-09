package com.example.realm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.realm.R;

/**
 * 查、改
 */
public class QueryActivity extends BaseActivity {
    TextView mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        mToolbar.setText("改、查");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_query;
    }

    void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_query) {
            startActivity(new Intent(QueryActivity.this, AllDogActivity.class));
        } else if (i == R.id.btn_condition_query) {
            startActivity(new Intent(QueryActivity.this, ConditionQueryActivity.class));
        } else if (i == R.id.btn_other_query) {
            startActivity(new Intent(QueryActivity.this, OtherQueryActivity.class));
        }

    }
}
