package com.example.ablex.mydatabase.greendao.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ablex.mydatabase.R;
import com.example.ablex.mydatabase.greendao.Adapter.ShopListAdapter;
import com.example.ablex.mydatabase.greendao.Bean.Shop;
import com.example.ablex.mydatabase.greendao.Dao.ShopDaoOpe;

import java.util.ArrayList;
import java.util.List;


/*
*
* Android实战——GreenDao3.2的使用，爱不释手
* https://blog.csdn.net/qq_30379689/article/details/54410838
*
* Android框架之路——GreenDao3.2.2的使用
* https://blog.csdn.net/bskfnvjtlyzmv867/article/details/71250101
* */
public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv_content;
    private List<Shop> shops;
    private static int i = 10;
    private ShopListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_greendao);

        Button bt_add = (Button) findViewById(R.id.bt_add_green);
        Button bt_delete = (Button) findViewById(R.id.bt_delete_green);
        Button bt_update = (Button) findViewById(R.id.bt_update_green);
        Button bt_query = (Button) findViewById(R.id.bt_query_green);
        lv_content = (ListView) findViewById(R.id.lv_content_green);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

        queryDate();
    }

    @Override
    public void onClick(View v) {
        int i1 = v.getId();
        if (i1 == R.id.bt_add_green) {
            addDate();

        } else if (i1 == R.id.bt_delete_green) {
            deleteDate();

        } else if (i1 == R.id.bt_update_green) {
            updateDate();

        } else if (i1 == R.id.bt_query_green) {
            queryDate();

        }
    }

    private void deleteDate() {
        if (shops != null && shops.size() > 0) {
            System.out.println("删除前shop.size=============" + shops.size());
            ShopDaoOpe.deleteLove(shops.get(0).getId());
            queryDate();
        }
    }

    private void queryDate() {
        shops = new ArrayList<>();
        shops = ShopDaoOpe.queryLove();
        if (shops != null) {
            System.out.println("查询到shops.size=====================" + shops.size());
            adapter = new ShopListAdapter(this, shops);
            lv_content.setAdapter(adapter);
        }
    }

    private void addDate() {
        Shop shop = new Shop();
        shop.setType(Shop.TYPE_LOVE);
        shop.setAddress("广东深圳");
        shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
        shop.setPrice("19.40");
        shop.setSell_num(15263);
        shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
        ShopDaoOpe.insertLove(shop);
        queryDate();
    }

    private void updateDate() {
        if (shops != null && !shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setName("我是修改的名字");
            ShopDaoOpe.updateLove(shop);
            queryDate();
        }
    }
}
