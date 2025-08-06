package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class AdConfig implements Serializable {
    public List<OpenScreenAdv> openScreenAdvList;
    public OpenScreenCommonConfig openScreenCommonConfig;

    /* renamed from: ts  reason: collision with root package name */
    public long f70218ts;

    public static class OpenScreenAdv implements Serializable {
        public long advId;
        public String advName;
        public int count;
        public long endTime;
        public String imageUrl;
        public String jumpTo;
        public String language;
        public long materialId;
        public long materialLanguageId;
        public String materialName;
        public int priority;
        public long startTime;
    }

    public static class OpenScreenCommonConfig {
        public int count;
        public int duration;
        public int interval;
    }
}
