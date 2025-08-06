package com.huobi.domain.data.source.remote.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RemoteDomainInfo implements Serializable {
    private static final long serialVersionUID = -8100282455675877509L;
    @SerializedName(alternate = {"list"}, value = "list_cn")
    private List<String> list;
    @SerializedName("list_overseas")
    private List<String> listOverseas;
    @SerializedName("priority_cn")
    @Deprecated
    private String priorityCn;
    @SerializedName("priority_overseas")
    @Deprecated
    private String priorityOverseas;
    @SerializedName("url_cn")
    private String urlCn;
    @SerializedName("url_overseas")
    private String urlOverseas;

    public List<String> getList() {
        return this.list;
    }

    public List<String> getListOverseas() {
        return this.listOverseas;
    }

    @Deprecated
    public String getPriorityCn() {
        return this.priorityCn;
    }

    @Deprecated
    public String getPriorityOverseas() {
        return this.priorityOverseas;
    }

    public String getUrlCn() {
        return this.urlCn;
    }

    public String getUrlOverseas() {
        return this.urlOverseas;
    }

    public void setList(List<String> list2) {
        this.list = list2;
    }

    public void setListOverseas(List<String> list2) {
        this.listOverseas = list2;
    }

    @Deprecated
    public void setPriorityCn(String str) {
        this.priorityCn = str;
    }

    @Deprecated
    public void setPriorityOverseas(String str) {
        this.priorityOverseas = str;
    }

    public void setUrlCn(String str) {
        this.urlCn = str;
    }

    public void setUrlOverseas(String str) {
        this.urlOverseas = str;
    }
}
