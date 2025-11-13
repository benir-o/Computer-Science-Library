
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            # Visualize: highlight arr[j] and arr[j+1]
            print(f"Comparing: {arr[j]} and {arr[j+1]} | Array: {arr}")
            if arr[j] > arr[j + 1]:
                # Visualize: swap arr[j] and arr[j+1]
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                print(f"Swapped: {arr[j]} and {arr[j+1]} | Array: {arr}")
    return arr


sample = [64, 34, 25, 12, 22, 11, 90]
print("Original array:", sample)
sorted_arr = bubble_sort(sample)
print("Sorted array:", sorted_arr)