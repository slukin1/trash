package gp;

import com.huobi.otc.bean.ReminderData;
import com.huobi.otc.floating.OtcReminderModelImp;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcReminderModelImp f54854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReminderData f54855c;

    public /* synthetic */ b(OtcReminderModelImp otcReminderModelImp, ReminderData reminderData) {
        this.f54854b = otcReminderModelImp;
        this.f54855c = reminderData;
    }

    public final void run() {
        this.f54854b.e(this.f54855c);
    }
}
