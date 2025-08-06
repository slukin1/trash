package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.c;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void gainFocus(int i11, Rect rect) {
        if (i11 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i11 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i11, rect);
        }
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(Long l11, Long l12, Long l13, Long l14) {
        return l11 == null || l12 == null || l13 == null || l14 == null || l13.longValue() > l12.longValue() || l14.longValue() < l11.longValue();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    public final void onDraw(Canvas canvas) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        Long item = adapter.getItem(adapter.firstPositionInMonth());
        Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (c next : dateSelector.getSelectedRanges()) {
            F f11 = next.f8468a;
            if (f11 != null) {
                if (next.f8469b != null) {
                    long longValue = ((Long) f11).longValue();
                    long longValue2 = ((Long) next.f8469b).longValue();
                    if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (longValue < item.longValue()) {
                            i12 = adapter.firstPositionInMonth();
                            if (adapter.isFirstInRow(i12)) {
                                i11 = 0;
                            } else if (!isLayoutRtl) {
                                i11 = materialCalendarGridView.getChildAt(i12 - 1).getRight();
                            } else {
                                i11 = materialCalendarGridView.getChildAt(i12 - 1).getLeft();
                            }
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                            i12 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            i11 = horizontalMidPoint(materialCalendarGridView.getChildAt(i12));
                        }
                        if (longValue2 > item2.longValue()) {
                            i14 = Math.min(adapter.lastPositionInMonth(), getChildCount() - 1);
                            if (adapter.isLastInRow(i14)) {
                                i13 = getWidth();
                            } else if (!isLayoutRtl) {
                                i13 = materialCalendarGridView.getChildAt(i14).getRight();
                            } else {
                                i13 = materialCalendarGridView.getChildAt(i14).getLeft();
                            }
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                            i14 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            i13 = horizontalMidPoint(materialCalendarGridView.getChildAt(i14));
                        }
                        int itemId = (int) adapter.getItemId(i12);
                        int itemId2 = (int) adapter.getItemId(i14);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + calendarStyle.day.getTopInset();
                            int bottom = childAt.getBottom() - calendarStyle.day.getBottomInset();
                            if (!isLayoutRtl) {
                                i16 = numColumns > i12 ? 0 : i11;
                                i15 = i14 > numColumns2 ? getWidth() : i13;
                            } else {
                                int i17 = i14 > numColumns2 ? 0 : i13;
                                i15 = numColumns > i12 ? getWidth() : i11;
                                i16 = i17;
                            }
                            canvas.drawRect((float) i16, (float) top, (float) i15, (float) bottom, calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        if (z11) {
            gainFocus(i11, rect);
        } else {
            super.onFocusChanged(false, i11, rect);
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (!super.onKeyDown(i11, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i11) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public void onMeasure(int i11, int i12) {
        if (this.nestedScrollable) {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(FlexItem.MAX_SIZE, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void setSelection(int i11) {
        if (i11 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i11);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        h0.x0(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.q0((Object) null);
            }
        });
    }

    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
