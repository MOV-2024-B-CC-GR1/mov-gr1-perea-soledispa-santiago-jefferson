package com.example.ccgr12024b_sjps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tetrimono {
    private var x = 4
    private var y = 0
    private val shape = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(0, 1, 0)
    )

    fun moveDown(board: Array<IntArray>): Boolean {
        if (y + shape.size >= board.size) return false
        y++
        return true
    }

    fun moveLeft(board: Array<IntArray>) {
        if (x > 0) x--
    }

    fun moveRight(board: Array<IntArray>) {
        if (x + shape[0].size < board[0].size) x++
    }

    fun rotate(board: Array<IntArray>) {
        // Rotación simplificada
    }

    fun addToBoard(board: Array<IntArray>) {
        for (i in shape.indices) {
            for (j in shape[i].indices) {
                if (shape[i][j] == 1) {
                    board[y + i][x + j] = 1
                }
            }
        }
    }
}