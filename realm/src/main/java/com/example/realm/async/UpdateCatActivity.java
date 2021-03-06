package com.example.realm.async;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.realm.R;
import com.example.realm.activity.BaseActivity;
import com.example.realm.bean.Cat;
import com.example.realm.util.ToastUtil;
import io.realm.Realm;
import io.realm.RealmAsyncTask;

public class UpdateCatActivity extends BaseActivity {
    TextView mToolbar;
    EditText etName;

    private Realm mRealm;
    private String mId;
    private RealmAsyncTask updateTask;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_cat;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        etName = (EditText) this.findViewById(R.id.et_name);

        initData();

    }

    private void initData() {
        mToolbar.setText("异步更新");
        mId = getIntent().getStringExtra("id");
        mRealm = Realm.getDefaultInstance();
    }

    void onClick(View view) {
        final String name = etName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showShortToast(UpdateCatActivity.this, "请输入新的Name");
            return;
        }

        updateTask = mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Cat cat = realm.where(Cat.class).equalTo("id", mId).findFirst();
                cat.setName(name);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                ToastUtil.showShortToast(UpdateCatActivity.this, "更新成功");
                setResult(RESULT_OK);
                finish();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                ToastUtil.showShortToast(UpdateCatActivity.this, "失败成功");

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (updateTask != null && !updateTask.isCancelled()) {
            updateTask.cancel();
        }
    }
}
