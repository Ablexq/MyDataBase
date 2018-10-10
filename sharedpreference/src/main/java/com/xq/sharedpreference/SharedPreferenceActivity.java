package com.xq.sharedpreference;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


@SuppressWarnings("MismatchedQueryAndUpdateOfStringBuilder")
public class SharedPreferenceActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sp);

        Logger.addLogAdapter(new AndroidLogAdapter());

        mTv = ((TextView) this.findViewById(R.id.tv));
    }

    @SuppressLint("SetTextI18n")
    public void onclick(View view) {
        int i = view.getId();
        if (i == R.id.btn1) {
            SharedPerfenceUtil.setParam(this, "string_key", "string_value");
        } else if (i == R.id.btn2) {
            String param = (String) SharedPerfenceUtil.getParam(this, "string_key", "default_string_value");
            mTv.setText("获取的字符串为" + param);
            Logger.d("获取的字符串为" + param);
        } else if (i == R.id.btn3) {
            User user = new User("leo", 18, 166f);
            SharedPerfenceUtil.putBean(this, "object_key", user);
        } else if (i == R.id.btn4) {
            User user = (User) SharedPerfenceUtil.getBean(this, "object_key");
            if (user != null) {
                String stringBuilder = "name===" + user.getName() + "\n" +
                        "age===" + user.getAge() + "\n" +
                        "height===" + user.getHeight();
                Logger.d(user);
                Logger.v("获取的对象属性为" + stringBuilder);
                mTv.setText("获取的对象属性为" + stringBuilder);
            }
        }
    }
}
