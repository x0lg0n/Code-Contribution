# Implement k Queues in a single array
# Last Updated : 20 Sep, 2025
# Given two integers n and k. Implement k queues using a single array of size n. Multiple queue must share the same array space while supporting the following operations:

# enqueue(qn, x): Adds the element x into the qn-th queue.
# dequeue(qn): Removes the front element from the qn-th queue and return it. If the queue is empty, return -1.
# isEmpty(qn): Checks if the qn-th queue is empty.

class kQueues:
    def __init__(self, n, k):
        self.n = n
        self.k = k
        self.arr = [0] * n
        self.front = [-1] * k
        self.rear = [-1] * k

    # Function to check if queue 'qn' is empty
    def isEmpty(self, qn):
        return self.front[qn] == -1

    # Function to check if queue 'qn' is full
    def isFull(self, qn):
        nextPos = (self.rear[qn] + 1) % (self.n // self.k)
        
        return (nextPos == self.front[qn] % (self.n // self.k) and self.front[qn] != -1)

    # Function to enqueue 'x' into queue 'qn'
    def enqueue(self, x, qn):
        if self.isFull(qn):
            return False

        base = qn * (self.n // self.k)
        if self.isEmpty(qn):
            self.front[qn] = base

        self.rear[qn] = base if self.rear[qn] == -1 \
        else base + (self.rear[qn] + 1 - base) % (self.n // self.k)
        
        self.arr[self.rear[qn]] = x

        return True

    # Function to dequeue from queue 'qn'
    def dequeue(self, qn):
        if self.isEmpty(qn):
            return -1

        base = qn * (self.n // self.k)
        x = self.arr[self.front[qn]]

        if self.front[qn] == self.rear[qn]:
            self.front[qn] = -1
            self.rear[qn] = -1
        else:
            self.front[qn] = base + (self.front[qn] + 1 - base) % (self.n // self.k)

        return x

if __name__ == "__main__":
    n, k = 10, 3
    queues = kQueues(n, k)

    print(queues.enqueue(10, 0), end=" ")
    print(queues.enqueue(20, 1), end=" ")
    print(queues.enqueue(30, 0), end=" ")
    print(queues.enqueue(40, 2), end=" ")

    print(queues.dequeue(0), end=" ")
    print(queues.dequeue(1), end=" ")
    print(queues.dequeue(2), end=" ")
    print(queues.dequeue(0), end=" ")
    print(queues.dequeue(0), end=" ")