package com.huobi.otc.bean;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.FileUtil;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class OtcCountryInfo implements Serializable {
    private static Type type = new TypeToken<List<OtcCountryInfo>>() {
    }.getType();
    private String alpha_code;
    private String code;

    /* renamed from: id  reason: collision with root package name */
    private String f78266id;
    private String name_cn;
    private String name_en;

    public static List<OtcCountryInfo> fromAsset() {
        try {
            return (List) new Gson().fromJson(new JsonParser().parse(FileUtil.k(BaseApplication.b().getResources().getAssets().open("country_code.json"))).getAsJsonObject().get("data"), type);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCountryInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCountryInfo)) {
            return false;
        }
        OtcCountryInfo otcCountryInfo = (OtcCountryInfo) obj;
        if (!otcCountryInfo.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = otcCountryInfo.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String code2 = getCode();
        String code3 = otcCountryInfo.getCode();
        if (code2 != null ? !code2.equals(code3) : code3 != null) {
            return false;
        }
        String name_cn2 = getName_cn();
        String name_cn3 = otcCountryInfo.getName_cn();
        if (name_cn2 != null ? !name_cn2.equals(name_cn3) : name_cn3 != null) {
            return false;
        }
        String name_en2 = getName_en();
        String name_en3 = otcCountryInfo.getName_en();
        if (name_en2 != null ? !name_en2.equals(name_en3) : name_en3 != null) {
            return false;
        }
        String alpha_code2 = getAlpha_code();
        String alpha_code3 = otcCountryInfo.getAlpha_code();
        return alpha_code2 != null ? alpha_code2.equals(alpha_code3) : alpha_code3 == null;
    }

    public String getAlpha_code() {
        return this.alpha_code;
    }

    public String getCode() {
        return this.code;
    }

    public String getId() {
        return this.f78266id;
    }

    public String getName_cn() {
        return this.name_cn;
    }

    public String getName_en() {
        return this.name_en;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String code2 = getCode();
        int hashCode2 = ((hashCode + 59) * 59) + (code2 == null ? 43 : code2.hashCode());
        String name_cn2 = getName_cn();
        int hashCode3 = (hashCode2 * 59) + (name_cn2 == null ? 43 : name_cn2.hashCode());
        String name_en2 = getName_en();
        int hashCode4 = (hashCode3 * 59) + (name_en2 == null ? 43 : name_en2.hashCode());
        String alpha_code2 = getAlpha_code();
        int i12 = hashCode4 * 59;
        if (alpha_code2 != null) {
            i11 = alpha_code2.hashCode();
        }
        return i12 + i11;
    }

    public void setAlpha_code(String str) {
        this.alpha_code = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setId(String str) {
        this.f78266id = str;
    }

    public void setName_cn(String str) {
        this.name_cn = str;
    }

    public void setName_en(String str) {
        this.name_en = str;
    }

    public String toString() {
        return "OtcCountryInfo(id=" + getId() + ", code=" + getCode() + ", name_cn=" + getName_cn() + ", name_en=" + getName_en() + ", alpha_code=" + getAlpha_code() + ")";
    }
}
