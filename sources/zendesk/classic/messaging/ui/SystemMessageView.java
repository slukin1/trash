package zendesk.classic.messaging.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.classic.messaging.R$id;
import zendesk.classic.messaging.R$layout;

public class SystemMessageView extends LinearLayout implements a0<a> {

    /* renamed from: b  reason: collision with root package name */
    public TextView f62741b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f62742a;

        /* renamed from: b  reason: collision with root package name */
        public final r f62743b;

        public a(r rVar, String str) {
            this.f62743b = rVar;
            this.f62742a = str;
        }

        public String b() {
            return this.f62742a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            String str = this.f62742a;
            if (str == null ? aVar.f62742a != null : !str.equals(aVar.f62742a)) {
                return false;
            }
            r rVar = this.f62743b;
            r rVar2 = aVar.f62743b;
            if (rVar != null) {
                return rVar.equals(rVar2);
            }
            if (rVar2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f62742a;
            int i11 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            r rVar = this.f62743b;
            if (rVar != null) {
                i11 = rVar.hashCode();
            }
            return hashCode + i11;
        }
    }

    public SystemMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        setOrientation(1);
        LinearLayout.inflate(getContext(), R$layout.zui_view_system_message, this);
        this.f62741b = (TextView) findViewById(R$id.zui_system_message_text);
    }

    /* renamed from: b */
    public void update(a aVar) {
        aVar.f62743b.a(this);
        this.f62741b.setText(aVar.b());
    }

    public SystemMessageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }
}
