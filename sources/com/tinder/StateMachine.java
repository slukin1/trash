package com.tinder;

import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0010*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u00020\u0001:\u0005\f\u001c\u001d\u001e\tB#\b\u0002\u0012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006*\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000b*\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f*\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u000f*\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001e\u0010\u0013\u001a\u00020\u000f*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006H\u0002R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/tinder/StateMachine;", "", "STATE", "EVENT", "SIDE_EFFECT", "event", "Lcom/tinder/StateMachine$b;", "f", "(Ljava/lang/Object;)Lcom/tinder/StateMachine$b;", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$b;", "Lcom/tinder/StateMachine$Graph$State;", "a", "(Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State;", "cause", "", "c", "(Ljava/lang/Object;Ljava/lang/Object;)V", "d", "e", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "stateRef", "Lcom/tinder/StateMachine$Graph;", "Lcom/tinder/StateMachine$Graph;", "graph", "<init>", "(Lcom/tinder/StateMachine$Graph;)V", "Graph", "GraphBuilder", "Matcher", "state-machine"}, k = 1, mv = {1, 4, 0})
public final class StateMachine<STATE, EVENT, SIDE_EFFECT> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f51108c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<STATE> f51109a;

    /* renamed from: b  reason: collision with root package name */
    public final Graph<STATE, EVENT, SIDE_EFFECT> f51110b;

    @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u0001*\b\b\u0004\u0010\u0003*\u00020\u0001*\b\b\u0005\u0010\u0004*\u00020\u00012\u00020\u0001:\u0001!Bm\u0012\u0006\u0010\u000f\u001a\u00028\u0003\u00120\u0010\u0017\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00120\u0010\u0012*\u0010\u001e\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u0018¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00028\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eRA\u0010\u0017\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00030\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00120\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R;\u0010\u001e\u001a&\u0012\"\u0012 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d¨\u0006\""}, d2 = {"Lcom/tinder/StateMachine$Graph;", "", "STATE", "EVENT", "SIDE_EFFECT", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "initialState", "", "Lcom/tinder/StateMachine$Matcher;", "Lcom/tinder/StateMachine$Graph$State;", "b", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "stateDefinitions", "", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$b;", "", "Ljava/util/List;", "()Ljava/util/List;", "onTransitionListeners", "<init>", "(Ljava/lang/Object;Ljava/util/Map;Ljava/util/List;)V", "State", "state-machine"}, k = 1, mv = {1, 4, 0})
    public static final class Graph<STATE, EVENT, SIDE_EFFECT> {

        /* renamed from: a  reason: collision with root package name */
        public final STATE f51111a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> f51112b;

        /* renamed from: c  reason: collision with root package name */
        public final List<l<b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f51113c;

        @Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0006\u0010\u0002*\u00020\u0001*\b\b\u0007\u0010\u0003*\u00020\u0001*\b\b\b\u0010\u0004*\u00020\u00012\u00020\u0001:\u0001\bB\t\b\u0000¢\u0006\u0004\b\u0016\u0010\u0017R/\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR/\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\f\u0010\nR\u0001\u0010\u0015\u001ar\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u000f\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00100\u00060\u000ej8\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\u00070\u000f\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\b0\u00100\u0006`\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/tinder/StateMachine$Graph$State;", "", "STATE", "EVENT", "SIDE_EFFECT", "", "Lkotlin/Function2;", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "onEnterListeners", "b", "onExitListeners", "Ljava/util/LinkedHashMap;", "Lcom/tinder/StateMachine$Matcher;", "Lcom/tinder/StateMachine$Graph$State$a;", "Lkotlin/collections/LinkedHashMap;", "c", "Ljava/util/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "transitions", "<init>", "()V", "state-machine"}, k = 1, mv = {1, 4, 0})
        public static final class State<STATE, EVENT, SIDE_EFFECT> {

            /* renamed from: a  reason: collision with root package name */
            public final List<p<STATE, EVENT, Unit>> f51114a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public final List<p<STATE, EVENT, Unit>> f51115b = new ArrayList();

            /* renamed from: c  reason: collision with root package name */
            public final LinkedHashMap<Matcher<EVENT, EVENT>, p<STATE, EVENT, a<STATE, SIDE_EFFECT>>> f51116c = new LinkedHashMap<>();

            @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000*\n\b\t\u0010\u0002 \u0001*\u00020\u0001*\n\b\n\u0010\u0003 \u0001*\u00020\u00012\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0010\u001a\u00028\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00018\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00028\tHÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00018\nHÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0010\u001a\u00028\t8\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005R\u0019\u0010\u0012\u001a\u0004\u0018\u00018\n8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/tinder/StateMachine$Graph$State$a;", "", "STATE", "SIDE_EFFECT", "a", "()Ljava/lang/Object;", "b", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getToState", "toState", "getSideEffect", "sideEffect", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "state-machine"}, k = 1, mv = {1, 4, 0})
            public static final class a<STATE, SIDE_EFFECT> {

                /* renamed from: a  reason: collision with root package name */
                public final STATE f51117a;

                /* renamed from: b  reason: collision with root package name */
                public final SIDE_EFFECT f51118b;

                public a(STATE state, SIDE_EFFECT side_effect) {
                    this.f51117a = state;
                    this.f51118b = side_effect;
                }

                public final STATE a() {
                    return this.f51117a;
                }

                public final SIDE_EFFECT b() {
                    return this.f51118b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof a)) {
                        return false;
                    }
                    a aVar = (a) obj;
                    return x.b(this.f51117a, aVar.f51117a) && x.b(this.f51118b, aVar.f51118b);
                }

                public int hashCode() {
                    STATE state = this.f51117a;
                    int i11 = 0;
                    int hashCode = (state != null ? state.hashCode() : 0) * 31;
                    SIDE_EFFECT side_effect = this.f51118b;
                    if (side_effect != null) {
                        i11 = side_effect.hashCode();
                    }
                    return hashCode + i11;
                }

                public String toString() {
                    return "TransitionTo(toState=" + this.f51117a + ", sideEffect=" + this.f51118b + ")";
                }
            }

            public final List<p<STATE, EVENT, Unit>> a() {
                return this.f51114a;
            }

            public final List<p<STATE, EVENT, Unit>> b() {
                return this.f51115b;
            }

            public final LinkedHashMap<Matcher<EVENT, EVENT>, p<STATE, EVENT, a<STATE, SIDE_EFFECT>>> c() {
                return this.f51116c;
            }
        }

        public Graph(STATE state, Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> map, List<? extends l<? super b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> list) {
            this.f51111a = state;
            this.f51112b = map;
            this.f51113c = list;
        }

        public final STATE a() {
            return this.f51111a;
        }

        public final List<l<b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> b() {
            return this.f51113c;
        }

        public final Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> c() {
            return this.f51112b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Graph)) {
                return false;
            }
            Graph graph = (Graph) obj;
            return x.b(this.f51111a, graph.f51111a) && x.b(this.f51112b, graph.f51112b) && x.b(this.f51113c, graph.f51113c);
        }

        public int hashCode() {
            STATE state = this.f51111a;
            int i11 = 0;
            int hashCode = (state != null ? state.hashCode() : 0) * 31;
            Map<Matcher<STATE, STATE>, State<STATE, EVENT, SIDE_EFFECT>> map = this.f51112b;
            int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
            List<l<b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> list = this.f51113c;
            if (list != null) {
                i11 = list.hashCode();
            }
            return hashCode2 + i11;
        }

        public String toString() {
            return "Graph(initialState=" + this.f51111a + ", stateDefinitions=" + this.f51112b + ", onTransitionListeners=" + this.f51113c + ")";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t\"\b\b\u0003\u0010\u0002*\u00020\u0001\"\b\b\u0004\u0010\u0003*\u00020\u0001\"\b\b\u0005\u0010\u0004*\u00020\u00012$\u0010\b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0004\u0012\u00020\u00070\u0005Jz\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\t\"\b\b\u0003\u0010\u0002*\u00020\u0001\"\b\b\u0004\u0010\u0003*\u00020\u0001\"\b\b\u0005\u0010\u0004*\u00020\u00012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u000b2$\u0010\b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/tinder/StateMachine$a;", "", "STATE", "EVENT", "SIDE_EFFECT", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$GraphBuilder;", "", "init", "Lcom/tinder/StateMachine;", "b", "Lcom/tinder/StateMachine$Graph;", "graph", "a", "<init>", "()V", "state-machine"}, k = 1, mv = {1, 4, 0})
    public static final class a {
        public a() {
        }

        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> a(Graph<STATE, EVENT, SIDE_EFFECT> graph, l<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> lVar) {
            GraphBuilder graphBuilder = new GraphBuilder(graph);
            lVar.invoke(graphBuilder);
            return new StateMachine<>(graphBuilder.a(), (r) null);
        }

        public final <STATE, EVENT, SIDE_EFFECT> StateMachine<STATE, EVENT, SIDE_EFFECT> b(l<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>, Unit> lVar) {
            return a((Graph) null, lVar);
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0003\u0010\u0002 \u0001*\u00020\u0001*\n\b\u0004\u0010\u0003 \u0001*\u00020\u0001*\n\b\u0005\u0010\u0004 \u0001*\u00020\u00012\u00020\u0001:\u0002\u0005\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0007\u001a\u00028\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/tinder/StateMachine$b;", "", "STATE", "EVENT", "SIDE_EFFECT", "a", "()Ljava/lang/Object;", "event", "<init>", "()V", "b", "Lcom/tinder/StateMachine$b$b;", "Lcom/tinder/StateMachine$b$a;", "state-machine"}, k = 1, mv = {1, 4, 0})
    public static abstract class b<STATE, EVENT, SIDE_EFFECT> {

        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000*\n\b\u0006\u0010\u0002 \u0001*\u00020\u0001*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0001*\n\b\b\u0010\u0004 \u0001*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u0005B\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00028\u0006\u0012\u0006\u0010\u0012\u001a\u00028\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0011\u001a\u00028\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00028\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/tinder/StateMachine$b$a;", "", "STATE", "EVENT", "SIDE_EFFECT", "Lcom/tinder/StateMachine$b;", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "fromState", "event", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "state-machine"}, k = 1, mv = {1, 4, 0})
        public static final class a<STATE, EVENT, SIDE_EFFECT> extends b<STATE, EVENT, SIDE_EFFECT> {

            /* renamed from: a  reason: collision with root package name */
            public final STATE f51127a;

            /* renamed from: b  reason: collision with root package name */
            public final EVENT f51128b;

            public a(STATE state, EVENT event) {
                super((r) null);
                this.f51127a = state;
                this.f51128b = event;
            }

            public EVENT a() {
                return this.f51128b;
            }

            public STATE b() {
                return this.f51127a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return x.b(b(), aVar.b()) && x.b(a(), aVar.a());
            }

            public int hashCode() {
                Object b11 = b();
                int i11 = 0;
                int hashCode = (b11 != null ? b11.hashCode() : 0) * 31;
                Object a11 = a();
                if (a11 != null) {
                    i11 = a11.hashCode();
                }
                return hashCode + i11;
            }

            public String toString() {
                return "Invalid(fromState=" + b() + ", event=" + a() + ")";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000*\n\b\u0006\u0010\u0002 \u0001*\u00020\u0001*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0001*\n\b\b\u0010\u0004 \u0001*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u0005B+\b\u0000\u0012\u0006\u0010\u0011\u001a\u00028\u0006\u0012\u0006\u0010\u0012\u001a\u00028\u0007\u0012\u0006\u0010\u0015\u001a\u00028\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00018\b¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0011\u001a\u00028\u00068\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00028\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\u0017\u0010\u0015\u001a\u00028\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00018\b8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/tinder/StateMachine$b$b;", "", "STATE", "EVENT", "SIDE_EFFECT", "Lcom/tinder/StateMachine$b;", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "fromState", "event", "c", "d", "toState", "sideEffect", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "state-machine"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tinder.StateMachine$b$b  reason: collision with other inner class name */
        public static final class C0639b<STATE, EVENT, SIDE_EFFECT> extends b<STATE, EVENT, SIDE_EFFECT> {

            /* renamed from: a  reason: collision with root package name */
            public final STATE f51129a;

            /* renamed from: b  reason: collision with root package name */
            public final EVENT f51130b;

            /* renamed from: c  reason: collision with root package name */
            public final STATE f51131c;

            /* renamed from: d  reason: collision with root package name */
            public final SIDE_EFFECT f51132d;

            public C0639b(STATE state, EVENT event, STATE state2, SIDE_EFFECT side_effect) {
                super((r) null);
                this.f51129a = state;
                this.f51130b = event;
                this.f51131c = state2;
                this.f51132d = side_effect;
            }

            public EVENT a() {
                return this.f51130b;
            }

            public STATE b() {
                return this.f51129a;
            }

            public final SIDE_EFFECT c() {
                return this.f51132d;
            }

            public final STATE d() {
                return this.f51131c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0639b)) {
                    return false;
                }
                C0639b bVar = (C0639b) obj;
                return x.b(b(), bVar.b()) && x.b(a(), bVar.a()) && x.b(this.f51131c, bVar.f51131c) && x.b(this.f51132d, bVar.f51132d);
            }

            public int hashCode() {
                Object b11 = b();
                int i11 = 0;
                int hashCode = (b11 != null ? b11.hashCode() : 0) * 31;
                Object a11 = a();
                int hashCode2 = (hashCode + (a11 != null ? a11.hashCode() : 0)) * 31;
                STATE state = this.f51131c;
                int hashCode3 = (hashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                SIDE_EFFECT side_effect = this.f51132d;
                if (side_effect != null) {
                    i11 = side_effect.hashCode();
                }
                return hashCode3 + i11;
            }

            public String toString() {
                return "Valid(fromState=" + b() + ", event=" + a() + ", toState=" + this.f51131c + ", sideEffect=" + this.f51132d + ")";
            }
        }

        public b() {
        }

        public abstract EVENT a();

        public /* synthetic */ b(r rVar) {
            this();
        }
    }

    public StateMachine(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
        this.f51110b = graph;
        this.f51109a = new AtomicReference<>(graph.a());
    }

    public final Graph.State<STATE, EVENT, SIDE_EFFECT> a(STATE state) {
        Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> c11 = this.f51110b.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : c11.entrySet()) {
            if (((Matcher) next.getKey()).b(state)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry value : linkedHashMap.entrySet()) {
            arrayList.add((Graph.State) value.getValue());
        }
        Graph.State<STATE, EVENT, SIDE_EFFECT> state2 = (Graph.State) CollectionsKt___CollectionsKt.c0(arrayList);
        if (state2 != null) {
            return state2;
        }
        throw new IllegalStateException(("Missing definition for state " + state.getClass().getSimpleName() + '!').toString());
    }

    public final b<STATE, EVENT, SIDE_EFFECT> b(STATE state, EVENT event) {
        for (Map.Entry entry : a(state).c().entrySet()) {
            p pVar = (p) entry.getValue();
            if (((Matcher) entry.getKey()).b(event)) {
                Graph.State.a aVar = (Graph.State.a) pVar.invoke(state, event);
                return new b.C0639b(state, event, aVar.a(), aVar.b());
            }
        }
        return new b.a(state, event);
    }

    public final void c(STATE state, EVENT event) {
        for (p invoke : a(state).a()) {
            invoke.invoke(state, event);
        }
    }

    public final void d(STATE state, EVENT event) {
        for (p invoke : a(state).b()) {
            invoke.invoke(state, event);
        }
    }

    public final void e(b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT> bVar) {
        for (l invoke : this.f51110b.b()) {
            invoke.invoke(bVar);
        }
    }

    public final b<STATE, EVENT, SIDE_EFFECT> f(EVENT event) {
        b<STATE, EVENT, SIDE_EFFECT> b11;
        synchronized (this) {
            b11 = b(this.f51109a.get(), event);
            if (b11 instanceof b.C0639b) {
                this.f51109a.set(((b.C0639b) b11).d());
            }
        }
        e(b11);
        if (b11 instanceof b.C0639b) {
            b.C0639b bVar = (b.C0639b) b11;
            d(bVar.b(), event);
            c(bVar.d(), event);
        }
        return b11;
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0012*\b\b\u0003\u0010\u0002*\u00020\u0001*\n\b\u0004\u0010\u0003 \u0001*\u00028\u00032\u00020\u0001:\u0001\nB\u0017\b\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00040\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00050\t0\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00040\r8\bX\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/tinder/StateMachine$Matcher;", "", "T", "R", "value", "", "b", "(Ljava/lang/Object;)Z", "", "Lkotlin/Function1;", "a", "Ljava/util/List;", "predicates", "Ljava/lang/Class;", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;)V", "c", "state-machine"}, k = 1, mv = {1, 4, 0})
    public static final class Matcher<T, R extends T> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f51124c = new a((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final List<l<T, Boolean>> f51125a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<R> f51126b;

        @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ4\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u00060\u0006\"\b\b\u0005\u0010\u0002*\u00020\u0001\"\b\b\u0006\u0010\u0003*\u00028\u00052\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00060\u0004¨\u0006\n"}, d2 = {"Lcom/tinder/StateMachine$Matcher$a;", "", "T", "R", "Ljava/lang/Class;", "clazz", "Lcom/tinder/StateMachine$Matcher;", "a", "<init>", "()V", "state-machine"}, k = 1, mv = {1, 4, 0})
        public static final class a {
            public a() {
            }

            public final <T, R extends T> Matcher<T, R> a(Class<R> cls) {
                return new Matcher<>(cls, (r) null);
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public Matcher(Class<R> cls) {
            this.f51126b = cls;
            this.f51125a = CollectionsKt__CollectionsKt.p(new StateMachine$Matcher$predicates$1(this));
        }

        public final boolean b(T t11) {
            List<l<T, Boolean>> list = this.f51125a;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            for (l invoke : list) {
                if (!((Boolean) invoke.invoke(t11)).booleanValue()) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Matcher(Class cls, r rVar) {
            this(cls);
        }
    }

    public /* synthetic */ StateMachine(Graph graph, r rVar) {
        this(graph);
    }

    @Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u0001*\b\b\u0004\u0010\u0003*\u00020\u0001*\b\b\u0005\u0010\u0004*\u00020\u00012\u00020\u0001:\u0001#B%\u0012\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u0013¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0007\u0010\bJT\u0010\u000f\u001a\u00020\u0006\"\b\b\u0006\u0010\t*\u00028\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00060\n2.\u0010\u000e\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u00060\rR\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0000\u0012\u0004\u0012\u00020\u00060\fJ,\u0010\u0012\u001a\u00020\u00062$\u0010\u0011\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0004\u0012\u00020\u00060\fJ\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00018\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015RÉ\u0001\u0010\u001b\u001a¶\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u0017*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n0\n\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u0017*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00180\u00180\u0016jZ\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003 \u0017*\u0010\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0003\u0018\u00010\n0\n\u00120\u0012.\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005 \u0017*\u0016\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0018\u00010\u00180\u0018`\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR­\u0001\u0010\u001f\u001a\u0001\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0004\u0012\u00020\u0006 \u0017*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f0\f0\u001cjL\u0012H\u0012F\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0004\u0012\u00020\u0006 \u0017*\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f0\f`\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e¨\u0006$"}, d2 = {"Lcom/tinder/StateMachine$GraphBuilder;", "", "STATE", "EVENT", "SIDE_EFFECT", "initialState", "", "b", "(Ljava/lang/Object;)V", "S", "Lcom/tinder/StateMachine$Matcher;", "stateMatcher", "Lkotlin/Function1;", "Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "init", "d", "Lcom/tinder/StateMachine$b;", "listener", "c", "Lcom/tinder/StateMachine$Graph;", "a", "Ljava/lang/Object;", "Ljava/util/LinkedHashMap;", "kotlin.jvm.PlatformType", "Lcom/tinder/StateMachine$Graph$State;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "stateDefinitions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "onTransitionListeners", "graph", "<init>", "(Lcom/tinder/StateMachine$Graph;)V", "StateDefinitionBuilder", "state-machine"}, k = 1, mv = {1, 4, 0})
    public static final class GraphBuilder<STATE, EVENT, SIDE_EFFECT> {

        /* renamed from: a  reason: collision with root package name */
        public STATE f51119a;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> f51120b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<l<b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> f51121c;

        @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0004\u0018\u0000*\b\b\u0006\u0010\u0001*\u00028\u00032\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016JJ\u0010\n\u001a\u00020\t\"\b\b\u0007\u0010\u0003*\u00028\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00070\u00042$\u0010\b\u001a \u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u00070\u0006J\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000bJ1\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0007*\u00028\u00062\u0006\u0010\r\u001a\u00028\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0005¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00050\u0007*\u00028\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00018\u0005¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/tinder/StateMachine$GraphBuilder$StateDefinitionBuilder;", "S", "", "E", "Lcom/tinder/StateMachine$Matcher;", "eventMatcher", "Lkotlin/Function2;", "Lcom/tinder/StateMachine$Graph$State$a;", "createTransitionTo", "", "d", "Lcom/tinder/StateMachine$Graph$State;", "a", "state", "sideEffect", "e", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State$a;", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/tinder/StateMachine$Graph$State$a;", "Lcom/tinder/StateMachine$Graph$State;", "stateDefinition", "<init>", "(Lcom/tinder/StateMachine$GraphBuilder;)V", "state-machine"}, k = 1, mv = {1, 4, 0})
        public final class StateDefinitionBuilder<S extends STATE> {

            /* renamed from: a  reason: collision with root package name */
            public final Graph.State<STATE, EVENT, SIDE_EFFECT> f51122a = new Graph.State<>();

            public StateDefinitionBuilder() {
            }

            public static /* synthetic */ Graph.State.a c(StateDefinitionBuilder stateDefinitionBuilder, Object obj, Object obj2, int i11, Object obj3) {
                if ((i11 & 1) != 0) {
                    obj2 = null;
                }
                return stateDefinitionBuilder.b(obj, obj2);
            }

            public final Graph.State<STATE, EVENT, SIDE_EFFECT> a() {
                return this.f51122a;
            }

            public final Graph.State.a<STATE, SIDE_EFFECT> b(S s11, SIDE_EFFECT side_effect) {
                return e(s11, s11, side_effect);
            }

            public final <E extends EVENT> void d(Matcher<EVENT, ? extends E> matcher, p<? super S, ? super E, ? extends Graph.State.a<? extends STATE, ? extends SIDE_EFFECT>> pVar) {
                this.f51122a.c().put(matcher, new StateMachine$GraphBuilder$StateDefinitionBuilder$on$1(pVar));
            }

            public final Graph.State.a<STATE, SIDE_EFFECT> e(S s11, STATE state, SIDE_EFFECT side_effect) {
                return new Graph.State.a<>(state, side_effect);
            }
        }

        public GraphBuilder() {
            this((Graph) null, 1, (r) null);
        }

        public GraphBuilder(Graph<STATE, EVENT, SIDE_EFFECT> graph) {
            List<l<b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit>> k11;
            Map<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> h11;
            this.f51119a = graph != null ? graph.a() : null;
            this.f51120b = new LinkedHashMap<>((graph == null || (h11 = graph.c()) == null) ? MapsKt__MapsKt.h() : h11);
            this.f51121c = new ArrayList<>((graph == null || (k11 = graph.b()) == null) ? CollectionsKt__CollectionsKt.k() : k11);
        }

        public final Graph<STATE, EVENT, SIDE_EFFECT> a() {
            STATE state = this.f51119a;
            if (state != null) {
                return new Graph<>(state, MapsKt__MapsKt.u(this.f51120b), CollectionsKt___CollectionsKt.I0(this.f51121c));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public final void b(STATE state) {
            this.f51119a = state;
        }

        public final void c(l<? super b<? extends STATE, ? extends EVENT, ? extends SIDE_EFFECT>, Unit> lVar) {
            this.f51121c.add(lVar);
        }

        public final <S extends STATE> void d(Matcher<STATE, ? extends S> matcher, l<? super GraphBuilder<STATE, EVENT, SIDE_EFFECT>.StateDefinitionBuilder<S>, Unit> lVar) {
            LinkedHashMap<Matcher<STATE, STATE>, Graph.State<STATE, EVENT, SIDE_EFFECT>> linkedHashMap = this.f51120b;
            StateDefinitionBuilder stateDefinitionBuilder = new StateDefinitionBuilder();
            lVar.invoke(stateDefinitionBuilder);
            linkedHashMap.put(matcher, stateDefinitionBuilder.a());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GraphBuilder(Graph graph, int i11, r rVar) {
            this((i11 & 1) != 0 ? null : graph);
        }
    }
}
