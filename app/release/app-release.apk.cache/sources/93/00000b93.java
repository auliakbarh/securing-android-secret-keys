package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: DatePickerDialog.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u009d\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u0017¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"DialogButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DialogButtonsMainAxisSpacing", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing = Dp.m4872constructorimpl(12);
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    public static final /* synthetic */ float access$getDialogButtonsCrossAxisSpacing$p() {
        return DialogButtonsCrossAxisSpacing;
    }

    public static final /* synthetic */ float access$getDialogButtonsMainAxisSpacing$p() {
        return DialogButtonsMainAxisSpacing;
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:299:? A[RETURN, SYNTHETIC] */
    /* renamed from: DatePickerDialog-GmEhDVc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1142DatePickerDialogGmEhDVc(final kotlin.jvm.functions.Function0<kotlin.Unit> r54, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.ui.Modifier r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, androidx.compose.ui.graphics.Shape r58, float r59, androidx.compose.material3.DatePickerColors r60, androidx.compose.ui.window.DialogProperties r61, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, androidx.compose.runtime.Composer r63, final int r64, final int r65) {
        /*
            Method dump skipped, instructions count: 635
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerDialog_androidKt.m1142DatePickerDialogGmEhDVc(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, float, androidx.compose.material3.DatePickerColors, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = 8;
        DialogButtonsPadding = PaddingKt.m476PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m4872constructorimpl(6), Dp.m4872constructorimpl(f), 3, null);
        DialogButtonsMainAxisSpacing = Dp.m4872constructorimpl(f);
    }
}