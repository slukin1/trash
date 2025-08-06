package com.iproov.sdk.p002break;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.iproov.sdk.R;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import com.iproov.sdk.ui.views.HovalayView;
import com.iproov.sdk.ui.views.LivenessDebugOverlay;
import com.iproov.sdk.ui.views.ShimmeringImageView;
import x1.a;
import x1.b;

/* renamed from: com.iproov.sdk.break.do  reason: invalid class name and invalid package */
public final class Cdo implements a {

    /* renamed from: break  reason: not valid java name */
    public final TextView f32break;

    /* renamed from: case  reason: not valid java name */
    public final ImageView f33case;

    /* renamed from: catch  reason: not valid java name */
    public final OpenGLRenderer f34catch;

    /* renamed from: class  reason: not valid java name */
    public final AppCompatTextView f35class;

    /* renamed from: const  reason: not valid java name */
    public final AppCompatTextView f36const;

    /* renamed from: do  reason: not valid java name */
    private final FrameLayout f37do;

    /* renamed from: else  reason: not valid java name */
    public final ShimmeringImageView f38else;

    /* renamed from: for  reason: not valid java name */
    public final FrameLayout f39for;

    /* renamed from: goto  reason: not valid java name */
    public final LivenessDebugOverlay f40goto;

    /* renamed from: if  reason: not valid java name */
    public final ImageView f41if;

    /* renamed from: new  reason: not valid java name */
    public final FrameLayout f42new;

    /* renamed from: this  reason: not valid java name */
    public final ImageView f43this;

    /* renamed from: try  reason: not valid java name */
    public final HovalayView f44try;

    private Cdo(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, LinearLayout linearLayout, FrameLayout frameLayout3, HovalayView hovalayView, ImageView imageView2, ShimmeringImageView shimmeringImageView, LivenessDebugOverlay livenessDebugOverlay, ImageView imageView3, TextView textView, OpenGLRenderer openGLRenderer, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f37do = frameLayout;
        this.f41if = imageView;
        this.f39for = frameLayout2;
        this.f42new = frameLayout3;
        this.f44try = hovalayView;
        this.f33case = imageView2;
        this.f38else = shimmeringImageView;
        this.f40goto = livenessDebugOverlay;
        this.f43this = imageView3;
        this.f32break = textView;
        this.f34catch = openGLRenderer;
        this.f35class = appCompatTextView;
        this.f36const = appCompatTextView2;
    }

    /* renamed from: do  reason: not valid java name */
    public FrameLayout getRoot() {
        return this.f37do;
    }

    /* renamed from: do  reason: not valid java name */
    public static Cdo m89do(LayoutInflater layoutInflater) {
        return m90do(layoutInflater, (ViewGroup) null, false);
    }

    /* renamed from: do  reason: not valid java name */
    public static Cdo m90do(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_full_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return m91do(inflate);
    }

    /* renamed from: do  reason: not valid java name */
    public static Cdo m91do(View view) {
        View view2 = view;
        int i11 = R.id.iproov__closeButtonImageView;
        ImageView imageView = (ImageView) b.a(view2, i11);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view2;
            i11 = R.id.iproov__header;
            LinearLayout linearLayout = (LinearLayout) b.a(view2, i11);
            if (linearLayout != null) {
                i11 = R.id.iproov_header_container;
                FrameLayout frameLayout2 = (FrameLayout) b.a(view2, i11);
                if (frameLayout2 != null) {
                    i11 = R.id.iproov__hovalView;
                    HovalayView hovalayView = (HovalayView) b.a(view2, i11);
                    if (hovalayView != null) {
                        i11 = R.id.iproov__imageHistogramPreView;
                        ImageView imageView2 = (ImageView) b.a(view2, i11);
                        if (imageView2 != null) {
                            i11 = R.id.iproov__iproovLogoImageView;
                            ShimmeringImageView shimmeringImageView = (ShimmeringImageView) b.a(view2, i11);
                            if (shimmeringImageView != null) {
                                i11 = R.id.iproov__liveness_debug_overlay;
                                LivenessDebugOverlay livenessDebugOverlay = (LivenessDebugOverlay) b.a(view2, i11);
                                if (livenessDebugOverlay != null) {
                                    i11 = R.id.iproov__logoImageView;
                                    ImageView imageView3 = (ImageView) b.a(view2, i11);
                                    if (imageView3 != null) {
                                        i11 = R.id.iproov__promptTextView;
                                        TextView textView = (TextView) b.a(view2, i11);
                                        if (textView != null) {
                                            i11 = R.id.iproov__rendererView;
                                            OpenGLRenderer openGLRenderer = (OpenGLRenderer) b.a(view2, i11);
                                            if (openGLRenderer != null) {
                                                i11 = R.id.iproov__textViewDebug;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view2, i11);
                                                if (appCompatTextView != null) {
                                                    i11 = R.id.iproov__titleTextView;
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) b.a(view2, i11);
                                                    if (appCompatTextView2 != null) {
                                                        return new Cdo(frameLayout, imageView, frameLayout, linearLayout, frameLayout2, hovalayView, imageView2, shimmeringImageView, livenessDebugOverlay, imageView3, textView, openGLRenderer, appCompatTextView, appCompatTextView2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }
}
