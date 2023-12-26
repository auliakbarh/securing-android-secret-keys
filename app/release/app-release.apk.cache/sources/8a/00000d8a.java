package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m4872constructorimpl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    public static final /* synthetic */ float access$getRadioStrokeWidth$p() {
        return RadioStrokeWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void RadioButton(final boolean r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.material3.RadioButtonColors r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.RadioButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m4872constructorimpl(f);
        RadioStrokeWidth = Dp.m4872constructorimpl(f);
    }
}