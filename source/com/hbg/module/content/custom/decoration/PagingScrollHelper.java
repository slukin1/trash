package com.hbg.module.content.custom.decoration;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PagingScrollHelper {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f18100a = null;

    /* renamed from: b  reason: collision with root package name */
    public b f18101b = new b();

    /* renamed from: c  reason: collision with root package name */
    public a f18102c = new a();

    /* renamed from: d  reason: collision with root package name */
    public int f18103d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f18104e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f18105f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f18106g = 0;

    /* renamed from: h  reason: collision with root package name */
    public ORIENTATION f18107h = ORIENTATION.HORIZONTAL;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f18108i = null;

    /* renamed from: j  reason: collision with root package name */
    public c f18109j = new c();

    /* renamed from: k  reason: collision with root package name */
    public boolean f18110k = true;

    /* renamed from: l  reason: collision with root package name */
    public d f18111l;

    public enum ORIENTATION {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    public class a extends RecyclerView.OnFlingListener {

        /* renamed from: com.hbg.module.content.custom.decoration.PagingScrollHelper$a$a  reason: collision with other inner class name */
        public class C0126a implements ValueAnimator.AnimatorUpdateListener {
            public C0126a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (PagingScrollHelper.this.f18107h == ORIENTATION.VERTICAL) {
                    PagingScrollHelper.this.f18100a.scrollBy(0, intValue - PagingScrollHelper.this.f18103d);
                    return;
                }
                PagingScrollHelper.this.f18100a.scrollBy(intValue - PagingScrollHelper.this.f18104e, 0);
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            public void onAnimationEnd(Animator animator) {
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                d dVar = pagingScrollHelper.f18111l;
                if (dVar != null) {
                    dVar.onPageChange(pagingScrollHelper.k());
                }
                PagingScrollHelper.this.f18100a.stopScroll();
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.f18105f = pagingScrollHelper2.f18103d;
                PagingScrollHelper pagingScrollHelper3 = PagingScrollHelper.this;
                pagingScrollHelper3.f18106g = pagingScrollHelper3.f18104e;
            }
        }

        public a() {
        }

        public boolean onFling(int i11, int i12) {
            int i13;
            int i14;
            if (PagingScrollHelper.this.f18107h == ORIENTATION.NULL) {
                return false;
            }
            int b11 = PagingScrollHelper.this.l();
            if (PagingScrollHelper.this.f18107h == ORIENTATION.VERTICAL) {
                i13 = PagingScrollHelper.this.f18103d;
                if (i12 < 0) {
                    b11--;
                } else if (i12 > 0) {
                    b11++;
                }
                i14 = b11 * PagingScrollHelper.this.f18100a.getHeight();
            } else {
                int e11 = PagingScrollHelper.this.f18104e;
                if (i11 < 0) {
                    b11--;
                } else if (i11 > 0) {
                    b11++;
                }
                i14 = b11 * PagingScrollHelper.this.f18100a.getWidth();
                i13 = e11;
            }
            if (i14 < 0) {
                i14 = 0;
            }
            PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
            ValueAnimator valueAnimator = pagingScrollHelper.f18108i;
            if (valueAnimator == null) {
                new ValueAnimator();
                pagingScrollHelper.f18108i = ValueAnimator.ofInt(new int[]{i13, i14});
                PagingScrollHelper.this.f18108i.setDuration(300);
                PagingScrollHelper.this.f18108i.addUpdateListener(new C0126a());
                PagingScrollHelper.this.f18108i.addListener(new b());
            } else {
                valueAnimator.cancel();
                PagingScrollHelper.this.f18108i.setIntValues(new int[]{i13, i14});
            }
            PagingScrollHelper.this.f18108i.start();
            return true;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            if (i11 == 0 && PagingScrollHelper.this.f18107h != ORIENTATION.NULL) {
                int i12 = -1000;
                boolean z11 = true;
                int i13 = 0;
                if (PagingScrollHelper.this.f18107h == ORIENTATION.VERTICAL) {
                    if (Math.abs(PagingScrollHelper.this.f18103d - PagingScrollHelper.this.f18105f) <= recyclerView.getHeight() / 2) {
                        z11 = false;
                    }
                    if (z11) {
                        if (PagingScrollHelper.this.f18103d - PagingScrollHelper.this.f18105f >= 0) {
                            i12 = 1000;
                        }
                        PagingScrollHelper.this.f18102c.onFling(i13, i12);
                    }
                } else {
                    if (Math.abs(PagingScrollHelper.this.f18104e - PagingScrollHelper.this.f18106g) <= recyclerView.getWidth() / 2) {
                        z11 = false;
                    }
                    if (z11) {
                        if (PagingScrollHelper.this.f18104e - PagingScrollHelper.this.f18106g >= 0) {
                            i12 = 1000;
                        }
                        i13 = i12;
                        i12 = 0;
                        PagingScrollHelper.this.f18102c.onFling(i13, i12);
                    }
                }
                i12 = 0;
                PagingScrollHelper.this.f18102c.onFling(i13, i12);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            PagingScrollHelper.d(PagingScrollHelper.this, i12);
            PagingScrollHelper.f(PagingScrollHelper.this, i11);
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (PagingScrollHelper.this.f18110k) {
                boolean unused = PagingScrollHelper.this.f18110k = false;
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                pagingScrollHelper.f18105f = pagingScrollHelper.f18103d;
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.f18106g = pagingScrollHelper2.f18104e;
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                boolean unused2 = PagingScrollHelper.this.f18110k = true;
            }
            return false;
        }
    }

    public interface d {
        void onPageChange(int i11);
    }

    public static /* synthetic */ int d(PagingScrollHelper pagingScrollHelper, int i11) {
        int i12 = pagingScrollHelper.f18103d + i11;
        pagingScrollHelper.f18103d = i12;
        return i12;
    }

    public static /* synthetic */ int f(PagingScrollHelper pagingScrollHelper, int i11) {
        int i12 = pagingScrollHelper.f18104e + i11;
        pagingScrollHelper.f18104e = i12;
        return i12;
    }

    public final int k() {
        if (this.f18100a.getHeight() == 0 || this.f18100a.getWidth() == 0) {
            return 0;
        }
        if (this.f18107h == ORIENTATION.VERTICAL) {
            return this.f18103d / this.f18100a.getHeight();
        }
        return this.f18104e / this.f18100a.getWidth();
    }

    public final int l() {
        if (this.f18100a.getHeight() == 0 || this.f18100a.getWidth() == 0) {
            return 0;
        }
        if (this.f18107h == ORIENTATION.VERTICAL) {
            return this.f18105f / this.f18100a.getHeight();
        }
        return this.f18106g / this.f18100a.getWidth();
    }
}
