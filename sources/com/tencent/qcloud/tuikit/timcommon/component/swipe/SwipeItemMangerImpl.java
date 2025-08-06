package com.tencent.qcloud.tuikit.timcommon.component.swipe;

import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.component.swipe.Attributes;
import com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SwipeItemMangerImpl implements SwipeItemMangerInterface {
    public final int INVALID_POSITION = -1;
    public boolean isSwipeEnabled = true;
    public int mOpenPosition = -1;
    public Set<Integer> mOpenPositions = new HashSet();
    public Set<SwipeLayout> mShownLayouts = new HashSet();
    /* access modifiers changed from: private */
    public Attributes.Mode mode = Attributes.Mode.Single;
    public SwipeAdapterInterface swipeAdapterInterface;

    public class OnLayoutListener implements SwipeLayout.OnLayout {
        private int position;

        public OnLayoutListener(int i11) {
            this.position = i11;
        }

        public void onLayout(SwipeLayout swipeLayout) {
            if (SwipeItemMangerImpl.this.isOpen(this.position)) {
                swipeLayout.open(false, false);
            } else {
                swipeLayout.close(false, false);
            }
        }

        public void setPosition(int i11) {
            this.position = i11;
        }
    }

    public class SwipeMemory extends SimpleSwipeListener {
        private int position;

        public SwipeMemory(int i11) {
            this.position = i11;
        }

        public void onClose(SwipeLayout swipeLayout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Multiple) {
                SwipeItemMangerImpl.this.mOpenPositions.remove(Integer.valueOf(this.position));
            } else {
                SwipeItemMangerImpl.this.mOpenPosition = -1;
            }
        }

        public void onOpen(SwipeLayout swipeLayout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Multiple) {
                SwipeItemMangerImpl.this.mOpenPositions.add(Integer.valueOf(this.position));
                return;
            }
            SwipeItemMangerImpl.this.closeAllExcept(swipeLayout);
            SwipeItemMangerImpl.this.mOpenPosition = this.position;
        }

        public void onStartOpen(SwipeLayout swipeLayout) {
            if (SwipeItemMangerImpl.this.mode == Attributes.Mode.Single) {
                SwipeItemMangerImpl.this.closeAllExcept(swipeLayout);
            }
        }

        public void setPosition(int i11) {
            this.position = i11;
        }
    }

    public class ValueBox {
        public OnLayoutListener onLayoutListener;
        public int position;
        public SwipeMemory swipeMemory;

        public ValueBox(int i11, SwipeMemory swipeMemory2, OnLayoutListener onLayoutListener2) {
            this.swipeMemory = swipeMemory2;
            this.onLayoutListener = onLayoutListener2;
            this.position = i11;
        }
    }

    public SwipeItemMangerImpl(SwipeAdapterInterface swipeAdapterInterface2) {
        if (swipeAdapterInterface2 != null) {
            this.swipeAdapterInterface = swipeAdapterInterface2;
            return;
        }
        throw new IllegalArgumentException("SwipeAdapterInterface can not be null");
    }

    public void bind(View view, int i11) {
        int swipeLayoutResourceId = this.swipeAdapterInterface.getSwipeLayoutResourceId(i11);
        SwipeLayout swipeLayout = (SwipeLayout) view.findViewById(swipeLayoutResourceId);
        if (swipeLayout != null) {
            swipeLayout.setSwipeEnabled(this.isSwipeEnabled);
            if (swipeLayout.getTag(swipeLayoutResourceId) == null) {
                OnLayoutListener onLayoutListener = new OnLayoutListener(i11);
                SwipeMemory swipeMemory = new SwipeMemory(i11);
                swipeLayout.addSwipeListener(swipeMemory);
                swipeLayout.addOnLayoutListener(onLayoutListener);
                swipeLayout.setTag(swipeLayoutResourceId, new ValueBox(i11, swipeMemory, onLayoutListener));
                this.mShownLayouts.add(swipeLayout);
                return;
            }
            ValueBox valueBox = (ValueBox) swipeLayout.getTag(swipeLayoutResourceId);
            valueBox.swipeMemory.setPosition(i11);
            valueBox.onLayoutListener.setPosition(i11);
            valueBox.position = i11;
            return;
        }
        throw new IllegalStateException("can not find SwipeLayout in target view");
    }

    public void closeAllExcept(SwipeLayout swipeLayout) {
        for (SwipeLayout next : this.mShownLayouts) {
            if (next != swipeLayout) {
                next.close();
            }
        }
    }

    public void closeAllSwipeItems() {
        if (this.mode == Attributes.Mode.Multiple) {
            this.mOpenPositions.clear();
        } else {
            this.mOpenPosition = -1;
        }
        for (SwipeLayout close : this.mShownLayouts) {
            close.close();
        }
    }

    public void closeItem(int i11) {
        if (this.mode == Attributes.Mode.Multiple) {
            this.mOpenPositions.remove(Integer.valueOf(i11));
        } else if (this.mOpenPosition == i11) {
            this.mOpenPosition = -1;
        }
        this.swipeAdapterInterface.notifySwipeItemChanged(i11);
    }

    public Attributes.Mode getMode() {
        return this.mode;
    }

    public List<Integer> getOpenItems() {
        if (this.mode == Attributes.Mode.Multiple) {
            return new ArrayList(this.mOpenPositions);
        }
        return Collections.singletonList(Integer.valueOf(this.mOpenPosition));
    }

    public List<SwipeLayout> getOpenLayouts() {
        return new ArrayList(this.mShownLayouts);
    }

    public boolean isOpen(int i11) {
        if (this.mode == Attributes.Mode.Multiple) {
            return this.mOpenPositions.contains(Integer.valueOf(i11));
        }
        return this.mOpenPosition == i11;
    }

    public void openItem(int i11) {
        if (this.mode != Attributes.Mode.Multiple) {
            this.mOpenPosition = i11;
        } else if (!this.mOpenPositions.contains(Integer.valueOf(i11))) {
            this.mOpenPositions.add(Integer.valueOf(i11));
        }
        this.swipeAdapterInterface.notifySwipeItemChanged(i11);
    }

    public void removeShownLayouts(SwipeLayout swipeLayout) {
        this.mShownLayouts.remove(swipeLayout);
    }

    public void setMode(Attributes.Mode mode2) {
        this.mode = mode2;
        this.mOpenPositions.clear();
        this.mShownLayouts.clear();
        this.mOpenPosition = -1;
    }

    public void setSwipeEnabled(boolean z11) {
        this.isSwipeEnabled = z11;
    }

    public void switchAllSwipeEnable(boolean z11) {
        for (SwipeLayout swipeEnabled : this.mShownLayouts) {
            swipeEnabled.setSwipeEnabled(z11);
        }
    }
}
