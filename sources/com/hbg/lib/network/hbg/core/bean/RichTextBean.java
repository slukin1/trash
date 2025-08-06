package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class RichTextBean implements Serializable {
    public String character;
    public ArrayList<RichTextBean> children;
    public OtherData data;
    public String text;
    public String type;
    public String url;

    public static class OtherData implements Serializable {
        public String coin;
        public String title;
        public String topicId;
        public String url;
    }
}
