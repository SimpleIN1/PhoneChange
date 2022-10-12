package com.example.phonechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    private fun get_unique_words(text: String):String{
        val list = text.split(" ");

        val setl = mutableSetOf<String>();

        list.forEach{
            setl.add(it);
        }

        val map = mutableMapOf<String, Int>()

        var count=0;
        for (item in setl){
            count=0;
            for (j in 0..list.size-1){
                if (item== list[j]){
                    count++;
                }
            }
            map.put(item, count);
        }

        var end_text = "";

        for (item in map){
            println( item)
        }

//        val map2 = map.toSortedMap();
//        println(map2.values);


//        val map1 = map.toSortedMap(compareByDescending { map[it] })

        val map1 = map.entries.sortedBy { it.value }.reversed()


        map1.forEach{
            end_text += it.toString() + '\n';
        }
        //map.isEmpty()

//        var mapImmutable = mapOf<Int, Int>(1 to 11, 2 to 22, 3 to 33)
//
//        println(mapImmutable.toSortedMap(
//            compareByDescending {  }
//        ))
        return end_text



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        val editText = findViewById<EditText>(R.id.editText);
        val textView = findViewById<TextView>(R.id.textView)

        editText.doAfterTextChanged {
            textView.text = get_unique_words(editText.text.toString());
        }


    }

}