package com.hbg.module.huobi.im;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.ChatSessionRemove;
import com.hbg.module.huobi.im.RedPoint.AbsRedPointNodeImp;
import com.hbg.module.huobi.im.RedPoint.a;
import com.hbg.module.huobi.im.event.MessageNoDisturbEvent;
import com.huobi.framework.im.common.ImManager;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationListener;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMTextElem;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observer;

public class IMConversationHelper extends V2TIMConversationListener {

    /* renamed from: q  reason: collision with root package name */
    public static volatile IMConversationHelper f19602q;

    /* renamed from: a  reason: collision with root package name */
    public List<V2TIMConversation> f19603a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19604b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f19605c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ChatSessionRemove f19606d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19607e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19608f;

    /* renamed from: g  reason: collision with root package name */
    public final AbsRedPointNodeImp f19609g;

    /* renamed from: h  reason: collision with root package name */
    public final AbsRedPointNodeImp f19610h;

    /* renamed from: i  reason: collision with root package name */
    public String f19611i;

    /* renamed from: j  reason: collision with root package name */
    public int f19612j;

    /* renamed from: k  reason: collision with root package name */
    public g f19613k;

    /* renamed from: l  reason: collision with root package name */
    public String f19614l;

    /* renamed from: m  reason: collision with root package name */
    public List<f> f19615m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f19616n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f19617o;

    /* renamed from: p  reason: collision with root package name */
    public h f19618p;

    public class a extends AbsRedPointNodeImp {
        public a() {
        }

        public boolean a() {
            String str;
            if (IMConversationHelper.this.f19603a == null) {
                return false;
            }
            int size = IMConversationHelper.this.f19603a.size();
            for (int i11 = 0; i11 < size; i11++) {
                V2TIMConversation v2TIMConversation = (V2TIMConversation) IMConversationHelper.this.f19603a.get(i11);
                if (v2TIMConversation.getType() == 2) {
                    str = v2TIMConversation.getGroupID();
                } else {
                    str = v2TIMConversation.getUserID();
                }
                if (!IMConversationHelper.this.u(str) && v2TIMConversation.getUnreadCount() > 0) {
                    return true;
                }
            }
            return false;
        }

        public int b() {
            String str;
            if (IMConversationHelper.this.f19603a == null) {
                return 0;
            }
            int size = IMConversationHelper.this.f19603a.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                V2TIMConversation v2TIMConversation = (V2TIMConversation) IMConversationHelper.this.f19603a.get(i12);
                if (v2TIMConversation.getType() == 2) {
                    str = v2TIMConversation.getGroupID();
                } else {
                    str = v2TIMConversation.getUserID();
                }
                int unreadCount = v2TIMConversation.getUnreadCount();
                if (!IMConversationHelper.this.u(str)) {
                    i11 += unreadCount;
                }
            }
            return i11;
        }
    }

    public class b extends AbsRedPointNodeImp {
        public b() {
        }

        public boolean a() {
            return IMConversationHelper.this.f19612j > 0;
        }

        public int b() {
            return IMConversationHelper.this.f19612j;
        }
    }

    public class c implements V2TIMValueCallback<V2TIMConversationResult> {
        public c() {
        }

        /* renamed from: a */
        public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
            List<V2TIMConversation> conversationList = v2TIMConversationResult.getConversationList();
            if (conversationList != null && !conversationList.isEmpty()) {
                if (IMConversationHelper.this.f19603a == null) {
                    List unused = IMConversationHelper.this.f19603a = new ArrayList();
                }
                IMConversationHelper.this.f19603a.addAll(conversationList);
            }
            boolean unused2 = IMConversationHelper.this.f19604b = v2TIMConversationResult.isFinished();
            long unused3 = IMConversationHelper.this.f19605c = v2TIMConversationResult.getNextSeq();
            IMConversationHelper.this.v();
            if (!IMConversationHelper.this.f19604b) {
                IMConversationHelper.this.q();
            } else {
                IMConversationHelper.this.E(true);
            }
        }

        public void onError(int i11, String str) {
            IMConversationHelper.this.E(true);
        }
    }

    public class d implements Comparator<V2TIMConversation> {
        public d() {
        }

        /* renamed from: a */
        public int compare(V2TIMConversation v2TIMConversation, V2TIMConversation v2TIMConversation2) {
            long j11 = 0;
            long timestamp = (v2TIMConversation == null || v2TIMConversation.getLastMessage() == null) ? 0 : v2TIMConversation.getLastMessage().getTimestamp();
            if (!(v2TIMConversation2 == null || v2TIMConversation2.getLastMessage() == null)) {
                j11 = v2TIMConversation2.getLastMessage().getTimestamp();
            }
            return Long.compare(j11, timestamp);
        }
    }

    public class e implements Observer<ChatSessionRemove> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(ChatSessionRemove chatSessionRemove) {
            boolean unused = IMConversationHelper.this.f19616n = false;
            IMConversationHelper.this.A(chatSessionRemove);
            IMConversationHelper.this.F(true);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            boolean unused = IMConversationHelper.this.f19616n = true;
            IMConversationHelper.this.F(true);
        }
    }

    public interface f {
        void onChatSessionRemoveChange();
    }

    public interface g {
        void a(String str);
    }

    public interface h {
        void b(List<V2TIMConversation> list);
    }

    public IMConversationHelper() {
        a aVar = new a();
        this.f19609g = aVar;
        b bVar = new b();
        this.f19610h = bVar;
        this.f19612j = 0;
        this.f19615m = new ArrayList();
        this.f19617o = false;
        com.hbg.module.huobi.im.RedPoint.b.a().e(aVar);
        com.hbg.module.huobi.im.RedPoint.b.a().b().f(bVar);
        EventBus.d().p(this);
    }

    public static IMConversationHelper o() {
        if (f19602q == null) {
            synchronized (IMConversationHelper.class) {
                if (f19602q == null) {
                    f19602q = new IMConversationHelper();
                }
            }
        }
        return f19602q;
    }

    public void A(ChatSessionRemove chatSessionRemove) {
        this.f19606d = chatSessionRemove;
        if (!this.f19615m.isEmpty()) {
            for (f onChatSessionRemoveChange : this.f19615m) {
                onChatSessionRemoveChange.onChatSessionRemoveChange();
            }
        }
    }

    public void B(String str) {
        this.f19611i = str;
        k();
    }

    public void C(a.C0138a aVar) {
        this.f19610h.e(aVar);
    }

    public void D(g gVar) {
        this.f19613k = gVar;
    }

    public void E(boolean z11) {
        this.f19607e = z11;
        if (z11 && this.f19608f) {
            ImManager imManager = ImManager.INSTANCE;
            imManager.removeConversationListener(this);
            imManager.addConversationListener(this);
        }
        m();
    }

    public void F(boolean z11) {
        this.f19608f = z11;
        if (this.f19607e && z11) {
            ImManager imManager = ImManager.INSTANCE;
            imManager.removeConversationListener(this);
            imManager.addConversationListener(this);
        }
        m();
    }

    public void G(h hVar) {
        this.f19618p = hVar;
    }

    public final void H(List<V2TIMConversation> list, boolean z11) {
        boolean z12;
        if (list != null && !list.isEmpty()) {
            if (this.f19603a == null) {
                this.f19603a = new ArrayList();
            }
            if (this.f19603a.isEmpty()) {
                this.f19603a.addAll(list);
            } else {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    V2TIMConversation v2TIMConversation = list.get(i11);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= this.f19603a.size()) {
                            z12 = false;
                            break;
                        } else if (this.f19603a.get(i12).getConversationID().equals(v2TIMConversation.getConversationID())) {
                            this.f19603a.set(i12, v2TIMConversation);
                            z12 = true;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (!z12) {
                        this.f19603a.add(v2TIMConversation);
                    }
                }
            }
            m();
            if (z11) {
                Collections.sort(this.f19603a, new d());
            }
            v();
        }
    }

    public void j(f fVar) {
        if (!this.f19615m.contains(fVar)) {
            this.f19615m.add(fVar);
        }
    }

    public final void k() {
        int i11 = 0;
        if (this.f19603a != null && !TextUtils.isEmpty(this.f19611i)) {
            while (true) {
                if (i11 >= this.f19603a.size()) {
                    break;
                }
                V2TIMConversation v2TIMConversation = this.f19603a.get(i11);
                if (v2TIMConversation.getType() == 1) {
                    String userID = v2TIMConversation.getUserID();
                    if (TextUtils.equals(userID, this.f19611i)) {
                        this.f19612j = v2TIMConversation.getUnreadCount();
                        String str = null;
                        V2TIMMessage lastMessage = v2TIMConversation.getLastMessage();
                        String sender = lastMessage.getSender();
                        V2TIMTextElem textElem = lastMessage.getTextElem();
                        if (textElem != null) {
                            str = textElem.getText();
                        }
                        if (this.f19613k != null && !TextUtils.isEmpty(str) && TextUtils.equals(sender, userID)) {
                            this.f19613k.a(str);
                        }
                    }
                }
                i11++;
            }
        } else {
            this.f19612j = 0;
        }
        this.f19610h.c();
    }

    public void l() {
        if (this.f19616n) {
            r();
        }
    }

    public final void m() {
        if (this.f19607e && this.f19608f) {
            List<V2TIMConversation> list = this.f19603a;
            if (!(list == null || list.isEmpty() || this.f19606d == null)) {
                Iterator<V2TIMConversation> it2 = this.f19603a.iterator();
                while (it2.hasNext()) {
                    V2TIMConversation next = it2.next();
                    String str = null;
                    if (next.getType() == 1) {
                        str = next.getUserID();
                    } else if (next.getType() == 2) {
                        str = next.getGroupID();
                    }
                    if (!TextUtils.isEmpty(str) && this.f19606d.isNeedRemove(str)) {
                        it2.remove();
                    }
                }
            }
            k();
            v();
            w();
        }
    }

    public String n() {
        return this.f19611i;
    }

    public void onConversationChanged(List<V2TIMConversation> list) {
        H(list, true);
        w();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onMessageNoDisturbUpdate(MessageNoDisturbEvent messageNoDisturbEvent) {
        r();
    }

    public void onNewConversation(List<V2TIMConversation> list) {
        r();
        H(list, true);
        w();
    }

    public void onSyncServerFailed() {
    }

    public void onSyncServerFinish() {
    }

    public void onSyncServerStart() {
    }

    public void onTotalUnreadMessageCountChanged(long j11) {
    }

    public String p(String str) {
        ChatSessionRemove chatSessionRemove = this.f19606d;
        if (chatSessionRemove != null) {
            return chatSessionRemove.getRemarkName(str);
        }
        return null;
    }

    public final void q() {
        ImManager.INSTANCE.getConversationList(this.f19605c, 100, new c());
    }

    public void r() {
        this.f19608f = false;
        v7.b.a().getChatSessionRemove().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new e());
    }

    public void s() {
        String uid = BaseModuleConfig.a().getUid();
        if (!TextUtils.equals(this.f19614l, uid)) {
            this.f19614l = uid;
            this.f19603a = new ArrayList();
            r();
            this.f19604b = false;
            this.f19605c = 0;
            this.f19607e = false;
            A((ChatSessionRemove) null);
            q();
        }
    }

    public boolean t(String str) {
        ChatSessionRemove chatSessionRemove = this.f19606d;
        return chatSessionRemove != null && chatSessionRemove.isManager(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f19606d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean u(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = r1.f19617o
            if (r0 != 0) goto L_0x0011
            com.hbg.lib.network.hbg.core.bean.ChatSessionRemove r0 = r1.f19606d
            if (r0 == 0) goto L_0x000f
            boolean r2 = r0.isNoDisturb(r2)
            if (r2 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r2 = 0
            goto L_0x0012
        L_0x0011:
            r2 = 1
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.IMConversationHelper.u(java.lang.String):boolean");
    }

    public final void v() {
    }

    public final void w() {
        h hVar = this.f19618p;
        if (hVar != null) {
            hVar.b(this.f19603a);
        }
        this.f19609g.c();
    }

    public void x(f fVar) {
        this.f19615m.remove(fVar);
    }

    public void y() {
        this.f19614l = null;
        this.f19603a = null;
        this.f19604b = false;
        this.f19605c = 0;
        this.f19607e = false;
        A((ChatSessionRemove) null);
        k();
        w();
    }

    public void z(boolean z11) {
        this.f19617o = z11;
        w();
    }
}
