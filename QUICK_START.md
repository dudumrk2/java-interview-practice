# 🚀 Quick Start Guide

## Getting Started

### 1. Navigate to the project:
```bash
cd /Users/duduma/code/java-interview-practice
```

### 2. Run problems using the script:
```bash
./run.sh
```

### 3. Or compile and run manually:
```bash
# Compile a problem
javac src/arrays/TwoSum.java

# Run it
java -cp src arrays.TwoSum
```

---

## 📚 What's Included

### ✅ Arrays (2 problems)
- **Two Sum** - HashMap approach, O(n) time
- **Remove Duplicates** - Two pointer technique

### ✅ Strings (1 problem)
- **Valid Palindrome** - Two pointer, alphanumeric filtering

### ✅ Linked Lists (1 problem)
- **Reverse Linked List** - Iterative & recursive solutions

### ✅ Trees (1 problem)
- **Max Depth Binary Tree** - DFS & BFS approaches

### ✅ Searching (1 problem)
- **Binary Search** - Iterative & recursive

### ✅ Dynamic Programming (1 problem)
- **Climbing Stairs** - DP with space optimization

---

## 💡 How to Practice

### Daily Routine:
1. **Pick a problem** from the list
2. **Try solving it yourself** (20-30 min)
3. **Run the provided solution**
4. **Compare approaches**
5. **Explain it out loud**

### Study Pattern:
```
Week 1: Arrays & Strings (basics)
Week 2: Linked Lists & Trees
Week 3: Sorting & Searching
Week 4: Dynamic Programming & Graphs
```

---

## 🎯 Interview Tips

### Before You Code:
1. **Clarify requirements** - Ask questions
2. **Discuss approach** - Explain your plan
3. **Consider edge cases** - Empty input, single element, etc.
4. **Analyze complexity** - Big O time and space

### While Coding:
1. **Think out loud** - Explain your logic
2. **Write clean code** - Use meaningful variable names
3. **Test as you go** - Verify logic with examples
4. **Handle errors** - Check for null, bounds, etc.

### After Coding:
1. **Test with examples** - Walk through your code
2. **Optimize if possible** - Can you do better?
3. **Explain trade-offs** - Why this approach?

---

## 📊 Complexity Cheat Sheet

| Data Structure | Access | Search | Insert | Delete |
|----------------|--------|--------|--------|--------|
| Array | O(1) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) |
| Hash Table | - | O(1) | O(1) | O(1) |
| Binary Tree | O(log n) | O(log n) | O(log n) | O(log n) |

| Algorithm | Best | Average | Worst | Space |
|-----------|------|---------|-------|-------|
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) |

---

## 🔥 Common Patterns

### Two Pointers:
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    // Process
    left++;
    right--;
}
```

### Sliding Window:
```java
int windowSum = 0;
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
```

### HashMap for O(1) lookup:
```java
Map<Integer, Integer> map = new HashMap<>();
if (map.containsKey(key)) {
    // Found
}
```

### BFS with Queue:
```java
Queue<Node> queue = new LinkedList<>();
queue.offer(root);
while (!queue.isEmpty()) {
    Node node = queue.poll();
    // Process
}
```

### DFS Recursive:
```java
void dfs(Node node) {
    if (node == null) return;
    // Process
    dfs(node.left);
    dfs(node.right);
}
```

---

## ✅ Next Steps

### Add More Problems:
1. Create new `.java` files in appropriate folders
2. Follow the same structure (package, comments, test cases)
3. Update `run.sh` if needed

### Practice Resources:
- **LeetCode**: Start with "Easy" tag
- **HackerRank**: Interview Preparation Kit
- **AlgoExpert**: Video explanations
- **InterviewBit**: Topic-wise practice

### Mock Interviews:
- **Pramp**: Free peer mock interviews
- **Interviewing.io**: Practice with engineers
- **LeetCode**: Live coding competitions

---

## 📞 Quick Commands

```bash
# Run a specific problem
./run.sh
# Choose from menu

# Compile all
javac -d bin src/**/*.java

# Run all tests
java -cp bin arrays.TwoSum
java -cp bin strings.ValidPalindrome
# ... etc

# Clean build
rm -rf bin && mkdir bin
```

---

**Happy Coding!** 🎉

Remember: **Practice makes perfect!**  
Aim for 1-2 problems per day.

---

**Created**: November 13, 2025  
**Location**: `/Users/duduma/code/java-interview-practice`  
**Java Version**: 11+

