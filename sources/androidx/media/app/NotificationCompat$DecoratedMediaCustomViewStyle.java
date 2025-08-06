package androidx.media.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.media.R$color;
import androidx.media.R$id;
import androidx.media.R$layout;
import p0.k;

public class NotificationCompat$DecoratedMediaCustomViewStyle extends NotificationCompat$MediaStyle {
    public int C(int i11) {
        return i11 <= 3 ? R$layout.notification_template_big_media_narrow_custom : R$layout.notification_template_big_media_custom;
    }

    public int D() {
        if (this.f8233a.j() != null) {
            return R$layout.notification_template_media_custom;
        }
        return super.D();
    }

    public final void E(RemoteViews remoteViews) {
        int i11;
        if (this.f8233a.i() != 0) {
            i11 = this.f8233a.i();
        } else {
            i11 = this.f8233a.f8252a.getResources().getColor(R$color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(R$id.status_bar_latest_event_content, "setBackgroundColor", i11);
    }

    public void b(k kVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            kVar.a().setStyle(y(new Notification.DecoratedMediaCustomViewStyle()));
        } else {
            super.b(kVar);
        }
    }

    public RemoteViews t(k kVar) {
        RemoteViews remoteViews;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return null;
        }
        if (this.f8233a.h() != null) {
            remoteViews = this.f8233a.h();
        } else {
            remoteViews = this.f8233a.j();
        }
        if (remoteViews == null) {
            return null;
        }
        RemoteViews z11 = z();
        d(z11, remoteViews);
        if (i11 >= 21) {
            E(z11);
        }
        return z11;
    }

    public RemoteViews u(k kVar) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return null;
        }
        boolean z11 = true;
        boolean z12 = this.f8233a.j() != null;
        if (i11 >= 21) {
            if (!z12 && this.f8233a.h() == null) {
                z11 = false;
            }
            if (z11) {
                RemoteViews A = A();
                if (z12) {
                    d(A, this.f8233a.j());
                }
                E(A);
                return A;
            }
        } else {
            RemoteViews A2 = A();
            if (z12) {
                d(A2, this.f8233a.j());
                return A2;
            }
        }
        return null;
    }

    public RemoteViews v(k kVar) {
        RemoteViews remoteViews;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return null;
        }
        if (this.f8233a.m() != null) {
            remoteViews = this.f8233a.m();
        } else {
            remoteViews = this.f8233a.j();
        }
        if (remoteViews == null) {
            return null;
        }
        RemoteViews z11 = z();
        d(z11, remoteViews);
        if (i11 >= 21) {
            E(z11);
        }
        return z11;
    }
}
