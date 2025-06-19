package com.example.st10467763practicum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

object SongListData {
    val artist = ArrayList<String>()
    val song = ArrayList<String>()
    val rating = ArrayList<Int>()
    val comment = ArrayList<String>()
}

class MainActivity : AppCompatActivity() {
    private lateinit var artistEditText: EditText
    private lateinit var songEditText: EditText
    private lateinit var ratingEditText: EditText
    private lateinit var commentEditText: EditText
    private lateinit var playlistBtn: Button
    private lateinit var secondBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        artistEditText = findViewById(R.id.artistEditText)
        songEditText = findViewById(R.id.songEditText)
        ratingEditText = findViewById(R.id.ratingEditText)
        commentEditText = findViewById(R.id.commentEditText)
        playlistBtn = findViewById(R.id.playlistBtn)
        secondBtn = findViewById(R.id.secondBtn)
        exitBtn = findViewById(R.id.exitBtn)

        playlistBtn.setOnClickListener {
            val artist = artistEditText.text.toString().trim()
            val song = songEditText.text.toString().trim()
            val ratingStr = ratingEditText.text.toString().trim()
            val comment = commentEditText.text.toString().trim()
            if(artist.isEmpty() || song.isEmpty() || ratingStr.isEmpty() || comment.isEmpty()) {
                Toast.makeText(this, "Please ensure that all fields are complete", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val rating = try {
                ratingStr.toInt()
            } catch (e:NumberFormatException) {
                Toast.makeText(this, "Rating must only be a number between 0 and 5", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (rating !in 0..5) {
                Toast.makeText(this, "RATING MUST BE BETWEEN 0 AND 5", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            SongListData.artist.add(artist)
            SongListData.song.add(song)
            SongListData.rating.add(rating)
            SongListData.comment.add(comment)

            Toast.makeText(this, "Song successfully added", Toast.LENGTH_SHORT).show()

            artistEditText.text.clear()
            songEditText.text.clear()
            ratingEditText.text.clear()
            commentEditText.text.clear()
        }
        secondBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        exitBtn.setOnClickListener {
            finish()
        }

        }
    }
