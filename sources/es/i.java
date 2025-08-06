package es;

import android.view.View;
import com.huobi.staring.bean.ProRemindListItem;
import com.huobi.staring.viewhandler.ProRemindListItemHandler;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProRemindListItemHandler f54414b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProRemindListItem f54415c;

    public /* synthetic */ i(ProRemindListItemHandler proRemindListItemHandler, ProRemindListItem proRemindListItem) {
        this.f54414b = proRemindListItemHandler;
        this.f54415c = proRemindListItem;
    }

    public final void onClick(View view) {
        this.f54414b.lambda$bind$1(this.f54415c, view);
    }
}
