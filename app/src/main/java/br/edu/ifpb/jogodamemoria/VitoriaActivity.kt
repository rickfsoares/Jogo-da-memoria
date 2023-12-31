package br.edu.ifpb.jogodamemoria

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class VitoriaActivity : AppCompatActivity() {

    val duracaoMensagem = Toast.LENGTH_SHORT

    private lateinit var btnReiniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vitoria)

        this.btnReiniciar = findViewById(R.id.bReiniciar)
        this.btnReiniciar.setOnClickListener {
            setResult(Activity.RESULT_OK)

            finish()
        }

        Toast.makeText(this, "Você perdeu", duracaoMensagem).show()
    }
}