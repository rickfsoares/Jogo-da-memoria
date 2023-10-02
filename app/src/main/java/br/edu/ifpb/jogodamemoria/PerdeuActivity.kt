package br.edu.ifpb.jogodamemoria

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PerdeuActivity : AppCompatActivity() {

    private val duracaoMensagem = Toast.LENGTH_SHORT
    private lateinit var btnReiniciar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)


        this.btnReiniciar = findViewById(R.id.bReiniciar)
        this.btnReiniciar.setOnClickListener {
            setResult(Activity.RESULT_OK)

            finish()
        }

        Toast.makeText(this, "Você venceu", duracaoMensagem).show()
    }
}