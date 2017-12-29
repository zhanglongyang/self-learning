def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0

    for i in range(1, len(arr)):
        if arr[i] < smallest:
            smallest = arr[i]
            smallest_index = i

    return smallest_index

print(findSmallest([1, 2, 3, 4]))


def selectionSort(arr):
    new_arr = []

    for i in range(len(arr)):
        smallest = findSmallest(arr)
        new_arr.append(arr.pop(smallest))

    return new_arr

print(selectionSort([2, 5, 1, 4, 3]))
