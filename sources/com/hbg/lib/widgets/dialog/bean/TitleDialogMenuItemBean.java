package com.hbg.lib.widgets.dialog.bean;

import android.view.View;
import com.hbg.lib.widgets.dialog.viewhander.TitleDialogBottomMenuHandler;
import java.io.Serializable;

public class TitleDialogMenuItemBean<T> implements s9.a, Serializable {
    private T data;
    private a menuItemOnClickListener;
    private MenuItemStyle style;
    private String text;
    private int type;

    public enum MenuItemStyle {
        COMMON,
        STRESS
    }

    public interface a<T> {
        void a(View view, TitleDialogMenuItemBean<T> titleDialogMenuItemBean, int i11);
    }

    public TitleDialogMenuItemBean(String str, MenuItemStyle menuItemStyle, T t11, a<T> aVar) {
        this(-1, str, menuItemStyle, t11, aVar);
    }

    public T getData() {
        return this.data;
    }

    public a getMenuItemOnClickListener() {
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

    public String getViewHandlerName() {
        return TitleDialogBottomMenuHandler.class.getName();
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setMenuItemOnClickListener(a aVar) {
        this.menuItemOnClickListener = aVar;
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

    public TitleDialogMenuItemBean(int i11, String str, MenuItemStyle menuItemStyle, T t11, a aVar) {
        this.type = i11;
        this.text = str;
        this.style = menuItemStyle;
        this.data = t11;
        this.menuItemOnClickListener = aVar;
    }
}
