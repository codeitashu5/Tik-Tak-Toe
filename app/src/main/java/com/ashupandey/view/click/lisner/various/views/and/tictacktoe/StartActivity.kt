package com.ashupandey.view.click.lisner.various.views.and.tictacktoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start.*

const val  KEY1 = "player1"
const val KEY2  = "player2"

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)



        button.setOnClickListener {

            val player1 = editText1.text.toString()
            val player2 = editText2.text.toString()

            if(player1.isEmpty() || player2.isEmpty())
                Toast.makeText(this,"Plese Enter Player Name",Toast.LENGTH_LONG).show()

            else{
                val i = Intent(this,MainActivity::class.java)
                i.putExtra(KEY1,player1)
                i.putExtra(KEY2,player2)
                startActivity(i)
            }
        }
    }


}