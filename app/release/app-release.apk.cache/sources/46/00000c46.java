package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppBar.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1", f = "AppBar.kt", i = {0, 0}, l = {1499, 1500}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
/* loaded from: classes.dex */
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnterAlwaysScrollBehavior$nestedScrollConnection$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(EnterAlwaysScrollBehavior$nestedScrollConnection$1 enterAlwaysScrollBehavior$nestedScrollConnection$1, Continuation<? super EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = enterAlwaysScrollBehavior$nestedScrollConnection$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo331onPostFlingRZ2iAVY(0L, 0L, this);
    }
}