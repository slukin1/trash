package com.tencent.qcloud.tuikit.timcommon.component.swipe;

import com.tencent.qcloud.tuikit.timcommon.component.swipe.Attributes;
import java.util.List;

public interface SwipeItemMangerInterface {
    void closeAllExcept(SwipeLayout swipeLayout);

    void closeAllSwipeItems();

    void closeItem(int i11);

    Attributes.Mode getMode();

    List<Integer> getOpenItems();

    List<SwipeLayout> getOpenLayouts();

    boolean isOpen(int i11);

    void openItem(int i11);

    void removeShownLayouts(SwipeLayout swipeLayout);

    void setMode(Attributes.Mode mode);

    void switchAllSwipeEnable(boolean z11);
}
