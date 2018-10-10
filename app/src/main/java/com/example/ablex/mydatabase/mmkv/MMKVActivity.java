package com.example.ablex.mydatabase.mmkv;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ablex.mydatabase.R;
import com.tencent.mmkv.MMKV;


public class MMKVActivity extends AppCompatActivity {

    private MMKV mmkv;
    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mmkv);

        mTv = ((TextView) this.findViewById(R.id.mmkv_tv));
        mmkv = MMKV.defaultMMKV();
    }

    @SuppressLint("SetTextI18n")
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.mmkv_btn1:
                mmkv.encode("string", "Hello from mmkv");
                mmkv.encode("boolean", true);
                mmkv.encode("int", Integer.MIN_VALUE);
                break;

            case R.id.mmkv_btn2:
                String str = mmkv.decodeString("string");
                boolean bValue = mmkv.decodeBool("boolean");
                int iValue = mmkv.decodeInt("int");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mmkv保存的字符串").append(str)
                        .append("\n").append("保存的布尔值").append(bValue)
                        .append("\n").append("保存的整型值").append(iValue);
                mTv.setText(stringBuilder.toString());
                System.out.println(stringBuilder.toString());
                break;
        }
    }


}
