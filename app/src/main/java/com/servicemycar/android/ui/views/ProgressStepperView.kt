package com.servicemycar.android.ui.views

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.annotation.IntRange
import androidx.annotation.Size
import androidx.core.content.res.ResourcesCompat

class ProgressStepperView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val steps = mutableListOf<String>()

    private var paint: Paint
    private var isNeedUp = false
    private var initialYValue =
        80f // this value can be set by view height calculation to set whole drawing in the center of view...
    private var upTextYValue = -45f + initialYValue
    private var downTextYValue = 45f + initialYValue+20f
    private var verticalLineHeight = 25f + initialYValue

    private var textSize = 35f

    private var stepSize = 100f// need to be calculated on the basis of current view width

    @Size(max = 20, min = 0)
    private var progress = 0

    @Size(max = 20, min = 1)
    private var totalSteps = if (steps.isEmpty()) 6 else steps.size

    // ny default show last edge vertical line is disabled.
    private var showLastEdge = false


    @ColorInt
    private var checkedColor: Int = Color.parseColor("#0FB94D")

    @ColorInt
    private var unCheckedColor: Int = Color.LTGRAY


    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        setStepSize()
        //Toast.makeText(context, "width is ${stepSize}", Toast.LENGTH_LONG).show()
        setWillNotDraw(false)
        paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = unCheckedColor
        paint.strokeWidth = 8f
        paint.strokeCap = Paint.Cap.ROUND
        paint.textSize = textSize

        paint.textAlign = Paint.Align.CENTER


    }

    private fun setStepSize() {
        val totalWidth = Resources.getSystem().displayMetrics.widthPixels - 250
        stepSize =  (totalWidth / totalSteps).toFloat()
        //exceptional case if too much steps are created
        if (totalSteps>6){
            stepSize -= 10
        }

    }

    override fun onDraw(canvas: Canvas) {
        isNeedUp = false
        super.onDraw(canvas)
        var currentStepStart = totalSteps.toFloat()//5f
        for (i in 1 until totalSteps) {
            drawHorizontalLineComponent(canvas, currentStepStart, currentStepStart + stepSize)
            if (i < progress) {
                drawHorizontalLineProgress(canvas, currentStepStart, currentStepStart + stepSize)
            }
            if (i == progress && progress < totalSteps - 1) {
                drawHorizontalHalfLineProgress(
                    canvas,
                    currentStepStart,
                    currentStepStart + stepSize
                )
            }
            val text = if (steps.isEmpty() || steps.size < i) i.toString() else steps[i - 1]
            drawVerticalLineWithText(canvas, text, currentStepStart, i)
            currentStepStart += stepSize
        }
        if (showLastEdge) {
            drawVerticalLineWithText(
                canvas,
                steps[totalSteps - 1].ifEmpty { totalSteps.toString() },
                currentStepStart,
                totalSteps
            )
        }


    }


    private fun drawVerticalLineWithText(
        canvas: Canvas?,
        text: String,
        startX: Float,
        stepIndex: Int
    ) {
        if (stepIndex <= progress) {
            paint.color = checkedColor
        } else {
            paint.color = unCheckedColor
        }
        val textY = if (isNeedUp) upTextYValue else downTextYValue
        val verticalHeight =
            if (isNeedUp) (verticalLineHeight - ((initialYValue) * 2)) * -1 else verticalLineHeight
        canvas?.drawLine(startX, initialYValue, startX, verticalHeight, paint)//v
        paint.color = unCheckedColor
        canvas?.drawText(text, startX, textY, paint)
        isNeedUp = !isNeedUp
    }

    private fun drawHorizontalLineComponent(
        canvas: Canvas?,
        startX: Float,
        stopX: Float
    ) {
        ////  if (stepIndex <= progress - 1) {
        //    paint.color = checkedColor
        //  } else {
        paint.color = unCheckedColor
        //  }
        canvas?.drawLine(startX, initialYValue, stopX, initialYValue, paint)//h
    }

    private fun drawHorizontalLineProgress(
        canvas: Canvas?,
        startX: Float,
        stopX: Float
    ) {
        paint.color = checkedColor
        canvas?.drawLine(startX, initialYValue, stopX, initialYValue, paint)//h
    }

    private fun drawHorizontalHalfLineProgress(
        canvas: Canvas?,
        startX: Float,
        stopX: Float
    ) {
        paint.color = checkedColor
        canvas?.drawLine(startX, initialYValue, stopX - stepSize / 2, initialYValue, paint)//h
    }

    private fun setMaxSteps(@IntRange(from = 1, to = 20) stepCount: Int) {
        totalSteps = stepCount
    }

    fun setSteps(steps: MutableList<String>) {
        this.steps.clear()
        this.steps.addAll(steps)
        setMaxSteps(steps.size)
        setStepSize()
        invalidate()
    }

    fun setMaxStepsCount(count:Int){
        setMaxSteps(count)
        setStepSize()
        invalidate()
    }

    fun setProgress(@IntRange(from = 0, to = 20) progress: Int) {
        this.progress = progress
        invalidate()
    }

    fun setCheckedColor(@ColorInt color: Int) {
        checkedColor = color
        invalidate()
    }

    fun setUnCheckedColor(@ColorInt color: Int) {
        unCheckedColor = color
        invalidate()
    }

    fun setTextSize(@DimenRes size: Int) {
        textSize = resources.getDimension(size)
        paint.textSize = resources.getDimension(size)
        invalidate()
    }

    fun setTextFontFamily(@FontRes font: Int) {
        paint.typeface = ResourcesCompat.getFont(context, font)
    }

    fun showLastEdge(show: Boolean = false) {
        showLastEdge = show
        invalidate()
    }
}