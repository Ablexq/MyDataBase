package com.example.ablex.mydatabase.greendao.Dao;


import com.example.ablex.mydatabase.MyApplication;
import com.example.ablex.mydatabase.greendao.Bean.Shop;
import com.example.ablex.mydatabase.greendao.gen.DaoSession;
import com.example.ablex.mydatabase.greendao.gen.ShopDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class ShopDaoOpe {

    /**
     * 添加数据
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        DaoSession daoInstant = MyApplication.getDaoSession();
        if (daoInstant == null) {
            return;
        }
        //Dao（Data Access Object）是指数据访问接口，即提供了数据库操作一些API接口，可通过dao进行增删改查操作
        ShopDao shopDao = daoInstant.getShopDao();
        if (shopDao == null) {
            return;
        }
        shopDao.insert(shop);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        DaoSession daoInstant = MyApplication.getDaoSession();
        if (daoInstant == null) {
            return;
        }
        ShopDao shopDao = daoInstant.getShopDao();
        if (shopDao == null) {
            return;
        }
        shopDao.deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        DaoSession daoInstant = MyApplication.getDaoSession();
        if (daoInstant == null) {
            return;
        }
        ShopDao shopDao = daoInstant.getShopDao();
        if (shopDao == null) {
            return;
        }
        shopDao.update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        DaoSession daoInstant = MyApplication.getDaoSession();
        if (daoInstant == null) {
            return null;
        }
        ShopDao shopDao = daoInstant.getShopDao();
        if (shopDao == null) {
            return null;
        }
        QueryBuilder<Shop> shopQueryBuilder = shopDao.queryBuilder();
        return shopQueryBuilder.where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }
}
