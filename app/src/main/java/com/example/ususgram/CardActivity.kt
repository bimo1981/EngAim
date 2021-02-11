package com.example.ususgram

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.ususgram.Class.Card
import org.w3c.dom.Text

class CardActivity : AppCompatActivity() {

    var counter: Int = 0
    var englishCard: ArrayList<Card> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        englishCard.add(Card("Book", "Книга", R.drawable.openbook))
        englishCard.add(Card("Dog", "Собака", R.drawable.dog1))

        inflateCard()
    }

    private fun inflateCard() {
        var englishTextView = findViewById<TextView>(R.id.englishTextView)
        var russianTextView = findViewById<TextView>(R.id.russianTextView)
        var imgView = findViewById<ImageView>(R.id.cardImageView)

        englishTextView.text = englishCard[counter].english
        russianTextView.text = englishCard[counter].russian
        imgView.setImageResource(englishCard[counter].img)
    }


    fun clickRemember(view: View) {
        var englishTextView = findViewById<TextView>(R.id.englishTextView)
        englishTextView.visibility = TextView.VISIBLE

        var buttonNext = findViewById<Button>(R.id.buttonNext)
        buttonNext.visibility = Button.VISIBLE

        englishCard.removeAt(counter)

    }
    fun clickForget(view: View) {
        var englishTextView = findViewById<TextView>(R.id.englishTextView)
        englishTextView.visibility = TextView.VISIBLE

        var buttonNext = findViewById<Button>(R.id.buttonNext)
        buttonNext.visibility = Button.VISIBLE

    }


    fun clickNext(view: View) {
        var englishTextView = findViewById<TextView>(R.id.englishTextView)
        englishTextView.visibility = TextView.INVISIBLE

        var buttonNext = findViewById<Button>(R.id.buttonNext)
        buttonNext.visibility = Button.INVISIBLE

        if(counter<englishCard.size-1) counter++
        else counter = 0

        if(englishCard.size == 0) System.exit(-1)
        inflateCard()

    }
}