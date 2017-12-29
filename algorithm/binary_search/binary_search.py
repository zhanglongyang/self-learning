def binary_search(l, item):
    low = 0
    high = len(l) - 1

    while low <= high:
        mid = (low + high) // 2

        guess = l[mid]

        if guess == item:
            return mid

        if guess > item:
            high = mid - 1
        else:
            low = mid + 1

    return None


print(binary_search([1, 3, 5, 7, 9], 3))
print(binary_search([1, 3, 5, 7, 9], 5))
print(binary_search([1, 3, 5, 7, 9], 6))
