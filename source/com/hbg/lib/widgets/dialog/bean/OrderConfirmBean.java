package com.hbg.lib.widgets.dialog.bean;

import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.dialog.viewhander.OrderConfirmListItemHandler;
import com.hbg.lib.widgets.dialog.viewhander.OrderConfirmListItemHandlerNew;
import com.hbg.lib.widgets.dialog.viewhander.OrderConfirmTpSlItemHandler;
import com.hbg.lib.widgets.dialog.viewhander.OrderDividerItemHandler;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class OrderConfirmBean implements Serializable {
    private String confirmBtnText;
    private String hint;
    private List<ListItem> list;
    private String title;
    private String topHint;

    public static class DividerItem extends ListItem {
        public boolean canEqual(Object obj) {
            return obj instanceof DividerItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof DividerItem) && ((DividerItem) obj).canEqual(this) && super.equals(obj);
        }

        public String getViewHandlerName() {
            return OrderDividerItemHandler.class.getName();
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            return "OrderConfirmBean.DividerItem()";
        }
    }

    public static class ListItem implements a, Serializable {
        private String key;
        private boolean showDividerLine = true;
        private boolean useNewStyle = false;
        private CharSequence value;
        private int valueColor;
        private String valueExtra;
        private int valueExtraColorRes = R$color.baseColorSecondaryText;

        public boolean canEqual(Object obj) {
            return obj instanceof ListItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ListItem)) {
                return false;
            }
            ListItem listItem = (ListItem) obj;
            if (!listItem.canEqual(this)) {
                return false;
            }
            String key2 = getKey();
            String key3 = listItem.getKey();
            if (key2 != null ? !key2.equals(key3) : key3 != null) {
                return false;
            }
            CharSequence value2 = getValue();
            CharSequence value3 = listItem.getValue();
            if (value2 != null ? !value2.equals(value3) : value3 != null) {
                return false;
            }
            String valueExtra2 = getValueExtra();
            String valueExtra3 = listItem.getValueExtra();
            if (valueExtra2 != null ? valueExtra2.equals(valueExtra3) : valueExtra3 == null) {
                return getValueColor() == listItem.getValueColor() && getValueExtraColorRes() == listItem.getValueExtraColorRes() && isShowDividerLine() == listItem.isShowDividerLine() && isUseNewStyle() == listItem.isUseNewStyle();
            }
            return false;
        }

        public String getKey() {
            return this.key;
        }

        public CharSequence getValue() {
            return this.value;
        }

        public int getValueColor() {
            return this.valueColor;
        }

        public String getValueExtra() {
            return this.valueExtra;
        }

        public int getValueExtraColorRes() {
            return this.valueExtraColorRes;
        }

        public String getViewHandlerName() {
            if (this.useNewStyle) {
                return OrderConfirmListItemHandlerNew.class.getName();
            }
            return OrderConfirmListItemHandler.class.getName();
        }

        public int hashCode() {
            String key2 = getKey();
            int i11 = 43;
            int hashCode = key2 == null ? 43 : key2.hashCode();
            CharSequence value2 = getValue();
            int hashCode2 = ((hashCode + 59) * 59) + (value2 == null ? 43 : value2.hashCode());
            String valueExtra2 = getValueExtra();
            int i12 = hashCode2 * 59;
            if (valueExtra2 != null) {
                i11 = valueExtra2.hashCode();
            }
            int i13 = 79;
            int valueColor2 = (((((((i12 + i11) * 59) + getValueColor()) * 59) + getValueExtraColorRes()) * 59) + (isShowDividerLine() ? 79 : 97)) * 59;
            if (!isUseNewStyle()) {
                i13 = 97;
            }
            return valueColor2 + i13;
        }

        public boolean isShowDividerLine() {
            return this.showDividerLine;
        }

        public boolean isUseNewStyle() {
            return this.useNewStyle;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setShowDividerLine(boolean z11) {
            this.showDividerLine = z11;
        }

        public void setUseNewStyle(boolean z11) {
            this.useNewStyle = z11;
        }

        public void setValue(CharSequence charSequence) {
            this.value = charSequence;
        }

        public void setValueColor(int i11) {
            this.valueColor = i11;
        }

        public void setValueExtra(String str) {
            this.valueExtra = str;
        }

        public void setValueExtraColorRes(int i11) {
            this.valueExtraColorRes = i11;
        }

        public String toString() {
            return "OrderConfirmBean.ListItem(key=" + getKey() + ", value=" + getValue() + ", valueExtra=" + getValueExtra() + ", valueColor=" + getValueColor() + ", valueExtraColorRes=" + getValueExtraColorRes() + ", showDividerLine=" + isShowDividerLine() + ", useNewStyle=" + isUseNewStyle() + ")";
        }
    }

    public static class TpSlItem extends ListItem {
        private String entrustPrice;
        private String entrustPriceTitle;
        private int itemBgDrawableRes;
        private int textColorRes;
        private String triggerPrice;
        private String triggerPriceTitle;

        public boolean canEqual(Object obj) {
            return obj instanceof TpSlItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TpSlItem)) {
                return false;
            }
            TpSlItem tpSlItem = (TpSlItem) obj;
            if (!tpSlItem.canEqual(this) || !super.equals(obj) || getItemBgDrawableRes() != tpSlItem.getItemBgDrawableRes() || getTextColorRes() != tpSlItem.getTextColorRes()) {
                return false;
            }
            String triggerPriceTitle2 = getTriggerPriceTitle();
            String triggerPriceTitle3 = tpSlItem.getTriggerPriceTitle();
            if (triggerPriceTitle2 != null ? !triggerPriceTitle2.equals(triggerPriceTitle3) : triggerPriceTitle3 != null) {
                return false;
            }
            String triggerPrice2 = getTriggerPrice();
            String triggerPrice3 = tpSlItem.getTriggerPrice();
            if (triggerPrice2 != null ? !triggerPrice2.equals(triggerPrice3) : triggerPrice3 != null) {
                return false;
            }
            String entrustPriceTitle2 = getEntrustPriceTitle();
            String entrustPriceTitle3 = tpSlItem.getEntrustPriceTitle();
            if (entrustPriceTitle2 != null ? !entrustPriceTitle2.equals(entrustPriceTitle3) : entrustPriceTitle3 != null) {
                return false;
            }
            String entrustPrice2 = getEntrustPrice();
            String entrustPrice3 = tpSlItem.getEntrustPrice();
            return entrustPrice2 != null ? entrustPrice2.equals(entrustPrice3) : entrustPrice3 == null;
        }

        public String getEntrustPrice() {
            return this.entrustPrice;
        }

        public String getEntrustPriceTitle() {
            return this.entrustPriceTitle;
        }

        public int getItemBgDrawableRes() {
            return this.itemBgDrawableRes;
        }

        public int getTextColorRes() {
            return this.textColorRes;
        }

        public String getTriggerPrice() {
            return this.triggerPrice;
        }

        public String getTriggerPriceTitle() {
            return this.triggerPriceTitle;
        }

        public String getViewHandlerName() {
            return OrderConfirmTpSlItemHandler.class.getName();
        }

        public int hashCode() {
            int hashCode = (((super.hashCode() * 59) + getItemBgDrawableRes()) * 59) + getTextColorRes();
            String triggerPriceTitle2 = getTriggerPriceTitle();
            int i11 = 43;
            int hashCode2 = (hashCode * 59) + (triggerPriceTitle2 == null ? 43 : triggerPriceTitle2.hashCode());
            String triggerPrice2 = getTriggerPrice();
            int hashCode3 = (hashCode2 * 59) + (triggerPrice2 == null ? 43 : triggerPrice2.hashCode());
            String entrustPriceTitle2 = getEntrustPriceTitle();
            int hashCode4 = (hashCode3 * 59) + (entrustPriceTitle2 == null ? 43 : entrustPriceTitle2.hashCode());
            String entrustPrice2 = getEntrustPrice();
            int i12 = hashCode4 * 59;
            if (entrustPrice2 != null) {
                i11 = entrustPrice2.hashCode();
            }
            return i12 + i11;
        }

        public void setEntrustPrice(String str) {
            this.entrustPrice = str;
        }

        public void setEntrustPriceTitle(String str) {
            this.entrustPriceTitle = str;
        }

        public void setItemBgDrawableRes(int i11) {
            this.itemBgDrawableRes = i11;
        }

        public void setTextColorRes(int i11) {
            this.textColorRes = i11;
        }

        public void setTriggerPrice(String str) {
            this.triggerPrice = str;
        }

        public void setTriggerPriceTitle(String str) {
            this.triggerPriceTitle = str;
        }

        public String toString() {
            return "OrderConfirmBean.TpSlItem(itemBgDrawableRes=" + getItemBgDrawableRes() + ", textColorRes=" + getTextColorRes() + ", triggerPriceTitle=" + getTriggerPriceTitle() + ", triggerPrice=" + getTriggerPrice() + ", entrustPriceTitle=" + getEntrustPriceTitle() + ", entrustPrice=" + getEntrustPrice() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OrderConfirmBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderConfirmBean)) {
            return false;
        }
        OrderConfirmBean orderConfirmBean = (OrderConfirmBean) obj;
        if (!orderConfirmBean.canEqual(this)) {
            return false;
        }
        String title2 = getTitle();
        String title3 = orderConfirmBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String topHint2 = getTopHint();
        String topHint3 = orderConfirmBean.getTopHint();
        if (topHint2 != null ? !topHint2.equals(topHint3) : topHint3 != null) {
            return false;
        }
        List<ListItem> list2 = getList();
        List<ListItem> list3 = orderConfirmBean.getList();
        if (list2 != null ? !list2.equals(list3) : list3 != null) {
            return false;
        }
        String hint2 = getHint();
        String hint3 = orderConfirmBean.getHint();
        if (hint2 != null ? !hint2.equals(hint3) : hint3 != null) {
            return false;
        }
        String confirmBtnText2 = getConfirmBtnText();
        String confirmBtnText3 = orderConfirmBean.getConfirmBtnText();
        return confirmBtnText2 != null ? confirmBtnText2.equals(confirmBtnText3) : confirmBtnText3 == null;
    }

    public String getConfirmBtnText() {
        return this.confirmBtnText;
    }

    public String getHint() {
        return this.hint;
    }

    public List<ListItem> getList() {
        return this.list;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopHint() {
        return this.topHint;
    }

    public int hashCode() {
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = title2 == null ? 43 : title2.hashCode();
        String topHint2 = getTopHint();
        int hashCode2 = ((hashCode + 59) * 59) + (topHint2 == null ? 43 : topHint2.hashCode());
        List<ListItem> list2 = getList();
        int hashCode3 = (hashCode2 * 59) + (list2 == null ? 43 : list2.hashCode());
        String hint2 = getHint();
        int hashCode4 = (hashCode3 * 59) + (hint2 == null ? 43 : hint2.hashCode());
        String confirmBtnText2 = getConfirmBtnText();
        int i12 = hashCode4 * 59;
        if (confirmBtnText2 != null) {
            i11 = confirmBtnText2.hashCode();
        }
        return i12 + i11;
    }

    public void setConfirmBtnText(String str) {
        this.confirmBtnText = str;
    }

    public void setHint(String str) {
        this.hint = str;
    }

    public void setList(List<ListItem> list2) {
        this.list = list2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopHint(String str) {
        this.topHint = str;
    }

    public String toString() {
        return "OrderConfirmBean(title=" + getTitle() + ", topHint=" + getTopHint() + ", list=" + getList() + ", hint=" + getHint() + ", confirmBtnText=" + getConfirmBtnText() + ")";
    }
}
