package com.hbg.lib.network.hbg.grid.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

public class GridSymbolsConfig implements Serializable {
    private static final long serialVersionUID = -7171479357933994920L;
    private String assetBuff;
    private String assetMulti;
    private List<String> bases;

    /* renamed from: id  reason: collision with root package name */
    private Long f70283id;
    private String key;
    private String minPutRate;
    private List<String> quotes;
    private List<GridSymbolsBean> symbols;

    public static class GridSymbolBeanBaseConverter implements PropertyConverter<List<String>, String> {

        public class a extends TypeToken<List<String>> {
            public a() {
            }
        }

        /* renamed from: a */
        public String convertToDatabaseValue(List<String> list) {
            if (list == null) {
                return null;
            }
            return new Gson().toJson((Object) list);
        }

        /* renamed from: b */
        public List<String> convertToEntityProperty(String str) {
            if (str == null) {
                return null;
            }
            return (List) new Gson().fromJson(str, new a().getType());
        }
    }

    public static class GridSymbolBeanConverter implements PropertyConverter<List<GridSymbolsBean>, String> {

        public class a extends TypeToken<List<GridSymbolsBean>> {
            public a() {
            }
        }

        /* renamed from: a */
        public String convertToDatabaseValue(List<GridSymbolsBean> list) {
            if (list == null) {
                return null;
            }
            return new Gson().toJson((Object) list);
        }

        /* renamed from: b */
        public List<GridSymbolsBean> convertToEntityProperty(String str) {
            if (str == null) {
                return null;
            }
            return (List) new Gson().fromJson(str, new a().getType());
        }
    }

    public GridSymbolsConfig(String str, Long l11, String str2, String str3, String str4, List<String> list, List<String> list2, List<GridSymbolsBean> list3) {
        this.key = str;
        this.f70283id = l11;
        this.assetMulti = str2;
        this.assetBuff = str3;
        this.minPutRate = str4;
        this.quotes = list;
        this.bases = list2;
        this.symbols = list3;
    }

    public String getAssetBuff() {
        return this.assetBuff;
    }

    public String getAssetMulti() {
        return this.assetMulti;
    }

    public List<String> getBases() {
        return this.bases;
    }

    public Long getId() {
        return this.f70283id;
    }

    public String getKey() {
        return this.key;
    }

    public String getMinPutRate() {
        return this.minPutRate;
    }

    public List<String> getQuotes() {
        return this.quotes;
    }

    public List<GridSymbolsBean> getSymbols() {
        return this.symbols;
    }

    public void setAssetBuff(String str) {
        this.assetBuff = str;
    }

    public void setAssetMulti(String str) {
        this.assetMulti = str;
    }

    public void setBases(List<String> list) {
        this.bases = list;
    }

    public void setId(Long l11) {
        this.f70283id = l11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMinPutRate(String str) {
        this.minPutRate = str;
    }

    public void setQuotes(List<String> list) {
        this.quotes = list;
    }

    public void setSymbols(List<GridSymbolsBean> list) {
        this.symbols = list;
    }

    public GridSymbolsConfig() {
    }
}
