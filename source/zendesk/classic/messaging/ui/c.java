package zendesk.classic.messaging.ui;

import com.squareup.picasso.Picasso;
import mz.f;
import zendesk.classic.messaging.R$drawable;

public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final int f62762b = R$drawable.zui_ic_default_avatar_16;

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f62763a;

    public c(Picasso picasso) {
        this.f62763a = picasso;
    }

    public void a(a aVar, AvatarView avatarView) {
        if (f.c(aVar.c())) {
            avatarView.d(this.f62763a, aVar.c());
        } else if (aVar.b() != null) {
            avatarView.c(aVar.b().intValue());
        } else if (!f.c(aVar.a()) || !aVar.a().matches("[a-zA-Z]")) {
            avatarView.b(f62762b, aVar.d());
        } else {
            avatarView.e(aVar.a(), aVar.d());
        }
    }
}
