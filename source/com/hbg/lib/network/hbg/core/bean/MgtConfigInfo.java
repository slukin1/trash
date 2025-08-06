package com.hbg.lib.network.hbg.core.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MgtConfigInfo implements Serializable {
    private static final long serialVersionUID = 4785565284094642299L;
    private int pattern;
    private String patternContent;
    private int patternState;

    public boolean canEqual(Object obj) {
        return obj instanceof MgtConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MgtConfigInfo)) {
            return false;
        }
        MgtConfigInfo mgtConfigInfo = (MgtConfigInfo) obj;
        if (!mgtConfigInfo.canEqual(this) || getPattern() != mgtConfigInfo.getPattern() || getPatternState() != mgtConfigInfo.getPatternState()) {
            return false;
        }
        String patternContent2 = getPatternContent();
        String patternContent3 = mgtConfigInfo.getPatternContent();
        return patternContent2 != null ? patternContent2.equals(patternContent3) : patternContent3 == null;
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

    public int hashCode() {
        int pattern2 = ((getPattern() + 59) * 59) + getPatternState();
        String patternContent2 = getPatternContent();
        return (pattern2 * 59) + (patternContent2 == null ? 43 : patternContent2.hashCode());
    }

    public boolean isOpen() {
        return this.patternState == 1;
    }

    public boolean isSwitch() {
        return this.pattern == 1;
    }

    public <T> List<T> parse(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.patternContent)) {
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
        return "MgtConfigInfo(pattern=" + getPattern() + ", patternState=" + getPatternState() + ", patternContent=" + getPatternContent() + ")";
    }
}
