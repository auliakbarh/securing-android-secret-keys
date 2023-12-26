package androidx.compose.material3;

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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
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
import androidx.compose.ui.util.MathHelpersKt;
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

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0083\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001ø\u0001\u0000¢\u0006\u0002\u0010>\u001am\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001am\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a)\u0010X\u001a\u00020\r*\u00020\r2\u0006\u0010Y\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a\u009a\u0001\u0010\\\u001a\u00020\u0007*\u00020]2\u0006\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020%2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010a2\b\u0010c\u001a\u0004\u0018\u00010a2\b\u0010d\u001a\u0004\u0018\u00010a2\u0006\u0010e\u001a\u00020a2\b\u0010f\u001a\u0004\u0018\u00010a2\b\u0010g\u001a\u0004\u0018\u00010a2\u0006\u0010h\u001a\u00020a2\b\u0010i\u001a\u0004\u0018\u00010a2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010j\u001a\u00020k2\u0006\u0010<\u001a\u00020=H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006l"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "prefixPlaceableHeight", "suffixPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-DHJA7U0", "(IIIIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-DHJA7U0", "(IIIIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m4872constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m4872constructorimpl(8);

    public static final /* synthetic */ float access$getOutlinedTextFieldInnerPadding$p() {
        return OutlinedTextFieldInnerPadding;
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
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
    public static final void OutlinedTextField(final java.lang.String r120, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instructions count: 1763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r120, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r121, androidx.compose.ui.Modifier r122, boolean r123, boolean r124, androidx.compose.ui.text.TextStyle r125, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r126, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r127, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r128, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r129, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r130, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r131, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r132, boolean r133, androidx.compose.ui.text.input.VisualTransformation r134, androidx.compose.foundation.text.KeyboardOptions r135, androidx.compose.foundation.text.KeyboardActions r136, boolean r137, int r138, int r139, androidx.compose.foundation.interaction.MutableInteractionSource r140, androidx.compose.ui.graphics.Shape r141, androidx.compose.material3.TextFieldColors r142, androidx.compose.runtime.Composer r143, final int r144, final int r145, final int r146, final int r147) {
        /*
            Method dump skipped, instructions count: 1763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final /* synthetic */ void OutlinedTextField(final java.lang.String r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instructions count: 1477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
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
    public static final /* synthetic */ void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r123, final kotlin.jvm.functions.Function1 r124, androidx.compose.ui.Modifier r125, boolean r126, boolean r127, androidx.compose.ui.text.TextStyle r128, kotlin.jvm.functions.Function2 r129, kotlin.jvm.functions.Function2 r130, kotlin.jvm.functions.Function2 r131, kotlin.jvm.functions.Function2 r132, kotlin.jvm.functions.Function2 r133, boolean r134, androidx.compose.ui.text.input.VisualTransformation r135, androidx.compose.foundation.text.KeyboardOptions r136, androidx.compose.foundation.text.KeyboardActions r137, boolean r138, int r139, int r140, androidx.compose.foundation.interaction.MutableInteractionSource r141, androidx.compose.ui.graphics.Shape r142, androidx.compose.material3.TextFieldColors r143, androidx.compose.runtime.Composer r144, final int r145, final int r146, final int r147, final int r148) {
        /*
            Method dump skipped, instructions count: 1477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> textField, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final boolean z, final float f, final Function1<? super Size, Unit> onLabelMeasured, final Function2<? super Composer, ? super Integer, Unit> container, final Function2<? super Composer, ? super Integer, Unit> function26, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        PaddingValues paddingValues2;
        int i3;
        int i4;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)518@25327L239,526@25614L7,527@25626L3534:OutlinedTextField.kt#uh7d8r");
        int i5 = (i & 14) == 0 ? (startRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i5 |= startRestartGroup.changedInstance(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i5 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i5 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i5 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i5 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i5 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i5 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i5 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        int i6 = (i2 & 14) == 0 ? (startRestartGroup.changedInstance(onLabelMeasured) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i6 |= startRestartGroup.changedInstance(container) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i6 |= startRestartGroup.changedInstance(function26) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            paddingValues2 = paddingValues;
            i6 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i5 & 1533916891) != 306783378 || (i6 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i5, i6, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:502)");
            }
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues2};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            int i7 = 0;
            boolean z2 = false;
            for (int i8 = 4; i7 < i8; i8 = 4) {
                z2 |= startRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, z, f, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
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
            int i9 = ((((i5 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m2269setimpl(m2262constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2269setimpl(m2262constructorimpl, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2269setimpl(m2262constructorimpl, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2269setimpl(m2262constructorimpl, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            materializerOf.invoke(SkippableUpdater.m2253boximpl(SkippableUpdater.m2254constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i9 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1116455022, "C530@25695L11,600@28180L228:OutlinedTextField.kt#uh7d8r");
            container.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            startRestartGroup.startReplaceableGroup(1116455047);
            ComposerKt.sourceInformation(startRestartGroup, "533@25759L219");
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
                i3 = i6;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313841, "C537@25951L9:OutlinedTextField.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                i3 = i6;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116455332);
            ComposerKt.sourceInformation(startRestartGroup, "541@26045L221");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313554, "C545@26238L10:OutlinedTextField.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
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
                i4 = 0;
                calculateStartPadding = Dp.m4872constructorimpl(RangesKt.coerceAtLeast(Dp.m4872constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4872constructorimpl(0)));
            } else {
                i4 = 0;
            }
            if (function23 != null) {
                calculateEndPadding = Dp.m4872constructorimpl(RangesKt.coerceAtLeast(Dp.m4872constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m4872constructorimpl(i4)));
            }
            startRestartGroup.startReplaceableGroup(1116456222);
            ComposerKt.sourceInformation(startRestartGroup, "564@26933L334");
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
                f2 = calculateStartPadding;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828312551, "C571@27241L8:OutlinedTextField.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i5 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f2 = calculateStartPadding;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116456621);
            ComposerKt.sourceInformation(startRestartGroup, "575@27332L332");
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
                f3 = calculateEndPadding;
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828312154, "C582@27638L8:OutlinedTextField.kt#uh7d8r");
                function25.invoke(startRestartGroup, Integer.valueOf((i5 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f3 = calculateEndPadding;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m483paddingqDBjuR0$default3 = PaddingKt.m483paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), function24 == null ? f2 : Dp.m4872constructorimpl(0), 0.0f, function25 == null ? f3 : Dp.m4872constructorimpl(0), 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(1116457331);
            ComposerKt.sourceInformation(startRestartGroup, "595@28047L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(m483paddingqDBjuR0$default3), startRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(m483paddingqDBjuR0$default3);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume19 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration6 = (ViewConfiguration) consume19;
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf6 = LayoutKt.materializerOf(then3);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311409, "C606@28383L11:OutlinedTextField.kt#uh7d8r");
            textField.invoke(startRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116457749);
            ComposerKt.sourceInformation(startRestartGroup, "610@28459L237");
            if (function2 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m514heightInVpY3zN4$default(Modifier.Companion, DpKt.m4915lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.LabelId);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
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
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf7 = LayoutKt.materializerOf(layoutId);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311105, "C614@28687L7:OutlinedTextField.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2058764510);
            ComposerKt.sourceInformation(startRestartGroup, "619@28822L269");
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828310715, "C624@29077L12:OutlinedTextField.kt#uh7d8r");
                function26.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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

            public final void invoke(Composer composer2, int i10) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, textField, function3, function2, function22, function23, function24, function25, z, f, onLabelMeasured, container, function26, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
            }
        });
    }

    /* renamed from: calculateWidth-DHJA7U0 */
    public static final int m1325calculateWidthDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, long j, float f, PaddingValues paddingValues) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, z ? i6 : 0)) + i2, Math.max(z ? 0 : i6 + MathKt.roundToInt(Dp.m4872constructorimpl(paddingValues.mo430calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo431calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f), Constraints.m4830getMinWidthimpl(j)));
    }

    /* renamed from: calculateHeight-DHJA7U0 */
    public static final int m1324calculateHeightDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f, PaddingValues paddingValues) {
        return Math.max(Constraints.m4829getMinHeightimpl(j), ComparisonsKt.maxOf(i, i2, i3, i4, MathKt.roundToInt(Math.max(i5, i7) + (paddingValues.mo429calculateBottomPaddingD9Ej5fM() * f) + Math.max(paddingValues.mo432calculateTopPaddingD9Ej5fM() * f, i6 / 2.0f))) + i8);
    }

    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable.PlacementScope.m3922place70tqf50$default(placementScope, placeable8, IntOffset.Companion.m5000getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int roundToInt = MathKt.roundToInt(paddingValues.mo432calculateTopPaddingD9Ej5fM() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f)) + roundToInt2, MathHelpersKt.lerp(z ? Alignment.Companion.getCenterVertically().align(placeable6.getHeight(), heightOrZero) : roundToInt, -(placeable6.getHeight() / 2), f), 0.0f, 4, null);
        }
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6, placeable3), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i2 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6, placeable4), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, place$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, widthOrZero, place$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable6, placeable7), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable, Placeable placeable2) {
        if (z) {
            i2 = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i2, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* renamed from: outlineCutout-12SF9DM */
    public static final Modifier m1326outlineCutout12SF9DM(Modifier outlineCutout, final long j, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float coerceAtLeast;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float m2458getWidthimpl = Size.m2458getWidthimpl(j);
                if (m2458getWidthimpl > 0.0f) {
                    float f = drawWithContent.mo324toPx0680j_4(OutlinedTextFieldKt.access$getOutlinedTextFieldInnerPadding$p());
                    float f2 = drawWithContent.mo324toPx0680j_4(paddingValues.mo430calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - f;
                    float f3 = 2;
                    float f4 = m2458getWidthimpl + f2 + (f * f3);
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        coerceAtLeast = Size.m2458getWidthimpl(drawWithContent.mo3171getSizeNHjbRc()) - f4;
                    } else {
                        coerceAtLeast = RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f5 = coerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        f4 = Size.m2458getWidthimpl(drawWithContent.mo3171getSizeNHjbRc()) - RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f6 = f4;
                    float m2455getHeightimpl = Size.m2455getHeightimpl(j);
                    float f7 = m2455getHeightimpl / f3;
                    int m2616getDifferencertfAjoo = ClipOp.Companion.m2616getDifferencertfAjoo();
                    DrawContext drawContext = drawWithContent.getDrawContext();
                    long mo3096getSizeNHjbRc = drawContext.mo3096getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo3099clipRectN_I0leg(f5, (-m2455getHeightimpl) / f3, f6, f7, m2616getDifferencertfAjoo);
                    drawWithContent.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo3097setSizeuvyYCjk(mo3096getSizeNHjbRc);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }
}