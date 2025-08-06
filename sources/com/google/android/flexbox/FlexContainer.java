package com.google.android.flexbox;

import android.view.View;
import java.util.List;

interface FlexContainer {
    public static final int NOT_SET = -1;

    void addView(View view);

    void addView(View view, int i11);

    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int i11, int i12, int i13);

    int getChildWidthMeasureSpec(int i11, int i12, int i13);

    int getDecorationLengthCrossAxis(View view);

    int getDecorationLengthMainAxis(View view, int i11, int i12);

    int getFlexDirection();

    View getFlexItemAt(int i11);

    int getFlexItemCount();

    List<FlexLine> getFlexLines();

    List<FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    View getReorderedFlexItemAt(int i11);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(View view, int i11, int i12, FlexLine flexLine);

    void onNewFlexLineAdded(FlexLine flexLine);

    void removeAllViews();

    void removeViewAt(int i11);

    void setAlignContent(int i11);

    void setAlignItems(int i11);

    void setFlexDirection(int i11);

    void setFlexLines(List<FlexLine> list);

    void setFlexWrap(int i11);

    void setJustifyContent(int i11);

    void setMaxLine(int i11);

    void updateViewCache(int i11, View view);
}
