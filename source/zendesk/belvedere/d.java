package zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import f30.b;
import f30.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import zendesk.belvedere.BelvedereUi;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final c f62291a;

    /* renamed from: b  reason: collision with root package name */
    public final List<MediaIntent> f62292b;

    /* renamed from: c  reason: collision with root package name */
    public final List<MediaResult> f62293c;

    /* renamed from: d  reason: collision with root package name */
    public final List<MediaResult> f62294d;

    /* renamed from: e  reason: collision with root package name */
    public final long f62295e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f62296f;

    public d(Context context, BelvedereUi.UiConfig uiConfig) {
        this.f62291a = new c(context);
        this.f62292b = uiConfig.getIntents();
        this.f62293c = uiConfig.getSelectedItems();
        this.f62294d = uiConfig.getExtraItems();
        this.f62295e = uiConfig.getMaxFileSize();
        this.f62296f = uiConfig.showFullScreenOnly();
    }

    public boolean a() {
        return l() != null;
    }

    public boolean b() {
        return j() != null;
    }

    public List<MediaResult> c(MediaResult mediaResult) {
        this.f62293c.remove(mediaResult);
        return this.f62293c;
    }

    public boolean d() {
        return this.f62296f;
    }

    public boolean e() {
        return l() != null && this.f62291a.a("com.google.android.apps.photos");
    }

    public List<MediaResult> f() {
        return n(this.f62291a.b(500), n(this.f62294d, this.f62293c));
    }

    public MediaIntent g() {
        MediaIntent l11 = l();
        if (l11 == null) {
            return null;
        }
        Intent intent = l11.getIntent();
        intent.setPackage("com.google.android.apps.photos");
        intent.setAction("android.intent.action.GET_CONTENT");
        return l11;
    }

    public long h() {
        return this.f62295e;
    }

    public List<MediaResult> i() {
        return this.f62293c;
    }

    public MediaIntent j() {
        return m(2);
    }

    public List<MediaResult> k(MediaResult mediaResult) {
        this.f62293c.add(mediaResult);
        return this.f62293c;
    }

    public MediaIntent l() {
        return m(1);
    }

    public final MediaIntent m(int i11) {
        for (MediaIntent next : this.f62292b) {
            if (next.getTarget() == i11) {
                return next;
            }
        }
        return null;
    }

    public final List<MediaResult> n(List<MediaResult> list, List<MediaResult> list2) {
        HashSet hashSet = new HashSet(list.size());
        for (MediaResult originalUri : list) {
            hashSet.add(originalUri.getOriginalUri());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        for (int size = list2.size() - 1; size >= 0; size--) {
            MediaResult mediaResult = list2.get(size);
            if (!hashSet.contains(mediaResult.getOriginalUri())) {
                arrayList.add(0, mediaResult);
            }
        }
        return arrayList;
    }
}
