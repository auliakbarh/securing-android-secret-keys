package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001aA\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\t\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.m4872constructorimpl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ void access$CheckboxImpl(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Composer composer, int i) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer, i);
    }

    /* renamed from: access$drawBox-1wkBAMs */
    public static final /* synthetic */ void m1020access$drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        m1022drawBox1wkBAMs(drawScope, j, j2, f, f2);
    }

    /* renamed from: access$drawCheck-3IgeMak */
    public static final /* synthetic */ void m1021access$drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        m1023drawCheck3IgeMak(drawScope, j, f, f2, f3, checkDrawingCache);
    }

    public static final /* synthetic */ float access$getRadiusSize$p() {
        return RadiusSize;
    }

    public static final /* synthetic */ float access$getStrokeWidth$p() {
        return StrokeWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Checkbox(final boolean r29, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.material3.CheckboxColors r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TriStateCheckbox(final androidx.compose.ui.state.ToggleableState r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.material3.CheckboxColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.TriStateCheckbox(androidx.compose.ui.state.ToggleableState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02b3 A[LOOP:0: B:238:0x02b0->B:240:0x02b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CheckboxImpl(final boolean r35, final androidx.compose.ui.state.ToggleableState r36, final androidx.compose.ui.Modifier r37, final androidx.compose.material3.CheckboxColors r38, androidx.compose.runtime.Composer r39, final int r40) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.CheckboxImpl(boolean, androidx.compose.ui.state.ToggleableState, androidx.compose.ui.Modifier, androidx.compose.material3.CheckboxColors, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: drawBox-1wkBAMs */
    public static final void m1022drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float m2458getWidthimpl = Size.m2458getWidthimpl(drawScope.mo3171getSizeNHjbRc());
        if (Color.m2629equalsimpl0(j, j2)) {
            DrawScope.m3168drawRoundRectuAw5IA$default(drawScope, j, 0L, SizeKt.Size(m2458getWidthimpl, m2458getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f4 = m2458getWidthimpl - (2 * f2);
        DrawScope.m3168drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f2, f2), SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = m2458getWidthimpl - f2;
        DrawScope.m3168drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f3, f3), SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* renamed from: drawCheck-3IgeMak */
    public static final void m1023drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.Companion.m2976getSquareKaPHkGw(), 0, null, 26, null);
        float m2458getWidthimpl = Size.m2458getWidthimpl(drawScope.mo3171getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * m2458getWidthimpl, lerp3 * m2458getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(lerp * m2458getWidthimpl, lerp2 * m2458getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * m2458getWidthimpl, m2458getWidthimpl * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m3162drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.m4872constructorimpl(f);
        StrokeWidth = Dp.m4872constructorimpl(f);
        RadiusSize = Dp.m4872constructorimpl(f);
    }
}