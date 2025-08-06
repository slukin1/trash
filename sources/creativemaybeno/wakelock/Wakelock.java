package creativemaybeno.wakelock;

import android.app.Activity;
import creativemaybeno.wakelock.Messages;

public final class Wakelock {

    /* renamed from: a  reason: collision with root package name */
    public Activity f53468a;

    public final boolean a() {
        return (this.f53468a.getWindow().getAttributes().flags & 128) != 0;
    }

    public final Messages.IsEnabledMessage b() {
        if (this.f53468a != null) {
            Messages.IsEnabledMessage isEnabledMessage = new Messages.IsEnabledMessage();
            isEnabledMessage.b(Boolean.valueOf(a()));
            return isEnabledMessage;
        }
        throw new NoActivityException();
    }

    public final void c(Activity activity) {
        this.f53468a = activity;
    }

    public final void d(Messages.ToggleMessage toggleMessage) {
        Activity activity = this.f53468a;
        if (activity != null) {
            boolean a11 = a();
            if (toggleMessage.b().booleanValue()) {
                if (!a11) {
                    activity.getWindow().addFlags(128);
                }
            } else if (a11) {
                activity.getWindow().clearFlags(128);
            }
        } else {
            throw new NoActivityException();
        }
    }
}
