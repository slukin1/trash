package com.hbg.component.kline.draw.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.converter.PropertyConverter;

public class KlineDrawLineBean implements Serializable {
    private static final long serialVersionUID = 7920669262940909842L;

    /* renamed from: id  reason: collision with root package name */
    private Long f67191id;
    private int lineColor;
    private int lineColorIndex;
    private float lineSize;
    private int lineSizeIndex;
    private int lineStyle;
    private int lineType;
    private boolean lock;
    private String period;
    private List<KlineDrawPointBean> pointList = new ArrayList();
    private String symbolId;
    private long updateTimestamp;

    public static class PointListConverter implements PropertyConverter<List<KlineDrawPointBean>, String> {

        public class a extends TypeToken<List<KlineDrawPointBean>> {
            public a() {
            }
        }

        /* renamed from: a */
        public String convertToDatabaseValue(List<KlineDrawPointBean> list) {
            if (list == null) {
                return null;
            }
            return new Gson().toJson((Object) list);
        }

        /* renamed from: b */
        public List<KlineDrawPointBean> convertToEntityProperty(String str) {
            if (str == null) {
                return null;
            }
            return (List) new Gson().fromJson(str, new a().getType());
        }
    }

    public KlineDrawLineBean(Long l11, String str, String str2, int i11, int i12, float f11, int i13, int i14, int i15, boolean z11, List<KlineDrawPointBean> list, long j11) {
        this.f67191id = l11;
        this.symbolId = str;
        this.period = str2;
        this.lineType = i11;
        this.lineStyle = i12;
        this.lineSize = f11;
        this.lineSizeIndex = i13;
        this.lineColor = i14;
        this.lineColorIndex = i15;
        this.lock = z11;
        this.pointList = list;
        this.updateTimestamp = j11;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof KlineDrawLineBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KlineDrawLineBean)) {
            return false;
        }
        KlineDrawLineBean klineDrawLineBean = (KlineDrawLineBean) obj;
        if (!klineDrawLineBean.canEqual(this)) {
            return false;
        }
        Long id2 = getId();
        Long id3 = klineDrawLineBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String symbolId2 = getSymbolId();
        String symbolId3 = klineDrawLineBean.getSymbolId();
        if (symbolId2 != null ? !symbolId2.equals(symbolId3) : symbolId3 != null) {
            return false;
        }
        String period2 = getPeriod();
        String period3 = klineDrawLineBean.getPeriod();
        if (period2 != null ? !period2.equals(period3) : period3 != null) {
            return false;
        }
        if (getLineType() != klineDrawLineBean.getLineType() || getLineStyle() != klineDrawLineBean.getLineStyle() || Float.compare(getLineSize(), klineDrawLineBean.getLineSize()) != 0 || getLineSizeIndex() != klineDrawLineBean.getLineSizeIndex() || getLineColor() != klineDrawLineBean.getLineColor() || getLineColorIndex() != klineDrawLineBean.getLineColorIndex() || getLock() != klineDrawLineBean.getLock()) {
            return false;
        }
        List<KlineDrawPointBean> pointList2 = getPointList();
        List<KlineDrawPointBean> pointList3 = klineDrawLineBean.getPointList();
        if (pointList2 != null ? pointList2.equals(pointList3) : pointList3 == null) {
            return getUpdateTimestamp() == klineDrawLineBean.getUpdateTimestamp();
        }
        return false;
    }

    public Long getId() {
        return this.f67191id;
    }

    public int getLineColor() {
        return this.lineColor;
    }

    public int getLineColorIndex() {
        return this.lineColorIndex;
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public int getLineSizeIndex() {
        return this.lineSizeIndex;
    }

    public int getLineStyle() {
        return this.lineStyle;
    }

    public int getLineType() {
        return this.lineType;
    }

    public boolean getLock() {
        return this.lock;
    }

    public String getPeriod() {
        return this.period;
    }

    public List<KlineDrawPointBean> getPointList() {
        return this.pointList;
    }

    public String getSymbolId() {
        return this.symbolId;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public int hashCode() {
        Long id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String symbolId2 = getSymbolId();
        int hashCode2 = ((hashCode + 59) * 59) + (symbolId2 == null ? 43 : symbolId2.hashCode());
        String period2 = getPeriod();
        int hashCode3 = (((((((((((((((hashCode2 * 59) + (period2 == null ? 43 : period2.hashCode())) * 59) + getLineType()) * 59) + getLineStyle()) * 59) + Float.floatToIntBits(getLineSize())) * 59) + getLineSizeIndex()) * 59) + getLineColor()) * 59) + getLineColorIndex()) * 59) + (getLock() ? 79 : 97);
        List<KlineDrawPointBean> pointList2 = getPointList();
        int i12 = hashCode3 * 59;
        if (pointList2 != null) {
            i11 = pointList2.hashCode();
        }
        long updateTimestamp2 = getUpdateTimestamp();
        return ((i12 + i11) * 59) + ((int) ((updateTimestamp2 >>> 32) ^ updateTimestamp2));
    }

    public void setId(Long l11) {
        this.f67191id = l11;
    }

    public void setLineColor(int i11) {
        this.lineColor = i11;
    }

    public void setLineColorIndex(int i11) {
        this.lineColorIndex = i11;
    }

    public void setLineSize(float f11) {
        this.lineSize = f11;
    }

    public void setLineSizeIndex(int i11) {
        this.lineSizeIndex = i11;
    }

    public void setLineStyle(int i11) {
        this.lineStyle = i11;
    }

    public void setLineType(int i11) {
        this.lineType = i11;
    }

    public void setLock(boolean z11) {
        this.lock = z11;
    }

    public void setPeriod(String str) {
        this.period = str;
    }

    public void setPointList(List<KlineDrawPointBean> list) {
        this.pointList = list;
    }

    public void setSymbolId(String str) {
        this.symbolId = str;
    }

    public void setUpdateTimestamp(long j11) {
        this.updateTimestamp = j11;
    }

    public String toString() {
        return "KlineDrawLineBean(id=" + getId() + ", symbolId=" + getSymbolId() + ", period=" + getPeriod() + ", lineType=" + getLineType() + ", lineStyle=" + getLineStyle() + ", lineSize=" + getLineSize() + ", lineSizeIndex=" + getLineSizeIndex() + ", lineColor=" + getLineColor() + ", lineColorIndex=" + getLineColorIndex() + ", lock=" + getLock() + ", pointList=" + getPointList() + ", updateTimestamp=" + getUpdateTimestamp() + ")";
    }

    public KlineDrawLineBean() {
    }
}
