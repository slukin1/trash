package com.huochat.community.widget.divider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class Api20ItemDivider extends Divider {
    private final Drawer mDrawer;
    private final int mHeight;
    private final int mWidth;

    public Api20ItemDivider(int i11) {
        this(i11, 4, 4);
    }

    private void drawHorizontal(Canvas canvas, View view, int i11, int i12, int i13) {
        boolean isFirstRaw = isFirstRaw(0, i11, i12, i13);
        boolean isLastRaw = isLastRaw(0, i11, i12, i13);
        boolean isFirstColumn = isFirstColumn(0, i11, i12, i13);
        boolean isLastColumn = isLastColumn(0, i11, i12, i13);
        if (i12 == 1) {
            if (isFirstRaw && isLastColumn) {
                return;
            }
            if (isFirstColumn) {
                this.mDrawer.drawRight(view, canvas);
            } else if (isLastColumn) {
                this.mDrawer.drawLeft(view, canvas);
            } else {
                this.mDrawer.drawLeft(view, canvas);
                this.mDrawer.drawRight(view, canvas);
            }
        } else if (isFirstColumn && isFirstRaw) {
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isFirstColumn && isLastRaw) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else if (isLastColumn && isFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastColumn && isLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
        } else if (isFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        }
    }

    private void drawVertical(Canvas canvas, View view, int i11, int i12, int i13) {
        boolean isFirstRaw = isFirstRaw(1, i11, i12, i13);
        boolean isLastRaw = isLastRaw(1, i11, i12, i13);
        boolean isFirstColumn = isFirstColumn(1, i11, i12, i13);
        boolean isLastColumn = isLastColumn(1, i11, i12, i13);
        if (i12 == 1) {
            if (isFirstRaw && isLastRaw) {
                return;
            }
            if (isFirstRaw) {
                this.mDrawer.drawBottom(view, canvas);
            } else if (isLastRaw) {
                this.mDrawer.drawTop(view, canvas);
            } else {
                this.mDrawer.drawTop(view, canvas);
                this.mDrawer.drawBottom(view, canvas);
            }
        } else if (isFirstRaw && isFirstColumn) {
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isFirstRaw && isLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastRaw && isFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else if (isLastRaw && isLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
        } else if (isFirstRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastRaw) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
        } else if (isFirstColumn) {
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else if (isLastColumn) {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        } else {
            this.mDrawer.drawLeft(view, canvas);
            this.mDrawer.drawTop(view, canvas);
            this.mDrawer.drawRight(view, canvas);
            this.mDrawer.drawBottom(view, canvas);
        }
    }

    private int getOrientation(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    private int getSpanCount(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).k();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).D();
        }
        return 1;
    }

    private boolean isFirstColumn(int i11, int i12, int i13, int i14) {
        if (i11 != 1) {
            return i12 < i13;
        }
        if (i13 == 1) {
            return true;
        }
        return i12 % i13 == 0;
    }

    private boolean isFirstRaw(int i11, int i12, int i13, int i14) {
        if (i11 == 1) {
            return i12 < i13;
        }
        if (i13 == 1) {
            return true;
        }
        return i12 % i13 == 0;
    }

    private boolean isLastColumn(int i11, int i12, int i13, int i14) {
        if (i11 == 1) {
            if (i13 == 1) {
                return true;
            }
            return (i12 + 1) % i13 == 0;
        } else if (i13 == 1) {
            return i12 + 1 == i14;
        } else {
            int i15 = i14 % i13;
            int i16 = ((i14 - i15) / i13) + (i15 > 0 ? 1 : 0);
            int i17 = i12 + 1;
            int i18 = i17 % i13;
            if (i18 == 0) {
                if (i16 == i17 / i13) {
                    return true;
                }
                return false;
            } else if (i16 == ((i17 - i18) / i13) + 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean isLastRaw(int i11, int i12, int i13, int i14) {
        if (i11 == 1) {
            if (i13 == 1) {
                return i12 + 1 == i14;
            }
            int i15 = i14 % i13;
            int i16 = ((i14 - i15) / i13) + (i15 > 0 ? 1 : 0);
            int i17 = i12 + 1;
            int i18 = i17 % i13;
            if (i18 == 0) {
                if (i16 == i17 / i13) {
                    return true;
                }
                return false;
            } else if (i16 == ((i17 - i18) / i13) + 1) {
                return true;
            } else {
                return false;
            }
        } else if (i13 == 1) {
            return true;
        } else {
            if ((i12 + 1) % i13 == 0) {
                return true;
            }
            return false;
        }
    }

    private void offsetHorizontal(Rect rect, int i11, int i12, int i13) {
        boolean isFirstRaw = isFirstRaw(0, i11, i12, i13);
        boolean isLastRaw = isLastRaw(0, i11, i12, i13);
        boolean isFirstColumn = isFirstColumn(0, i11, i12, i13);
        boolean isLastColumn = isLastColumn(0, i11, i12, i13);
        if (i12 == 1) {
            if (isFirstColumn && isLastColumn) {
                rect.set(0, 0, 0, 0);
            } else if (isFirstColumn) {
                rect.set(0, 0, this.mWidth, 0);
            } else if (isLastColumn) {
                rect.set(this.mWidth, 0, 0, 0);
            } else {
                int i14 = this.mWidth;
                rect.set(i14, 0, i14, 0);
            }
        } else if (isFirstColumn && isFirstRaw) {
            rect.set(0, 0, this.mWidth, this.mHeight);
        } else if (isFirstColumn && isLastRaw) {
            rect.set(0, this.mHeight, this.mWidth, 0);
        } else if (isLastColumn && isFirstRaw) {
            rect.set(this.mWidth, 0, 0, this.mHeight);
        } else if (isLastColumn && isLastRaw) {
            rect.set(this.mWidth, this.mHeight, 0, 0);
        } else if (isFirstColumn) {
            int i15 = this.mHeight;
            rect.set(0, i15, this.mWidth, i15);
        } else if (isLastColumn) {
            int i16 = this.mWidth;
            int i17 = this.mHeight;
            rect.set(i16, i17, 0, i17);
        } else if (isFirstRaw) {
            int i18 = this.mWidth;
            rect.set(i18, 0, i18, this.mHeight);
        } else if (isLastRaw) {
            int i19 = this.mWidth;
            rect.set(i19, this.mHeight, i19, 0);
        } else {
            int i21 = this.mWidth;
            int i22 = this.mHeight;
            rect.set(i21, i22, i21, i22);
        }
    }

    private void offsetVertical(Rect rect, int i11, int i12, int i13) {
        boolean isFirstRaw = isFirstRaw(1, i11, i12, i13);
        boolean isLastRaw = isLastRaw(1, i11, i12, i13);
        boolean isFirstColumn = isFirstColumn(1, i11, i12, i13);
        boolean isLastColumn = isLastColumn(1, i11, i12, i13);
        if (i12 == 1) {
            if (isFirstRaw && isLastRaw) {
                rect.set(0, 0, 0, 0);
            } else if (isFirstRaw) {
                rect.set(0, 0, 0, this.mHeight);
            } else if (isLastRaw) {
                rect.set(0, this.mHeight, 0, 0);
            } else {
                int i14 = this.mHeight;
                rect.set(0, i14, 0, i14);
            }
        } else if (isFirstRaw && isFirstColumn) {
            rect.set(0, 0, this.mWidth, this.mHeight);
        } else if (isFirstRaw && isLastColumn) {
            rect.set(this.mWidth, 0, 0, this.mHeight);
        } else if (isLastRaw && isFirstColumn) {
            rect.set(0, this.mHeight, this.mWidth, 0);
        } else if (isLastRaw && isLastColumn) {
            rect.set(this.mWidth, this.mHeight, 0, 0);
        } else if (isFirstRaw) {
            int i15 = this.mWidth;
            rect.set(i15, 0, i15, this.mHeight);
        } else if (isLastRaw) {
            int i16 = this.mWidth;
            rect.set(i16, this.mHeight, i16, 0);
        } else if (isFirstColumn) {
            int i17 = this.mHeight;
            rect.set(0, i17, this.mWidth, i17);
        } else if (isLastColumn) {
            int i18 = this.mWidth;
            int i19 = this.mHeight;
            rect.set(i18, i19, 0, i19);
        } else {
            int i21 = this.mWidth;
            int i22 = this.mHeight;
            rect.set(i21, i22, i21, i22);
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int orientation = getOrientation(layoutManager);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            int spanCount = getSpanCount(layoutManager);
            int itemCount = layoutManager.getItemCount();
            if (orientation == 1) {
                offsetVertical(rect, childLayoutPosition, spanCount, itemCount);
            } else {
                offsetHorizontal(rect, childLayoutPosition, spanCount, itemCount);
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int i11 = this.mWidth;
            int i12 = this.mHeight;
            rect.set(i11, i12, i11, i12);
        }
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int orientation = getOrientation(layoutManager);
        int spanCount = getSpanCount(layoutManager);
        int childCount = layoutManager.getChildCount();
        if (layoutManager instanceof LinearLayoutManager) {
            canvas.save();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = layoutManager.getChildAt(i11);
                int childLayoutPosition = recyclerView.getChildLayoutPosition(childAt);
                if (orientation == 1) {
                    drawVertical(canvas, childAt, childLayoutPosition, spanCount, childCount);
                } else {
                    drawHorizontal(canvas, childAt, childLayoutPosition, spanCount, childCount);
                }
            }
            canvas.restore();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            canvas.save();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = layoutManager.getChildAt(i12);
                this.mDrawer.drawLeft(childAt2, canvas);
                this.mDrawer.drawTop(childAt2, canvas);
                this.mDrawer.drawRight(childAt2, canvas);
                this.mDrawer.drawBottom(childAt2, canvas);
            }
            canvas.restore();
        }
    }

    public Api20ItemDivider(int i11, int i12, int i13) {
        int round = Math.round(((float) i12) / 2.0f);
        this.mWidth = round;
        int round2 = Math.round(((float) i13) / 2.0f);
        this.mHeight = round2;
        this.mDrawer = new ColorDrawer(i11, round, round2);
    }
}
