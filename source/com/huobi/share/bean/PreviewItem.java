package com.huobi.share.bean;

import android.graphics.Bitmap;
import java.io.Serializable;

public class PreviewItem implements Serializable {
    private Bitmap bmp;
    public String content;
    public int downNumber;

    /* renamed from: id  reason: collision with root package name */
    public long f80866id;
    public long issueTime;
    public int raiseNumber;
    public String shareImg;
    private int styleLayout;
    private String template;
    public String title;

    public PreviewItem(String str, String str2, long j11, int i11, int i12, String str3, int i13) {
        this.title = str;
        this.content = str2;
        this.issueTime = j11;
        this.raiseNumber = i11;
        this.downNumber = i12;
        this.shareImg = str3;
        this.styleLayout = i13;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PreviewItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreviewItem)) {
            return false;
        }
        PreviewItem previewItem = (PreviewItem) obj;
        if (!previewItem.canEqual(this)) {
            return false;
        }
        String title2 = getTitle();
        String title3 = previewItem.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = previewItem.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        if (getIssueTime() != previewItem.getIssueTime() || getRaiseNumber() != previewItem.getRaiseNumber() || getDownNumber() != previewItem.getDownNumber()) {
            return false;
        }
        String shareImg2 = getShareImg();
        String shareImg3 = previewItem.getShareImg();
        if (shareImg2 != null ? !shareImg2.equals(shareImg3) : shareImg3 != null) {
            return false;
        }
        Bitmap bmp2 = getBmp();
        Bitmap bmp3 = previewItem.getBmp();
        if (bmp2 != null ? !bmp2.equals(bmp3) : bmp3 != null) {
            return false;
        }
        if (getStyleLayout() != previewItem.getStyleLayout()) {
            return false;
        }
        String template2 = getTemplate();
        String template3 = previewItem.getTemplate();
        if (template2 != null ? template2.equals(template3) : template3 == null) {
            return getId() == previewItem.getId();
        }
        return false;
    }

    public Bitmap getBmp() {
        return this.bmp;
    }

    public String getContent() {
        return this.content;
    }

    public Bitmap getContentBmp() {
        return this.bmp;
    }

    public int getDownNumber() {
        return this.downNumber;
    }

    public long getId() {
        return this.f80866id;
    }

    public long getIssueTime() {
        return this.issueTime;
    }

    public int getLayoutRes() {
        return this.styleLayout;
    }

    public int getRaiseNumber() {
        return this.raiseNumber;
    }

    public String getShareImg() {
        return this.shareImg;
    }

    public int getStyleLayout() {
        return this.styleLayout;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = title2 == null ? 43 : title2.hashCode();
        String content2 = getContent();
        int hashCode2 = ((hashCode + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
        long issueTime2 = getIssueTime();
        int raiseNumber2 = (((((hashCode2 * 59) + ((int) (issueTime2 ^ (issueTime2 >>> 32)))) * 59) + getRaiseNumber()) * 59) + getDownNumber();
        String shareImg2 = getShareImg();
        int hashCode3 = (raiseNumber2 * 59) + (shareImg2 == null ? 43 : shareImg2.hashCode());
        Bitmap bmp2 = getBmp();
        int hashCode4 = (((hashCode3 * 59) + (bmp2 == null ? 43 : bmp2.hashCode())) * 59) + getStyleLayout();
        String template2 = getTemplate();
        int i12 = hashCode4 * 59;
        if (template2 != null) {
            i11 = template2.hashCode();
        }
        long id2 = getId();
        return ((i12 + i11) * 59) + ((int) ((id2 >>> 32) ^ id2));
    }

    public void setBmp(Bitmap bitmap) {
        this.bmp = bitmap;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentBmp(Bitmap bitmap) {
        this.bmp = bitmap;
    }

    public void setDownNumber(int i11) {
        this.downNumber = i11;
    }

    public void setId(long j11) {
        this.f80866id = j11;
    }

    public void setIssueTime(long j11) {
        this.issueTime = j11;
    }

    public void setLayoutRes(int i11) {
        this.styleLayout = i11;
    }

    public void setRaiseNumber(int i11) {
        this.raiseNumber = i11;
    }

    public void setShareImg(String str) {
        this.shareImg = str;
    }

    public void setStyleLayout(int i11) {
        this.styleLayout = i11;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PreviewItem(title=" + getTitle() + ", content=" + getContent() + ", issueTime=" + getIssueTime() + ", raiseNumber=" + getRaiseNumber() + ", downNumber=" + getDownNumber() + ", shareImg=" + getShareImg() + ", bmp=" + getBmp() + ", styleLayout=" + getStyleLayout() + ", template=" + getTemplate() + ", id=" + getId() + ")";
    }

    public PreviewItem() {
    }
}
