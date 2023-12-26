package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006(²\u0006\n\u0010)\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020%X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "textFieldValueState", "lastTextValue"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicTextFieldKt {
    public static final /* synthetic */ TextFieldValue access$BasicTextField$lambda$2(MutableState mutableState) {
        return BasicTextField$lambda$2(mutableState);
    }

    public static final /* synthetic */ void access$BasicTextField$lambda$3(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    public static final /* synthetic */ String access$BasicTextField$lambda$6(MutableState mutableState) {
        return BasicTextField$lambda$6(mutableState);
    }

    public static final /* synthetic */ void access$BasicTextField$lambda$7(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:549:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final java.lang.String r40, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, int r50, androidx.compose.ui.text.input.VisualTransformation r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final String BasicTextField$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:297:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:464:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:521:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r36, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, boolean r40, androidx.compose.ui.text.TextStyle r41, androidx.compose.foundation.text.KeyboardOptions r42, androidx.compose.foundation.text.KeyboardActions r43, boolean r44, int r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1093
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:257:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:441:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BasicTextField(final java.lang.String r37, final kotlin.jvm.functions.Function1 r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1 r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 899
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:257:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:441:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BasicTextField(final androidx.compose.ui.text.input.TextFieldValue r37, final kotlin.jvm.functions.Function1 r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1 r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 899
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}