package com.huochat.community.widget.expandable;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f38720b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f38721c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f38722d;

    public /* synthetic */ c(ExpandableTextView expandableTextView, CharSequence charSequence, String str) {
        this.f38720b = expandableTextView;
        this.f38721c = charSequence;
        this.f38722d = str;
    }

    public final void run() {
        this.f38720b.lambda$doSetContent$1(this.f38721c, this.f38722d);
    }
}
