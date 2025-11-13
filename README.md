# Java Interview Coding Practice

## 📚 Overview
A structured collection of common coding interview questions and solutions in Java.

## 🗂️ Project Structure
```
java-interview-practice/
├── src/
│   ├── arrays/           # Array manipulation problems
│   ├── strings/          # String processing problems
│   ├── linkedlists/      # Linked list problems
│   ├── trees/            # Binary tree problems
│   ├── sorting/          # Sorting algorithms
│   ├── searching/        # Searching algorithms
│   ├── dp/               # Dynamic programming
│   ├── graphs/           # Graph algorithms
│   └── utils/            # Helper classes
└── tests/                # Unit tests
```

## 🎯 Interview Topics Covered

### 1. Arrays & Strings
- Two Sum
- Remove Duplicates from Sorted Array
- Rotate Array
- Valid Palindrome
- String Reversal
- Check Anagram

### 2. Linked Lists
- Reverse Linked List
- Detect Cycle
- Merge Two Sorted Lists
- Find Middle Element

### 3. Trees
- Binary Tree Traversal (Inorder, Preorder, Postorder)
- Maximum Depth
- Validate BST
- Lowest Common Ancestor

### 4. Sorting & Searching
- Binary Search
- Quick Sort
- Merge Sort
- Search in Rotated Sorted Array

### 5. Dynamic Programming
- Fibonacci Numbers
- Climbing Stairs
- Longest Common Subsequence
- Coin Change

### 6. Graphs
- DFS (Depth First Search)
- BFS (Breadth First Search)
- Number of Islands

## 🚀 How to Run

### Compile and run a specific problem:
```bash
# Arrays
javac src/arrays/TwoSum.java
java -cp src arrays.TwoSum

# Linked Lists
javac src/linkedlists/ReverseLinkedList.java
java -cp src linkedlists.ReverseLinkedList
```

### Compile all at once:
```bash
javac -d bin src/**/*.java
java -cp bin arrays.TwoSum
```

## 📖 Usage Example

```java
// Example: Two Sum Problem
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }
}
```

## 🎓 Study Tips

1. **Start with Easy**: Begin with arrays and strings
2. **Understand Time Complexity**: Know Big O for each solution
3. **Practice Daily**: Solve at least 1-2 problems per day
4. **Write Tests**: Verify your solutions work correctly
5. **Explain Out Loud**: Practice explaining your approach
6. **Multiple Approaches**: Try brute force first, then optimize

## 📊 Complexity Reference

| Problem | Time | Space | Difficulty |
|---------|------|-------|------------|
| Two Sum | O(n) | O(n) | Easy |
| Binary Search | O(log n) | O(1) | Easy |
| Merge Sort | O(n log n) | O(n) | Medium |
| LCS | O(m*n) | O(m*n) | Medium |
| DFS/BFS | O(V+E) | O(V) | Medium |

## 🔗 Resources

- **LeetCode**: https://leetcode.com - Practice platform
- **HackerRank**: https://hackerrank.com - Coding challenges
- **Cracking the Coding Interview** - Essential book
- **Java Docs**: https://docs.oracle.com/en/java/

## ✅ Progress Tracking

Track your completion:
- [ ] Arrays & Strings (6/6)
- [ ] Linked Lists (4/4)
- [ ] Trees (4/4)
- [ ] Sorting & Searching (4/4)
- [ ] Dynamic Programming (4/4)
- [ ] Graphs (3/3)

## 🎯 Interview Preparation Checklist

Before your interview:
- [ ] Review all major data structures
- [ ] Practice Big O time/space analysis
- [ ] Solve 50+ different problems
- [ ] Do 3+ mock interviews
- [ ] Practice explaining solutions clearly
- [ ] Handle edge cases in all solutions
- [ ] Test with various inputs

---

**Created**: November 13, 2025  
**Language**: Java 11+  
**Purpose**: Technical Interview Preparation  
**Status**: Ready to Use

