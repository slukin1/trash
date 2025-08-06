package com.hbg.lib.network.hbg.core.bean;

import java.util.List;

public class ShareNewConfigInfo {
    public long buttonId;
    public List<String> channelList;
    public int isInvite;
    public String moduleTopFloatDoc;
    public int needLogin;
    public String pageBottomFloatDoc;
    public String pageButtonDoc;
    public long pageId;
    public String pageJumpUrl;
    public String pageTopFloatDoc;
    public String posterAdvertDoc;
    public String posterTitleDoc;
    public List<String> posterUrlList;
    public String registerTopFloatDoc;
    public String shareLinkDoc;
    public int state;

    public long getButtonId() {
        return this.buttonId;
    }

    public List<String> getChannelList() {
        return this.channelList;
    }

    public int getIsInvite() {
        return this.isInvite;
    }

    public String getModuleTopFloatDoc() {
        return this.moduleTopFloatDoc;
    }

    public int getNeedLogin() {
        return this.needLogin;
    }

    public String getPageBottomFloatDoc() {
        return this.pageBottomFloatDoc;
    }

    public String getPageButtonDoc() {
        return this.pageButtonDoc;
    }

    public long getPageId() {
        return this.pageId;
    }

    public String getPageJumpUrl() {
        return this.pageJumpUrl;
    }

    public String getPageTopFloatDoc() {
        return this.pageTopFloatDoc;
    }

    public String getPosterAdvertDoc() {
        return this.posterAdvertDoc;
    }

    public String getPosterTitleDoc() {
        return this.posterTitleDoc;
    }

    public List<String> getPosterUrlList() {
        return this.posterUrlList;
    }

    public String getRegisterTopFloatDoc() {
        return this.registerTopFloatDoc;
    }

    public String getShareLinkDoc() {
        return this.shareLinkDoc;
    }

    public int getState() {
        return this.state;
    }

    public void setButtonId(long j11) {
        this.buttonId = j11;
    }

    public void setChannelList(List<String> list) {
        this.channelList = list;
    }

    public void setIsInvite(int i11) {
        this.isInvite = i11;
    }

    public void setModuleTopFloatDoc(String str) {
        this.moduleTopFloatDoc = str;
    }

    public void setNeedLogin(int i11) {
        this.needLogin = i11;
    }

    public void setPageBottomFloatDoc(String str) {
        this.pageBottomFloatDoc = str;
    }

    public void setPageButtonDoc(String str) {
        this.pageButtonDoc = str;
    }

    public void setPageId(long j11) {
        this.pageId = j11;
    }

    public void setPageJumpUrl(String str) {
        this.pageJumpUrl = str;
    }

    public void setPageTopFloatDoc(String str) {
        this.pageTopFloatDoc = str;
    }

    public void setPosterAdvertDoc(String str) {
        this.posterAdvertDoc = str;
    }

    public void setPosterTitleDoc(String str) {
        this.posterTitleDoc = str;
    }

    public void setPosterUrlList(List<String> list) {
        this.posterUrlList = list;
    }

    public void setRegisterTopFloatDoc(String str) {
        this.registerTopFloatDoc = str;
    }

    public void setShareLinkDoc(String str) {
        this.shareLinkDoc = str;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "SharePageInfo{ \n posterTitleDoc='" + this.posterTitleDoc + '\'' + ", \n pageTopFloatDoc='" + this.pageTopFloatDoc + '\'' + ", \n pageButtonDoc='" + this.pageButtonDoc + '\'' + ", \n buttonId=" + this.buttonId + ", \n moduleTopFloatDoc='" + this.moduleTopFloatDoc + '\'' + ", \n posterAdvertDoc='" + this.posterAdvertDoc + '\'' + ", \n registerTopFloatDoc='" + this.registerTopFloatDoc + '\'' + ", \n state=" + this.state + ", \n needLogin=" + this.needLogin + ", \n isInvite=" + this.isInvite + ", \n shareLinkDoc='" + this.shareLinkDoc + '\'' + ", \n pageJumpUrl='" + this.pageJumpUrl + '\'' + ", \n pageBottomFloatDoc='" + this.pageBottomFloatDoc + '\'' + ", \n pageId=" + this.pageId + ", \n channelList=" + this.channelList + ", \n posterUrlList=" + this.posterUrlList + '}';
    }
}
