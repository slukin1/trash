package com.huobi.otc.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import c4.g;
import cn.sharesdk.framework.InnerShareParams;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.hbg.event.ChatReSendEvent;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcCancelChatContent;
import com.huobi.otc.bean.OtcChatContent;
import com.huobi.otc.bean.OtcChatPromptLinkContent;
import com.huobi.otc.ui.OtcLiteChatActivity;
import com.huobi.utils.GsonHelper;
import com.huobi.view.roundimg.RoundedImageView;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hp.j;
import hp.k;
import hp.l;
import hp.m;
import hp.n;
import hp.o;
import hp.p;
import i6.r;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jp.v1;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class OtcChatContentHandler implements s9.d<OtcChatContent> {
    public ImageView A;
    public FrameLayout B;
    public ConstraintLayout C;
    public LinearLayout D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public ImageView J;
    public LinearLayout K;
    public LinearLayout L;
    public TextView M;
    public TextView N;
    public FrameLayout O;

    /* renamed from: b  reason: collision with root package name */
    public TextView f78730b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f78731c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f78732d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78733e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f78734f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f78735g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f78736h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f78737i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f78738j;

    /* renamed from: k  reason: collision with root package name */
    public RoundedImageView f78739k;

    /* renamed from: l  reason: collision with root package name */
    public RoundedImageView f78740l;

    /* renamed from: m  reason: collision with root package name */
    public FrameLayout f78741m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f78742n;

    /* renamed from: o  reason: collision with root package name */
    public ViewGroup f78743o;

    /* renamed from: p  reason: collision with root package name */
    public ViewGroup f78744p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f78745q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f78746r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f78747s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f78748t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f78749u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f78750v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f78751w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f78752x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f78753y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f78754z;

    public class a extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OtcChatPromptLinkContent f78755b;

        public a(OtcChatPromptLinkContent otcChatPromptLinkContent) {
            this.f78755b = otcChatPromptLinkContent;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (OtcChatContentHandler.this.N.getContext() != null) {
                String t11 = OtcModuleConfig.a().t();
                if (!TextUtils.isEmpty(t11) && !t11.startsWith("http")) {
                    t11 = DomainTool.DOMAIN_PREFIX + t11;
                }
                HBBaseWebActivity.showWebView(OtcChatContentHandler.this.N.getContext(), t11 + this.f78755b.getPlaceholderContent(), "", "", false);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(v1.b());
            textPaint.setUnderlineText(false);
        }
    }

    public class b implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f78757b;

        public b(TextView textView) {
            this.f78757b = textView;
        }

        public boolean onLongClick(View view) {
            if (!(this.f78757b.getText() instanceof Spannable)) {
                TextView textView = this.f78757b;
                textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
            }
            Selection.selectAll((Spannable) this.f78757b.getText());
            return false;
        }
    }

    public class c implements View.OnLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f78759b;

        public c(TextView textView) {
            this.f78759b = textView;
        }

        public boolean onLongClick(View view) {
            if (!(this.f78759b.getText() instanceof Spannable)) {
                TextView textView = this.f78759b;
                textView.setText(textView.getText(), TextView.BufferType.SPANNABLE);
            }
            Selection.selectAll((Spannable) this.f78759b.getText());
            return false;
        }
    }

    public class d implements e<Drawable> {
        public d() {
        }

        /* renamed from: a */
        public boolean onResourceReady(Drawable drawable, Object obj, g<Drawable> gVar, DataSource dataSource, boolean z11) {
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Drawable> gVar, boolean z11) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(OtcChatContent otcChatContent, View view) {
        k(otcChatContent, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(OtcChatContent otcChatContent, View view) {
        k(otcChatContent, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void p(OtcChatContent otcChatContent, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        if (otcChatContent != null) {
            ChatReSendEvent chatReSendEvent = new ChatReSendEvent();
            chatReSendEvent.setOtcChatContent(otcChatContent);
            EventBus.d().k(chatReSendEvent);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(OtcChatContent otcChatContent, View view) {
        Context context = this.A.getContext();
        if (context == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        DialogUtils.b0((FragmentActivity) oa.a.g().b(), "", context.getString(R$string.n_otc_chat_re_send_message), "", context.getString(R$string.n_otc_chat_cancel), context.getString(R$string.n_otc_chat_re_send_ok), ad.b.f3517a, new m(otcChatContent));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void r(OtcChatContent otcChatContent, TextView textView, Void voidR) {
        if (otcChatContent.getOtcDetailData() != null && otcChatContent.getOtcDetailData().getOtherInfo() != null) {
            long uid = otcChatContent.getOtcDetailData().getOtherInfo().getUid();
            OtcModuleConfig.b().K((Activity) textView.getContext(), Long.valueOf(uid));
        }
    }

    public static /* synthetic */ void s(View view, String str, String str2, int i11, Void voidR) {
        if (view.getContext() instanceof OtcLiteChatActivity) {
            ((OtcLiteChatActivity) view.getContext()).Ki(str, str2, (long) i11);
        }
    }

    public static /* synthetic */ void t(Void voidR) {
    }

    public final void A(OtcChatContent otcChatContent) {
        String str;
        if (otcChatContent != null) {
            this.f78735g.setVisibility(8);
            this.f78751w.setVisibility(8);
            this.f78751w.setVisibility(8);
            this.f78736h.setVisibility(8);
            this.f78752x.setVisibility(8);
            this.f78737i.setVisibility(0);
            this.O.setVisibility(0);
            this.f78740l.setVisibility(0);
            this.C.setVisibility(0);
            this.f78738j.setVisibility(8);
            this.f78743o.setVisibility(8);
            if (!TextUtils.isEmpty(otcChatContent.getLocalFilePath())) {
                this.f78740l.setTag(otcChatContent.getLocalFilePath());
                if (otcChatContent.getLocalChatContentType() == OtcChatContent.ChatType.Pdf) {
                    this.f78743o.setVisibility(0);
                    this.f78742n.setVisibility(8);
                    this.f78738j.setVisibility(8);
                    this.f78750v.setVisibility(8);
                    File file = new File(otcChatContent.getLocalFilePath());
                    this.f78745q.setText(file.getName());
                    float length = ((float) file.length()) / 1024.0f;
                    float f11 = length / 1024.0f;
                    if (f11 > 1.0f) {
                        str = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f11)}) + "MB";
                    } else {
                        str = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(length)}) + "KB";
                    }
                    this.f78746r.setText(str);
                    dw.a.a(this.f78743o).throttleFirst(1, TimeUnit.SECONDS).subscribe(p.f54970b);
                } else if (otcChatContent.getLocalChatContentType() == OtcChatContent.ChatType.Image) {
                    this.f78740l.setImageURI(FileUtil.j(otcChatContent.getLocalFilePath()));
                    this.f78742n.setVisibility(0);
                } else {
                    this.f78750v.setVisibility(0);
                    this.f78742n.setVisibility(0);
                    ((com.bumptech.glide.c) com.bumptech.glide.a.v(this.f78740l.getContext()).v((RequestOptions) ((RequestOptions) new RequestOptions().p(1000000)).d()).n(new File(otcChatContent.getLocalFilePath())).G0(new d()).h(DiskCacheStrategy.f63709a)).D0(this.f78740l);
                }
            }
            this.f78753y.setText(String.format(Locale.CHINA, "%d%%", new Object[]{Integer.valueOf(otcChatContent.getProgress())}));
            if (otcChatContent.getSendStatus() == OtcChatContent.ChatImageSendSendStatus.Sending) {
                this.B.setVisibility(0);
                this.A.setVisibility(8);
                return;
            }
            this.B.setVisibility(8);
            this.A.setVisibility(0);
        }
    }

    public int getResId() {
        return R$layout.item_otc_chat_content;
    }

    public final void j() {
        this.f78735g.setVisibility(8);
        this.D.setVisibility(8);
        this.f78736h.setVisibility(8);
        this.f78737i.setVisibility(8);
        this.f78752x.setVisibility(8);
        this.f78751w.setVisibility(8);
    }

    public final void k(OtcChatContent otcChatContent, View view) {
        String str;
        Intent intent = new Intent();
        if ((otcChatContent.getOtcChatContent() == null || otcChatContent.getOtcChatContent().getChatContentType() != OtcChatContent.ChatType.Image) && otcChatContent.getLocalChatContentType() != OtcChatContent.ChatType.Image) {
            if (otcChatContent.getOtcChatContent() != null) {
                str = otcChatContent.getOtcChatContent().getChatContent();
            } else if (otcChatContent.getUri() != null) {
                str = otcChatContent.getUri().toString();
            } else {
                str = otcChatContent.getLocalFilePath();
            }
            OtcModuleConfig.b().t(view.getContext(), str);
            return;
        }
        if (otcChatContent.getOtcChatContent() != null) {
            intent.putExtra(InnerShareParams.IMAGE_URL, otcChatContent.getOtcChatContent().getChatContent());
        } else if (otcChatContent.getUri() != null) {
            intent.putExtra("imageURI", otcChatContent.getUri());
        } else {
            Uri j11 = FileUtil.j(otcChatContent.getLocalFilePath());
            if (j11 != null) {
                intent.putExtra("imageURI", j11);
            }
        }
        OtcModuleConfig.b().a(view.getContext(), intent);
    }

    /* renamed from: l */
    public void handleView(v9.c cVar, int i11, OtcChatContent otcChatContent, ViewGroup viewGroup) {
        OtcChatContent otcChatContent2 = otcChatContent;
        r e11 = cVar.e();
        this.f78730b = (TextView) e11.b(R$id.otc_chat_systeminfo_time);
        this.f78731c = (TextView) e11.b(R$id.otc_chat_systeminfo_content);
        this.f78732d = (TextView) e11.b(R$id.otc_chat_otherside_username);
        this.f78733e = (TextView) e11.b(R$id.otc_chat_otherside_header);
        this.f78734f = (TextView) e11.b(R$id.otc_chat_otherside_content);
        this.f78735g = (LinearLayout) e11.b(R$id.otc_chat_systeminfo_layout);
        this.f78736h = (RelativeLayout) e11.b(R$id.otc_chat_otherside_layout);
        this.f78737i = (LinearLayout) e11.b(R$id.otc_chat_my_content_layout);
        this.f78738j = (TextView) e11.b(R$id.otc_chat_my_content);
        this.f78739k = (RoundedImageView) e11.b(R$id.otc_chat_otherside_image);
        this.f78740l = (RoundedImageView) e11.b(R$id.otc_chat_my_image);
        this.f78741m = (FrameLayout) e11.b(R$id.fl_otherside_image);
        this.f78742n = (FrameLayout) e11.b(R$id.fl_my_image);
        this.f78743o = (ViewGroup) e11.b(R$id.my_pdf_layout);
        this.f78745q = (TextView) e11.b(R$id.otc_my_pdf_file_name);
        this.f78746r = (TextView) e11.b(R$id.otc_my_pdf_file_size);
        this.f78744p = (ViewGroup) e11.b(R$id.other_pdf_layout);
        this.f78747s = (TextView) e11.b(R$id.otc_other_pdf_file_name);
        this.f78748t = (TextView) e11.b(R$id.otc_other_pdf_file_size);
        this.f78749u = (ImageView) e11.b(R$id.iv_otherside_play);
        this.f78750v = (ImageView) e11.b(R$id.iv_otc_chat_my_play);
        this.A = (ImageView) e11.b(R$id.re_send_iv);
        this.f78751w = (TextView) e11.b(R$id.otc_chat_my_content_time);
        this.f78752x = (TextView) e11.b(R$id.otc_chat_otherside_time);
        this.B = (FrameLayout) e11.b(R$id.send_progress_fl);
        this.f78753y = (TextView) e11.b(R$id.send_progress_tv);
        this.C = (ConstraintLayout) e11.b(R$id.otc_chat_my_image_cl);
        this.f78754z = (TextView) e11.b(R$id.tv_otc_chat_read);
        this.D = (LinearLayout) e11.b(R$id.id_waring_msg_ll);
        this.E = (TextView) e11.b(R$id.id_waring_msg_title);
        this.F = (TextView) e11.b(R$id.id_waring_msg_content);
        this.K = (LinearLayout) e11.b(R$id.otc_chat_cancel_layout);
        this.G = (TextView) e11.b(R$id.otc_chat_cancel_time);
        this.I = (TextView) e11.b(R$id.otc_chat_cancel_title);
        this.H = (TextView) e11.b(R$id.tv_otc_cancel_content);
        this.L = (LinearLayout) e11.b(R$id.otc_system_trade_info_layout);
        this.M = (TextView) e11.b(R$id.otc_system_trade_info_time);
        this.N = (TextView) e11.b(R$id.otc_system_trade_info_content);
        this.O = (FrameLayout) e11.b(R$id.fl_img_pdf);
        this.J = (ImageView) e11.b(R$id.iv_cancel);
        this.f78754z.setVisibility(8);
        this.f78749u.setVisibility(8);
        this.f78750v.setVisibility(8);
        this.L.setVisibility(8);
        this.f78744p.setVisibility(8);
        this.f78741m.setClickable(true);
        this.f78741m.setOnClickListener(new l(this, otcChatContent2));
        this.f78742n.setClickable(true);
        this.f78742n.setOnClickListener(new j(this, otcChatContent2));
        this.A.setOnClickListener(new k(this, otcChatContent2));
        if (otcChatContent.getSendStatus() == OtcChatContent.ChatImageSendSendStatus.Sending || otcChatContent.getSendStatus() == OtcChatContent.ChatImageSendSendStatus.SendFail) {
            A(otcChatContent2);
            return;
        }
        this.B.setVisibility(8);
        this.A.setVisibility(8);
        this.K.setVisibility(8);
        if (!TextUtils.isEmpty(otcChatContent.getLocalInput()) || otcChatContent.getUri() != null) {
            this.f78735g.setVisibility(8);
            this.f78736h.setVisibility(8);
            this.f78752x.setVisibility(8);
            this.f78737i.setVisibility(0);
            if (otcChatContent.isEnoughInterval()) {
                this.f78751w.setVisibility(0);
                this.f78751w.setText(DateTimeUtils.l(System.currentTimeMillis() / 1000));
            } else {
                this.f78751w.setVisibility(8);
            }
            if (!TextUtils.isEmpty(otcChatContent.getLocalInput())) {
                this.f78738j.setVisibility(0);
                this.f78740l.setVisibility(8);
                this.C.setVisibility(8);
                this.f78738j.setText(otcChatContent.getLocalInput());
            } else if (otcChatContent.getUri() != null) {
                this.f78738j.setVisibility(8);
                this.f78740l.setVisibility(0);
                this.C.setVisibility(0);
                this.f78740l.setTag(otcChatContent.getUri());
                this.f78740l.setImageURI(Uri.parse(otcChatContent.getUri()));
            }
        } else if (otcChatContent.getOtcChatContent() != null) {
            int chatType = otcChatContent.getOtcChatContent().getChatType();
            if (chatType == 0) {
                this.f78735g.setVisibility(0);
                this.f78736h.setVisibility(8);
                this.f78737i.setVisibility(8);
                this.f78752x.setVisibility(8);
                this.f78751w.setVisibility(8);
                this.D.setVisibility(8);
                this.f78730b.setText(DateTimeUtils.l(otcChatContent.getOtcChatContent().getGmtCreate() / 1000));
                this.f78731c.setText(otcChatContent.getOtcChatContent().getChatContent());
            } else if (chatType == 1) {
                this.f78735g.setVisibility(8);
                this.D.setVisibility(8);
                if (otcChatContent.isCurrentUser()) {
                    x(otcChatContent, this.f78736h, this.f78737i, this.f78738j, this.f78742n, this.f78740l, this.f78751w, this.f78752x, this.f78743o);
                    return;
                }
                y(otcChatContent, this.f78732d, this.f78733e, this.f78734f, this.f78736h, this.f78737i, this.f78739k, this.f78752x, this.f78751w, false);
            } else if (chatType == 2) {
                this.f78735g.setVisibility(8);
                this.D.setVisibility(8);
                y(otcChatContent, this.f78732d, this.f78733e, this.f78734f, this.f78736h, this.f78737i, this.f78739k, this.f78752x, this.f78751w, true);
            } else if (chatType == 4) {
                this.f78735g.setVisibility(8);
                this.D.setVisibility(0);
                this.f78736h.setVisibility(8);
                this.f78737i.setVisibility(8);
                this.f78752x.setVisibility(8);
                this.f78751w.setVisibility(8);
                if (!TextUtils.isEmpty(otcChatContent.getOtcChatContent().getChatContent())) {
                    try {
                        JSONObject jSONObject = new JSONObject(otcChatContent.getOtcChatContent().getChatContent());
                        if (jSONObject.has("title")) {
                            this.E.setText((CharSequence) jSONObject.get("title"));
                        }
                        if (jSONObject.has("content")) {
                            this.F.setText((CharSequence) jSONObject.get("content"));
                        }
                    } catch (JSONException e12) {
                        e12.printStackTrace();
                    }
                }
            } else if (chatType == 5) {
                this.K.setVisibility(0);
                this.f78735g.setVisibility(8);
                this.f78736h.setVisibility(8);
                this.f78737i.setVisibility(8);
                this.f78752x.setVisibility(8);
                this.f78751w.setVisibility(8);
                this.D.setVisibility(8);
                this.G.setText(DateTimeUtils.l(otcChatContent.getOtcChatContent().getGmtCreate() / 1000));
                String chatContent = otcChatContent.getOtcChatContent().getChatContent();
                if (!TextUtils.isEmpty(chatContent)) {
                    try {
                        OtcCancelChatContent otcCancelChatContent = (OtcCancelChatContent) GsonHelper.a().fromJson(chatContent, OtcCancelChatContent.class);
                        this.I.setText(otcCancelChatContent.getTitle());
                        String content = otcCancelChatContent.getContent();
                        if (!content.contains("{") || !content.contains("}")) {
                            this.H.setText(content);
                        } else {
                            String substring = content.substring(content.indexOf("{") + 1, content.indexOf("}"));
                            String replaceFirst = content.replaceFirst("\\{", "").replaceFirst("\\}", "");
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(replaceFirst);
                            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.H.getResources().getColor(R$color.baseColorPrimaryText));
                            int indexOf = replaceFirst.indexOf(substring);
                            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, substring.length() + indexOf, 34);
                            this.H.setText(spannableStringBuilder);
                        }
                        if (1 == otcCancelChatContent.getType()) {
                            this.J.setImageResource(R$drawable.otc_chat_wait);
                        } else if (2 == otcCancelChatContent.getType()) {
                            this.J.setImageResource(R$drawable.otc_chat_refuse);
                        } else {
                            this.J.setImageResource(R$drawable.otc_chat_agree);
                        }
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                }
            } else if (chatType != 6) {
                j();
            } else {
                this.L.setVisibility(0);
                this.f78735g.setVisibility(8);
                this.f78736h.setVisibility(8);
                this.f78737i.setVisibility(8);
                this.f78752x.setVisibility(8);
                this.f78751w.setVisibility(8);
                this.D.setVisibility(8);
                this.M.setText(DateTimeUtils.l(otcChatContent.getOtcChatContent().getGmtCreate() / 1000));
                String chatContent2 = otcChatContent.getOtcChatContent().getChatContent();
                if (!TextUtils.isEmpty(chatContent2)) {
                    try {
                        OtcChatPromptLinkContent otcChatPromptLinkContent = (OtcChatPromptLinkContent) GsonHelper.a().fromJson(chatContent2, OtcChatPromptLinkContent.class);
                        if (otcChatPromptLinkContent != null && !TextUtils.isEmpty(otcChatPromptLinkContent.getContentValue()) && !TextUtils.isEmpty(otcChatPromptLinkContent.getContent())) {
                            this.N.setMovementMethod(LinkMovementMethod.getInstance());
                            String contentValue = otcChatPromptLinkContent.getContentValue();
                            String format = String.format(otcChatPromptLinkContent.getContent(), new Object[]{contentValue});
                            SpannableString spannableString = new SpannableString(format);
                            spannableString.setSpan(new ForegroundColorSpan(this.N.getContext().getResources().getColor(R$color.baseColorMajorTheme100)), format.indexOf(contentValue), format.indexOf(contentValue) + contentValue.length(), 17);
                            spannableString.setSpan(new a(otcChatPromptLinkContent), format.indexOf(contentValue), format.indexOf(contentValue) + contentValue.length(), 33);
                            this.N.setText(spannableString);
                        }
                    } catch (Exception e14) {
                        e14.printStackTrace();
                        this.L.setVisibility(8);
                    }
                }
            }
        } else if (!TextUtils.isEmpty(otcChatContent.getLocalFilePath())) {
            v();
        } else {
            j();
        }
    }

    /* renamed from: m */
    public void a(v9.c cVar, int i11, OtcChatContent otcChatContent, ViewGroup viewGroup, List<Object> list) {
        TextView textView;
        if (cVar != null && cVar.e() != null && (textView = (TextView) cVar.e().b(R$id.tv_otc_chat_read)) != null) {
            w(textView, otcChatContent);
        }
    }

    public final void u(ImageView imageView, String str) {
        com.bumptech.glide.a.v(imageView.getContext()).p(new up.b(str)).D0(imageView);
    }

    public final void v() {
        this.f78735g.setVisibility(8);
        this.D.setVisibility(8);
        this.f78736h.setVisibility(8);
        this.f78737i.setVisibility(0);
        this.f78752x.setVisibility(8);
        this.f78751w.setVisibility(8);
    }

    public final void w(TextView textView, OtcChatContent otcChatContent) {
        textView.setVisibility(0);
        if (otcChatContent.getOtcChatContent().getReadState() == 0) {
            textView.setText(textView.getResources().getString(R$string.n_otc_chat_unread));
            textView.setTextColor(textView.getResources().getColor(R$color.baseColorMajorTheme100));
            return;
        }
        textView.setText(textView.getResources().getString(R$string.n_otc_chat_read));
        textView.setTextColor(textView.getResources().getColor(R$color.baseColorThreeLevelText));
    }

    public final void x(OtcChatContent otcChatContent, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, RoundedImageView roundedImageView, TextView textView2, TextView textView3, View view) {
        OtcChatContent otcChatContent2 = otcChatContent;
        TextView textView4 = textView;
        FrameLayout frameLayout2 = frameLayout;
        RoundedImageView roundedImageView2 = roundedImageView;
        TextView textView5 = textView2;
        View view2 = view;
        if (otcChatContent.isEnoughInterval()) {
            textView5.setVisibility(0);
            textView5.setText(DateTimeUtils.l(otcChatContent.getOtcChatContent().getGmtCreate() / 1000));
        } else {
            textView5.setVisibility(8);
        }
        relativeLayout.setVisibility(8);
        textView3.setVisibility(8);
        linearLayout.setVisibility(0);
        if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Image) {
            this.O.setVisibility(0);
            frameLayout2.setVisibility(0);
            roundedImageView2.setVisibility(0);
            this.C.setVisibility(0);
            textView4.setVisibility(8);
            view2.setVisibility(8);
            this.f78750v.setVisibility(8);
            roundedImageView2.setTag(otcChatContent.getOtcChatContent().getChatContent());
            u(roundedImageView2, otcChatContent.getOtcChatContent().getChatContent());
        } else if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Video) {
            this.O.setVisibility(0);
            roundedImageView2.setVisibility(0);
            frameLayout2.setVisibility(0);
            this.C.setVisibility(0);
            view2.setVisibility(8);
            this.f78750v.setVisibility(0);
            textView4.setVisibility(8);
            roundedImageView2.setImageResource(R$drawable.chat_video_default_bg);
        } else if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Pdf) {
            this.O.setVisibility(0);
            this.f78750v.setVisibility(8);
            roundedImageView2.setVisibility(0);
            this.C.setVisibility(0);
            frameLayout2.setVisibility(8);
            textView4.setVisibility(8);
            view2.setVisibility(0);
            z(otcChatContent, view2, this.f78745q, this.f78746r);
        } else {
            this.O.setVisibility(8);
            roundedImageView2.setVisibility(8);
            this.C.setVisibility(8);
            textView4.setVisibility(0);
            textView4.setText(otcChatContent.getOtcChatContent().getChatContent());
            textView4.setTextIsSelectable(true);
            textView4.setSelectAllOnFocus(true);
            if (Build.VERSION.SDK_INT >= 29) {
                int i11 = R$drawable.otc_text_selected_left_shape;
                textView4.setTextSelectHandleLeft(i11);
                textView4.setTextSelectHandleRight(i11);
                textView4.setTextSelectHandle(i11);
                textView4.setOnLongClickListener(new c(textView4));
            }
        }
        w(this.f78754z, otcChatContent);
    }

    public final void y(OtcChatContent otcChatContent, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout, LinearLayout linearLayout, ImageView imageView, TextView textView4, TextView textView5, boolean z11) {
        OtcChatContent otcChatContent2 = otcChatContent;
        TextView textView6 = textView2;
        TextView textView7 = textView3;
        ImageView imageView2 = imageView;
        TextView textView8 = textView4;
        if (otcChatContent.isEnoughInterval()) {
            textView8.setVisibility(0);
            textView8.setText(DateTimeUtils.l(otcChatContent.getOtcChatContent().getGmtCreate() / 1000));
        } else {
            textView8.setVisibility(8);
        }
        relativeLayout.setVisibility(0);
        linearLayout.setVisibility(8);
        textView5.setVisibility(8);
        this.f78741m.setVisibility(8);
        TextView textView9 = textView;
        textView.setText(otcChatContent.getOtcChatContent().getSendUserName());
        if (z11) {
            textView6.setText("");
            textView6.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.order_chat_service_head, 0, 0, 0);
        } else {
            if (!TextUtils.isEmpty(otcChatContent.getOtcChatContent().getSendUserName())) {
                textView6.setText(otcChatContent.getOtcChatContent().getSendUserName().substring(0, 1));
            }
            textView6.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            dw.a.a(textView2).throttleFirst(1, TimeUnit.SECONDS).subscribe(new o(otcChatContent, textView6));
        }
        if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Image) {
            this.f78741m.setVisibility(0);
            imageView2.setVisibility(0);
            textView7.setVisibility(8);
            this.f78744p.setVisibility(8);
            imageView2.setTag(otcChatContent.getOtcChatContent().getChatContent());
            u(imageView2, otcChatContent.getOtcChatContent().getChatContent());
        } else if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Video) {
            this.f78741m.setVisibility(0);
            imageView2.setVisibility(0);
            textView7.setVisibility(8);
            this.f78749u.setVisibility(0);
            this.f78744p.setVisibility(8);
            imageView2.setTag(otcChatContent.getOtcChatContent().getChatContent());
            imageView2.setImageResource(R$drawable.chat_video_default_bg);
        } else if (otcChatContent.getOtcChatContent().getChatContentType() == OtcChatContent.ChatType.Pdf) {
            this.f78741m.setVisibility(8);
            imageView2.setVisibility(8);
            textView7.setVisibility(8);
            this.f78744p.setVisibility(0);
            z(otcChatContent, this.f78744p, this.f78747s, this.f78748t);
        } else {
            this.f78741m.setVisibility(8);
            imageView2.setVisibility(8);
            textView7.setVisibility(0);
            this.f78744p.setVisibility(8);
            textView7.setText(otcChatContent.getOtcChatContent().getChatContent());
            textView7.setTextIsSelectable(true);
            textView7.setSelectAllOnFocus(true);
            if (Build.VERSION.SDK_INT >= 29) {
                int i11 = R$drawable.otc_text_selected_left_shape;
                textView7.setTextSelectHandleLeft(i11);
                textView7.setTextSelectHandleRight(i11);
                textView7.setTextSelectHandle(i11);
                textView7.setOnLongClickListener(new b(textView7));
            }
        }
    }

    public final void z(OtcChatContent otcChatContent, View view, TextView textView, TextView textView2) {
        String str;
        Exception exc;
        String str2 = "";
        int i11 = 0;
        String str3 = null;
        if (!TextUtils.isEmpty(otcChatContent.getOtcChatContent().getChatContent())) {
            try {
                JSONObject jSONObject = new JSONObject(otcChatContent.getOtcChatContent().getChatContent());
                String str4 = jSONObject.has("fileName") ? (String) jSONObject.get("fileName") : str2;
                try {
                    if (jSONObject.has("fileSize")) {
                        int intValue = ((Integer) jSONObject.get("fileSize")).intValue();
                        float f11 = ((float) intValue) / 1024.0f;
                        float f12 = f11 / 1024.0f;
                        if (f12 > 1.0f) {
                            try {
                                str2 = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f12)}) + "MB";
                            } catch (Exception e11) {
                                e = e11;
                                i11 = intValue;
                                exc = e;
                                str = str2;
                                str2 = str4;
                                exc.printStackTrace();
                                TextView textView3 = textView;
                                textView.setText(str2);
                                textView2.setText(str);
                                View view2 = view;
                                dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(view, str3, str2, i11));
                            }
                        } else {
                            str2 = String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f11)}) + "KB";
                        }
                        i11 = intValue;
                    }
                    if (jSONObject.has("url")) {
                        str3 = (String) jSONObject.get("url");
                    }
                    TextView textView4 = textView;
                    str = str2;
                    str2 = str4;
                } catch (Exception e12) {
                    e = e12;
                    exc = e;
                    str = str2;
                    str2 = str4;
                    exc.printStackTrace();
                    TextView textView32 = textView;
                    textView.setText(str2);
                    textView2.setText(str);
                    View view22 = view;
                    dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(view, str3, str2, i11));
                }
            } catch (Exception e13) {
                exc = e13;
                str = str2;
                exc.printStackTrace();
                TextView textView322 = textView;
                textView.setText(str2);
                textView2.setText(str);
                View view222 = view;
                dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(view, str3, str2, i11));
            }
        } else {
            TextView textView5 = textView;
            str = str2;
        }
        textView.setText(str2);
        textView2.setText(str);
        View view2222 = view;
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(view, str3, str2, i11));
    }
}
