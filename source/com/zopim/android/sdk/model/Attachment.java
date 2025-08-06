package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zendesk.logger.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class Attachment {
    private static final String LOG_TAG = "Attachment";
    @SerializedName("mime_type$string")
    @Expose
    private String mimeType;
    @SerializedName("name$string")
    @Expose
    private String name;
    @SerializedName("size$int")
    @Expose
    private Long size;
    @SerializedName("thumb$string")
    @Expose
    private String thumbnail;
    @SerializedName("type$string")
    @Expose
    private String type;
    @SerializedName("url$string")
    @Expose
    private String url;

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public Long getSize() {
        return this.size;
    }

    public URL getThumbnail() {
        if (this.thumbnail != null) {
            try {
                return new URL(this.thumbnail);
            } catch (MalformedURLException e11) {
                Logger.k(LOG_TAG, "Can not retrieve url. ", e11, new Object[0]);
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }

    public URL getUrl() {
        if (this.url != null) {
            try {
                return new URL(this.url);
            } catch (MalformedURLException e11) {
                Logger.k(LOG_TAG, "Can not retrieve url. ", e11, new Object[0]);
            }
        }
        return null;
    }
}
