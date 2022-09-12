
<h1 align="center">Kotlin Login & Register Page</h1>


<p align="center">
  <img width="30%" src="https://github.com/FMSSBilisimAndroid/ozturk-sahin-yetisir-odev2/blob/master/screenshots/ss1.png" alt="gif image"/>
  <img width="30%" src="https://github.com/FMSSBilisimAndroid/ozturk-sahin-yetisir-odev2/blob/master/screenshots/ss2.png" alt="gif image"/>
  <img width="30%" src="https://github.com/FMSSBilisimAndroid/ozturk-sahin-yetisir-odev2/blob/master/screenshots/ss3.png" alt="gif image"/>
  
</p>

---

<h2>Eager & Lazy Filters</h2>

<h3>Filters nedir ?</h3>
<p>Filters bir listenin içindeki verileridaha kolay bir şekilde bulunmasını sağlayan filtreleme işlemidir.</p>

<h3>Eager Filter</h3>
Aşağıdaki komut bloğunda Hayvanlardan oluşturulmuş bir liste bulunmakta. Bu listenin içinde ilk harfi D olan hayvanlar eagerList içine kaydedildi ve println komutuyla çıktısı alındı.

```kotlin
val animals = listOf("Donkeys", "Dogs", "Cats", "Monkeys", "Elephants", "Lions")
fun main() {
  val eagerList = animals.filter {it[0] == 'D'}
  println(eagerList)
 }
```
<h3>Lazy Filter:</h3>

Lazy Filter **.toList** komutunu kullanmadan yazıldığında obje çağıracaktır. **println(lazylist)** şeklinde yazılan kodun çıktısı **kotlin.sequences.FilteringSequence@45ff54e6** şeklinde olacaktır.

```kotlin
val animals = listOf("Donkeys", "Dogs", "Cats", "Monkeys", "Elephants", "Lions")
fun main() {
  val lazyList = animals.asSequence().filter {it[0] == 'D'}
  println(lazyList) // println(lazylist.toList()) 
 }
```

<h3>Ek Kısım</h3>
 **lazyMap.first** komutu listenin ilk nesnesini alır.
 **lazyMap.toList()** tüm listenin listeyi alır **asSequence().filter {it[0] == 'D'}** kullanılarak filtrelemeye uyan nesneleri alır.

```kotlin
val animals = listOf("Donkeys", "Dogs", "Cats", "Monkeys", "Elephants", "Lions")
fun main() {
  val lazyList = animals.asSequence().filter {it[0] == 'D'}
  val lazyMap = animals.asSequence().filter {it[0] == 'D'}.map {
      println("access: $it")
      println("")
      it
  }
  println(lazyMap)
  println("")
  println("firts:  ${lazyMap.first()}")
  println("")
  println("entire list: ${lazyMap.toList()}")
  
 }
 ```
 
 <h3>Eager Filters & Lazy Filters arasındaki fark </h3>
 
<p>Eager Filters'da  hayvanlardan oluşturulmuş bir listede önce tümünü filtreler bu filtrelenmeyi yeni bir listede depolar. Daha sonrasında her sonucu bir harita üzerinden geçirir ve yeni bir ara liste üretir. Bu ara listeden eşlenen ilk öğe alınır.</p>
<p>Lazy Filters'da* hayvanlardan oluşturulmuş bir listede ilk eşleşmeyi alır. Bu öğeyi eşler ve take(1) olarak getirir. Daha fazla işlem yapılmaz ve diğer öğelere bakılmaz.</p>
