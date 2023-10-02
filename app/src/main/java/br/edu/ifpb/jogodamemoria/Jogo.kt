package br.edu.ifpb.jogodamemoria

import android.os.CountDownTimer

class Jogo {
    var distros: MutableList<Int>

    private var pontuacao: Int = 8

    init {
        this.distros = mutableListOf(
            R.drawable.arch_logo,
            R.drawable.arch_logo,
            R.drawable.debian_logo,
            R.drawable.debian_logo,
            R.drawable.fedora_logo,
            R.drawable.fedora_logo,
            R.drawable.gentoo_logo,
            R.drawable.gentoo_logo,
            R.drawable.kurumin_logo,
            R.drawable.kurumin_logo,
            R.drawable.pop_os_logo,
            R.drawable.pop_os_logo,
            R.drawable.zorin_os_logo,
            R.drawable.zorin_os_logo,
            R.drawable.mint_logo,
            R.drawable.mint_logo,
        )

        this.distros.shuffle()
    }

    fun getPontuacao(): Int {
        return this.pontuacao
    }

    fun decrementarPontuacao() {
        this.pontuacao -= 1
    }

    fun resetarPontuacao() {
        pontuacao = 8
    }
}