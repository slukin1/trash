package com.huochat.community.model;

import java.io.Serializable;

public class MediaBean implements Serializable {
    public static final int Media_Image = 1;
    public static final int Media_Vedio = 2;
    public int duration;
    public int height;
    public String imageUrl;
    public String localVideoPath;
    public String msgId;
    public int type;
    public String videoUrl;
    public int width;
}
