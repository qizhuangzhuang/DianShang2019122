package com.bawei.dianshang2019122.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@Auther:祁壮壮
 *@Date: 2019/12/4
 *@Time:9:28
 *@Description功能: * */
@Entity
public class EntiyBean {

    @Id
    private Long id;
    private int rank;
    private String title;
    @Generated(hash = 1928426157)
    public EntiyBean(Long id, int rank, String title) {
        this.id = id;
        this.rank = rank;
        this.title = title;
    }
    @Generated(hash = 2120929203)
    public EntiyBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRank() {
        return this.rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
