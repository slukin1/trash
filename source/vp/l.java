package vp;

import com.huobi.otc.widget.ExperienceItem;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExperienceItem f61156b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61157c;

    public /* synthetic */ l(ExperienceItem experienceItem, String str) {
        this.f61156b = experienceItem;
        this.f61157c = str;
    }

    public final void run() {
        this.f61156b.l(this.f61157c);
    }
}
