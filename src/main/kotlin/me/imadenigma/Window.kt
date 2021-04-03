package me.imadenigma

import org.omg.CORBA.FREE_MEM
import org.w3c.dom.css.Rect
import java.awt.*
import java.io.File
import javax.swing.BorderFactory
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel

class Window {

    init {


        val frame = JFrame("Math-Exo")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.size = Dimension(600,600)
        frame.isResizable = false
        //Setting up the icon
        val icon = ImageIcon(File("/home/imad/IdeaProjects/Math-exo/src/main/resources/","logo.png").absolutePath)
        frame.iconImage = icon.image
        frame.background = Color.WHITE

        frame.add(Panel())
        frame.isVisible = true

    }

}