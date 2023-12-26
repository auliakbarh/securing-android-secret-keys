package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1", f = "LazyLayoutAnimateItemModifierNode.kt", i = {0}, l = {97, 103}, m = "invokeSuspend", n = {"spec"}, s = {"L$0"})
/* loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, Continuation<? super LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        SpringSpec placementAnimationSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        Animatable animatable2;
        Animatable animatable3;
        SpringSpec springSpec;
        Animatable animatable4;
        Animatable animatable5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.placementDeltaAnimation;
            if (animatable.isRunning()) {
                if (this.this$0.getPlacementAnimationSpec() instanceof SpringSpec) {
                    placementAnimationSpec = this.this$0.getPlacementAnimationSpec();
                } else {
                    springSpec = LazyLayoutAnimateItemModifierNodeKt.InterruptionSpec;
                    placementAnimationSpec = springSpec;
                }
            } else {
                placementAnimationSpec = this.this$0.getPlacementAnimationSpec();
            }
            finiteAnimationSpec = placementAnimationSpec;
            animatable2 = this.this$0.placementDeltaAnimation;
            if (!animatable2.isRunning()) {
                animatable3 = this.this$0.placementDeltaAnimation;
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (animatable3.snapTo(IntOffset.m4981boximpl(this.$totalDelta), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setAnimationInProgress(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        animatable4 = this.this$0.placementDeltaAnimation;
        long m4999unboximpl = ((IntOffset) animatable4.getValue()).m4999unboximpl();
        long j = this.$totalDelta;
        final long IntOffset = IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m4999unboximpl) - IntOffset.m4990getXimpl(j), IntOffset.m4991getYimpl(m4999unboximpl) - IntOffset.m4991getYimpl(j));
        animatable5 = this.this$0.placementDeltaAnimation;
        final LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (Animatable.animateTo$default(animatable5, IntOffset.m4981boximpl(IntOffset), finiteAnimationSpec, null, new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Animatable<IntOffset, AnimationVector2D> animatable6) {
                invoke2(animatable6);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Animatable<IntOffset, AnimationVector2D> animateTo) {
                Intrinsics.checkNotNullParameter(animateTo, "$this$animateTo");
                LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode2 = LazyLayoutAnimateItemModifierNode.this;
                long m4999unboximpl2 = animateTo.getValue().m4999unboximpl();
                long j2 = IntOffset;
                lazyLayoutAnimateItemModifierNode2.m622setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4990getXimpl(m4999unboximpl2) - IntOffset.m4990getXimpl(j2), IntOffset.m4991getYimpl(m4999unboximpl2) - IntOffset.m4991getYimpl(j2)));
            }
        }, this, 4, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}