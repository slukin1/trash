package gc;

import android.view.View;
import android.widget.Checkable;
import com.huochat.community.widget.expandable.ExpandableTextView;
import com.huochat.community.widget.expandable.StatusType;

public final class d {
    public static final <T extends View> long b(T t11) {
        Object tag = t11.getTag(1766613352);
        Long l11 = tag instanceof Long ? (Long) tag : null;
        if (l11 != null) {
            return l11.longValue();
        }
        return 0;
    }

    public static final <T extends View> void c(T t11, long j11) {
        t11.setTag(1766613352, Long.valueOf(j11));
    }

    public static final void d(ExpandableTextView expandableTextView, ExpandableTextView.OnExpandOrContractClickListener onExpandOrContractClickListener, boolean z11, long j11) {
        expandableTextView.setExpandOrContractClickListener(new c(expandableTextView, j11, onExpandOrContractClickListener), z11);
    }

    public static /* synthetic */ void e(ExpandableTextView expandableTextView, ExpandableTextView.OnExpandOrContractClickListener onExpandOrContractClickListener, boolean z11, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            j11 = 1000;
        }
        d(expandableTextView, onExpandOrContractClickListener, z11, j11);
    }

    public static final void f(ExpandableTextView expandableTextView, long j11, ExpandableTextView.OnExpandOrContractClickListener onExpandOrContractClickListener, StatusType statusType) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b(expandableTextView) > j11 || (expandableTextView instanceof Checkable)) {
            c(expandableTextView, currentTimeMillis);
            onExpandOrContractClickListener.onClick(statusType);
        }
    }
}
