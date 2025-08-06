package zendesk.classic.messaging.ui;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.v;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Set;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$menu;

public class MessagePopUpHelper {

    public enum Option {
        COPY,
        RETRY,
        DELETE
    }

    public class a implements v.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62701a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62702b;

        public a(n nVar, String str) {
            this.f62701a = nVar;
            this.f62702b = str;
        }

        @SensorsDataInstrumented
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == R$id.zui_failed_message_retry) {
                this.f62701a.a(this.f62702b);
                SensorsDataAutoTrackHelper.trackMenuItem(menuItem);
                return true;
            } else if (menuItem.getItemId() == R$id.zui_failed_message_delete) {
                this.f62701a.b(this.f62702b);
                SensorsDataAutoTrackHelper.trackMenuItem(menuItem);
                return true;
            } else if (menuItem.getItemId() == R$id.zui_message_copy) {
                this.f62701a.c(this.f62702b);
                SensorsDataAutoTrackHelper.trackMenuItem(menuItem);
                return true;
            } else {
                SensorsDataAutoTrackHelper.trackMenuItem(menuItem);
                return false;
            }
        }
    }

    public static v.d a(n nVar, String str) {
        if (nVar == null) {
            return null;
        }
        return new a(nVar, str);
    }

    public static v b(View view, int i11, v.d dVar) {
        v vVar = new v(view.getContext(), view);
        vVar.c(i11);
        vVar.e(dVar);
        vVar.d(8388613);
        return vVar;
    }

    public static void c(View view, Set<Option> set, n nVar, String str) {
        v b11 = b(view, R$menu.zui_message_options_copy_retry_delete, a(nVar, str));
        b11.a().getItem(0).setVisible(set.contains(Option.COPY));
        b11.a().getItem(1).setVisible(set.contains(Option.RETRY));
        b11.a().getItem(2).setVisible(set.contains(Option.DELETE));
        b11.f();
    }
}
