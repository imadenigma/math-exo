package me.imadenigma

import java.awt.*
import java.io.File
import javax.swing.ImageIcon
import javax.swing.JFrame

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