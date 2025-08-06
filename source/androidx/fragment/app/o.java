package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.y;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

public class o {
    public static int a(Fragment fragment, boolean z11, boolean z12) {
        if (z12) {
            if (z11) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z11) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    @SuppressLint({"ResourceType"})
    public static a b(Context context, Fragment fragment, boolean z11, boolean z12) {
        int nextTransition = fragment.getNextTransition();
        int a11 = a(fragment, z11, z12);
        boolean z13 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i11 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i11) != null) {
                fragment.mContainer.setTag(i11, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z11, a11);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z11, a11);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a11 == 0 && nextTransition != 0) {
            a11 = d(context, nextTransition, z11);
        }
        if (a11 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a11));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a11);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z13 = true;
                } catch (Resources.NotFoundException e11) {
                    throw e11;
                } catch (RuntimeException unused) {
                }
            }
            if (!z13) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a11);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e12) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a11);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e12;
                    }
                }
            }
        }
        return null;
    }

    public static int c(Context context, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i11});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i11, boolean z11) {
        if (i11 == 4097) {
            return z11 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i11 == 8194) {
            return z11 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
        }
        if (i11 != 8197) {
            if (i11 == 4099) {
                return z11 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
            }
            if (i11 != 4100) {
                return -1;
            }
            if (z11) {
                return c(context, 16842936);
            }
            return c(context, 16842937);
        } else if (z11) {
            return c(context, 16842938);
        } else {
            return c(context, 16842939);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f9768a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f9769b;

        public a(Animation animation) {
            this.f9768a = animation;
            this.f9769b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f9768a = null;
            this.f9769b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class b extends AnimationSet implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final ViewGroup f9770b;

        /* renamed from: c  reason: collision with root package name */
        public final View f9771c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9772d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9773e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9774f = true;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f9770b = viewGroup;
            this.f9771c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j11, Transformation transformation) {
            this.f9774f = true;
            if (this.f9772d) {
                return !this.f9773e;
            }
            if (!super.getTransformation(j11, transformation)) {
                this.f9772d = true;
                y.a(this.f9770b, this);
            }
            return true;
        }

        public void run() {
            if (this.f9772d || !this.f9774f) {
                this.f9770b.endViewTransition(this.f9771c);
                this.f9773e = true;
                return;
            }
            this.f9774f = false;
            this.f9770b.post(this);
        }

        public boolean getTransformation(long j11, Transformation transformation, float f11) {
            this.f9774f = true;
            if (this.f9772d) {
                return !this.f9773e;
            }
            if (!super.getTransformation(j11, transformation, f11)) {
                this.f9772d = true;
                y.a(this.f9770b, this);
            }
            return true;
        }
    }
}
