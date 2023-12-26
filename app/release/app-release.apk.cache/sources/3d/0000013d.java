package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2>\b\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 0\u0014ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020!2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    /* JADX WARN: Removed duplicated region for block: B:136:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S> void AnimatedContent(final S r19, androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r21, androidx.compose.ui.Alignment r22, java.lang.String r23, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r24, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m9invokeTemP2vQ(intSize.m5036unboximpl(), intSize2.m5036unboximpl());
                }

                /* renamed from: invoke-TemP2vQ  reason: not valid java name */
                public final SpringSpec<IntSize> m9invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5024boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(z, sizeAnimationSpec);
    }

    public static final ContentTransform togetherWith(EnterTransition enterTransition, ExitTransition exit) {
        Intrinsics.checkNotNullParameter(enterTransition, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform(enterTransition, exit, 0.0f, null, 12, null);
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(expression = "togetherWith(exit)", imports = {}))
    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exit) {
        Intrinsics.checkNotNullParameter(enterTransition, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform(enterTransition, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:212:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0279 A[LOOP:2: B:324:0x0277->B:325:0x0279, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S> void AnimatedContent(final androidx.compose.animation.core.Transition<S> r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> r25, androidx.compose.ui.Alignment r26, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r27, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}