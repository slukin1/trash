package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class DeepNews implements Serializable {
    private String abstraction;
    private String author;
    private String content;
    private long dynamicId;

    /* renamed from: id  reason: collision with root package name */
    private long f70235id;
    private String imgUrl;
    private int isTop;
    private long issueTime;
    private String redact;
    private String source;
    private String sourceLink;
    private String title;
    private String visit;

    public String getAbstraction() {
        return this.abstraction;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getContent() {
        return this.content;
    }

    public long getDynamicId() {
        return this.dynamicId;
    }

    public long getId() {
        return this.f70235id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getIsTop() {
        return this.isTop;
    }

    public long getIssueTime() {
        return this.issueTime;
    }

    public String getRedact() {
        return this.redact;
    }

    public String getSource() {
        return this.source;
    }

    public String getSourceLink() {
        return this.sourceLink;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVisit() {
        return this.visit;
    }

    public void setAbstraction(String str) {
        this.abstraction = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDynamicId(long j11) {
        this.dynamicId = j11;
    }

    public void setId(long j11) {
        this.f70235id = j11;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setIsTop(int i11) {
        this.isTop = i11;
    }

    public void setIssueTime(long j11) {
        this.issueTime = j11;
    }

    public void setRedact(String str) {
        this.redact = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSourceLink(String str) {
        this.sourceLink = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVisit(String str) {
        this.visit = str;
    }
}
