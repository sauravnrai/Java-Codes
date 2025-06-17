# Java PriorityQueue Guide 📌

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Data Structures](https://img.shields.io/badge/Data%20Structures-Heap-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Heap_(data_structure))
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)

A comprehensive guide to Java's `PriorityQueue` implementation covering Min-Heap, Max-Heap, and custom comparators with practical examples and interview problem solutions.

## Table of Contents

- [What is a PriorityQueue?](#what-is-a-priorityqueue)
- [Declaration Examples](#declaration-examples)
- [Key Methods](#key-methods)
- [Custom Comparators](#custom-comparators)
- [Complete Example](#complete-example)
- [When to Use Min-Heap vs Max-Heap](#when-to-use-min-heap-vs-max-heap)
- [Limitations](#limitations)
- [Popular Interview Questions](#popular-interview-questions)
- [Time Complexity](#time-complexity)
- [Contributing](#contributing)

## What is a PriorityQueue?

A `PriorityQueue` is a **heap-based queue** that retrieves the element with the highest priority first.

- ✅ By default, Java's `PriorityQueue` is a **Min-Heap** — smallest element has the highest priority
- ✅ You can turn it into a **Max-Heap** using a custom comparator
- ✅ Based on binary heap data structure for efficient operations

## Declaration Examples

### Min-Heap (Default)

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```

### Max-Heap

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
```

### Max-Heap for Custom Objects/Arrays

```java
PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
    (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
);

//This is for the squared distance: distance² = x² + y² that was used in kth closest point
// Depending on the problem, custom comperator will change
```

## Key Methods

| Method | Description | Time Complexity |
|--------|-------------|----------------|
| `offer(e)` | Inserts element `e` into the queue | O(log N) |
| `poll()` | Retrieves and removes the head | O(log N) |
| `peek()` | Retrieves (but doesn't remove) the head | O(1) |
| `isEmpty()` | Returns true if queue is empty | O(1) |
| `size()` | Returns number of elements | O(1) |

## Custom Comparators

### For Primitive Types

```java
// Max-Heap for integers
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

// Min-Heap for integers (default behavior)
PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
```

### For 2D Arrays (Points by Distance)

```java
// Min-heap by distance to origin
// If we use a min heap, the formula has changed w.r.t to previous 
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
    (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
);
```

### For Custom Objects

```java
class Employee {
    int salary;
    String name;
    
    Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}

// Min-heap by salary
PriorityQueue<Employee> pq = new PriorityQueue<>((a, b) -> a.salary - b.salary);
```

> ⚠️ **Performance Tip:** Avoid `Math.sqrt()` in distance comparisons — comparing squared distances is sufficient and faster.

## Complete Example

### K Closest Points to Origin

```java
public int[][] kClosest(int[][] points, int k) {
    // Max-heap to maintain k closest points
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        int distA = a[0]*a[0] + a[1]*a[1];
        int distB = b[0]*b[0] + b[1]*b[1];
        return distB - distA; // Max-Heap
    });
    
    for (int[] point : points) {
        pq.offer(point);
        if (pq.size() > k) {
            pq.poll(); // Remove farthest point
        }
    }
    
    // Extract results
    int[][] result = new int[k][2];
    int i = 0;
    while (!pq.isEmpty()) {
        result[i++] = pq.poll();
    }
    
    return result;
}
```

## When to Use Min-Heap vs Max-Heap

| Problem Type | Heap Type | Reason |
|--------------|-----------|--------|
| Kth Smallest Element | Min-Heap | Direct access to smallest |
| Kth Largest Element | Max-Heap | Direct access to largest |
| Top K Frequent Elements | Min-Heap (size K) | Maintain K most frequent |
| Merge K Sorted Lists | Min-Heap | Always get minimum next element |
| Sliding Window Maximum | Max-Heap | Track maximum in window |
| Dijkstra's Algorithm | Min-Heap | Process shortest distances first |
| Task Scheduling | Max-Heap | Process highest priority tasks |

## Limitations

- ❌ **Not fully sorted** — only the head is guaranteed to be min/max
- ❌ **No random access** — no `.get(index)` method available
- ❌ **Iterator not ordered** — iteration doesn't follow heap order
- ✅ **Efficient for priority operations** — O(log N) insertion/deletion

## Time Complexity

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Insertion (`offer`) | O(log N) | O(1) |
| Deletion (`poll`) | O(log N) | O(1) |
| Peek | O(1) | O(1) |
| Search | O(N) | O(1) |
| Construction | O(N log N) | O(N) |

## Popular Interview Questions

### Beginner Level
- ✅ Kth Largest Element in an Array
- ✅ Last Stone Weight
- ✅ Merge K Sorted Lists

### Intermediate Level
- ✅ Top K Frequent Elements
- ✅ K Closest Points to Origin
- ✅ Task Scheduler
- ✅ Reorganize String

### Advanced Level
- ✅ Median from Data Stream
- ✅ Sliding Window Maximum
- ✅ Find Smallest Range Covering Elements from K Lists
- ✅ Maximum Performance of a Team

## Best Practices

1. **Choose the right heap type** based on whether you need min or max element
2. **Use size-limited heaps** for "Top K" problems to optimize space
3. **Avoid sqrt() operations** in comparators for better performance  
4. **Consider TreeSet** if you need both priority queue functionality and sorted iteration

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

### How to Contribute
1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Resources

- [Oracle Java Documentation - PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
- [LeetCode Heap Problems](https://leetcode.com/tag/heap/)
- [GeeksforGeeks Heap Data Structure](https://www.geeksforgeeks.org/heap-data-structure/)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**💡 Pro Tip:** Practice with LeetCode problems like `Kth Largest Element`, `Top K Frequent`, and `Merge K Lists` to solidify your understanding.

**⭐ If this guide helped you, please consider giving it a star!**