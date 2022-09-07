package com.example.miholamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() { /*Es tipo formulario*/
    lateinit var boton : Button //lateinit significa que vamos a instanciar la variable despues
    lateinit var lbl: TextView
    lateinit var img: ImageView
    lateinit var img2: ImageView

    var valor: Int = 0
    var num1: Int = 0
    var num2: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) { /*El evento se lanza cuando la app se ejecuta*/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        lbl=findViewById(R.id.txtSaludo)
        boton=findViewById(R.id.btnRoller)
        img=findViewById(R.id.imgRoller)


        img2=findViewById(R.id.imgRoller2)

//        boton.setOnClickListener(View.OnClickListener {
//            Toast.makeText(applicationContext,"Boton Precionado", Toast.LENGTH_LONG).show()
//        })

        img.setImageDrawable(resources.getDrawable(R.drawable.dice_3)) //Cargar una imagen al iniciar la aplicacion
        img2.setImageDrawable(resources.getDrawable(R.drawable.dice_1))

        boton.setOnClickListener {


            var dado1= getRandomDiceImage()
            num1=valor
            var dado2= getRandomDiceImage()
            num2=valor

            var resultados="Valores de los dados $num1 y $num2"
            lbl.text=resultados

            img.setImageResource(dado1)
            img2.setImageResource(dado2)

            Toast.makeText(applicationContext,"¡¡Datos Lanzados!!", Toast.LENGTH_LONG).show()

        }

    }

    fun diceRoller(): Int{
        return (1..6).random()
    }

    private fun getRandomDiceImage(): Int{
        val ale = diceRoller() //Guarda un numero random
        valor=ale
        val idImagenAl=when(ale){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        return idImagenAl
    }

}

