package kotlinx.coroutines.flow;

import kotlin.coroutines.c;

final class StartedLazily implements i1 {
    public d<SharingCommand> a(j1<Integer> j1Var) {
        return f.F(new StartedLazily$command$1(j1Var, (c<? super StartedLazily$command$1>) null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
