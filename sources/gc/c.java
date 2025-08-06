package gc;

import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final /* synthetic */ class c implements ExpandableTextView.OnExpandOrContractClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f54818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f54819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView.OnExpandOrContractClickListener f54820c;

    public /* synthetic */ c(ExpandableTextView expandableTextView, long j11, ExpandableTextView.OnExpandOrContractClickListener onExpandOrContractClickListener) {
        this.f54818a = expandableTextView;
        this.f54819b = j11;
        this.f54820c = onExpandOrContractClickListener;
    }

    public final void onClick(StatusType statusType) {
        d.f(this.f54818a, this.f54819b, this.f54820c, statusType);
    }
}
