package com.mdev.mid_term_shoppinglistapp


import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList

/*File name: Mid-Term Shopping List
Author Name: Benny Baby
STUDENT ID : 200469127
App Description : Shopping list app for mid-term exam
Version: Android Studio Dolphin | 2021.3.1 for Windows 64-bit */


class MainActivity : AppCompatActivity() {

    // on below line we are creating a variable.
    lateinit var textBox: ListView
    lateinit var addBtn: Button
    lateinit var removeBtn: Button
    lateinit var saveBtn: Button
    lateinit var itemEdit: EditText
    lateinit var lngList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on below line we are initializing our variables.
        removeBtn = findViewById(R.id.cancel)
        textBox = findViewById(R.id.idListBox)
        addBtn = findViewById(R.id.idBtnAdd)
        saveBtn = findViewById(R.id.save)
        itemEdit = findViewById(R.id.idTextBox)
        lngList = ArrayList()

        // on below line we are adding items to our list
        lngList.add("Non-Fat Milk")
        lngList.add("Carton of Eggs")
        lngList.add("Whole Wheat Bread")
        lngList.add("Canned Tuna")
        lngList.add("Lemons")

        // on below line we are initializing adapter for our list view.
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?>(
            this@MainActivity,
            android.R.layout.simple_list_item_1,
            lngList as List<String?>
        )

        // on below line we are setting adapter for our list view.
        textBox.adapter = adapter

        // on below line we are adding click listener for our button.
        addBtn.setOnClickListener {

            // on below line we are getting text from edit text
            val item = itemEdit.text.toString()
            // on below line we are checking if item is not empty
            if (item.isNotEmpty()) {
                // on below line we are adding item to our list.
                lngList.add(item)
                // on below line we are notifying adapter
                // that data in list is updated to update our list view.
                adapter.notifyDataSetChanged()
            }
        }

        // on below line we are deleting click listener for our button.
        removeBtn.setOnClickListener {

            // on below line we are getting text from edit text
            val item = itemEdit.text.toString()
            // on below line we are checking if item is not empty
            if (item.isNotEmpty()) {
                // on below line we are adding item to our list.
                lngList.remove(item)
                // on below line we are notifying adapter
                // that data in list is updated to update our list view.
                adapter.notifyDataSetChanged()
            }
        }

        //Print to Logcat
        saveBtn.setOnClickListener {
            val item = itemEdit.text.toString()
            Log.i(item, "Item Added to List")
        }

    }
}

/*Reference:
* Add item to list: The Baeldung Logo "Add an Element to a List in Kotlin" https://www.baeldung.com/kotlin/add-element-to-list
* */