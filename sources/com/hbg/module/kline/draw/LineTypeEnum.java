package com.hbg.module.kline.draw;

import android.content.Context;
import android.util.TypedValue;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$string;

public enum LineTypeEnum {
    LINE_SEGMENT(1, R$string.n_kline_line_segment, R$attr.kline_draw_linesegment_selector_attr, 2, 1),
    H_LINE_SEGMENT(2, R$string.n_kline_line_horizonal, R$attr.kline_draw_horizontalline_selector_attr, 2, 1),
    V_LINE_SEGMENT(3, R$string.n_kline_line_vertical, R$attr.kline_draw_verticalline_selector_attr, 2, 1),
    RAY(4, R$string.n_kline_ray, R$attr.kline_draw_ray_selector_attr, 2, 1),
    PARALLEL_CHANNEL(5, R$string.n_kline_line_parallel, R$attr.kline_draw_parallelchannel_selector_attr, 3, 1),
    RECTANGLE(6, R$string.n_kline_rect, R$attr.kline_draw_rectangle_selector_attr, 2, 2),
    PARALLELOGRAM(7, R$string.n_kline_rhomboid, R$attr.kline_draw_parallelogram_selector_attr, 3, 2);
    
    private int anchorCount;
    private int groupId;
    private int iconId;
    private int nameId;
    private int type;

    private LineTypeEnum(int i11, int i12, int i13, int i14, int i15) {
        this.type = i11;
        this.nameId = i12;
        this.iconId = i13;
        this.anchorCount = i14;
        this.groupId = i15;
    }

    public static int getIconResourceId(Context context, LineTypeEnum lineTypeEnum) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(lineTypeEnum.getIconId(), typedValue, true);
        return typedValue.resourceId;
    }

    public static LineTypeEnum getLineType(int i11) {
        LineTypeEnum[] values = values();
        for (int i12 = 0; i12 < values.length; i12++) {
            if (values[i12].getType() == i11) {
                return values[i12];
            }
        }
        return LINE_SEGMENT;
    }

    public int getAnchorCount() {
        return this.anchorCount;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getIconId() {
        return this.iconId;
    }

    public int getNameId() {
        return this.nameId;
    }

    public int getType() {
        return this.type;
    }
}
