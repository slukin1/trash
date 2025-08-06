package fa;

import com.hbg.lib.widgets.expandable.ExpandableTextView;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f54477b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f54478c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54479d;

    public /* synthetic */ e(ExpandableTextView expandableTextView, CharSequence charSequence, String str) {
        this.f54477b = expandableTextView;
        this.f54478c = charSequence;
        this.f54479d = str;
    }

    public final void run() {
        this.f54477b.lambda$doSetContent$1(this.f54478c, this.f54479d);
    }
}
