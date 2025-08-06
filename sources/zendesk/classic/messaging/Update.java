package zendesk.classic.messaging;

import android.app.Activity;
import android.content.Intent;
import g30.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Update {

    /* renamed from: a  reason: collision with root package name */
    public final String f62398a;

    public static abstract class State extends Update {

        public static class HideTyping extends State {
            public HideTyping() {
                super("hide_typing");
            }
        }

        public static class a extends State {

            /* renamed from: b  reason: collision with root package name */
            public final List<MessagingItem> f62399b;

            public List<MessagingItem> b() {
                return this.f62399b;
            }
        }

        public static class b extends State {

            /* renamed from: b  reason: collision with root package name */
            public final AgentDetails f62400b;

            public AgentDetails b() {
                return this.f62400b;
            }
        }

        public static class c extends State {

            /* renamed from: b  reason: collision with root package name */
            public final ConnectionState f62401b;

            public ConnectionState b() {
                return this.f62401b;
            }
        }

        public static class d extends State {

            /* renamed from: b  reason: collision with root package name */
            public final String f62402b;

            /* renamed from: c  reason: collision with root package name */
            public final Boolean f62403c;

            /* renamed from: d  reason: collision with root package name */
            public final g30.b f62404d;

            /* renamed from: e  reason: collision with root package name */
            public final Integer f62405e;

            public d(String str, Boolean bool, g30.b bVar, Integer num) {
                super("update_input_field_state");
                this.f62402b = str;
                this.f62403c = bool;
                this.f62404d = bVar;
                this.f62405e = num;
            }

            public static d f(boolean z11) {
                return new d((String) null, Boolean.valueOf(z11), (g30.b) null, (Integer) null);
            }

            public g30.b b() {
                return this.f62404d;
            }

            public String c() {
                return this.f62402b;
            }

            public Integer d() {
                return this.f62405e;
            }

            public Boolean e() {
                return this.f62403c;
            }
        }

        public State(String str) {
            super(str);
        }
    }

    public static abstract class a extends Update {

        /* renamed from: zendesk.classic.messaging.Update$a$a  reason: collision with other inner class name */
        public static class C0685a extends a {

            /* renamed from: d  reason: collision with root package name */
            public static int f62406d = -1;

            /* renamed from: b  reason: collision with root package name */
            public final int f62407b;

            /* renamed from: c  reason: collision with root package name */
            public final Intent f62408c;

            public void b(Activity activity) {
                int i11 = this.f62407b;
                if (i11 == f62406d) {
                    activity.startActivity(this.f62408c);
                } else {
                    activity.startActivityForResult(this.f62408c, i11);
                }
            }
        }
    }

    public static class b extends State {

        /* renamed from: b  reason: collision with root package name */
        public final List<g> f62409b;

        public b(g... gVarArr) {
            super("apply_menu_items");
            List<g> list;
            if (gVarArr == null) {
                list = Collections.emptyList();
            } else {
                list = Arrays.asList(gVarArr);
            }
            this.f62409b = list;
        }

        public List<g> b() {
            return this.f62409b;
        }
    }

    public static class c extends State {

        /* renamed from: b  reason: collision with root package name */
        public final Banner f62410b;

        public Banner b() {
            return this.f62410b;
        }
    }

    public static class d extends State {

        /* renamed from: b  reason: collision with root package name */
        public final DialogContent f62411b;

        public DialogContent b() {
            return this.f62411b;
        }
    }

    public Update(String str) {
        this.f62398a = str;
    }

    public String a() {
        return this.f62398a;
    }
}
