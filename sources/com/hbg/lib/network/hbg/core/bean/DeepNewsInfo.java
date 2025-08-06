package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class DeepNewsInfo implements Serializable {
    private int dataSource;
    private DeepNews news;
    private Promulgator promulgator;

    public int getDataSource() {
        return this.dataSource;
    }

    public DeepNews getNews() {
        return this.news;
    }

    public Promulgator getPromulgator() {
        return this.promulgator;
    }

    public void setDataSource(int i11) {
        this.dataSource = i11;
    }

    public void setNews(DeepNews deepNews) {
        this.news = deepNews;
    }

    public void setPromulgator(Promulgator promulgator2) {
        this.promulgator = promulgator2;
    }
}
