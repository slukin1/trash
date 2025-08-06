package com.huobi.view.indexlist;

public class EntityWrapper<T> {
    public static final int TYPE_CONTENT = Integer.MAX_VALUE;
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_TITLE = 2147483646;
    private T data;
    private int headerFooterType;
    private String index;
    private String indexByField;
    private String indexTitle;
    private int itemType = Integer.MAX_VALUE;
    private int originalPosition = -1;

    public EntityWrapper() {
    }

    public T getData() {
        return this.data;
    }

    public int getHeaderFooterType() {
        return this.headerFooterType;
    }

    public String getIndex() {
        return this.index;
    }

    public String getIndexByField() {
        return this.indexByField;
    }

    public String getIndexTitle() {
        return this.indexTitle;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int getOriginalPosition() {
        return this.originalPosition;
    }

    public boolean isContent() {
        return this.itemType == Integer.MAX_VALUE;
    }

    public boolean isFooter() {
        return this.headerFooterType == 2;
    }

    public boolean isHeader() {
        return this.headerFooterType == 1;
    }

    public boolean isTitle() {
        return this.itemType == 2147483646;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setHeaderFooterType(int i11) {
        this.headerFooterType = i11;
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public void setIndexByField(String str) {
        this.indexByField = str;
    }

    public void setIndexTitle(String str) {
        this.indexTitle = str;
    }

    public void setItemType(int i11) {
        this.itemType = i11;
    }

    public void setOriginalPosition(int i11) {
        this.originalPosition = i11;
    }

    public EntityWrapper(String str, int i11) {
        this.index = str;
        this.indexTitle = str;
        this.itemType = i11;
    }
}
