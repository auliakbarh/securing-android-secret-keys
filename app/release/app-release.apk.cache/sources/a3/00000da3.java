package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SearchBar.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0080\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u008a\u0002\u0010?\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u00108\u001a\u0002092\u001c\u0010:\u001a\u0018\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b<H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001aÆ\u0001\u0010D\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020E2\b\b\u0002\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0018\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0013\u0010\u001b\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0013\u0010\u001c\u001a\u00020\u0010X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0013\"\u0019\u0010\u001d\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0019\u0010\u001f\u001a\u00020\u0010X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-rpjkMjA", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Id_Pb_0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius = Dp.m4872constructorimpl(SearchBarDefaults.INSTANCE.m1363getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedActiveTableMinHeight = Dp.m4872constructorimpl(240);
    private static final float SearchBarMinWidth = Dp.m4872constructorimpl(360);
    private static final float SearchBarMaxWidth = Dp.m4872constructorimpl(720);
    private static final float SearchBarVerticalPadding = Dp.m4872constructorimpl(8);
    private static final float SearchBarIconOffsetX = Dp.m4872constructorimpl(4);

    public static final /* synthetic */ void access$SearchBarInputField(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, int i, int i2, int i3) {
        SearchBarInputField(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, textFieldColors, mutableInteractionSource, composer, i, i2, i3);
    }

    public static final /* synthetic */ float access$getSearchBarCornerRadius$p() {
        return SearchBarCornerRadius;
    }

    public static final /* synthetic */ float access$getSearchBarMaxWidth$p() {
        return SearchBarMaxWidth;
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    /* JADX WARN: Code restructure failed: missing block: B:423:0x01c0, code lost:
        if (r6.changed(r57) == false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:420:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:565:? A[RETURN, SYNTHETIC] */
    /* renamed from: SearchBar-Id_Pb_0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1367SearchBarId_Pb_0(final java.lang.String r44, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r45, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r46, final boolean r47, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r48, androidx.compose.ui.Modifier r49, boolean r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.ui.graphics.Shape r54, androidx.compose.material3.SearchBarColors r55, float r56, androidx.compose.foundation.layout.WindowInsets r57, androidx.compose.foundation.interaction.MutableInteractionSource r58, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, androidx.compose.runtime.Composer r60, final int r61, final int r62, final int r63) {
        /*
            Method dump skipped, instructions count: 1543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m1367SearchBarId_Pb_0(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:364:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:453:? A[RETURN, SYNTHETIC] */
    /* renamed from: DockedSearchBar-rpjkMjA */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1366DockedSearchBarrpjkMjA(final java.lang.String r39, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r40, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, final boolean r42, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r43, androidx.compose.ui.Modifier r44, boolean r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.ui.graphics.Shape r49, androidx.compose.material3.SearchBarColors r50, float r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m1366DockedSearchBarrpjkMjA(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:273:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x035e A[LOOP:0: B:391:0x035c->B:392:0x035e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:413:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SearchBarInputField(final java.lang.String r81, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r82, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r83, final boolean r84, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r85, androidx.compose.ui.Modifier r86, boolean r87, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, androidx.compose.material3.TextFieldColors r91, androidx.compose.foundation.interaction.MutableInteractionSource r92, androidx.compose.runtime.Composer r93, final int r94, final int r95, final int r96) {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.SearchBarInputField(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tween = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        TweenSpec tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        TweenSpec tween3 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        TweenSpec tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, null, false, null, 14, null));
    }

    public static final boolean SearchBar_Id_Pb_0$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}