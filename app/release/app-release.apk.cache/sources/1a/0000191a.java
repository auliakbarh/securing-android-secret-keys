package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CursorAnchorInfoBuilder.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "setInsertionMarker", "selectionStart", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CursorAnchorInfoBuilderKt {
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, TextLayoutResult textLayoutResult, Matrix matrix) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int m4401getMinimpl = TextRange.m4401getMinimpl(textFieldValue.m4622getSelectiond9O1mEE());
        builder.setSelectionRange(m4401getMinimpl, TextRange.m4400getMaximpl(textFieldValue.m4622getSelectiond9O1mEE()));
        setInsertionMarker(builder, m4401getMinimpl, textLayoutResult);
        TextRange m4621getCompositionMzsxiRA = textFieldValue.m4621getCompositionMzsxiRA();
        int m4401getMinimpl2 = m4621getCompositionMzsxiRA != null ? TextRange.m4401getMinimpl(m4621getCompositionMzsxiRA.m4407unboximpl()) : -1;
        TextRange m4621getCompositionMzsxiRA2 = textFieldValue.m4621getCompositionMzsxiRA();
        int m4400getMaximpl = m4621getCompositionMzsxiRA2 != null ? TextRange.m4400getMaximpl(m4621getCompositionMzsxiRA2.m4407unboximpl()) : -1;
        if (m4401getMinimpl2 >= 0 && m4401getMinimpl2 < m4400getMaximpl) {
            builder.setComposingText(m4401getMinimpl2, textFieldValue.getText().subSequence(m4401getMinimpl2, m4400getMaximpl));
        }
        CursorAnchorInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return build;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl ? 4 : 0);
        return builder;
    }
}