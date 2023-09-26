package br.edu.ifpb.jogodamemoria

import android.os.CountDownTimer

class Jogo {
    var distros: MutableList<Int>

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

    fun timer() {
        var countDownTimer = object: CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {
                TODO("Not yet implemented")
            }
            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }
    }

}