package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FileSending {
    @SerializedName("enabled$bool")
    @Expose
    private boolean enabled;
    @SerializedName("allowed_extensions$string")
    @Expose
    private String extensions;

    public String[] getExtensions() {
        if (this.extensions == null) {
            return new String[0];
        }
        StringTokenizer stringTokenizer = new StringTokenizer(this.extensions, Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringTokenizer.countTokens();
        LinkedList linkedList = new LinkedList();
        while (stringTokenizer.hasMoreTokens()) {
            linkedList.add(stringTokenizer.nextToken());
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String toString() {
        return "File Sending. Enabled: " + this.enabled + " Ext: " + this.extensions;
    }
}
