package mx.edu.ittepic.ladm_u2_tarea

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var colores:Array<Int> = Array(10){ 0 }
    var hilo : Hilo?=null
    var actionBar: ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colores[0]=Color.rgb(255, 255, 255)
        colores[1]=Color.rgb(155, 89, 182)
        colores[2]=Color.rgb(41, 128, 185)
        colores[3]=Color.rgb(245, 183, 177)
        colores[4]=Color.rgb(192, 57, 43)
        colores[5]=Color.rgb(26, 188, 156)
        colores[6]=Color.rgb(241, 196, 15)
        colores[7]=Color.rgb(250, 128, 114)
        colores[8]=Color.rgb(255, 84, 138)
        colores[9]=Color.rgb(21, 67, 96)
        hilo = Hilo(this)
        actionBar= supportActionBar
        setTitle("ESTADO: "+hilo!!.isAlive)


        iniciar.setOnClickListener{
            try {
                if(hilo!!.estaIniciado()){
                    mensaje("Error, hilo ya está iniciado")
                    return@setOnClickListener
                }
                hilo?.start()
                setTitle("Estado: "+hilo!!.isAlive)
            }catch (e: Exception){
                setTitle("Estado: "+hilo!!.isAlive)
                mensaje("Excepción: el Hilo ya fue detenido")
            }
        }//iniciar

        pausar.setOnClickListener{
            hilo?.pausar()
        }
        despausar.setOnClickListener {
            hilo?.despausar()
        }
        reiniciar.setOnClickListener {
            hilo?.indice=0
        }
        detener.setOnClickListener {
            hilo!!.detener()
            setTitle("ESTADO: detenido")
        }

    }
    private fun mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}
