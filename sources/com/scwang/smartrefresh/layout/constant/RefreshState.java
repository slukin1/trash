package com.scwang.smartrefresh.layout.constant;

public enum RefreshState {
    None(0, false),
    PullDownToRefresh(1, true),
    PullUpToLoad(2, true),
    PullDownCanceled(1, false),
    PullUpCanceled(2, false),
    ReleaseToRefresh(1, true),
    ReleaseToLoad(2, true),
    ReleaseToTwoLevel(1, true),
    TwoLevelReleased(1, false),
    RefreshReleased(1, false),
    LoadReleased(2, false),
    Refreshing(1, false, true),
    Loading(2, false, true),
    TwoLevel(1, false, true),
    RefreshFinish(1, false, false, true),
    LoadFinish(2, false, false, true),
    TwoLevelFinish(1, false, false, true);
    
    public final boolean dragging;
    public final boolean finishing;
    public final boolean opening;
    private final int role;

    private RefreshState(int i11, boolean z11) {
        this.role = i11;
        this.dragging = z11;
        this.opening = false;
        this.finishing = false;
    }

    public boolean isFooter() {
        return this.role == 2;
    }

    public boolean isHeader() {
        return this.role == 1;
    }

    private RefreshState(int i11, boolean z11, boolean z12) {
        this.role = i11;
        this.dragging = z11;
        this.opening = z12;
        this.finishing = false;
    }

    private RefreshState(int i11, boolean z11, boolean z12, boolean z13) {
        this.role = i11;
        this.dragging = z11;
        this.opening = z12;
        this.finishing = z13;
    }
}
