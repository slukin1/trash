package zendesk.classic.messaging.ui;

import android.content.Context;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import zendesk.classic.messaging.AgentDetails;
import zendesk.classic.messaging.MessagingItem;
import zendesk.classic.messaging.R$layout;
import zendesk.classic.messaging.c;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.ui.ActionOptionsView;
import zendesk.classic.messaging.ui.AgentFileCellView;
import zendesk.classic.messaging.ui.AgentImageCellView;
import zendesk.classic.messaging.ui.AgentMessageView;
import zendesk.classic.messaging.ui.ArticlesResponseView;
import zendesk.classic.messaging.ui.MessagingState;
import zendesk.classic.messaging.ui.SystemMessageView;
import zendesk.classic.messaging.ui.TypingIndicatorView;

public class p {

    /* renamed from: h  reason: collision with root package name */
    public static final String f62821h = UUID.randomUUID().toString();

    /* renamed from: i  reason: collision with root package name */
    public static final AgentDetails f62822i = new AgentDetails("", "", false);

    /* renamed from: a  reason: collision with root package name */
    public final MessagingCellPropsFactory f62823a;

    /* renamed from: b  reason: collision with root package name */
    public final DateProvider f62824b;

    /* renamed from: c  reason: collision with root package name */
    public final g30.f f62825c;

    /* renamed from: d  reason: collision with root package name */
    public final zendesk.classic.messaging.e f62826d;

    /* renamed from: e  reason: collision with root package name */
    public final c f62827e;

    /* renamed from: f  reason: collision with root package name */
    public final b f62828f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f62829g;

    public class a implements v {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g30.f f62830a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ zendesk.classic.messaging.e f62831b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MessagingItem.c.a f62832c;

        public a(g30.f fVar, zendesk.classic.messaging.e eVar, MessagingItem.c.a aVar) {
            this.f62830a = fVar;
            this.f62831b = eVar;
            this.f62832c = aVar;
        }

        public void a(Context context) {
            this.f62830a.a(this.f62831b.b(this.f62832c));
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g30.f f62833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ zendesk.classic.messaging.e f62834c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.b f62835d;

        public b(g30.f fVar, zendesk.classic.messaging.e eVar, c.b bVar) {
            this.f62833b = fVar;
            this.f62834c = eVar;
            this.f62835d = bVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62833b.a(this.f62834c.m(this.f62835d));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g30.f f62836b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ zendesk.classic.messaging.e f62837c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MessagingItem.a f62838d;

        public c(g30.f fVar, zendesk.classic.messaging.e eVar, MessagingItem.a aVar) {
            this.f62836b = fVar;
            this.f62837c = eVar;
            this.f62838d = aVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f62836b.a(this.f62837c.a(this.f62838d));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements x {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g30.f f62839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ zendesk.classic.messaging.e f62840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MessagingItem.h f62841c;

        public d(g30.f fVar, zendesk.classic.messaging.e eVar, MessagingItem.h hVar) {
            this.f62839a = fVar;
            this.f62840b = eVar;
            this.f62841c = hVar;
        }

        public void a(MessagingItem.g gVar) {
            this.f62839a.a(this.f62840b.e(this.f62841c, gVar));
        }
    }

    public static class e implements n {

        /* renamed from: a  reason: collision with root package name */
        public final g30.f f62842a;

        /* renamed from: b  reason: collision with root package name */
        public final MessagingItem.Query f62843b;

        /* renamed from: c  reason: collision with root package name */
        public final zendesk.classic.messaging.e f62844c;

        public e(g30.f fVar, MessagingItem.Query query, zendesk.classic.messaging.e eVar) {
            this.f62842a = fVar;
            this.f62843b = query;
            this.f62844c = eVar;
        }

        public void a(String str) {
            MessagingItem.Query query = this.f62843b;
            if (query instanceof MessagingItem.FileQuery) {
                this.f62842a.a(this.f62844c.j((MessagingItem.FileQuery) query));
            } else {
                this.f62842a.a(this.f62844c.i(query));
            }
        }

        public void b(String str) {
            this.f62842a.a(this.f62844c.d(this.f62843b));
        }

        public void c(String str) {
            this.f62842a.a(this.f62844c.c(this.f62843b));
        }
    }

    public static class f extends MessagingItem.i {
        public /* synthetic */ f(Date date, String str, AgentDetails agentDetails, a aVar) {
            this(date, str, agentDetails);
        }

        public f(Date date, String str, AgentDetails agentDetails) {
            super(date, str, agentDetails);
        }
    }

    public p(MessagingCellPropsFactory messagingCellPropsFactory, DateProvider dateProvider, g30.f fVar, zendesk.classic.messaging.e eVar, c cVar, b bVar, boolean z11) {
        this.f62823a = messagingCellPropsFactory;
        this.f62824b = dateProvider;
        this.f62825c = fVar;
        this.f62826d = eVar;
        this.f62827e = cVar;
        this.f62828f = bVar;
        this.f62829g = z11;
    }

    public static o<ActionOptionsView.b, ActionOptionsView> a(MessagingItem.b bVar, r rVar, g30.f fVar, zendesk.classic.messaging.e eVar, b bVar2, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (MessagingItem.a next : bVar.c()) {
            arrayList.add(new ActionOptionsView.a(next.a(), new c(fVar, eVar, next)));
        }
        return new o<>(bVar.a(), new ActionOptionsView.b(bVar.d(), bVar.b().getAgentName(), bVar.b().isBot(), rVar, arrayList, true, bVar2.a(bVar.b()), cVar), R$layout.zui_cell_action_options, ActionOptionsView.class);
    }

    public static o<ActionOptionsView.b, ActionOptionsView> b(MessagingItem.m mVar, r rVar, g30.f fVar, zendesk.classic.messaging.e eVar, b bVar, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (c.b next : mVar.c()) {
            arrayList.add(new ActionOptionsView.a(next.a(), new b(fVar, eVar, next)));
        }
        return new o<>(mVar.a(), new ActionOptionsView.b(mVar.d(), mVar.b().getAgentName(), mVar.b().isBot(), rVar, arrayList, mVar.e(), bVar.a(mVar.b()), cVar), R$layout.zui_cell_action_options, ActionOptionsView.class);
    }

    public static o<AgentFileCellView.b, AgentFileCellView> c(MessagingItem.d dVar, r rVar, b bVar, c cVar) {
        return new o<>(dVar.a(), new AgentFileCellView.b(dVar.c(), rVar, dVar.b().getAgentName(), dVar.b().isBot(), bVar.a(dVar.b()), cVar), R$layout.zui_cell_agent_file_view, AgentFileCellView.class);
    }

    public static o<AgentImageCellView.b, AgentImageCellView> d(MessagingItem.f fVar, r rVar, Picasso picasso, b bVar, c cVar) {
        return new o<>(fVar.a(), new AgentImageCellView.b(picasso, rVar, fVar.c(), fVar.b().getAgentName(), fVar.b().isBot(), bVar.a(fVar.b()), cVar), R$layout.zui_cell_agent_image_view, AgentImageCellView.class);
    }

    public static ArticlesResponseView.b e(MessagingItem.c.a aVar, g30.f fVar, zendesk.classic.messaging.e eVar) {
        return new ArticlesResponseView.b(aVar.b(), aVar.a(), new a(fVar, eVar, aVar));
    }

    public static List<ArticlesResponseView.b> f(List<MessagingItem.c.a> list, g30.f fVar, zendesk.classic.messaging.e eVar) {
        ArrayList arrayList = new ArrayList(list.size());
        for (MessagingItem.c.a e11 : list) {
            arrayList.add(e(e11, fVar, eVar));
        }
        return arrayList;
    }

    public static o<ArticlesResponseView.c, ArticlesResponseView> g(MessagingItem.c cVar, r rVar, g30.f fVar, zendesk.classic.messaging.e eVar, b bVar, c cVar2) {
        return new o<>(cVar.a(), new ArticlesResponseView.c(cVar.b().getAgentName(), cVar.b().isBot(), rVar, f(cVar.c(), fVar, eVar), bVar.a(cVar.b()), cVar2), R$layout.zui_cell_articles_response, ArticlesResponseView.class);
    }

    public static o h(MessagingItem messagingItem, r rVar, Picasso picasso, g30.b bVar, c cVar, b bVar2, g30.f fVar, zendesk.classic.messaging.e eVar, boolean z11) {
        if (messagingItem instanceof MessagingItem.Query) {
            return m(messagingItem, rVar, picasso, bVar, fVar, eVar);
        }
        if (messagingItem instanceof MessagingItem.i) {
            return n((MessagingItem.i) messagingItem, rVar, picasso, fVar, eVar, cVar, bVar2);
        }
        if (messagingItem instanceof MessagingItem.h) {
            return o((MessagingItem.h) messagingItem, rVar, fVar, eVar, z11);
        }
        if (messagingItem instanceof MessagingItem.j) {
            return p((MessagingItem.j) messagingItem, rVar);
        }
        return null;
    }

    public static o<g, EndUserFileCellView> j(MessagingItem.FileQuery fileQuery, r rVar, g30.b bVar, g30.f fVar, zendesk.classic.messaging.e eVar) {
        return new o<>(fileQuery.a(), new g(fileQuery.a(), rVar, fileQuery.b(), new e(fVar, fileQuery, eVar), fileQuery.c(), fileQuery.d(), bVar), R$layout.zui_cell_end_user_file_view, EndUserFileCellView.class);
    }

    public static o<h, EndUserImageCellView> k(MessagingItem.e eVar, r rVar, Picasso picasso, g30.b bVar, g30.f fVar, zendesk.classic.messaging.e eVar2) {
        return new o<>(eVar.a(), new h(eVar.a(), rVar, eVar.b(), new e(fVar, eVar, eVar2), eVar.c(), eVar.d(), bVar, picasso), R$layout.zui_cell_end_user_image_view, EndUserImageCellView.class);
    }

    public static o<h, EndUserImageCellView> l(MessagingItem.e eVar, r rVar, Picasso picasso, g30.b bVar, g30.f fVar, zendesk.classic.messaging.e eVar2) {
        return k(eVar, rVar, picasso, bVar, fVar, eVar2);
    }

    public static o m(MessagingItem messagingItem, r rVar, Picasso picasso, g30.b bVar, g30.f fVar, zendesk.classic.messaging.e eVar) {
        if (messagingItem instanceof MessagingItem.k) {
            return q((MessagingItem.k) messagingItem, rVar, fVar, eVar);
        }
        if (messagingItem instanceof MessagingItem.e) {
            return l((MessagingItem.e) messagingItem, rVar, picasso, bVar, fVar, eVar);
        }
        if (messagingItem instanceof MessagingItem.FileQuery) {
            return j((MessagingItem.FileQuery) messagingItem, rVar, bVar, fVar, eVar);
        }
        return null;
    }

    public static o n(MessagingItem.i iVar, r rVar, Picasso picasso, g30.f fVar, zendesk.classic.messaging.e eVar, c cVar, b bVar) {
        if (iVar instanceof MessagingItem.c) {
            return g((MessagingItem.c) iVar, rVar, fVar, eVar, bVar, cVar);
        }
        if (iVar instanceof MessagingItem.m) {
            return b((MessagingItem.m) iVar, rVar, fVar, eVar, bVar, cVar);
        }
        if (iVar instanceof MessagingItem.b) {
            return a((MessagingItem.b) iVar, rVar, fVar, eVar, bVar, cVar);
        }
        if (iVar instanceof MessagingItem.f) {
            return d((MessagingItem.f) iVar, rVar, picasso, bVar, cVar);
        }
        if (iVar instanceof MessagingItem.d) {
            return c((MessagingItem.d) iVar, rVar, bVar, cVar);
        }
        if (iVar instanceof f) {
            return s((f) iVar, rVar, cVar, bVar);
        }
        if (iVar instanceof MessagingItem.l) {
            return r((MessagingItem.l) iVar, rVar, cVar, bVar);
        }
        return null;
    }

    public static o<z, ?> o(MessagingItem.h hVar, r rVar, g30.f fVar, zendesk.classic.messaging.e eVar, boolean z11) {
        z zVar = new z(hVar.b(), new d(fVar, eVar, hVar), rVar);
        if (z11) {
            return new o<>(hVar.a(), zVar, R$layout.zui_cell_response_options_stacked, StackedResponseOptionsView.class);
        }
        return new o<>(hVar.a(), zVar, R$layout.zui_cell_response_options, ResponseOptionsView.class);
    }

    public static o<SystemMessageView.a, SystemMessageView> p(MessagingItem.j jVar, r rVar) {
        return new o<>(jVar.a(), new SystemMessageView.a(rVar, jVar.b()), R$layout.zui_cell_system_message, SystemMessageView.class);
    }

    public static o<i, EndUserMessageView> q(MessagingItem.k kVar, r rVar, g30.f fVar, zendesk.classic.messaging.e eVar) {
        return new o<>(kVar.a(), new i(kVar.a(), rVar, kVar.b(), new e(fVar, kVar, eVar), kVar.c()), R$layout.zui_cell_end_user_message, EndUserMessageView.class);
    }

    public static o<AgentMessageView.a, AgentMessageView> r(MessagingItem.l lVar, r rVar, c cVar, b bVar) {
        return new o<>(lVar.a(), new AgentMessageView.a(rVar, lVar.c(), lVar.b().getAgentName(), lVar.b().isBot(), bVar.a(lVar.b()), cVar), R$layout.zui_cell_agent_message_view, AgentMessageView.class);
    }

    public static o<TypingIndicatorView.b, TypingIndicatorView> s(f fVar, r rVar, c cVar, b bVar) {
        return new o<>(f62821h, new TypingIndicatorView.b(rVar, fVar.b().getAgentName(), fVar.b().isBot(), bVar.a(fVar.b()), cVar), R$layout.zui_cell_typing_indicator, TypingIndicatorView.class);
    }

    public List<o> i(List<MessagingItem> list, MessagingState.b bVar, Picasso picasso, g30.b bVar2) {
        if (list == null) {
            return Collections.emptyList();
        }
        List<TypeT> c11 = mz.a.c(list);
        if (bVar != null && bVar.b()) {
            c11.add(new f(this.f62824b.a(), f62821h, bVar.a() != null ? bVar.a() : f62822i, (a) null));
        }
        List<r> d11 = this.f62823a.d(c11);
        ArrayList arrayList = new ArrayList(c11.size());
        for (int i11 = 0; i11 < c11.size(); i11++) {
            o h11 = h((MessagingItem) c11.get(i11), d11.get(i11), picasso, bVar2, this.f62827e, this.f62828f, this.f62825c, this.f62826d, this.f62829g);
            if (h11 != null) {
                arrayList.add(h11);
            }
        }
        return arrayList;
    }
}
