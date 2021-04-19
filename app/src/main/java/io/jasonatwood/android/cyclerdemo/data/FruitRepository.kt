package io.jasonatwood.android.cyclerdemo.data

fun getFruits(): List<Fruit> {
  return listOf(
    Apple(id = "1"),
    Apple(id = "2"),
    Banana(id = "3"),
    Pear(id = "4"),
    Banana(id = "5")
  )
}