package com.example.myimada1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val famousPeople = listOf(
        "Nelson Mandela" to 95,
        "William Shakespeare" to 52,
        "Albert Einstein" to 76,
        "Leanardo da Vinci" to 67,
        "Marie Curie" to 66,
        "Steve Jobs" to 56,
        "Mahatma Gandhi" to 78,
        "Abraham Lincoln" to 56,
        "Marilyn Monroe" to 36,
        "Winston Churchill" to 90
    )
    private lateinit var ageInput: EditText
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.editTextText)
        searchButton = findViewById(R.id.button)
        clearButton = findViewById(R.id.button2)
        resultTextView = findViewById(R.id.editTextText)

        searchButton.setOnClickListener {
            val ageText = ageInput.text.toString()
            if (ageText.matches(Regex("[0-9]+"))) {
                val age = ageText.toInt()
                if (age in 20..100) {52
                    val personName = findPersonByAge(famousPeople, age)
                    if (personName != null) {
                        resultTextView.text =
                            "Passed away $age $personName"
                    } else {
                        resultTextView.text = "No famous person passed away at that age."
                    }
                } else {
                    resultTextView.text =
                        "Error: The age is out of range (20-100)." +" Please enter a valid age."
                }
            } else {
                resultTextView.text =
                    "Error: The age is an invalid format. Please enter a valid age as a whole number."
            }
        }

        clearButton.setOnClickListener {
            resultTextView.text = ""
            ageInput.text.clear()
        }
    }

    private fun findPersonByAge(famousPeople: List<Pair<String, Int>>, age: Int?):List<String> {
        val PersonByAge = mutableListOf<String>()
        for ((figure, figureage) in this.famousPeople) {
            if (figureage == age) {
                PersonByAge.add(figure)
            }
        }
        return PersonByAge
    }
}

