package com.huobi.view.indexlist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.hbg.lib.widgets.R$array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class IndexBar extends View {
    private ArrayList<EntityWrapper> mDatas;
    private Paint mFocusPaint = new Paint(1);
    private float mIndexHeight;
    private List<String> mIndexList = new ArrayList();
    private boolean mIsShowListSticky = true;
    private HashMap<String, Integer> mMapping = new HashMap<>();
    private Paint mPaint = new Paint(1);
    private int mSelectionPosition;
    private float mTextSpace;
    private int mTotalHeight;

    public IndexBar(Context context) {
        super(context);
    }

    public int getFirstRecyclerViewPositionBySelection() {
        String str = this.mIndexList.get(this.mSelectionPosition);
        if (this.mMapping.containsKey(str)) {
            return this.mMapping.get(str).intValue();
        }
        return -1;
    }

    public List<String> getIndexList() {
        return this.mIndexList;
    }

    public int getPositionForPointY(float f11) {
        if (this.mIndexList.size() <= 0) {
            return -1;
        }
        int i11 = (int) (f11 / this.mIndexHeight);
        if (i11 < 0) {
            return 0;
        }
        return i11 > this.mIndexList.size() + -1 ? this.mIndexList.size() - 1 : i11;
    }

    public int getSelectionPosition() {
        return this.mSelectionPosition;
    }

    public void init(Drawable drawable, int i11, int i12, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
        this.mTextSpace = f12;
        this.mPaint.setColor(i11);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize(f11);
        this.mFocusPaint.setTextAlign(Paint.Align.CENTER);
        this.mFocusPaint.setTextSize(f11 + ((float) ((int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()))));
        this.mFocusPaint.setColor(i12);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIndexList.size() != 0) {
            this.mIndexHeight = ((float) getHeight()) / ((float) this.mIndexList.size());
            for (int i11 = 0; i11 < this.mIndexList.size(); i11++) {
                if (this.mSelectionPosition == i11) {
                    float f11 = this.mIndexHeight;
                    canvas.drawText(this.mIndexList.get(i11), (float) (getWidth() / 2), (0.85f * f11) + (f11 * ((float) i11)), this.mFocusPaint);
                } else {
                    float f12 = this.mIndexHeight;
                    canvas.drawText(this.mIndexList.get(i11), (float) (getWidth() / 2), (0.85f * f12) + (f12 * ((float) i11)), this.mPaint);
                }
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i12);
        if (this.mIndexList.size() > 0) {
            this.mTotalHeight = (int) ((((float) (this.mIndexList.size() - 1)) * this.mPaint.getTextSize()) + this.mFocusPaint.getTextSize() + (((float) (this.mIndexList.size() + 1)) * this.mTextSpace));
        }
        if (this.mTotalHeight > size) {
            this.mTotalHeight = size;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(this.mTotalHeight, 1073741824));
    }

    public void setDatas(boolean z11, ArrayList<EntityWrapper> arrayList) {
        ArrayList arrayList2;
        this.mDatas = arrayList;
        this.mIndexList.clear();
        this.mMapping.clear();
        if (z11) {
            this.mIndexList = Arrays.asList(getResources().getStringArray(R$array.indexable_letter));
            this.mIndexList = new ArrayList(this.mIndexList);
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = null;
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            EntityWrapper entityWrapper = arrayList.get(i11);
            if (this.mIsShowListSticky) {
                String index = entityWrapper.getIndex();
                if (!TextUtils.isEmpty(index)) {
                    if (!z11) {
                        if (!this.mIndexList.contains(index)) {
                            this.mIndexList.add(index);
                        }
                    } else if (!this.mIndexList.contains(index)) {
                        this.mIndexList.add("#");
                    } else if (this.mIndexList.indexOf(index) < 0) {
                        if (entityWrapper.getHeaderFooterType() == 1 && arrayList2.indexOf(index) < 0) {
                            arrayList2.add(index);
                        } else if (entityWrapper.getHeaderFooterType() == 2) {
                            this.mIndexList.add(index);
                        }
                    }
                    if (!this.mMapping.containsKey(index)) {
                        this.mMapping.put(index, Integer.valueOf(i11));
                    }
                }
            } else if (entityWrapper.getItemType() == 2147483646 || entityWrapper.getIndexTitle() == null) {
                String index2 = entityWrapper.getIndex();
                if (!TextUtils.isEmpty(index2)) {
                    if (!z11) {
                        this.mIndexList.add(index2);
                    } else if ("#".equals(index2)) {
                        this.mIndexList.add("#");
                    } else if (this.mIndexList.indexOf(index2) < 0) {
                        if (entityWrapper.getHeaderFooterType() == 1 && arrayList2.indexOf(index2) < 0) {
                            arrayList2.add(index2);
                        } else if (entityWrapper.getHeaderFooterType() == 2) {
                            this.mIndexList.add(index2);
                        }
                    }
                    if (!this.mMapping.containsKey(index2)) {
                        this.mMapping.put(index2, Integer.valueOf(i11));
                    }
                }
            }
        }
        if (z11) {
            this.mIndexList.addAll(0, arrayList2);
        }
        requestLayout();
    }

    public void setIsShowListSticky(boolean z11) {
        this.mIsShowListSticky = z11;
    }

    public void setSelection(int i11) {
        int indexOf;
        ArrayList<EntityWrapper> arrayList = this.mDatas;
        if (arrayList != null && arrayList.size() > i11 && i11 >= 0 && this.mSelectionPosition != (indexOf = this.mIndexList.indexOf(this.mDatas.get(i11).getIndex())) && indexOf >= 0) {
            this.mSelectionPosition = indexOf;
            invalidate();
        }
    }

    public void setSelectionPosition(int i11) {
        this.mSelectionPosition = i11;
        invalidate();
    }
}
