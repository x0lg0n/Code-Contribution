def find_position(arr, pos):
    index = -1
    max_value = -1
    n = len(arr)
    
    for i in range(n):
        if max_value < arr[i]:
            index = i
            max_value = arr[i]
    
    if index == pos:
        return 0
    
    arr[index] = -1
    
    for i in range(index):
        if arr[i] > 0:
            arr[i] += 1
    
    return 1 + find_position(arr, pos)

def main():
    n = int(input())
    arr = list(map(int, input().split()))
    k = int(input()) - 1
    
    print(1 + find_position(arr, k))

if __name__ == "__main__":
    main()
