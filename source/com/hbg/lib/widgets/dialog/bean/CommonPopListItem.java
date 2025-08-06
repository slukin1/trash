package com.hbg.lib.widgets.dialog.bean;

import android.content.Context;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.dialog.viewhander.CommonPopListItemHandler;
import java.io.Serializable;

public class CommonPopListItem implements Serializable, s9.a {
    private a callback;
    private int checkedTextColor;
    private int childType;
    private String text;
    private int type;
    private int unCheckedTextColor;

    public interface a {
        void V6(CommonPopListItem commonPopListItem);

        boolean ic(CommonPopListItem commonPopListItem);
    }

    public CommonPopListItem(int i11, String str, a aVar) {
        this(i11, str, 0, aVar);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CommonPopListItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommonPopListItem)) {
            return false;
        }
        CommonPopListItem commonPopListItem = (CommonPopListItem) obj;
        if (!commonPopListItem.canEqual(this) || getType() != commonPopListItem.getType() || getChildType() != commonPopListItem.getChildType()) {
            return false;
        }
        String text2 = getText();
        String text3 = commonPopListItem.getText();
        if (text2 != null ? !text2.equals(text3) : text3 != null) {
            return false;
        }
        if (getCheckedTextColor() != commonPopListItem.getCheckedTextColor() || getUnCheckedTextColor() != commonPopListItem.getUnCheckedTextColor()) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = commonPopListItem.getCallback();
        return callback2 != null ? callback2.equals(callback3) : callback3 == null;
    }

    public a getCallback() {
        return this.callback;
    }

    public int getCheckedTextColor() {
        return this.checkedTextColor;
    }

    public int getChildType() {
        return this.childType;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public int getUnCheckedTextColor() {
        return this.unCheckedTextColor;
    }

    public String getViewHandlerName() {
        return CommonPopListItemHandler.class.getName();
    }

    public int hashCode() {
        int type2 = ((getType() + 59) * 59) + getChildType();
        String text2 = getText();
        int i11 = 43;
        int hashCode = (((((type2 * 59) + (text2 == null ? 43 : text2.hashCode())) * 59) + getCheckedTextColor()) * 59) + getUnCheckedTextColor();
        a callback2 = getCallback();
        int i12 = hashCode * 59;
        if (callback2 != null) {
            i11 = callback2.hashCode();
        }
        return i12 + i11;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setCheckedTextColor(int i11) {
        this.checkedTextColor = i11;
    }

    public void setChildType(int i11) {
        this.childType = i11;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUnCheckedTextColor(int i11) {
        this.unCheckedTextColor = i11;
    }

    public String toString() {
        return "CommonPopListItem(type=" + getType() + ", childType=" + getChildType() + ", text=" + getText() + ", checkedTextColor=" + getCheckedTextColor() + ", unCheckedTextColor=" + getUnCheckedTextColor() + ", callback=" + getCallback() + ")";
    }

    public CommonPopListItem(int i11, String str, int i12, a aVar) {
        this(i11, str, i12, 0, aVar);
    }

    public int getCheckedTextColor(Context context) {
        int i11 = this.checkedTextColor;
        if (i11 != 0) {
            return i11;
        }
        return context.getResources().getColor(R$color.baseColorPrimaryText);
    }

    public int getUnCheckedTextColor(Context context) {
        int i11 = this.unCheckedTextColor;
        if (i11 != 0) {
            return i11;
        }
        return context.getResources().getColor(R$color.baseColorSecondaryText);
    }

    public CommonPopListItem(int i11, String str, int i12, int i13, a aVar) {
        setType(i11);
        setText(str);
        setCheckedTextColor(i12);
        setUnCheckedTextColor(i13);
        setCallback(aVar);
    }
}
