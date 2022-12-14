interface Queue<T> {

    fun push(value: T?)

    fun pop(): T?

    fun size(): Int

    fun clear()

    fun peek(): T?
}

class MyQueue<T>(var head: Node<T>? = null) : Queue<T> {

    class Node<T>(val data: T?, var next: Node<T>? = null)

    override fun push(value: T?) {
        val newNode: Node<T> = Node(value)
        var currentNode = head

        if (head == null) {
            head = newNode
        } else {
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = newNode
        }
    }

    override fun pop(): T? {
        if (head != null) {
            val result: T? = head?.data
            head = head?.next
            return result
        } else {
            throw IndexOutOfBoundsException("Impossible call method pop() from empty Queue")
        }
    }

    override fun size(): Int {
        var i = 0
        var currentNode = head
        while (currentNode != null) {
            i++
            currentNode = currentNode.next
        }
        return i
    }

    override fun clear() {
        var currentNode = head
        while (currentNode != null) {
            this.pop()
            currentNode = currentNode.next
        }
    }

    override fun peek(): T? {
        return head?.data
    }

    fun peek1(): T? {
        if (head != null) {
            val result: T? = this.pop()
            if (result != null) {
                this.push(result)
                for (i in 1 until this.size()) {
                    this.push(this.pop())
                }
                return result
            }
        }
        return null
    }
}


fun main() {
    val queue : MyQueue<Int> = MyQueue()

    queue.push(4)
    queue.push(3) // [4, 3]
    println(queue.size() == 2)
    queue.clear()
    println(queue.peek() == null)
    println(queue.size() == 0)

    queue.push(5)
    queue.push(6)
    println(queue.pop() == 5)
    println(queue.size() == 1)
    // [6]
    queue.push(3)
    queue.push(1)
    // [6, 3, 1]
    println(queue.peek1()) // 6
    for (i in 0 until queue.size()) {
        print(queue.pop())
        print(", ")
    }

}