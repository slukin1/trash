package com.sensorsdata.analytics.android.sdk.visual.model;

import android.view.View;
import java.io.Serializable;
import java.lang.ref.WeakReference;

public class ViewNode implements Serializable {
    private static final long serialVersionUID = -1242947408632673572L;
    private boolean isListView;
    private WeakReference<View> view;
    private String viewContent;
    private String viewOriginalPath;
    private String viewPath;
    private String viewPosition;
    private String viewType;

    public ViewNode(String str, String str2) {
        this((View) null, (String) null, (String) null, (String) null, str, str2, false);
    }

    public WeakReference<View> getView() {
        return this.view;
    }

    public String getViewContent() {
        return this.viewContent;
    }

    public String getViewOriginalPath() {
        return this.viewOriginalPath;
    }

    public String getViewPath() {
        return this.viewPath;
    }

    public String getViewPosition() {
        return this.viewPosition;
    }

    public String getViewType() {
        return this.viewType;
    }

    public boolean isListView() {
        return this.isListView;
    }

    public void setListView(boolean z11) {
        this.isListView = z11;
    }

    public void setViewContent(String str) {
        this.viewContent = str;
    }

    public void setViewOriginalPath(String str) {
        this.viewOriginalPath = str;
    }

    public void setViewPath(String str) {
        this.viewPath = str;
    }

    public void setViewPosition(String str) {
        this.viewPosition = str;
    }

    public void setViewType(String str) {
        this.viewType = str;
    }

    public ViewNode(View view2, String str, String str2, String str3, String str4) {
        this(view2, str, str2, str3, str4, (String) null, false);
    }

    public ViewNode(View view2, String str, String str2, String str3, String str4, String str5, boolean z11) {
        this.view = new WeakReference<>(view2);
        this.viewPosition = str;
        this.viewOriginalPath = str2;
        this.viewPath = str3;
        this.viewContent = str4;
        this.viewType = str5;
        this.isListView = z11;
    }
}
