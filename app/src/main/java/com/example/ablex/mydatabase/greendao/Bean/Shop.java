package com.example.ablex.mydatabase.greendao.Bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

//实体类，不需要自己写get和set方法，在生成表的时候会自动生成。不要忘了在类名上标记@Entity注解
@Entity//@Entity 将我们的java普通类变为一个能够被greenDAO识别的数据库类型的实体类
public class Shop{

    public static final int TYPE_CART = 0x01;
    public static final int TYPE_LOVE = 0x02;

    //不能用int
    @Id(autoincrement = true)//@Id：主键，通过这个注解标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
    private Long id;

    @NotNull// @NotNull 设置数据库表当前列不能为空
    @Unique//唯一
    private String name;

    @Property(nameInDb = "price")//@Property：设置一个非默认关系映射所对应的列名，默认是使用字段名，例如：@Property(nameInDb = "name")
    private String price;

//    @Transient//@Transient：表明这个字段不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的，不会被持久化,即不设置为数据库字段
    private int sell_num;

    private String image_url;
    private String address;
    private int type;

    private String person;

    @Generated(hash = 876868391)
    public Shop(Long id, @NotNull String name, String price, int sell_num, String image_url,
            String address, int type, String person) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sell_num = sell_num;
        this.image_url = image_url;
        this.address = address;
        this.type = type;
        this.person = person;
    }

    @Generated(hash = 633476670)
    public Shop() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSell_num() {
        return this.sell_num;
    }

    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    //@Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
  


}
