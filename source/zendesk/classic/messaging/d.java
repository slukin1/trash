package zendesk.classic.messaging;

import android.content.Intent;
import java.io.File;
import java.util.Date;
import java.util.List;
import zendesk.classic.messaging.DialogContent;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.c;

public abstract class d implements g30.o {

    /* renamed from: a  reason: collision with root package name */
    public final String f62462a;

    /* renamed from: b  reason: collision with root package name */
    public final Date f62463b;

    public static class b extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.a f62464c;

        public b(MessagingItem.a aVar, Date date) {
            super("action_option_clicked", date);
            this.f62464c = aVar;
        }
    }

    public static class c extends d {

        /* renamed from: c  reason: collision with root package name */
        public final int f62465c;

        /* renamed from: d  reason: collision with root package name */
        public final int f62466d;

        /* renamed from: e  reason: collision with root package name */
        public final Intent f62467e;

        public c(int i11, int i12, Intent intent, Date date) {
            super("activity_result_received", date);
            this.f62465c = i11;
            this.f62466d = i12;
            this.f62467e = intent;
        }
    }

    /* renamed from: zendesk.classic.messaging.d$d  reason: collision with other inner class name */
    public static class C0691d extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.c.a f62468c;

        public C0691d(MessagingItem.c.a aVar, Date date) {
            super("article_suggestion_clicked", date);
            this.f62468c = aVar;
        }
    }

    public static class e extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.Query f62469c;

        public e(MessagingItem.Query query, Date date) {
            super("message_copied", date);
            this.f62469c = query;
        }
    }

    public static class f extends d {

        /* renamed from: c  reason: collision with root package name */
        public final DialogContent.Config f62470c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f62471d;

        /* renamed from: e  reason: collision with root package name */
        public final String f62472e;

        /* renamed from: f  reason: collision with root package name */
        public final DialogContent.Config f62473f;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final Date f62474a;

            /* renamed from: b  reason: collision with root package name */
            public final DialogContent.Config f62475b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f62476c;

            /* renamed from: d  reason: collision with root package name */
            public String f62477d = null;

            /* renamed from: e  reason: collision with root package name */
            public DialogContent.Config f62478e = null;

            public a(Date date, DialogContent.Config config, boolean z11) {
                this.f62474a = date;
                this.f62475b = config;
                this.f62476c = z11;
            }

            public f a() {
                return new f(this.f62474a, this.f62475b, this.f62476c, this.f62477d, this.f62478e);
            }

            public a b(String str) {
                this.f62477d = str;
                return this;
            }

            public a c(DialogContent.Config config) {
                this.f62478e = config;
                return this;
            }
        }

        public f(Date date, DialogContent.Config config, boolean z11, String str, DialogContent.Config config2) {
            super("dialog_item_clicked", date);
            this.f62470c = config;
            this.f62471d = z11;
            this.f62472e = str;
            this.f62473f = config2;
        }
    }

    public static class g extends d {

        /* renamed from: c  reason: collision with root package name */
        public final c.b f62479c;

        public g(c.b bVar, Date date) {
            super("transfer_option_clicked", date);
            this.f62479c = bVar;
        }

        public c.b b() {
            return this.f62479c;
        }
    }

    public static class h extends d {

        /* renamed from: c  reason: collision with root package name */
        public final List<File> f62480c;

        public h(List<File> list, Date date) {
            super("file_selected", date);
            this.f62480c = list;
        }
    }

    public static class i extends d {

        /* renamed from: c  reason: collision with root package name */
        public final int f62481c;

        public i(Date date, int i11) {
            super("menu_item_clicked", date);
            this.f62481c = i11;
        }
    }

    public static class j extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.Query f62482c;

        public j(MessagingItem.Query query, Date date) {
            super("message_deleted", date);
            this.f62482c = query;
        }
    }

    public static class k extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.Query f62483c;

        public k(MessagingItem.Query query, Date date) {
            super("message_resent", date);
            this.f62483c = query;
        }
    }

    public static class l extends d {

        /* renamed from: c  reason: collision with root package name */
        public final String f62484c;

        public l(String str, Date date) {
            super("message_submitted", date);
            this.f62484c = str;
        }
    }

    public static class m extends d {
        public m(Date date) {
            super("reconnect_button_clicked", date);
        }
    }

    public static class n extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.h f62485c;

        /* renamed from: d  reason: collision with root package name */
        public final MessagingItem.g f62486d;

        public n(MessagingItem.h hVar, MessagingItem.g gVar, Date date) {
            super("response_option_clicked", date);
            this.f62485c = hVar;
            this.f62486d = gVar;
        }
    }

    public static class o extends d {

        /* renamed from: c  reason: collision with root package name */
        public final MessagingItem.FileQuery f62487c;

        public o(MessagingItem.FileQuery fileQuery, Date date) {
            super("retry_send_attachment_clicked", date);
            this.f62487c = fileQuery;
        }
    }

    public static class p extends d {
        public p(Date date) {
            super("typing_started", date);
        }
    }

    public static class q extends d {
        public q(Date date) {
            super("typing_stopped", date);
        }
    }

    public d(String str, Date date) {
        this.f62462a = str;
        this.f62463b = date;
    }

    public String a() {
        return this.f62462a;
    }

    public Date getTimestamp() {
        return this.f62463b;
    }
}
