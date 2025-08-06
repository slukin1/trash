package cf;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import java.util.List;
import n3.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26395a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final HbgBaseShareProvider f26396b = ((HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation());

    /* renamed from: cf.a$a  reason: collision with other inner class name */
    public static final class C0235a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f26397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26398b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f26399c;

        public C0235a(LiveDetailBean liveDetailBean, View view, FragmentActivity fragmentActivity) {
            this.f26397a = liveDetailBean;
            this.f26398b = view;
            this.f26399c = fragmentActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
            r12 = r12.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r12) {
            /*
                r11 = this;
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r12 = r11.f26397a
                java.util.List<com.hbg.lib.network.hbg.core.bean.LiveSpeaker> r12 = r12.speakerList
                boolean r12 = com.hbg.module.libkt.base.ext.b.w(r12)
                r0 = 0
                if (r12 == 0) goto L_0x000f
                java.lang.String r12 = ""
            L_0x000d:
                r8 = r12
                goto L_0x0022
            L_0x000f:
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r12 = r11.f26397a
                java.util.List<com.hbg.lib.network.hbg.core.bean.LiveSpeaker> r12 = r12.speakerList
                if (r12 == 0) goto L_0x0020
                java.lang.Object r12 = r12.get(r0)
                com.hbg.lib.network.hbg.core.bean.LiveSpeaker r12 = (com.hbg.lib.network.hbg.core.bean.LiveSpeaker) r12
                if (r12 == 0) goto L_0x0020
                java.lang.String r12 = r12.nickname
                goto L_0x000d
            L_0x0020:
                r12 = 0
                goto L_0x000d
            L_0x0022:
                android.view.View r12 = r11.f26398b
                int r1 = com.hbg.module.content.R$id.tvName
                android.view.View r12 = r12.findViewById(r1)
                android.widget.TextView r12 = (android.widget.TextView) r12
                r12.setText(r8)
                android.view.View r12 = r11.f26398b
                int r1 = com.hbg.module.content.R$id.tvTitle
                android.view.View r12 = r12.findViewById(r1)
                android.widget.TextView r12 = (android.widget.TextView) r12
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = r11.f26397a
                java.lang.String r1 = r1.title
                r12.setText(r1)
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r1 = "  "
                r12.append(r1)
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = r11.f26397a
                java.lang.String r1 = r1.introduction
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                android.text.SpannableString r1 = new android.text.SpannableString
                r1.<init>(r12)
                androidx.fragment.app.FragmentActivity r12 = r11.f26399c
                android.content.res.Resources r12 = r12.getResources()
                int r2 = com.hbg.module.content.R$drawable.icon_quotation_marks_left
                android.graphics.drawable.Drawable r12 = r12.getDrawable(r2)
                int r2 = r12.getIntrinsicWidth()
                int r3 = r12.getIntrinsicHeight()
                r12.setBounds(r0, r0, r2, r3)
                com.hbg.module.content.utls.f r2 = new com.hbg.module.content.utls.f
                r3 = 2
                r2.<init>(r12, r3)
                r12 = 33
                r4 = 1
                r1.setSpan(r2, r0, r4, r12)
                android.view.View r12 = r11.f26398b
                int r2 = com.hbg.module.content.R$id.tvDesc
                android.view.View r12 = r12.findViewById(r2)
                android.widget.TextView r12 = (android.widget.TextView) r12
                r12.setText(r1)
                android.view.View r12 = r11.f26398b
                int r1 = com.hbg.module.content.R$id.llPop
                android.view.View r12 = r12.findViewById(r1)
                android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
                android.view.View r1 = r11.f26398b
                int r2 = com.hbg.module.content.R$id.tvPop
                android.view.View r1 = r1.findViewById(r2)
                android.widget.TextView r1 = (android.widget.TextView) r1
                android.view.View r2 = r11.f26398b
                int r5 = com.hbg.module.content.R$id.llPlayTime
                android.view.View r2 = r2.findViewById(r5)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r11.f26397a
                int r5 = r5.status
                if (r5 != r4) goto L_0x0116
                int r3 = com.hbg.module.content.R$color.color_live_appointment
                r12.setBackgroundResource(r3)
                kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
                androidx.fragment.app.FragmentActivity r12 = r11.f26399c
                android.content.res.Resources r12 = r12.getResources()
                int r3 = com.hbg.module.content.R$string.n_content_live_appointment
                java.lang.String r12 = r12.getString(r3)
                java.lang.Object[] r3 = new java.lang.Object[r4]
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r11.f26397a
                int r5 = r5.appointedNum
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r5 = he.b.e(r5)
                r3[r0] = r5
                java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
                java.lang.String r12 = java.lang.String.format(r12, r3)
                r1.setText(r12)
                android.view.View r12 = r11.f26398b
                int r1 = com.hbg.module.content.R$id.tvPlayTime
                android.view.View r12 = r12.findViewById(r1)
                android.widget.TextView r12 = (android.widget.TextView) r12
                androidx.fragment.app.FragmentActivity r1 = r11.f26399c
                android.content.res.Resources r1 = r1.getResources()
                int r3 = com.hbg.module.content.R$string.n_live_start_playing_time
                java.lang.String r1 = r1.getString(r3)
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
                java.lang.String r6 = "MM-dd HH:mm "
                r5.<init>(r6)
                java.util.Date r6 = new java.util.Date
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r7 = r11.f26397a
                long r9 = r7.startTime
                r6.<init>(r9)
                java.lang.String r5 = r5.format(r6)
                r3[r0] = r5
                java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r4)
                java.lang.String r1 = java.lang.String.format(r1, r3)
                r12.setText(r1)
                goto L_0x0150
            L_0x0116:
                if (r5 != r3) goto L_0x011b
                int r5 = com.hbg.module.content.R$color.color_live_playing
                goto L_0x011d
            L_0x011b:
                int r5 = com.hbg.module.content.R$color.color_live_playback
            L_0x011d:
                r12.setBackgroundResource(r5)
                kotlin.jvm.internal.d0 r12 = kotlin.jvm.internal.d0.f56774a
                androidx.fragment.app.FragmentActivity r12 = r11.f26399c
                android.content.res.Resources r12 = r12.getResources()
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r11.f26397a
                int r5 = r5.status
                if (r5 != r3) goto L_0x0131
                int r3 = com.hbg.module.content.R$string.n_content_live_watch
                goto L_0x0133
            L_0x0131:
                int r3 = com.hbg.module.content.R$string.n_content_live_watched
            L_0x0133:
                java.lang.String r12 = r12.getString(r3)
                java.lang.Object[] r3 = new java.lang.Object[r4]
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r11.f26397a
                java.lang.String r5 = r5.onlineNum
                java.lang.String r5 = he.b.e(r5)
                r3[r0] = r5
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r4)
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r1.setText(r12)
                r0 = 8
            L_0x0150:
                r2.setVisibility(r0)
                com.hbg.lib.core.BaseModuleConfig$a r12 = com.hbg.lib.core.BaseModuleConfig.a()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "live/detail/h5?id="
                r0.append(r1)
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = r11.f26397a
                java.lang.String r1 = r1.f70249id
                java.lang.String r1 = com.hbg.lib.common.utils.StringUtils.b(r1)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r5 = r12.k(r0)
                cf.a r12 = cf.a.f26395a
                com.hbg.module.libkt.provider.HbgBaseShareProvider r0 = r12.a()
                if (r0 == 0) goto L_0x01a9
                androidx.fragment.app.FragmentActivity r1 = r11.f26399c
                android.view.View r2 = r11.f26398b
                android.view.View r0 = r0.q(r1, r2)
                if (r0 == 0) goto L_0x01a9
                androidx.fragment.app.FragmentActivity r2 = r11.f26399c
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r1 = r11.f26397a
                int r3 = com.hbg.module.content.R$id.llShareView
                android.view.View r0 = r0.findViewById(r3)
                r3 = r0
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                com.hbg.module.libkt.provider.HbgBaseShareProvider r12 = r12.a()
                java.lang.String r4 = r1.f70249id
                java.lang.String r6 = r1.coverImageUrl
                java.lang.String r7 = r1.title
                int r9 = r3.getMeasuredWidth()
                int r10 = r3.getMeasuredHeight()
                r1 = r12
                r1.h(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            L_0x01a9:
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r12 = r11.f26397a
                int r12 = r12.status
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                com.hbg.lib.network.hbg.core.bean.LiveDetailBean r0 = r11.f26397a
                java.lang.String r1 = r0.f70249id
                java.lang.String r0 = r0.title
                com.hbg.module.livesquare.utils.LiveTrackUtils.d(r12, r1, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cf.a.C0235a.a(boolean):void");
        }
    }

    public static final class b extends SimpleTarget<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f26400b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f26401c;

        public b(ImageView imageView, b bVar) {
            this.f26400b = imageView;
            this.f26401c = bVar;
        }

        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
            this.f26400b.setImageBitmap(bitmap);
            b bVar = this.f26401c;
            if (bVar != null) {
                bVar.a(true);
            }
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            b bVar = this.f26401c;
            if (bVar != null) {
                bVar.a(false);
            }
        }
    }

    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f26402a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26403b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveDetailBean f26404c;

        public c(FragmentActivity fragmentActivity, View view, LiveDetailBean liveDetailBean) {
            this.f26402a = fragmentActivity;
            this.f26403b = view;
            this.f26404c = liveDetailBean;
        }

        public void a(boolean z11) {
            a.f26395a.c(this.f26402a, this.f26403b, this.f26404c);
        }
    }

    public static /* synthetic */ void d(a aVar, ImageView imageView, String str, b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        aVar.b(imageView, str, bVar, z11);
    }

    public final HbgBaseShareProvider a() {
        return f26396b;
    }

    public final void b(ImageView imageView, String str, b bVar, boolean z11) {
        com.bumptech.glide.c<Bitmap> M0 = com.bumptech.glide.a.v(imageView.getContext()).b().M0(str);
        if (z11) {
            M0.b((RequestOptions) RequestOptions.r0(new n3.c((g<T>[]) new g[]{new CenterCrop(), new CircleCrop()})).h(DiskCacheStrategy.f63711c));
        }
        M0.A0(new b(imageView, bVar));
    }

    public final void c(FragmentActivity fragmentActivity, View view, LiveDetailBean liveDetailBean) {
        if (liveDetailBean != null) {
            d(f26395a, (ImageView) view.findViewById(R$id.ivPic), liveDetailBean.coverImageUrl, new C0235a(liveDetailBean, view, fragmentActivity), false, 8, (Object) null);
        }
    }

    public final void e(FragmentActivity fragmentActivity, LiveDetailBean liveDetailBean) {
        List<LiveSpeaker> list;
        LiveSpeaker liveSpeaker;
        String str = null;
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R$layout.live_share_view, (ViewGroup) null);
        if (com.hbg.module.libkt.base.ext.b.w(liveDetailBean != null ? liveDetailBean.speakerList : null)) {
            str = "";
        } else if (!(liveDetailBean == null || (list = liveDetailBean.speakerList) == null || (liveSpeaker = list.get(0)) == null)) {
            str = liveSpeaker.avatar;
        }
        b((ImageView) inflate.findViewById(R$id.ivAvatar), str, new c(fragmentActivity, inflate, liveDetailBean), true);
    }
}
