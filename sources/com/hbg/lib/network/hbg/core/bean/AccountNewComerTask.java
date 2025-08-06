package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import java.io.Serializable;
import java.util.List;

public class AccountNewComerTask implements Serializable {
    private static final long serialVersionUID = 2192314880229045202L;
    private String bubbleTitle;
    private String h5Url;

    /* renamed from: id  reason: collision with root package name */
    private long f70216id;
    private String name;
    private int status;
    private List<AccountTaskResp.TaskAwardResp> taskAwards;
    private int taskType;
    private String title;
    private String url;

    public String getBubbleTitle() {
        return this.bubbleTitle;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public long getId() {
        return this.f70216id;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public List<AccountTaskResp.TaskAwardResp> getTaskAwards() {
        return this.taskAwards;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBubbleTitle(String str) {
        this.bubbleTitle = str;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setId(long j11) {
        this.f70216id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTaskAwards(List<AccountTaskResp.TaskAwardResp> list) {
        this.taskAwards = list;
    }

    public void setTaskType(int i11) {
        this.taskType = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
