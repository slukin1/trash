package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.SymbolCurrencyViewHandler;
import com.huobi.view.indexlist.IndexPartEntity;
import java.io.Serializable;
import s9.a;

public class SymbolCurrencyEntity implements IndexPartEntity, Serializable, a {
    public static final int TRADE_MARGIN_TYPE = 1;
    private String baseCurrency;
    private String descCanNotDeposit;
    private String descCanNotWithDraw;

    /* renamed from: id  reason: collision with root package name */
    private long f45391id;
    private int layoutType;
    private String name;
    private String quoteCurrency;
    private int status;

    public SymbolCurrencyEntity() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SymbolCurrencyEntity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SymbolCurrencyEntity)) {
            return false;
        }
        SymbolCurrencyEntity symbolCurrencyEntity = (SymbolCurrencyEntity) obj;
        if (!symbolCurrencyEntity.canEqual(this) || getId() != symbolCurrencyEntity.getId()) {
            return false;
        }
        String name2 = getName();
        String name3 = symbolCurrencyEntity.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        if (getStatus() != symbolCurrencyEntity.getStatus()) {
            return false;
        }
        String descCanNotDeposit2 = getDescCanNotDeposit();
        String descCanNotDeposit3 = symbolCurrencyEntity.getDescCanNotDeposit();
        if (descCanNotDeposit2 != null ? !descCanNotDeposit2.equals(descCanNotDeposit3) : descCanNotDeposit3 != null) {
            return false;
        }
        String descCanNotWithDraw2 = getDescCanNotWithDraw();
        String descCanNotWithDraw3 = symbolCurrencyEntity.getDescCanNotWithDraw();
        if (descCanNotWithDraw2 != null ? !descCanNotWithDraw2.equals(descCanNotWithDraw3) : descCanNotWithDraw3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = symbolCurrencyEntity.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = symbolCurrencyEntity.getQuoteCurrency();
        if (quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null) {
            return getLayoutType() == symbolCurrencyEntity.getLayoutType();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getDescCanNotDeposit() {
        return this.descCanNotDeposit;
    }

    public String getDescCanNotWithDraw() {
        return this.descCanNotWithDraw;
    }

    public String getFieldIndexBy() {
        return this.name;
    }

    public long getId() {
        return this.f45391id;
    }

    public int getLayoutType() {
        return this.layoutType;
    }

    public String getName() {
        return this.name;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSearchKey() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String getViewHandlerName() {
        return SymbolCurrencyViewHandler.class.getName();
    }

    public int hashCode() {
        long id2 = getId();
        String name2 = getName();
        int i11 = 43;
        int hashCode = ((((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + getStatus();
        String descCanNotDeposit2 = getDescCanNotDeposit();
        int hashCode2 = (hashCode * 59) + (descCanNotDeposit2 == null ? 43 : descCanNotDeposit2.hashCode());
        String descCanNotWithDraw2 = getDescCanNotWithDraw();
        int hashCode3 = (hashCode2 * 59) + (descCanNotWithDraw2 == null ? 43 : descCanNotWithDraw2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode4 = (hashCode3 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode4 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return ((i12 + i11) * 59) + getLayoutType();
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setDescCanNotDeposit(String str) {
        this.descCanNotDeposit = str;
    }

    public void setDescCanNotWithDraw(String str) {
        this.descCanNotWithDraw = str;
    }

    public void setId(long j11) {
        this.f45391id = j11;
    }

    public void setLayoutType(int i11) {
        this.layoutType = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "SymbolCurrencyEntity(id=" + getId() + ", name=" + getName() + ", status=" + getStatus() + ", descCanNotDeposit=" + getDescCanNotDeposit() + ", descCanNotWithDraw=" + getDescCanNotWithDraw() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", layoutType=" + getLayoutType() + ")";
    }

    public SymbolCurrencyEntity(String str) {
        this.name = str;
    }
}
