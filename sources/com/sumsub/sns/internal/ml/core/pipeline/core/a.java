package com.sumsub.sns.internal.ml.core.pipeline.core;

public final class a<Input, Output> {

    /* renamed from: a  reason: collision with root package name */
    public final b<Input, Output> f35037a;

    /* renamed from: com.sumsub.sns.internal.ml.core.pipeline.core.a$a  reason: collision with other inner class name */
    public static final class C0413a implements b<Input, NewOutput> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b<Output, NewOutput> f35038a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<Input, Output> f35039b;

        public C0413a(b<Output, NewOutput> bVar, a<Input, Output> aVar) {
            this.f35038a = bVar;
            this.f35039b = aVar;
        }

        public NewOutput a(Input input) {
            return this.f35038a.a(this.f35039b.f35037a.a(input));
        }
    }

    public a(b<Input, Output> bVar) {
        this.f35037a = bVar;
    }

    public final <NewOutput> a<Input, NewOutput> a(b<Output, NewOutput> bVar) {
        return new a<>(new C0413a(bVar, this));
    }

    public final Output a(Input input) {
        return this.f35037a.a(input);
    }
}
