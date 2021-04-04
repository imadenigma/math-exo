package me.imadenigma

import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.Point
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import java.text.DecimalFormat
import javax.swing.JPanel
import kotlin.math.floor

class Panel : JPanel(), MouseMotionListener {


    init {
        this.addMouseMotionListener(this)
    }

    private var lineX = 450
    private var lineY = 300

    private var rad = 0.0
    private var radPi = 0.0
    private var degrees = 0.0

    override fun paint(g: Graphics) {
        val circle = Circle(150, 150, 300)
        g.color = Color.lightGray
        g.fillOval(circle.x, circle.y, circle.diameter, circle.diameter)
        g.color = Color.BLACK
        g.drawOval(circle.x, circle.y, circle.diameter, circle.diameter)
        g.font = Font("BOLD", 20, 20)
        g.drawString("Y",circle.diameter - 5,circle.y - 3)
        g.drawString("X",circle.x + 310,circle.diameter + 5)

        g.color = Color.white
        g.fillRect(0, 0, 600, 100)

        g.color = Color.cyan
        g.drawLine(150, 300, 450, 300)

        g.color = Color.green
        g.drawLine(300, 150, 300, 450)


        g.color = Color.BLUE
        g.font = Font("Serif", 20, 20)
        val formatter = DecimalFormat("#0.00")
        g.drawString("Radians(Pi): ${formatter.format(radPi)}", 10, 25)
        g.drawString("Radians: ${formatter.format(rad)}", 10, 50)
        g.drawString("Degrees: ${formatter.format(degrees)}", 10, 75)


        if (degrees >= 180) {
            g.drawString("Radians(Pi): -${formatter.format(radPi)}", 400, 25)
            g.drawString("Radians: -${formatter.format(rad)}", 400, 50)
        }


        g.color = Color.BLACK
        g.drawLine(300, 300, lineX, lineY)

    }


    override fun mouseDragged(p0: MouseEvent?) {}

    override fun mouseMoved(p0: MouseEvent?) {
        if (p0 == null) return

        degrees = MathUtil.pointsToDeg(Point(300, 300), p0.point)
        rad = Math.toRadians(degrees)
        radPi = degrees / 180

        val coor = MathUtil.angleToCoor(rad, 149.0)
        this.lineX = Math.negateExact(coor[0].toInt())
        this.lineY = Math.negateExact(coor[1].toInt())
        if (p0.xOnScreen > 0) this.lineX = floor(coor[0]).toInt()
        if (p0.yOnScreen > 0) this.lineY = floor(coor[1]).toInt()


        println(p0.point)
        println(coor.asList())
        this.repaint(10)
    }

    internal data class Circle(val x: Int, val y: Int, val diameter: Int)
}
