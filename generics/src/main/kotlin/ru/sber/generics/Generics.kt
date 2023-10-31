package ru.sber.generics

// 1.
fun <E1, E2> compare(p1: Pair<E1, E2>, p2: Pair<E1, E2>): Boolean {
    return p1.first == p2.first && p1.second == p2.second
}

// 2.
fun <E : Comparable<E>> countGreaterThan(anArray: Array<E>, elem: E): Int {

    var count = 0

    for (item in anArray) {
       if( item > elem) {
           count++
       }
    }
    return count
}

// 3.
class Sorter<T : Comparable<T>> {
    private val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)

        list.sort()
    }
}

// 4.
class Stack<T> {
    private val items: MutableList<T> = mutableListOf()

    fun push(item: T) {
        items.add(item)
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return items.removeAt(items.size - 1)
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }
}