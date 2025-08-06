package com.huobi.store;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Keep
public class BusinessLine implements Serializable {
    private static final long serialVersionUID = 4785565284094642289L;
    public int number;
    public int pattern;
    public String patternContent;
    public int patternState;

    public int getNumber() {
        return this.number;
    }

    public int getPattern() {
        return this.pattern;
    }

    public String getPatternContent() {
        return this.patternContent;
    }

    public int getPatternState() {
        return this.patternState;
    }

    public boolean isOpen() {
        return this.patternState == 1;
    }

    public boolean isSwitch() {
        return this.pattern == 1;
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.patternContent) && this.patternContent.startsWith("[")) {
            try {
                JsonArray asJsonArray = new JsonParser().parse(this.patternContent).getAsJsonArray();
                Gson gson = new Gson();
                Iterator<JsonElement> it2 = asJsonArray.iterator();
                while (it2.hasNext()) {
                    arrayList.add(gson.fromJson(it2.next(), cls));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return arrayList;
    }

    public <T> T parseObject(Class<T> cls) {
        if (TextUtils.isEmpty(this.patternContent) || !this.patternContent.startsWith("{")) {
            return null;
        }
        return GsonHelper.a().fromJson(this.patternContent, cls);
    }

    public void setNumber(int i11) {
        this.number = i11;
    }

    public void setPattern(int i11) {
        this.pattern = i11;
    }

    public void setPatternContent(String str) {
        this.patternContent = str;
    }

    public void setPatternState(int i11) {
        this.patternState = i11;
    }

    public String toString() {
        return GsonHelper.a().toJson((Object) this);
    }

    public <T> T parseObject(Type type) {
        if (!TextUtils.isEmpty(this.patternContent)) {
            return GsonHelper.a().fromJson(this.patternContent, type);
        }
        return null;
    }
}
