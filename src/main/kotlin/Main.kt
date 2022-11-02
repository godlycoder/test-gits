fun main(args: Array<String>) {
    task1()
    task2()
    task3()
}

fun task1() {
    var result : List<Int>? = null
    val list = listOf(1,0,0,1,0,1,1)
    var index = list.size - 1

    while(result == null && index >= 0) {
        val windowed = list.windowed(index)
        var windowedIndex = windowed.size - 1

        while (result == null && windowedIndex >= 0) {
            val itemWindowed = windowed[windowedIndex]
            val isResult = itemWindowed.all { it == 1 }

            if (isResult) result = itemWindowed

            windowedIndex -= 1
        }

        index -= 1
    }

    println("Soal ke-1")
    println("Output : ${result?.size}\n\n")
}

fun task2() {
    val input = mutableListOf('h', 'e', 'l', 'l', 'o')
    val output = reverse(input)

    println("Soal ke-2")
    println("Output : $output \n\n")

}

fun reverse(list: MutableList<Char>) : MutableList<Char> {
    if (list.isEmpty()) {
        return list
    }

    val lastIndex = list.size
    val result = reverse(list.subList(1, lastIndex))
    result.add(list[0])

    return result
}



fun task3() {
    val input = listOf('{', '[', '(', ')', ']', '}')
    val stack = ArrayDeque<Char>()

    val map = mapOf(
        '(' to ')', ')' to '(',
        '[' to ']', ']' to '[',
        '{' to '}', '}' to '{'
    )

    for (item in input) {
        if (map[item] == null)
            continue

        if (stack.isNotEmpty() && map[item] == stack.last()) {
            stack.removeLast()
        } else {
            stack.addLast(item)
        }
    }

    val output = if (stack.isEmpty()) "Yes" else "No"

    println("Soal ke-3")
    println("Output : $output")
}