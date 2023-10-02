package br.edu.ifpb.jogodamemoria

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Chronometer
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var jogo: Jogo
    private lateinit var listImage: MutableList<MutableList<ImageView>>

    private var distro1: ImageView? = null
    private var distro2: ImageView? = null

    private lateinit var numeroTentativas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Jogo()

        this.listImage = mutableListOf()

        this.numeroTentativas = findViewById(R.id.tvNumeroTentativas)

        montarMatriz()

        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                //
            }

            override fun onFinish() {
                cobrirCartas()
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        this.numeroTentativas.text = "5"
        this.jogo.resetarPontuacao()
        this.jogo.embaralhar()

        montarMatriz()

        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                //
            }

            override fun onFinish() {
                cobrirCartas()
            }
        }.start()
    }

    fun montarMatriz() {
        val it = this.jogo.distros.iterator()
        for (i in 0 .. 3) {
            val linha = mutableListOf<ImageView>()
            for (j in 0 .. 3) {
                val id = resources.getIdentifier("image${i}${j}", "id", packageName)
                val imagem = findViewById<ImageView>(id)

                imagem.setOnClickListener {
                    distroSelecionada(imagem)
                }

                var imagemDaDistro = it.next()
                imagem.setImageResource(imagemDaDistro)
                imagem.tag = imagemDaDistro
                linha.add(imagem)
            }
            this.listImage.add(linha)
        }
    }

    fun cobrirCartas() {
        for (i in 0 .. 3) {
            for (j in 0 .. 3) {
                val id = resources.getIdentifier("image${i}${j}", "id", packageName)
                val imagem = findViewById<ImageView>(id)
                imagem.setImageResource(R.drawable.tux)
            }
        }
    }

    private fun distroSelecionada(distroImage: ImageView?) {

        if (distroImage?.isClickable == false) {
            return
        }

        if (distro1 == null) {
//            Log.i("APP-MEMORIA", "selecionei 1")
            distro1 = distroImage
            distro1?.setImageResource(distroImage?.tag as Int)
            distro1?.isClickable = false

        } else if (distro2 == null){
            distro2 = distroImage
            distro2?.setImageResource(distroImage?.tag as Int)
            distro2?.isClickable = false
//            Log.i("APP-MEMORIA", "selecionei 2")
            checarJogada()
        }
    }

    private fun checarJogada() {
        if (distro1?.tag == distro2?.tag) {
//            Log.i("APP-MEMORIA", "achou")
            distro1?.isClickable = false
            distro2?.isClickable = false

            distro1 = null
            distro2 = null

            venceu()
        } else {
            var countDownTimer = object : CountDownTimer(3000, 1000) {
                override fun onTick(p0: Long) {
                    //
                }

                override fun onFinish() {
                    distro1?.setImageResource(R.drawable.tux)
                    distro2?.setImageResource(R.drawable.tux)

                    distro1?.isClickable = true
                    distro2?.isClickable = true

                    distro1 = null
                    distro2 = null

                    decrementarTentativa()
                }
            }.start()
        }
    }

    private fun decrementarTentativa() {
        val valorAtual = numeroTentativas.text.toString().toIntOrNull()

        if (valorAtual != null) {
            val novoValor = valorAtual - 1
            perdeu(novoValor)
            numeroTentativas.text = novoValor.toString()
        }
    }

    private fun venceu() {
        this.jogo.decrementarPontuacao()
        if (this.jogo.getPontuacao() == 0) {
            val intent = Intent(this, VitoriaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun perdeu(numeroTentivas: Int) {
        if (numeroTentivas == 0) {
            val intent = Intent(this, PerdeuActivity::class.java)
            startActivity(intent)
        }
    }

}