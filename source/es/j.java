package es;

import android.view.View;
import com.huobi.staring.bean.ProRemindListItem;
import com.huobi.staring.viewhandler.ProRemindListItemHandler;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProRemindListItemHandler f54416b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProRemindListItem f54417c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54418d;

    public /* synthetic */ j(ProRemindListItemHandler proRemindListItemHandler, ProRemindListItem proRemindListItem, int i11) {
        this.f54416b = proRemindListItemHandler;
        this.f54417c = proRemindListItem;
        this.f54418d = i11;
    }

    public final void onClick(View view) {
        this.f54416b.lambda$bind$0(this.f54417c, this.f54418d, view);
    }
}
