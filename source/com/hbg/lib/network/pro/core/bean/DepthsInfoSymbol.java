package com.hbg.lib.network.pro.core.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import org.greenrobot.greendao.converter.PropertyConverter;

public class DepthsInfoSymbol implements Serializable {
    private static final long serialVersionUID = -2256976886013133071L;
    private DepthsInfo depthsInfo;

    /* renamed from: id  reason: collision with root package name */
    private Long f70611id;
    private String key;
    private String symbol;

    public static class DepthStepsConverter implements PropertyConverter<DepthsInfo, String> {

        public class a extends TypeToken<DepthsInfo> {
            public a() {
            }
        }

        /* renamed from: a */
        public String convertToDatabaseValue(DepthsInfo depthsInfo) {
            if (depthsInfo == null) {
                return null;
            }
            return new Gson().toJson((Object) depthsInfo);
        }

        /* renamed from: b */
        public DepthsInfo convertToEntityProperty(String str) {
            if (str == null) {
                return null;
            }
            return (DepthsInfo) new Gson().fromJson(str, new a().getType());
        }
    }

    public DepthsInfoSymbol(String str, Long l11, String str2, DepthsInfo depthsInfo2) {
        this.key = str;
        this.f70611id = l11;
        this.symbol = str2;
        this.depthsInfo = depthsInfo2;
    }

    public DepthsInfo getDepthsInfo() {
        return this.depthsInfo;
    }

    public Long getId() {
        return this.f70611id;
    }

    public String getKey() {
        return this.key;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setDepthsInfo(DepthsInfo depthsInfo2) {
        this.depthsInfo = depthsInfo2;
    }

    public void setId(Long l11) {
        this.f70611id = l11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public DepthsInfoSymbol() {
    }
}
