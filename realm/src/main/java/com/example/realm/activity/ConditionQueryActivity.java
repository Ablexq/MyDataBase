package com.example.realm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realm.R;
import com.example.realm.adapter.LikeDogAdapter;
import com.example.realm.bean.Dog;
import com.example.realm.util.RealmHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * 条件查询
 */
public class ConditionQueryActivity extends BaseActivity {
    EditText etId;
    EditText etAge;
    RecyclerView mRecyclerView;
    TextView mToolbar;

    private RealmHelper mRealmHelper;
    private List<Dog> mDogs = new ArrayList<>();
    private LikeDogAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_condition_query;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        etId = ((EditText) this.findViewById(R.id.et_id));
        etAge = ((EditText) this.findViewById(R.id.et_age));
        mRecyclerView = ((RecyclerView) this.findViewById(R.id.recyclerView));
        mToolbar = ((TextView) this.findViewById(R.id.toolBar));


        mToolbar.setText("条件查询");
        initData();
    }

    void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_query_id) {
            queryById();
        } else if (i == R.id.btn_query_age) {
            queryByAge();
        }
    }

    private void initData() {
        mRealmHelper = new RealmHelper(this);
        mAdapter = new LikeDogAdapter(this, mDogs, R.layout.item_dog);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void queryById() {
        String id = etId.getText().toString().trim();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(ConditionQueryActivity.this, "请输入Id", Toast.LENGTH_SHORT).show();
            return;
        }

        mDogs.clear();
        Dog dog = mRealmHelper.queryDogById(id);
        if (dog != null) {
            mDogs.add(dog);
        } else {
            Toast.makeText(ConditionQueryActivity.this, "查询结果为空", Toast.LENGTH_SHORT).show();
        }
        mAdapter.notifyDataSetChanged();

    }

    private void queryByAge() {
        String age = etAge.getText().toString().trim();
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(ConditionQueryActivity.this, "请输入age", Toast.LENGTH_SHORT).show();
            return;
        }

        mDogs.clear();
        List<Dog> dogs = mRealmHelper.queryDobByAge(Integer.parseInt(age));
        if (dogs != null) {
            mDogs.addAll(dogs);

        } else {
            Toast.makeText(ConditionQueryActivity.this, "查询结果为空", Toast.LENGTH_SHORT).show();

        }
        mAdapter.notifyDataSetChanged();
    }

}
