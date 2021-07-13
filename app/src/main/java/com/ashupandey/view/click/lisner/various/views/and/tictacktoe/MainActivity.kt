package com.ashupandey.view.click.lisner.various.views.and.tictacktoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.accessibility.AccessibilityEventSource
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

const val KEY = "winer"
var winp1 = 0
var winp2 = 0
var total = 0

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btn: Array<Array<Button>>
    var ch = '1'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btn00.setOnClickListener(this)

        var matrix = Array<IntArray>(3) { IntArray(3) }
        for (i in 0..2)
            for (j in 0..2)
                matrix[i][j] = -1


        btn = arrayOf(
            arrayOf(btn00, btn01, btn02),
            arrayOf(btn10, btn11, btn12),
            arrayOf(btn20, btn21, btn22)
        )

        //the initial conditions
        var isChancex = true
        var chance = 0
        val player1 = intent.getStringExtra(KEY1)
        val player2 = intent.getStringExtra(KEY2)
        textView.text = player1


        val i = Intent(this, Winer::class.java)

        fun chechkWinerForInt(matrix: Array<IntArray>, i: Int, j: Int, x: Int): Boolean {
            //check for the first diagonal
            if (j == i) {
                if (matrix[0][0] == x && matrix[1][1] == x && matrix[2][2] == x)
                {
                    return true
                }

            }
            //check for the second diagonal
            if (matrix[2][0] == x && matrix[0][2] == x && matrix[1][1] == x)
                return true



            //check for the row
            if (matrix[i][0] == x && matrix[i][1] == x && matrix[i][2] == x){
                return true
            }


            //check for column
            if (matrix[0][j] == x && matrix[1][j] == x && matrix[2][j] == x){
                return true
            }


            return false
        }

        fun isWiner(ch: Char, matrix: Array<IntArray>, i: Int, j: Int): Boolean {
            if (ch == 'x')
                return chechkWinerForInt(matrix, i, j, 1)
            else
                return chechkWinerForInt(matrix, i, j, 0)

        }


        fun startIntent(ch: String) {
            i.apply {
                putExtra(KEY1, player1)
                putExtra(KEY2, player2)
                putExtra(KEY, ch)
            }

            startActivity(i)
        }


        fun disableBtns(){
            for (i in 0..2)
                for (j in 0..2) {
                    btn[i][j].isEnabled = false
                }
        }

        fun commonForEveryClick(i: Int, j: Int) {


            if (isChancex) {
                btn[i][j].setText("X")
                textView.text = player2
                isChancex = false
                ch = 'x'
                matrix[i][j] = 1
            } else {
                btn[i][j].setText("0")
                textView.text = player1
                isChancex = true
                ch = 'y'
                matrix[i][j] = 0
            }

            btn[i][j].isEnabled = false
            chance++

            if (chance > 4 && chance < 9) {
                if (isWiner(ch, matrix, i, j)) {
                    if(ch=='x')
                        winp1++
                    else
                        winp2++
                    disableBtns()
                    total++
                    startIntent(ch.toString())

                }
            } else if (chance == 9) {
                if (isWiner(ch, matrix, i, j)) {
                    if(ch=='x')
                        winp1++
                    else
                        winp2++
                    total++
                    startIntent(ch.toString())
                } else {
                    total++
                    startIntent("Match Draw")
                }
            }

        }


        btn00.setOnClickListener {
            val i = 0
            val j = 0

            commonForEveryClick(i, j)

        }
        btn01.setOnClickListener {
            val i = 0
            val j = 1
            commonForEveryClick(i, j)
        }
        btn02.setOnClickListener {
            val i = 0
            val j = 2
            commonForEveryClick(i, j)
        }

        btn10.setOnClickListener {
            val i = 1
            val j = 0
            commonForEveryClick(i, j)
        }
        btn11.setOnClickListener {
            val i = 1
            val j = 1
            commonForEveryClick(i, j)

        }
        btn12.setOnClickListener {
            val i = 1
            val j = 2
            commonForEveryClick(i, j)
        }

        btn20.setOnClickListener {
            val i = 2
            val j = 0
            commonForEveryClick(i, j)
        }
        btn21.setOnClickListener {
            val i = 2
            val j = 1
            commonForEveryClick(i, j)
        }
        btn22.setOnClickListener {
            val i = 2
            val j = 2
            commonForEveryClick(i, j)
        }

        reset.setOnClickListener {
            for (i in 0..2)
                for (j in 0..2) {
                    btn[i][j].isEnabled = true
                    btn[i][j].text = ""
                }

            for(i in 0..2)
                for(j in 0..2)
                    matrix[i][j] = -1

            if(total%2==0){
                chance = 0
                textView.text = player1
                isChancex = true
            }
            else{
                chance = 0
                textView.text = player2
                isChancex = false
            }


            
        }


    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}

