package com.sensorsdata.analytics.android.sdk.visual.model;

import java.io.Serializable;
import java.util.List;

public class WebNode implements Serializable {
    private static final long serialVersionUID = -5865016149609340219L;
    private String $element_content;
    private String $element_path;
    private String $element_position;
    private String $element_selector;
    private String $title;
    private String $url;
    private boolean enable_click;
    private float height;

    /* renamed from: id  reason: collision with root package name */
    private String f29944id;
    private boolean isRootView;
    private boolean is_list_view;
    private float left;
    private int level;
    private String lib_version;
    private String list_selector;
    private float originLeft;
    private float originTop;
    private float scale;
    private float scrollX;
    private float scrollY;
    private List<String> subelements;
    private String tagName;
    private float top;
    private boolean visibility;
    private float width;
    private int zIndex;

    public String get$element_content() {
        return this.$element_content;
    }

    public String get$element_path() {
        return this.$element_path;
    }

    public String get$element_position() {
        return this.$element_position;
    }

    public String get$element_selector() {
        return this.$element_selector;
    }

    public String get$title() {
        return this.$title;
    }

    public String get$url() {
        return this.$url;
    }

    public float getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f29944id;
    }

    public float getLeft() {
        return this.left;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLib_version() {
        return this.lib_version;
    }

    public String getList_selector() {
        return this.list_selector;
    }

    public float getOriginLeft() {
        return this.originLeft;
    }

    public float getOriginTop() {
        return this.originTop;
    }

    public float getScale() {
        return this.scale;
    }

    public float getScrollX() {
        return this.scrollX;
    }

    public float getScrollY() {
        return this.scrollY;
    }

    public List<String> getSubelements() {
        return this.subelements;
    }

    public String getTagName() {
        return this.tagName;
    }

    public float getTop() {
        return this.top;
    }

    public float getWidth() {
        return this.width;
    }

    public int getzIndex() {
        return this.zIndex;
    }

    public boolean isEnable_click() {
        return this.enable_click;
    }

    public boolean isIs_list_view() {
        return this.is_list_view;
    }

    public boolean isRootView() {
        return this.isRootView;
    }

    public boolean isVisibility() {
        return this.visibility;
    }

    public void set$element_content(String str) {
        this.$element_content = str;
    }

    public void set$element_path(String str) {
        this.$element_path = str;
    }

    public void set$element_position(String str) {
        this.$element_position = str;
    }

    public void set$element_selector(String str) {
        this.$element_selector = str;
    }

    public void set$title(String str) {
        this.$title = str;
    }

    public void set$url(String str) {
        this.$url = str;
    }

    public void setEnable_click(boolean z11) {
        this.enable_click = z11;
    }

    public void setHeight(float f11) {
        this.height = f11;
    }

    public void setId(String str) {
        this.f29944id = str;
    }

    public void setIs_list_view(boolean z11) {
        this.is_list_view = z11;
    }

    public void setLeft(float f11) {
        this.left = f11;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setLib_version(String str) {
        this.lib_version = str;
    }

    public void setList_selector(String str) {
        this.list_selector = str;
    }

    public void setOriginLeft(float f11) {
        this.originLeft = f11;
    }

    public void setOriginTop(float f11) {
        this.originTop = f11;
    }

    public void setRootView(boolean z11) {
        this.isRootView = z11;
    }

    public void setScale(float f11) {
        this.scale = f11;
    }

    public void setScrollX(float f11) {
        this.scrollX = f11;
    }

    public void setScrollY(float f11) {
        this.scrollY = f11;
    }

    public void setSubelements(List<String> list) {
        this.subelements = list;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setTop(float f11) {
        this.top = f11;
    }

    public void setVisibility(boolean z11) {
        this.visibility = z11;
    }

    public void setWidth(float f11) {
        this.width = f11;
    }

    public void setzIndex(int i11) {
        this.zIndex = i11;
    }
}
