package sorting

fun main(args : Array<String>) {
    val array = intArrayOf(10,4,2,3,9,6)

    maxHeapify(array)

    val size = array.size
    var i = 0;
    while(i < size) {
        swap(array, 0, size - 1 - i)
        i++
        maxHeapifyNode(array, 0, size - i);
    }
    print("\nSorted array : ")
    array.forEach { print("$it ") }
}

fun maxHeapify(array : IntArray) {
    val size = array.size

    var i : Int = (size - 1)/2
    while(i >= 0) {
        maxHeapifyNode(array, i, size)
        i--
    }
}

fun maxHeapifyNode(a: IntArray, index: Int, size : Int) {
    val left = 2*index + 1
    val right = left+1

    if(right < size) {
        if(a[left] > a[index] && a[left] > a[right]) {
            swap(a, index, left)
            maxHeapifyNode(a, left, size)
        } else if(a[right] > a[index] && a[right] > a[left]) {
            swap(a, index, right)
            maxHeapifyNode(a, right, size)
        }
    } else if(left < size) {
        if(a[left] > a[index]) {
            swap(a, index, left)
            //No need to call maxHeapifyNode(a, left) because left is a leaf
        }
    }
}

fun swap(array: IntArray, i : Int, j : Int) {
    val temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
