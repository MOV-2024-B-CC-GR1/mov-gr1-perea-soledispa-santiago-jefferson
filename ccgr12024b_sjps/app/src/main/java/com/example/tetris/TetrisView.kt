package com.example.tetris

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.KeyEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.concurrent.thread

class TetrisView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    private var running = false
    private val paint = Paint()
    private lateinit var gameThread: Thread
    private val board = Array(20) { IntArray(10) }
    private var currentPiece = Tetrimono()

    init {
        holder.addCallback(this)
        isFocusable = true
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        running = true
        gameThread = thread(start = true) {
            while (running) {
                val canvas: Canvas? = holder.lockCanvas()
                canvas?.let {
                    drawGame(it)
                    holder.unlockCanvasAndPost(it)
                }
                movePieceDown()
                Thread.sleep(500)
            }
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        gameThread.join()
    }

    private fun drawGame(canvas: Canvas) {
        canvas.drawColor(Color.BLACK)
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == 1) {
                    canvas.drawRect(j * 50f, i * 50f, (j + 1) * 50f, (i + 1) * 50f, paint)
                }
            }
        }
    }

    private fun movePieceDown() {
        if (!currentPiece.moveDown(board)) {
            currentPiece.addToBoard(board)
            currentPiece = Tetrimono()
        }
    }

    fun moveLeft() = currentPiece.moveLeft(board)
    fun moveRight() = currentPiece.moveRight(board)
    fun rotate() = currentPiece.rotate(board)
}
