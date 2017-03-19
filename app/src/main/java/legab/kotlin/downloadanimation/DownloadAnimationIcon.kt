package legab.kotlin.downloadanimation

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class DownloadAnimationIcon: View {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DownloadAnimationIcon, 0, 0)
        try {
            progress = a.getFloat(R.styleable.DownloadAnimationIcon_progress, 0.0f)
            processColor = a.getColor(R.styleable.DownloadAnimationIcon_processColor, Color.MAGENTA)
            successColor = a.getColor(R.styleable.DownloadAnimationIcon_successColor, Color.GRAY)
            failureColor = a.getColor(R.styleable.DownloadAnimationIcon_failureColor, Color.RED)
        } finally {
            a.recycle()
        }
    }

    var progress: Float = 0.0f
    var processColor: Int = Color.MAGENTA
    var successColor: Int = Color.GREEN
    var failureColor: Int = Color.RED

    val progressPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val progressBGPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)



    interface ProcessChangedListener {
        fun onProgressChanged(f: (Float) -> Unit)
    }

    interface CompleteListener {
        fun onComplete(f: () -> Unit)
    }

    interface FailureListener {
        fun onFailure(f: (Throwable) -> Unit)
    }
}
