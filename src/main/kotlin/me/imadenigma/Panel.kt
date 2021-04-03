package me.imadenigma

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

class Panel: JPanel() {

    companion object {
        val center = listOf(350,350)
    }

    override fun paint(g: Graphics) {
        g.color = Color.BLACK
        g.fillOval(center[0], center[1],150,150)
    }
}