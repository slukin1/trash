package rx.internal.operators;

import java.util.Arrays;
import java.util.Collection;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class SingleOnSubscribeUsing<T, Resource> implements Single.OnSubscribe<T> {
    public final Action1<? super Resource> disposeAction;
    public final boolean disposeEagerly;
    public final Func0<Resource> resourceFactory;
    public final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;

    public SingleOnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z11) {
        this.resourceFactory = func0;
        this.singleFactory = func1;
        this.disposeAction = action1;
        this.disposeEagerly = z11;
    }

    public void handleSubscriptionTimeError(SingleSubscriber<? super T> singleSubscriber, Resource resource, Throwable th2) {
        Exceptions.throwIfFatal(th2);
        if (this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th3}));
            }
        }
        singleSubscriber.onError(th2);
        if (!this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaHooks.onError(th4);
            }
        }
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        try {
            final Resource call = this.resourceFactory.call();
            try {
                Single single = (Single) this.singleFactory.call(call);
                if (single == null) {
                    handleSubscriptionTimeError(singleSubscriber, call, new NullPointerException("The single"));
                    return;
                }
                AnonymousClass1 r22 = new SingleSubscriber<T>() {
                    public void onError(Throwable th2) {
                        SingleOnSubscribeUsing.this.handleSubscriptionTimeError(singleSubscriber, call, th2);
                    }

                    public void onSuccess(T t11) {
                        SingleOnSubscribeUsing singleOnSubscribeUsing = SingleOnSubscribeUsing.this;
                        if (singleOnSubscribeUsing.disposeEagerly) {
                            try {
                                singleOnSubscribeUsing.disposeAction.call(call);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                singleSubscriber.onError(th2);
                                return;
                            }
                        }
                        singleSubscriber.onSuccess(t11);
                        SingleOnSubscribeUsing singleOnSubscribeUsing2 = SingleOnSubscribeUsing.this;
                        if (!singleOnSubscribeUsing2.disposeEagerly) {
                            try {
                                singleOnSubscribeUsing2.disposeAction.call(call);
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                RxJavaHooks.onError(th3);
                            }
                        }
                    }
                };
                singleSubscriber.add(r22);
                single.subscribe(r22);
            } catch (Throwable th2) {
                handleSubscriptionTimeError(singleSubscriber, call, th2);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            singleSubscriber.onError(th3);
        }
    }
}
