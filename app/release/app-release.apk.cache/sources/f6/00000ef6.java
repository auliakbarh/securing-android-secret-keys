package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010-\u001aÖ\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010/\u001a¨\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020.2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001aì\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0002\b\u00142\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00105\u001a\u0002062\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\b\u00142\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013¢\u0006\u0002\b\u00142\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001au\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001aU\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020$2\u0006\u0010P\u001a\u00020$2\u0006\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u0014\u0010U\u001a\u00020\f*\u00020\f2\u0006\u0010V\u001a\u00020WH\u0000\u001a\u009a\u0001\u0010X\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020$2\u0006\u0010g\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u000206H\u0002\u001a\u0080\u0001\u0010h\u001a\u00020\u0006*\u00020Y2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$2\u0006\u0010i\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010]2\b\u0010a\u001a\u0004\u0018\u00010]2\b\u0010b\u001a\u0004\u0018\u00010]2\b\u0010c\u001a\u0004\u0018\u00010]2\u0006\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010]2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010H\u001a\u0002062\u0006\u00109\u001a\u00020:H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006j"}, d2 = {"TextFieldWithLabelVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTextFieldWithLabelVerticalPadding", "()F", "F", TextFieldImplKt.TextFieldId, "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelFocused", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m4872constructorimpl(8);

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:398:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:564:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:591:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:647:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:656:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:668:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:670:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:701:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:704:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:713:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:716:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:723:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextField(final java.lang.String r120, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instructions count: 1763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:398:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:533:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:564:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:591:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:647:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:656:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:668:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:670:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:689:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:701:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:704:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:709:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:713:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:716:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:723:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TextField(final androidx.compose.ui.text.input.TextFieldValue r120, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instructions count: 1763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:366:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:659:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void TextField(final java.lang.String r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instructions count: 1477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:366:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:589:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:659:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void TextField(final androidx.compose.ui.text.input.TextFieldValue r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instructions count: 1477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final boolean z, final float f, final Function2<? super Composer, ? super Integer, Unit> container, final Function2<? super Composer, ? super Integer, Unit> function26, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        int i6;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-1830307184);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldLayout)P(4,11,2,6,3,12,7,9,8!2,10)512@24588L139,515@24775L7,516@24787L3994:TextField.kt#uh7d8r");
        if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i3 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(container) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i3 & 1533916891) != 306783378 || (i4 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i3, i4, "androidx.compose.material3.TextFieldLayout (TextField.kt:497)");
            }
            Boolean valueOf = Boolean.valueOf(z);
            Float valueOf2 = Float.valueOf(f);
            startRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(valueOf2) | startRestartGroup.changed(paddingValues2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume4;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i7 = ((((i3 << 3) & 112) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m2262constructorimpl = Updater.m2262constructorimpl(startRestartGroup);
            Updater.m2269setimpl(m2262constructorimpl, textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2269setimpl(m2262constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2269setimpl(m2262constructorimpl, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2269setimpl(m2262constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i7 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -95272033, "C522@25106L11,605@28102L229:TextField.kt#uh7d8r");
            container.invoke(startRestartGroup, Integer.valueOf(i4 & 14));
            startRestartGroup.startReplaceableGroup(-95272008);
            ComposerKt.sourceInformation(startRestartGroup, "525@25170L269");
            if (function22 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume6;
                i5 = i4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(then);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl2 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl2, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl2, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl2, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219124082, "C531@25412L9:TextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i5 = i4;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95271673);
            ComposerKt.sourceInformation(startRestartGroup, "535@25506L271");
            if (function23 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) consume9;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume10;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl3 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl3, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl3, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl3, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219124419, "C541@25749L10:TextField.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            if (function22 != null) {
                i6 = 0;
                calculateStartPadding = Dp.m4872constructorimpl(RangesKt.coerceAtLeast(Dp.m4872constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4872constructorimpl(0)));
            } else {
                i6 = 0;
            }
            if (function23 != null) {
                calculateEndPadding = Dp.m4872constructorimpl(RangesKt.coerceAtLeast(Dp.m4872constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4872constructorimpl(i6)));
            }
            startRestartGroup.startReplaceableGroup(-95270733);
            ComposerKt.sourceInformation(startRestartGroup, "560@26444L334");
            if (function24 != null) {
                Modifier m483paddingqDBjuR0$default = PaddingKt.m483paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), calculateStartPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density4 = (Density) consume11;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) consume12;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume13 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) consume13;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(m483paddingqDBjuR0$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl4 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl4, density4, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl4, layoutDirection5, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl4, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219125422, "C567@26752L8:TextField.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i3 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95270334);
            ComposerKt.sourceInformation(startRestartGroup, "571@26843L332");
            if (function25 != null) {
                Modifier m483paddingqDBjuR0$default2 = PaddingKt.m483paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, calculateEndPadding, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume14 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density5 = (Density) consume14;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume15 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection6 = (LayoutDirection) consume15;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume16 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) consume16;
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(m483paddingqDBjuR0$default2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl5 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl5, rememberBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl5, density5, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl5, layoutDirection6, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl5, viewConfiguration5, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf5.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219125819, "C578@27149L8:TextField.kt#uh7d8r");
                function25.invoke(startRestartGroup, Integer.valueOf((i3 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-95269936);
            ComposerKt.sourceInformation(startRestartGroup, "583@27240L347");
            if (function2 != null) {
                f3 = calculateStartPadding;
                Modifier m483paddingqDBjuR0$default3 = PaddingKt.m483paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId), DpKt.m4915lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), f3, 0.0f, calculateEndPadding, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume17 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density6 = (Density) consume17;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume18 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection7 = (LayoutDirection) consume18;
                f2 = calculateEndPadding;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume19 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration6 = (ViewConfiguration) consume19;
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf6 = LayoutKt.materializerOf(m483paddingqDBjuR0$default3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor6);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl6 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl6, rememberBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl6, density6, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl6, layoutDirection7, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl6, viewConfiguration6, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf6.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219126248, "C589@27578L7:TextField.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f2 = calculateEndPadding;
                f3 = calculateStartPadding;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m483paddingqDBjuR0$default4 = PaddingKt.m483paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function24 == null ? f3 : Dp.m4872constructorimpl(0), 0.0f, function25 == null ? f2 : Dp.m4872constructorimpl(0), 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(-95269212);
            ComposerKt.sourceInformation(startRestartGroup, "601@27970L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(m483paddingqDBjuR0$default4), startRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(m483paddingqDBjuR0$default4);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume20 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density7 = (Density) consume20;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume21 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection8 = (LayoutDirection) consume21;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration7 = (ViewConfiguration) consume22;
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf7 = LayoutKt.materializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2262constructorimpl7 = Updater.m2262constructorimpl(startRestartGroup);
            Updater.m2269setimpl(m2262constructorimpl7, rememberBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2269setimpl(m2262constructorimpl7, density7, ComposeUiNode.Companion.getSetDensity());
            Updater.m2269setimpl(m2262constructorimpl7, layoutDirection8, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2269setimpl(m2262constructorimpl7, viewConfiguration7, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf7.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219126976, "C611@28306L11:TextField.kt#uh7d8r");
            textField.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(243142693);
            ComposerKt.sourceInformation(startRestartGroup, "616@28443L269");
            if (function26 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m1517supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume23 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density8 = (Density) consume23;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume24 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection9 = (LayoutDirection) consume24;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume25 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration8 = (ViewConfiguration) consume25;
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf8 = LayoutKt.materializerOf(padding);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer m2262constructorimpl8 = Updater.m2262constructorimpl(startRestartGroup);
                Updater.m2269setimpl(m2262constructorimpl8, rememberBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2269setimpl(m2262constructorimpl8, density8, ComposeUiNode.Companion.getSetDensity());
                Updater.m2269setimpl(m2262constructorimpl8, layoutDirection9, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2269setimpl(m2262constructorimpl8, viewConfiguration8, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf8.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219127368, "C621@28698L12:TextField.kt#uh7d8r");
                function26.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextFieldLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                TextFieldKt.TextFieldLayout(Modifier.this, textField, function2, function3, function22, function23, function24, function25, z, f, container, function26, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
            }
        });
    }

    /* renamed from: calculateWidth-yeHjK3Y */
    public static final int m1548calculateWidthyeHjK3Y(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, i6)) + i2, Constraints.m4830getMinWidthimpl(j));
    }

    /* renamed from: calculateHeight-mKXJcVc */
    public static final int m1547calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, long j, float f, PaddingValues paddingValues) {
        float m4872constructorimpl;
        int max;
        boolean z2 = i2 > 0;
        if (!z2 || z) {
            m4872constructorimpl = Dp.m4872constructorimpl(paddingValues.mo432calculateTopPaddingD9Ej5fM() + paddingValues.mo429calculateBottomPaddingD9Ej5fM());
        } else {
            m4872constructorimpl = Dp.m4872constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2);
        }
        float f2 = f * m4872constructorimpl;
        if (z2 && z) {
            f2 += i2;
            max = Math.max(i, i7);
        } else {
            max = Math.max(i2, Math.max(i, i7));
        }
        return Math.max(Constraints.m4829getMinHeightimpl(j), ComparisonsKt.maxOf(i3, i4, i5, i6, MathKt.roundToInt(f2 + max)) + i8);
    }

    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z, int i3, int i4, float f, float f2) {
        int roundToInt;
        Placeable.PlacementScope.m3922place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m5000getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), heightOrZero);
            } else {
                roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), roundToInt - MathKt.roundToInt((roundToInt - i3) * f), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i4, 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, i4, 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z, float f, PaddingValues paddingValues) {
        Placeable.PlacementScope.m3922place70tqf50$default(placementScope, placeable7, IntOffset.Companion.m5000getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - TextFieldImplKt.heightOrZero(placeable8);
        int roundToInt = MathKt.roundToInt(paddingValues.mo432calculateTopPaddingD9Ej5fM() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable5), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable3) + TextFieldImplKt.widthOrZero(placeable5);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable) {
        return z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        final float m184getWidthD9Ej5fM = indicatorBorder.m184getWidthD9Ej5fM();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                drawWithContent.drawContent();
                if (Dp.m4877equalsimpl0(m184getWidthD9Ej5fM, Dp.Companion.m4890getHairlineD9Ej5fM())) {
                    return;
                }
                float density = m184getWidthD9Ej5fM * drawWithContent.getDensity();
                float m2455getHeightimpl = Size.m2455getHeightimpl(drawWithContent.mo3171getSizeNHjbRc()) - (density / 2);
                DrawScope.m3157drawLine1RTmtNc$default(drawWithContent, indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, m2455getHeightimpl), OffsetKt.Offset(Size.m2458getWidthimpl(drawWithContent.mo3171getSizeNHjbRc()), m2455getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }
}