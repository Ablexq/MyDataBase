package com.example.realm.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realm.R;
import com.example.realm.util.RealmHelper;

public class UpdateActivity extends BaseActivity {
    TextView mToolbar;
    EditText etName;

    private RealmHelper mRealmHelper;
    private String mId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar = ((TextView) this.findViewById(R.id.toolBar));
        etName = (EditText) this.findViewById(R.id.et_name);

        mToolbar.setText("改");

        initData();
    }

    private void initData() {
        mRealmHelper = new RealmHelper(this);
        mId = getIntent().getStringExtra("id");
    }

    void onClick(View v) {
        String name = etName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(UpdateActivity.this, "请输入名称", Toast.LENGTH_SHORT).show();
            return;
        }

        mRealmHelper.updateDog(mId, name);

        setResult(RESULT_OK);
        finish();
    }
}
