package com.example.deber01_pereasanyiago

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AgregarArtistaActivity : AppCompatActivity() {

    private lateinit var btnGuardar: Button
    private lateinit var btnVerArtista: Button
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializar vistas
        btnVerArtista = findViewById(R.id.verArtista)

        dbHelper = DatabaseHelper(this)

        // Detectar si estamos en modo edición

        }

        btnGuardar.setOnClickListener {

                } else {
                }
            } else {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

        val db = dbHelper.readableDatabase

        if (cursor.moveToFirst()) {
        }
        cursor.close()
    }


        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
        }

        if (filasActualizadas > 0) {
            finish()
        } else {
        }
    }

        val db = dbHelper.writableDatabase
        val valores = ContentValues().apply {
        }

        if (resultado != -1L) {
            finish()
        } else {
        }
    }
}
