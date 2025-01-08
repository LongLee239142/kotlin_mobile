package com.example.myapplication
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class FireworksView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val particles = mutableListOf<Particle>()

    init {
        startFireworks()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (particle in particles) {
            paint.color = particle.color
            canvas.drawCircle(particle.x, particle.y, particle.size, paint)
        }
    }

    private fun startFireworks() {
        // Tạo pháo hoa định kỳ
        postDelayed({
            createFireworks(width / 2f, height / 2f) // Vị trí giữa màn hình
            startFireworks()
        }, 1000)
    }

    private fun createFireworks(x: Float, y: Float) {
        val numParticles = 100 // Tăng số lượng hạt
        var duration = 2000L // Kéo dài thời gian pháo hoa

        particles.clear()
        for (i in 0 until numParticles) {
            val angle = Math.toRadians((360.0 / numParticles) * i)
            val speed = (100..300).random().toFloat() // Tăng vận tốc
            val vx = cos(angle) * speed
            val vy = sin(angle) * speed
            val color = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())

            val particle = Particle(x, y, vx, vy, color)
            particles.add(particle)

            ValueAnimator.ofFloat(1f, 0f).apply {
                duration = duration
                addUpdateListener { animator ->
                    val fraction = animator.animatedValue as Float
                    particle.x = (x + vx * (1 - fraction)).toFloat()
                    particle.y = (y + vy * (1 - fraction)).toFloat()
                    particle.size = 20f * fraction // Duy trì kích thước lớn hơn
                    invalidate()
                }
                start()
            }
        }
    }


    data class Particle(
        var x: Float,
        var y: Float,
        val vx: Double,
        val vy: Double,
        val color: Int,
        var size: Float = 20f
    )

}
