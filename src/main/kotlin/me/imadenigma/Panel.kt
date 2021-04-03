package me.imadenigma

import java.awt.*
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JPanel
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2

@Suppress("SENSELESS_COMPARISON")
class Panel: JPanel(), MouseListener {

    companion object {
        val center = listOf(350,350)
        var rad = 0.0
        var radPi = 0.0
        var degrees = 0.0
    }

    init {
        this.addMouseListener(this)
    }



    override fun paint(g: Graphics) {
        val circle = Circle(150,150,300)
        g.color = Color.lightGray
        g.fillOval(circle.x, circle.y, circle.diameter, circle.diameter)
        g.color = Color.BLACK
        g.drawOval(circle.x, circle.y, circle.diameter, circle.diameter)
        g.drawLine(300,300,450,300)

        g.color = Color.white
        g.fillRect(0,0,600,100)

        g.color = Color.BLUE
        g.font = Font("Serif",16,16)
        g.drawString("Radians(Pi): $radPi",10,25)
        g.drawString("Radians: $rad",10,50)
        g.drawString("Degrees: $degrees",10,75)
    }


    internal data class Circle(val x: Int, val y: Int, val diameter: Int)

    override fun mouseClicked(p0: MouseEvent?) {

    }

    override fun mousePressed(p0: MouseEvent?) {
        if (p0 == null) return
        if (p0.xOnScreen == null) return
        val x = p0.xOnScreen.minus(300)
        val y = p0.yOnScreen.minus(300)
        rad = atan2(abs(y).toDouble(), abs(x).toDouble())
        degrees = Math.toDegrees(rad)
        radPi = rad * PI
        this.repaint(10)
    }

    override fun mouseReleased(p0: MouseEvent?) {

    }

    override fun mouseEntered(p0: MouseEvent?) {
    }

    override fun mouseExited(p0: MouseEvent?) {
        TODO("Not yet implemented")
    }

    fun reload(g: Graphics) {

    }
}
