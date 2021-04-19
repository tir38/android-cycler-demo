package io.jasonatwood.android.cyclerdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.cycler.Recycler
import com.squareup.cycler.toDataSource
import io.jasonatwood.android.cyclerdemo.data.Apple
import io.jasonatwood.android.cyclerdemo.data.Fruit
import io.jasonatwood.android.cyclerdemo.data.getFruits

class MainActivity : AppCompatActivity() {

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val fruits = getFruits()

    // create a new Recycler if you do NOT already have a layout xml with a RV
    // val recycler = Recycler.create<Fruit>(
    //   context = this,
    //   id = R.id.recycler_view // ID to assign
    // )

    // ... or if already have a RV in a layout file.
    // We have to define a type because .adopt cannot infer one
    // Also, note that .adopt *requires* us to set an in-xml LayoutManager. If we need to set a
    // LayoutManager in-code then we must use .create()
    val recycler: Recycler<Fruit> = Recycler.adopt(findViewById(R.id.recycler_view)) {
      // the *order* of the row assignments matters

      // do something for all "remaining" Apples. You can see that this skipped apple #2!!!
      row<Apple, AppleView> {
        create(R.layout.apple_view) {
          val descriptionTextView = view.findViewById<TextView>(R.id.description)
          bind { subItem: Apple ->
            descriptionTextView.text = "This Apple: ${subItem.id} is very tasty."
          }
        }
      }

      // do something just for Apple #2
      row<Apple, AppleView> {
        forItemsWhere { apple -> apple.id == "2" }
        create(R.layout.apple_view) {
          val idTextView = view.findViewById<TextView>(R.id.apple_id)
          bind { subItem: Apple ->
            idTextView.text = "two"
          }
        }
      }

      // default fallback for all fruit
      row<Fruit, FruitView> {
        create(R.layout.fruit_view) {
          // do nothing, just show empty view
        }
      }
    }

    recycler.update {
      data =
        fruits.toDataSource() // recycler takes in "data" in a very simplified List. Even more simple than kotlin.list
      // this simple list is called DataSource. Recycler library provides extension methods to convert common collections
      // like kotlin.list to datasource
    }
  }
}