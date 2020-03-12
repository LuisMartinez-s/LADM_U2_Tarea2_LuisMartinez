package mx.edu.ittepic.ladm_u2_tarea


import android.graphics.drawable.ColorDrawable

import kotlinx.android.synthetic.main.activity_main.*

class Hilo(p: MainActivity) : Thread() {
    private var iniciado = false
    private var puntero = p
    private var pausa = false
    var indice=0
    override fun run() {
        super.run()
        iniciado = true
        while (iniciado){
            sleep(800)
        if (!pausa) {
            puntero.runOnUiThread {
                puntero.textView2.setText("Color: "+indice)
                puntero.layout.setBackgroundColor(puntero.colores[indice])
                puntero.actionBar?.setBackgroundDrawable(ColorDrawable(puntero.colores[indice]))
                indice++
                if (indice == 10) {
                    indice = 0
                }
            }
            }
        }
    }


    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }

}