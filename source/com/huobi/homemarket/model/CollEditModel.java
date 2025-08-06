package com.huobi.homemarket.model;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.huobi.homemarket.handler.CollEditViewHandler;
import java.io.Serializable;

public class CollEditModel implements Serializable, s9.a {
    private a callback;
    private boolean isCollection;
    private ItemTouchHelper itemTouchHelp;
    private String quoteCurrency;
    private String showSymbol;
    private String symbol;
    private double volume;
    private int weight;

    public interface a {
        void a(CollEditModel collEditModel);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CollEditModel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollEditModel)) {
            return false;
        }
        CollEditModel collEditModel = (CollEditModel) obj;
        if (!collEditModel.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = collEditModel.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String showSymbol2 = getShowSymbol();
        String showSymbol3 = collEditModel.getShowSymbol();
        if (showSymbol2 != null ? !showSymbol2.equals(showSymbol3) : showSymbol3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = collEditModel.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        if (Double.compare(getVolume(), collEditModel.getVolume()) != 0 || isCollection() != collEditModel.isCollection() || getWeight() != collEditModel.getWeight()) {
            return false;
        }
        ItemTouchHelper itemTouchHelp2 = getItemTouchHelp();
        ItemTouchHelper itemTouchHelp3 = collEditModel.getItemTouchHelp();
        if (itemTouchHelp2 != null ? !itemTouchHelp2.equals(itemTouchHelp3) : itemTouchHelp3 != null) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = collEditModel.getCallback();
        return callback2 != null ? callback2.equals(callback3) : callback3 == null;
    }

    public a getCallback() {
        return this.callback;
    }

    public ItemTouchHelper getItemTouchHelp() {
        return this.itemTouchHelp;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getShowSymbol() {
        return this.showSymbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return CollEditViewHandler.class.getName();
    }

    public double getVolume() {
        return this.volume;
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String showSymbol2 = getShowSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (showSymbol2 == null ? 43 : showSymbol2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(getVolume());
        int weight2 = (((((hashCode3 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + (isCollection() ? 79 : 97)) * 59) + getWeight();
        ItemTouchHelper itemTouchHelp2 = getItemTouchHelp();
        int hashCode4 = (weight2 * 59) + (itemTouchHelp2 == null ? 43 : itemTouchHelp2.hashCode());
        a callback2 = getCallback();
        int i12 = hashCode4 * 59;
        if (callback2 != null) {
            i11 = callback2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isCollection() {
        return this.isCollection;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setCollection(boolean z11) {
        this.isCollection = z11;
    }

    public void setItemTouchHelp(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelp = itemTouchHelper;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setShowSymbol(String str) {
        this.showSymbol = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setVolume(double d11) {
        this.volume = d11;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "CollEditModel(symbol=" + getSymbol() + ", showSymbol=" + getShowSymbol() + ", quoteCurrency=" + getQuoteCurrency() + ", volume=" + getVolume() + ", isCollection=" + isCollection() + ", weight=" + getWeight() + ", itemTouchHelp=" + getItemTouchHelp() + ", callback=" + getCallback() + ")";
    }
}
