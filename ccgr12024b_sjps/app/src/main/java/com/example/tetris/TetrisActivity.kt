package com.example.tetris

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TetrisActivity : AppCompatActivity() {
    private lateinit var gameView: TetrisView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tetris)

        gameView = findViewById(R.id.tetrisView)

        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRotate = findViewById<Button>(R.id.btnRotate)
        val btnRight = findViewById<Button>(R.id.btnRight)

        btnLeft.setOnClickListener { gameView.moveLeft() }
        btnRotate.setOnClickListener { gameView.rotate() }
        btnRight.setOnClickListener { gameView.moveRight() }
    }
}
