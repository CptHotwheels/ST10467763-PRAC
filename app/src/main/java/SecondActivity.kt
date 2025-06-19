package com.example.st10467763practicum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity (){
  private lateinit var songBtn: Button
  private lateinit var calculateBtn: Button
  private lateinit var backBtn: Button
  private lateinit var resultTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        songBtn = findViewById(R.id.songBtn)
        calculateBtn = findViewById(R.id.calculateBtn)
        backBtn = findViewById(R.id.backBtn)
        resultTextView = findViewById(R.id.resultTextView)

        songBtn.setOnClickListener {
            if (SongListData.song.isEmpty()) {
                resultTextView.text = "No songs currently saved"
                return@setOnClickListener
            }
            val builder = StringBuilder()
            for (i in SongListData.song.indices) {
                builder.append("Artist: ${SongListData.artist[i]}\n")
                builder.append("Song: ${SongListData.song[i]}\n")
                builder.append("Rating: ${SongListData.rating[i]}\n")
                builder.append("Comment: ${SongListData.comment[i]}\n\n")
            }
            resultTextView.text = builder.toString()
        }
        calculateBtn.setOnClickListener {
            Toast.makeText(this, "0 ratings available at this time", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        backBtn.setOnClickListener {
            finish()
        }
    }
}