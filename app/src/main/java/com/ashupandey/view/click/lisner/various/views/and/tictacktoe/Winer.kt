package com.ashupandey.view.click.lisner.various.views.and.tictacktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_winer.*

class Winer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winer)

       val p1 = intent.getStringExtra(KEY1)
       val p2 =  intent.getStringExtra(KEY2)

        win1.text = p1+"  score "+ winp1
        win2.text = p2+"  score "+ winp2


        val s = intent.getStringExtra(KEY)
        if(s?.length==1){
            if(s[0]=='x')
                textView2.setText("Winer is "+p1)
            else
                textView2.setText("Winer is "+p2)
        }
        else{
           textView2.setText("Match Draw")
        }
    }
}