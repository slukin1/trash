package gp;

import android.view.View;
import com.huobi.otc.bean.ReminderData;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f54856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReminderData f54857c;

    public /* synthetic */ e(g gVar, ReminderData reminderData) {
        this.f54856b = gVar;
        this.f54857c = reminderData;
    }

    public final void onClick(View view) {
        this.f54856b.s(this.f54857c, view);
    }
}
