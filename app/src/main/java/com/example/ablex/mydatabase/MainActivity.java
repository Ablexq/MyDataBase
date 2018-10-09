package com.example.ablex.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.realm.activity.RealmMainActivity;
import com.example.sqlite.SQLiteActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.sqlite:
                startActivity(new Intent(MainActivity.this, SQLiteActivity.class));
                break;

            case R.id.realm:
                startActivity(new Intent(MainActivity.this, RealmMainActivity.class));
                break;

        }

    }
}
