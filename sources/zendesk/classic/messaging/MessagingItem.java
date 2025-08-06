package zendesk.classic.messaging;

import g30.o;
import java.util.Date;
import java.util.List;
import zendesk.classic.messaging.c;

public abstract class MessagingItem implements o {

    /* renamed from: a  reason: collision with root package name */
    public final Date f62374a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62375b;

    public static class FileQuery extends Query {

        /* renamed from: d  reason: collision with root package name */
        public final g30.a f62376d;

        /* renamed from: e  reason: collision with root package name */
        public final FailureReason f62377e;

        public enum FailureReason {
            FILE_SIZE_TOO_LARGE,
            FILE_SENDING_DISABLED,
            UNSUPPORTED_FILE_TYPE
        }

        public g30.a c() {
            return this.f62376d;
        }

        public FailureReason d() {
            return this.f62377e;
        }
    }

    public static abstract class Query extends MessagingItem {

        /* renamed from: c  reason: collision with root package name */
        public final Status f62378c;

        public enum Status {
            PENDING,
            DELIVERED,
            FAILED,
            FAILED_NO_RETRY
        }

        public Status b() {
            return this.f62378c;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f62379a;

        public String a() {
            return this.f62379a;
        }
    }

    public static class b extends i {

        /* renamed from: d  reason: collision with root package name */
        public final String f62380d;

        /* renamed from: e  reason: collision with root package name */
        public List<a> f62381e;

        public List<a> c() {
            return this.f62381e;
        }

        public String d() {
            return this.f62380d;
        }
    }

    public static class c extends i {

        /* renamed from: d  reason: collision with root package name */
        public final List<a> f62382d;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f62383a;

            /* renamed from: b  reason: collision with root package name */
            public final String f62384b;

            public String a() {
                return this.f62384b;
            }

            public String b() {
                return this.f62383a;
            }
        }

        public List<a> c() {
            return this.f62382d;
        }
    }

    public static class d extends i {

        /* renamed from: d  reason: collision with root package name */
        public final g30.a f62385d;

        public g30.a c() {
            return this.f62385d;
        }
    }

    public static class e extends FileQuery {
    }

    public static class f extends d {
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final String f62386a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62387b;

        public String a() {
            return this.f62387b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            if (!this.f62386a.equals(gVar.f62386a)) {
                return false;
            }
            return this.f62387b.equals(gVar.f62387b);
        }

        public int hashCode() {
            return (this.f62386a.hashCode() * 31) + this.f62387b.hashCode();
        }
    }

    public static class h extends MessagingItem {

        /* renamed from: c  reason: collision with root package name */
        public final List<g> f62388c;

        public List<g> b() {
            return this.f62388c;
        }
    }

    public static abstract class i extends MessagingItem {

        /* renamed from: c  reason: collision with root package name */
        public final AgentDetails f62389c;

        public i(Date date, String str, AgentDetails agentDetails) {
            super(date, str);
            this.f62389c = agentDetails;
        }

        public AgentDetails b() {
            return this.f62389c;
        }
    }

    public static class j extends MessagingItem {

        /* renamed from: c  reason: collision with root package name */
        public final String f62390c;

        public String b() {
            return this.f62390c;
        }
    }

    public static class k extends Query {

        /* renamed from: d  reason: collision with root package name */
        public final String f62391d;

        public String c() {
            return this.f62391d;
        }
    }

    public static class l extends i {

        /* renamed from: d  reason: collision with root package name */
        public final String f62392d;

        public String c() {
            return this.f62392d;
        }
    }

    public static class m extends i {

        /* renamed from: d  reason: collision with root package name */
        public final String f62393d;

        /* renamed from: e  reason: collision with root package name */
        public final List<c.b> f62394e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f62395f;

        public m(Date date, String str, AgentDetails agentDetails, String str2, List<c.b> list, boolean z11) {
            super(date, str, agentDetails);
            this.f62393d = str2;
            this.f62394e = list;
            this.f62395f = z11;
        }

        public List<c.b> c() {
            return this.f62394e;
        }

        public String d() {
            return this.f62393d;
        }

        public boolean e() {
            return this.f62395f;
        }
    }

    public MessagingItem(Date date, String str) {
        this.f62374a = date;
        this.f62375b = str;
    }

    public String a() {
        return this.f62375b;
    }

    public Date getTimestamp() {
        return this.f62374a;
    }
}
