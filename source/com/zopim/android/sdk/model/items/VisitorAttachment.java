package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;
import java.io.File;
import java.net.URL;

public class VisitorAttachment extends VisitorItem<VisitorAttachment> {
    private String error;
    private File file;
    private int uploadProgress;
    private URL uploadUrl;

    public VisitorAttachment() {
        super.setType(RowItem.Type.VISITOR_ATTACHMENT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisitorAttachment) || !super.equals(obj)) {
            return false;
        }
        VisitorAttachment visitorAttachment = (VisitorAttachment) obj;
        if (this.uploadProgress != visitorAttachment.uploadProgress) {
            return false;
        }
        File file2 = this.file;
        if (file2 == null ? visitorAttachment.file != null : !file2.equals(visitorAttachment.file)) {
            return false;
        }
        URL url = this.uploadUrl;
        if (url == null ? visitorAttachment.uploadUrl != null : !url.equals(visitorAttachment.uploadUrl)) {
            return false;
        }
        String str = this.error;
        String str2 = visitorAttachment.error;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getError() {
        return this.error;
    }

    public File getFile() {
        return this.file;
    }

    public int getUploadProgress() {
        return this.uploadProgress;
    }

    public URL getUploadUrl() {
        return this.uploadUrl;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        File file2 = this.file;
        int i11 = 0;
        int hashCode2 = (hashCode + (file2 != null ? file2.hashCode() : 0)) * 31;
        URL url = this.uploadUrl;
        int hashCode3 = (((hashCode2 + (url != null ? url.hashCode() : 0)) * 31) + this.uploadProgress) * 31;
        String str = this.error;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode3 + i11;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public void setUploadProgress(int i11) {
        this.uploadProgress = i11;
    }

    public void setUploadUrl(URL url) {
        this.uploadUrl = url;
    }

    public String toString() {
        return "file:" + this.file + " uploadUrl:" + this.uploadUrl + " progress:" + this.uploadProgress + super.toString();
    }

    public void update(VisitorAttachment visitorAttachment) {
        super.update(visitorAttachment);
        this.file = visitorAttachment.file;
        this.uploadUrl = visitorAttachment.uploadUrl;
        this.uploadProgress = visitorAttachment.uploadProgress;
        this.error = visitorAttachment.error;
    }
}
