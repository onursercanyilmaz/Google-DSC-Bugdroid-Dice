package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

var player1: Int = 0
var player2: Int = 0
var clickNum: Int = 0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll : Button = findViewById(R.id.button)

        btnRoll.setOnClickListener{
            rollDice()
        }
    }

    /*
    How to Play
    * 2021 Most Populer Programming Languages
    * 1 - Python -> 6 point
    * 2 - Java  -> 5 point
    * 5 - JavaScript -> 4 point
    * 6 - C# -> 3 point
    * 8 - Go -> 2 point
    * 20 - Kotlin -> 1 point
    * */

    //If clickNum is odd it is player1 if clickNum is even it is player2



    fun rollDice(){
        clickNum+=1
        val dice = Dice(6)
        val rolledDice = dice.roll()

        val image : ImageView = findViewById(R.id.imageView)
        val pointPlayer1 : TextView = findViewById(R.id.pointPlayer1)
        val pointPlayer2 : TextView = findViewById(R.id.pointPlayer2)


        val turnedDice = when(rolledDice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val turnedPoint = when(rolledDice){
            1 -> 6
            2 -> 1
            3 -> 5
            4 -> 3
            5 -> 4
            else -> 2
        }

        if (clickNum % 2 == 0){
            player2+=turnedPoint
            pointPlayer2.setText("Player2: "+ player1.toString())
        }
        else{
            player1+=turnedPoint
            pointPlayer1.setText("Player1: "+ player1.toString())

        }

        image.setImageResource(turnedDice)
        image.contentDescription = turnedDice.toString()


    }

}

class Dice(val numSide: Int)
{
    fun roll():Int{
        return (1..numSide).random()
    }
}