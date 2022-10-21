// Generic function
fun <T: Comparable<T>> insertionSort(list: MutableList<T>) : List<T> {
    val copyList = list.toMutableList()
    for (i in 1 until copyList.size) {
        val item = copyList[i]
        var j = i
        while (j > 0 && item < copyList[j - 1]) {
            copyList[j] = copyList[j - 1]
            j -= 1
        }
        copyList[j] = item
    }
    return copyList
}

// Generic extension function
fun <T: Comparable<T>> MutableList<T>.insertionSort() {
    for (i in 1 until this.size) {
        val item = this[i]
        var j = i
        while (j > 0 && item < this[j - 1]) {
            this[j] = this[j - 1]
            j -= 1
        }
        this[j] = item
    }
}


fun main() {
    val numbers = mutableListOf(1, 2, 5, 4, 9, 7, 3, 3, 5)
    println(numbers)

    val ordered = insertionSort(numbers)
    println(ordered)

    numbers.insertionSort()
    println(ordered == numbers)

    val strings = mutableListOf("ab", "sd", "sdf", "abc")
    println(strings)

    strings.insertionSort()
    println(strings)
}