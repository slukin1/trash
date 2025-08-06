package fa;

import com.hbg.lib.widgets.expandable.ExpandableTextView;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f54475b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f54476c;

    public /* synthetic */ d(ExpandableTextView expandableTextView, CharSequence charSequence) {
        this.f54475b = expandableTextView;
        this.f54476c = charSequence;
    }

    public final void run() {
        this.f54475b.lambda$setContent$0(this.f54476c);
    }
}
