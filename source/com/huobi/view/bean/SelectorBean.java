package com.huobi.view.bean;

import android.view.View;
import com.huobi.view.viewhandler.SelectorItemHandler;
import java.io.Serializable;
import s9.a;

public class SelectorBean implements Serializable, a {
    private String name;
    private Object obj;
    private View.OnClickListener onClickListener;
    private boolean selected = false;

    public SelectorBean(String str) {
        this.name = str;
    }

    public boolean canEqual(Object obj2) {
        return obj2 instanceof SelectorBean;
    }

    public boolean equals(Object obj2) {
        if (obj2 == this) {
            return true;
        }
        if (!(obj2 instanceof SelectorBean)) {
            return false;
        }
        SelectorBean selectorBean = (SelectorBean) obj2;
        if (!selectorBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = selectorBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        Object obj3 = getObj();
        Object obj4 = selectorBean.getObj();
        if (obj3 != null ? !obj3.equals(obj4) : obj4 != null) {
            return false;
        }
        if (isSelected() != selectorBean.isSelected()) {
            return false;
        }
        View.OnClickListener onClickListener2 = getOnClickListener();
        View.OnClickListener onClickListener3 = selectorBean.getOnClickListener();
        return onClickListener2 != null ? onClickListener2.equals(onClickListener3) : onClickListener3 == null;
    }

    public String getName() {
        return this.name;
    }

    public Object getObj() {
        return this.obj;
    }

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public String getViewHandlerName() {
        return SelectorItemHandler.class.getName();
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        Object obj2 = getObj();
        int hashCode2 = ((((hashCode + 59) * 59) + (obj2 == null ? 43 : obj2.hashCode())) * 59) + (isSelected() ? 79 : 97);
        View.OnClickListener onClickListener2 = getOnClickListener();
        int i12 = hashCode2 * 59;
        if (onClickListener2 != null) {
            i11 = onClickListener2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObj(Object obj2) {
        this.obj = obj2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public void setSelected(boolean z11) {
        this.selected = z11;
    }

    public String toString() {
        return "SelectorBean(name=" + getName() + ", obj=" + getObj() + ", selected=" + isSelected() + ", onClickListener=" + getOnClickListener() + ")";
    }

    public SelectorBean(String str, Object obj2) {
        this.name = str;
        this.obj = obj2;
    }
}
