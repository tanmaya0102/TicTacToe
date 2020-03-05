package com.tanmaya.mytictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9

        }
        playGame(cellId, buSelected)
    }

    var activeplayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(cellId: Int, buSelected: Button) {
        if (activeplayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.Blue)
            player1.add(cellId)
            activeplayer = 2

        } else {
            buSelected.text = "0"
            buSelected.setBackgroundResource(R.color.DarkGreen)
            player2.add(cellId)
            activeplayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        //diagonal1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        //diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }


        if (winner == 1) {
            player1WinsCounts += 1
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            restartGame()

        } else if (winner == 2) {

            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }


    }


    var player1WinsCounts = 0
    var player2WinsCounts = 0


    fun restartGame() {

        activeplayer = 1
        player1.clear()
        player2.clear()

        for (cellId in 1..9) {

            var buSelected: Button? = when (cellId) {
                1 -> bu1
                2 -> bu2
                3 -> bu3
                4 -> bu4
                5 -> bu5
                6 -> bu6
                7 -> bu7
                8 -> bu8
                9 -> bu9
                else -> {
                    bu1
                }

            }
            buSelected!!.text = ""
            buSelected.setBackgroundResource(R.color.White)
            buSelected.isEnabled = true
        }

        Toast.makeText(
            this,
            "Player1: $player1WinsCounts, Player2: $player2WinsCounts",
            Toast.LENGTH_LONG
        ).show()


    }

    fun reset(view: View) {
        val button=view as Button
        button.setOnClickListener{
            restartGame()
        }
    }


}



    /*fun reset()
    {
        bu1.setBackgroundResource(R.color.White)
        bu1.text=""
        bu2.setBackgroundResource(R.color.White)
        bu2.text=""
        bu3.setBackgroundResource(R.color.White)
        bu3.text=""
        bu4.setBackgroundResource(R.color.White)
        bu4.text=""
        bu5.setBackgroundResource(R.color.White)
        bu5.text=""
        bu6.setBackgroundResource(R.color.White)
        bu6.text=""
        bu7.setBackgroundResource(R.color.White)
        bu7.text=""
        bu8.setBackgroundResource(R.color.White)
        bu8.text=""
        bu9.setBackgroundResource(R.color.White)
        bu9.text=""

    }*/


