package com.huobi.view.bottompopfragmentmenu;

public class MenuItem {
    private String item_name;
    private MenuItemOnClickListener menuItemOnClickListener;
    private MenuItemStyle style;
    private String text;
    private int type;

    public enum MenuItemStyle {
        COMMON,
        STRESS
    }

    public MenuItem() {
    }

    public String getItem_name() {
        return this.item_name;
    }

    public MenuItemOnClickListener getMenuItemOnClickListener() {
        return this.menuItemOnClickListener;
    }

    public MenuItemStyle getStyle() {
        return this.style;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public void setItem_name(String str) {
        this.item_name = str;
    }

    public void setMenuItemOnClickListener(MenuItemOnClickListener menuItemOnClickListener2) {
        this.menuItemOnClickListener = menuItemOnClickListener2;
    }

    public void setStyle(MenuItemStyle menuItemStyle) {
        this.style = menuItemStyle;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public MenuItem(String str, String str2, MenuItemStyle menuItemStyle, MenuItemOnClickListener menuItemOnClickListener2) {
        this(0, str, str2, menuItemStyle, menuItemOnClickListener2);
    }

    public MenuItem(int i11, String str, String str2, MenuItemStyle menuItemStyle, MenuItemOnClickListener menuItemOnClickListener2) {
        this.type = i11;
        this.item_name = str;
        this.text = str2;
        this.style = menuItemStyle;
        this.menuItemOnClickListener = menuItemOnClickListener2;
    }
}
