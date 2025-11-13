# Java Interview Practice

🚀 A structured collection of common coding interview questions and solutions in Java.

## 📚 Overview

This project contains well-documented solutions to popular coding interview problems, organized by topic. Each solution includes:
- Detailed problem description
- Multiple approaches (when applicable)
- Time and space complexity analysis
- Test cases with expected outputs
- Comments explaining the logic

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
│   └── utils/            # Helper classes (ListNode, TreeNode)
└── tests/                # Unit tests
```

## 🎯 Topics Covered

### Arrays & Strings
- Two Sum (HashMap approach, O(n))
- Remove Duplicates from Sorted Array
- Valid Palindrome

### Linked Lists
- Reverse Linked List (Iterative & Recursive)

### Trees
- Maximum Depth of Binary Tree (DFS & BFS)

### Searching
- Binary Search (Iterative & Recursive)

### Dynamic Programming
- Climbing Stairs (Multiple approaches with space optimization)

## 🚀 Quick Start

### Using the Interactive Runner:
```bash
./run.sh
```

### Manual Compilation:
```bash
# Compile and run a specific problem
javac src/arrays/TwoSum.java
java -cp src arrays.TwoSum

# Compile all files
javac -d bin src/**/*.java
java -cp bin arrays.TwoSum
```

## 📖 Example Problem

```java
// Two Sum - Find indices of two numbers that add up to target
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
```

## 📊 Complexity Reference

| Problem | Time | Space | Pattern |
|---------|------|-------|---------|
| Two Sum | O(n) | O(n) | HashMap |
| Binary Search | O(log n) | O(1) | Divide & Conquer |
| Climbing Stairs | O(n) | O(1) | DP |

## 🎓 Study Tips

1. **Start with Easy**: Begin with arrays and strings
2. **Understand Time Complexity**: Know Big O for each solution
3. **Practice Daily**: Solve at least 1-2 problems per day
4. **Multiple Approaches**: Try brute force first, then optimize
5. **Explain Out Loud**: Practice explaining your approach

## 🔗 Resources

- [LeetCode](https://leetcode.com) - Practice platform
- [HackerRank](https://hackerrank.com) - Coding challenges
- [NeetCode](https://neetcode.io) - Structured roadmap
- Cracking the Coding Interview - Essential book

## 🤝 Contributing

Feel free to add more problems! Follow the existing structure:
1. Create a new `.java` file in the appropriate folder
2. Include problem description, solution, and test cases
3. Document time/space complexity
4. Add comments explaining the approach

## 📝 License

This project is for educational purposes - free to use for interview preparation.

---

**Happy Coding!** 🎉

Remember: Consistency is key. Aim for 1-2 problems per day!

