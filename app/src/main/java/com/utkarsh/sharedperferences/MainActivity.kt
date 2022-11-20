package com.utkarsh.sharedperferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameText:EditText
    private lateinit var ageText:EditText
    private lateinit var sP:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText=findViewById(R.id.name_Tv)
        ageText=findViewById(R.id.number_Tv)
        sP=getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sP.edit()

    }

/*
* Saving our data to shared preference
* */
    override fun onPause() {
        super.onPause()
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()

        editor.apply {
            putString("sf_name",name)
            putInt("sf_age",age)
            commit()
        }
    }
/*
* Retrieving data to our text fields
* */
    override fun onResume() {
        super.onResume()
        val name = sP.getString("sf_name",null)
        val age = sP.getInt("sf_age",0)

        nameText.setText(name)
        if(age!=0){
            ageText.setText(age.toString())
        }

    }

}