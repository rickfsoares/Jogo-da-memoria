package br.edu.ifpb.jogodamemoria

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Chronometer
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var jogo: Jogo
    private lateinit var listImage: MutableList<MutableList<ImageView>>

    private var distro1: ImageView? = null
    private var distro2: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Jogo()

        this.listImage = mutableListOf()

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
                imagem.setImageResource(R.drawable.tux)
                imagem.tag = imagemDaDistro
                linha.add(imagem)
            }
            this.listImage.add(linha)
        }

    }

    private fun distroSelecionada(distroImage: ImageView?) {
        if (distro1 == null) {
//            Log.i("APP-MEMORIA", "selecionei 1")
            distro1 = distroImage
            distro1?.setImageResource(distroImage?.tag as Int)

        } else if (distro2 == null){
            distro2 = distroImage
            distro1?.setImageResource(distroImage?.tag as Int)
//            Log.i("APP-MEMORIA", "selecionei 2")
            checarJogada()
        }
    }

    private fun checarJogada() {
        if (distro1?.tag == distro2?.tag) {
//            Log.i("APP-MEMORIA", "achou")
            distro1?.setImageResource(R.drawable.baseline_check_24)
            distro2?.setImageResource(R.drawable.baseline_check_24)
            distro1 = null
            distro2 = null
        } else {
            distro1?.setImageResource(R.drawable.tux)
            distro2?.setImageResource(R.drawable.tux)
            distro1 = null
            distro2 = null
        }
    }

}