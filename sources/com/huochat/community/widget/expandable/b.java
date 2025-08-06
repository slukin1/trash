package com.huochat.community.widget.expandable;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f38718b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f38719c;

    public /* synthetic */ b(ExpandableTextView expandableTextView, CharSequence charSequence) {
        this.f38718b = expandableTextView;
        this.f38719c = charSequence;
    }

    public final void run() {
        this.f38718b.lambda$setContent$0(this.f38719c);
    }
}
