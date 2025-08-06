package com.hbg.lib.widgets.dialog.bean;

import android.view.View;
import com.hbg.lib.widgets.dialog.viewhander.BottomMenuHandler;
import com.hbg.lib.widgets.dialog.viewhander.PaymentMethodMenuHandler;
import java.io.Serializable;

public class MenuItemBean implements s9.a, Serializable {
    private int colorView;
    private a menuItemOnClickListener;
    private boolean payMethodKind;
    private MenuItemStyle style;
    private String text;
    private String textLeft;
    private String textRight;
    private String type;

    public enum MenuItemStyle {
        COMMON,
        STRESS,
        COMMON_BOLD
    }

    public interface a {
        void Xf(View view, MenuItemBean menuItemBean, int i11);
    }

    public MenuItemBean(String str, MenuItemStyle menuItemStyle, a aVar) {
        this("", str, menuItemStyle, aVar);
    }

    public int getColorView() {
        return this.colorView;
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

    public String getTextLeft() {
        return this.textLeft;
    }

    public String getTextRight() {
        return this.textRight;
    }

    public String getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        if (this.payMethodKind) {
            return PaymentMethodMenuHandler.class.getName();
        }
        return BottomMenuHandler.class.getName();
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

    public void setType(String str) {
        this.type = str;
    }

    public MenuItemBean(String str, String str2, MenuItemStyle menuItemStyle, a aVar) {
        this.payMethodKind = false;
        this.colorView = 0;
        this.type = str;
        this.text = str2;
        this.style = menuItemStyle;
        this.menuItemOnClickListener = aVar;
    }

    public MenuItemBean(String str, String str2, int i11, String str3, String str4, MenuItemStyle menuItemStyle, a aVar) {
        this.payMethodKind = false;
        this.colorView = 0;
        this.type = str;
        this.text = str2;
        this.colorView = i11;
        this.textLeft = str3;
        this.textRight = str4;
        this.style = menuItemStyle;
        this.menuItemOnClickListener = aVar;
        this.payMethodKind = true;
    }
}
