package yl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.invite.bean.InviterInfo;
import com.huobi.invite.helper.InviteReturnHelper;
import com.huobi.share.bean.PreviewItem;
import com.huobi.share.view.RiseDownProgressBar;
import com.huobi.sharev2.manager.ShareManager;
import com.huobi.utils.ImageUtils;
import com.huobi.utils.a0;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.tencent.imsdk.v2.V2TIMConversation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import tg.r;
import u6.g;

public final class a {

    /* renamed from: yl.a$a  reason: collision with other inner class name */
    public class C0826a implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f76828a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreviewItem f76829b;

        public C0826a(Context context, PreviewItem previewItem) {
            this.f76828a = context;
            this.f76829b = previewItem;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            a.c(this.f76828a, bitmap, this.f76829b);
        }

        public void d(String str, View view) {
        }
    }

    public class b extends BaseSubscriber<InviterInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PreviewItem f76830b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f76831c;

        public b(PreviewItem previewItem, ArrayList arrayList) {
            this.f76830b = previewItem;
            this.f76831c = arrayList;
        }

        /* renamed from: a */
        public void onNext(InviterInfo inviterInfo) {
            super.onNext(inviterInfo);
            if (inviterInfo != null) {
                a.j(this.f76830b, this.f76831c, inviterInfo.getInviteCode());
            } else {
                a.j(this.f76830b, this.f76831c, (String) null);
            }
        }
    }

    public static void c(Context context, Bitmap bitmap, PreviewItem previewItem) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.addAll(h(context, bitmap, previewItem));
        if (r.x().F0()) {
            InviteReturnHelper.e().compose(RxJavaHelper.t((g) null)).timeout(2, TimeUnit.SECONDS).onErrorResumeNext(Observable.just(null)).subscribe(new b(previewItem, arrayList));
        } else {
            j(previewItem, arrayList, (String) null);
        }
    }

    public static View d(View view, FragmentActivity fragmentActivity) {
        if (view == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        fragmentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return view;
    }

    public static Bitmap e(View view, Activity activity) {
        return f(view, activity, 0, 0);
    }

    public static Bitmap f(View view, Activity activity, int i11, int i12) {
        if (view == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (i11 == 0) {
            i11 = displayMetrics.widthPixels;
        }
        if (i12 == 0) {
            i12 = displayMetrics.heightPixels;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        int width = view.getWidth();
        int height = view.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        new Canvas(createBitmap).drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static String g(long j11, String str) {
        String str2 = a0.j() + (AppLanguageHelper.getInstance().isChineseLanguage() ? "/zh-cn" : "/en-us") + "/views/feed/details/news-flash-details/" + j11;
        if (!r.x().F0() || TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + "?inviteCode=" + str;
    }

    public static List<Bitmap> h(Context context, Bitmap bitmap, PreviewItem previewItem) {
        ArrayList arrayList = new ArrayList(3);
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = R.layout.layout_content_share_entity_style1;
            if (i11 == 0) {
                i12 = R.layout.layout_content_share_entity_style3;
            } else if (i11 != 1 && i11 == 2) {
                i12 = R.layout.layout_content_share_entity_style2;
            }
            View inflate = LayoutInflater.from(context).inflate(i12, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.share_issue_time_tv);
            TextView textView2 = (TextView) inflate.findViewById(R.id.share_title);
            TextView textView3 = (TextView) inflate.findViewById(R.id.share_content);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.share_content_img);
            RiseDownProgressBar riseDownProgressBar = (RiseDownProgressBar) inflate.findViewById(R.id.id_share_progressBar);
            String i13 = DateTimeUtils.i(previewItem.getIssueTime(), "EEEE MM-dd HH:mm", AppLanguageHelper.getInstance().getCurAppLocale());
            if (textView != null) {
                textView.setText(i13);
            }
            if (textView2 != null && !TextUtils.isEmpty(previewItem.getTitle())) {
                textView2.setText(previewItem.getTitle());
            }
            if (textView3 != null) {
                if (!TextUtils.isEmpty(previewItem.getContent())) {
                    textView3.setText(previewItem.getContent());
                } else {
                    textView3.setVisibility(8);
                }
            }
            if (riseDownProgressBar != null) {
                riseDownProgressBar.b(previewItem.getRaiseNumber(), previewItem.getDownNumber());
            }
            if (!(imageView == null || bitmap == null)) {
                imageView.setImageBitmap(bitmap);
            }
            arrayList.add(ImageUtils.b(inflate));
        }
        return arrayList;
    }

    public static void i(Context context, PreviewItem previewItem) {
        if (TextUtils.isEmpty(previewItem.getShareImg()) || !URLUtil.isValidUrl(previewItem.getShareImg())) {
            c(context, (Bitmap) null, previewItem);
        } else {
            g6.b.c().m(previewItem.getShareImg(), new C0826a(context, previewItem));
        }
    }

    public static void j(PreviewItem previewItem, ArrayList<Bitmap> arrayList, String str) {
        String str2 = str;
        String g11 = g(previewItem.getId(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, ag.a.b("", "", previewItem.getId() + "", "", "", previewItem.getContent(), 1, g(previewItem.getId(), str2), previewItem.getShareImg(), 0, 0, "News 7*24"));
        hashMap.put("community", ag.a.b("", "", previewItem.getId() + "", "", "", previewItem.getContent(), 1, g(previewItem.getId(), str2), previewItem.getShareImg(), 0, 0, "News 7*24"));
        ShareManager.getInstance().newShareWithShareUrl(g11, previewItem.getTitle(), arrayList, true, false, "news", hashMap, true);
    }
}
