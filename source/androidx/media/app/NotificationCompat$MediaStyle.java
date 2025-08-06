package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;
import p0.k;

public class NotificationCompat$MediaStyle extends NotificationCompat.Style {

    /* renamed from: e  reason: collision with root package name */
    public int[] f10179e = null;

    /* renamed from: f  reason: collision with root package name */
    public MediaSessionCompat.Token f10180f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10181g;

    /* renamed from: h  reason: collision with root package name */
    public PendingIntent f10182h;

    public RemoteViews A() {
        int i11;
        RemoteViews c11 = c(false, D(), true);
        int size = this.f8233a.f8253b.size();
        int[] iArr = this.f10179e;
        if (iArr == null) {
            i11 = 0;
        } else {
            i11 = Math.min(iArr.length, 3);
        }
        c11.removeAllViews(R$id.media_actions);
        if (i11 > 0) {
            int i12 = 0;
            while (i12 < i11) {
                if (i12 < size) {
                    c11.addView(R$id.media_actions, B(this.f8233a.f8253b.get(this.f10179e[i12])));
                    i12++;
                } else {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i12), Integer.valueOf(size - 1)}));
                }
            }
        }
        if (this.f10181g) {
            c11.setViewVisibility(R$id.end_padder, 8);
            int i13 = R$id.cancel_action;
            c11.setViewVisibility(i13, 0);
            c11.setOnClickPendingIntent(i13, this.f10182h);
            c11.setInt(i13, "setAlpha", this.f8233a.f8252a.getResources().getInteger(R$integer.cancel_button_image_alpha));
        } else {
            c11.setViewVisibility(R$id.end_padder, 0);
            c11.setViewVisibility(R$id.cancel_action, 8);
        }
        return c11;
    }

    public final RemoteViews B(NotificationCompat.Action action) {
        boolean z11 = action.a() == null;
        RemoteViews remoteViews = new RemoteViews(this.f8233a.f8252a.getPackageName(), R$layout.notification_media_action);
        int i11 = R$id.action0;
        remoteViews.setImageViewResource(i11, action.e());
        if (!z11) {
            remoteViews.setOnClickPendingIntent(i11, action.a());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(i11, action.j());
        }
        return remoteViews;
    }

    public int C(int i11) {
        return i11 <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
    }

    public int D() {
        return R$layout.notification_template_media;
    }

    public void b(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            kVar.a().setStyle(y(new Notification.MediaStyle()));
        } else if (this.f10181g) {
            kVar.a().setOngoing(true);
        }
    }

    public RemoteViews t(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return z();
    }

    public RemoteViews u(k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return A();
    }

    public Notification.MediaStyle y(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f10179e;
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f10180f;
        if (token != null) {
            mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
        }
        return mediaStyle;
    }

    public RemoteViews z() {
        int min = Math.min(this.f8233a.f8253b.size(), 5);
        RemoteViews c11 = c(false, C(min), false);
        c11.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i11 = 0; i11 < min; i11++) {
                c11.addView(R$id.media_actions, B(this.f8233a.f8253b.get(i11)));
            }
        }
        if (this.f10181g) {
            int i12 = R$id.cancel_action;
            c11.setViewVisibility(i12, 0);
            c11.setInt(i12, "setAlpha", this.f8233a.f8252a.getResources().getInteger(R$integer.cancel_button_image_alpha));
            c11.setOnClickPendingIntent(i12, this.f10182h);
        } else {
            c11.setViewVisibility(R$id.cancel_action, 8);
        }
        return c11;
    }
}
