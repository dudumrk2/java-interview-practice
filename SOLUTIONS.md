# 📚 Java LeetCode — הסברים מעמיקים לכל פתרון

> כל פתרון מוסבר בעומק: רעיון, צעד-אחר-צעד, ויזואליזציה, סיבוכיות ותובנות מפתח.

---

## תוכן עניינים

| # | תרגיל | קטגוריה | קושי |
|---|--------|----------|------|
| 1 | [Two Sum](#1-two-sum--leetcode-1) | Arrays | 🟢 Easy |
| 2 | [Remove Duplicates](#2-remove-duplicates-from-sorted-array--leetcode-26) | Arrays | 🟢 Easy |
| 3 | [Climbing Stairs](#3-climbing-stairs--leetcode-70) | Dynamic Programming | 🟢 Easy |
| 4 | [Reverse Linked List](#4-reverse-linked-list--leetcode-206) | Linked Lists | 🟢 Easy |
| 5 | [Binary Search](#5-binary-search--leetcode-704) | Searching | 🟢 Easy |
| 6 | [Valid Palindrome](#6-valid-palindrome--leetcode-125) | Strings | 🟢 Easy |
| 7 | [Maximum Depth of Binary Tree](#7-maximum-depth-of-binary-tree--leetcode-104) | Trees | 🟢 Easy |

---

## 1. Two Sum — LeetCode #1

### 📋 הבעיה

קיבלנו מערך שלמים `nums` ומספר `target`.  
יש להחזיר את **האינדקסים** של שני מספרים שסכומם שווה בדיוק ל-`target`.

**הגבלות חשובות:**
- קיים תמיד בדיוק פתרון אחד
- אי אפשר להשתמש באותו אלמנט פעמיים

**דוגמאות:**
```
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
הסבר:   nums[0] + nums[1] = 2 + 7 = 9 ✅

Input:  nums = [3, 2, 4], target = 6
Output: [1, 2]
הסבר:   nums[1] + nums[2] = 2 + 4 = 6 ✅

Input:  nums = [3, 3], target = 6
Output: [0, 1]
הסבר:   nums[0] + nums[1] = 3 + 3 = 6 ✅
```

---

### 🐌 פתרון 1 — Brute Force (כוח גס)

**הרעיון:** נסה כל זוג אפשרי `(i, j)` וראה אם סכומם שווה ל-`target`.

```java
public int[] twoSumBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No solution found");
}
```

**צעד-אחר-צעד על `[2, 7, 11, 15]`, target=9:**
```
i=0 (nums[0]=2):
    j=1 (nums[1]=7):  2+7=9  ✅ → return [0,1]
```

**דוגמה עם יותר עבודה — `[3, 2, 4]`, target=6:**
```
i=0 (nums[0]=3):
    j=1 (nums[1]=2):  3+2=5  ❌
    j=2 (nums[2]=4):  3+4=7  ❌
i=1 (nums[1]=2):
    j=2 (nums[2]=4):  2+4=6  ✅ → return [1,2]
```

**⏱️ סיבוכיות:**
- זמן: **O(n²)** — שתי לולאות מקוננות, n*(n-1)/2 השוואות
- מקום: **O(1)** — לא צריך זיכרון נוסף

**❌ חסרון:** על מערך של מיליון איברים — מיליארד פעולות. איטי מדי!

---

### ⚡ פתרון 2 — HashMap (האופטימלי)

**הרעיון המפתח:**  
במקום לשאול *"האם קיים j כך ש-nums[j] = target - nums[i]?"* ולחפש עליו בלולאה — נשמור תשובות שראינו ב-HashMap ונשאל אותו ב-O(1).

**הסתכלות אחרת:**  
לכל מספר `x` שאנחנו רואים, ה"משלים" שלו הוא `complement = target - x`.  
אם ה-complement כבר נמצא במפה → מצאנו!  
אם לא → נשמור את `x` למקרה שמישהו יחפש אותו בעתיד.

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(); // ערך → אינדקס

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

**ויזואליזציה על `[2, 7, 11, 15]`, target=9:**

```
┌─────┬──────────────┬────────────────────┬───────────────────────┐
│  i  │   nums[i]    │   complement (9-x) │       HashMap         │
├─────┼──────────────┼────────────────────┼───────────────────────┤
│  0  │      2       │    9-2 = 7         │ {} → לא קיים          │
│     │              │                    │ שמור: {2:0}           │
├─────┼──────────────┼────────────────────┼───────────────────────┤
│  1  │      7       │    9-7 = 2         │ {2:0} → 2 קיים! ✅    │
│     │              │                    │ return [map.get(2), 1]│
│     │              │                    │      = [0, 1]         │
└─────┴──────────────┴────────────────────┴───────────────────────┘
```

**ויזואליזציה על `[3, 2, 4]`, target=6:**

```
┌─────┬──────────────┬────────────────────┬───────────────────────┐
│  i  │   nums[i]    │   complement (6-x) │       HashMap         │
├─────┼──────────────┼────────────────────┼───────────────────────┤
│  0  │      3       │    6-3 = 3         │ {} → לא קיים          │
│     │              │                    │ שמור: {3:0}           │
├─────┼──────────────┼────────────────────┼───────────────────────┤
│  1  │      2       │    6-2 = 4         │ {3:0} → לא קיים       │
│     │              │                    │ שמור: {3:0, 2:1}      │
├─────┼──────────────┼────────────────────┼───────────────────────┤
│  2  │      4       │    6-4 = 2         │ {3:0, 2:1} → 2 קיים! ✅│
│     │              │                    │ return [1, 2]         │
└─────┴──────────────┴────────────────────┴───────────────────────┘
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — מעבר יחיד על המערך. HashMap.get/put הם O(1) בממוצע.
- מקום: **O(n)** — ב-worst case שומרים את כל המערך במפה.

**💡 תובנת מפתח:**  
אנחנו מחליפים זמן במקום — מוציאים O(n) זיכרון כדי לחסוך מ-O(n²) לזמן ל-O(n).  
זהו trade-off קלאסי בפתרון בעיות אלגוריתמיות!

---

## 2. Remove Duplicates from Sorted Array — LeetCode #26

### 📋 הבעיה

קיבלנו מערך **ממוין** בסדר עולה.  
יש להסיר כפילויות **in-place** (בלי להקצות מערך חדש) ולהחזיר את מספר האיברים הייחודיים.

**הגבלות:**
- יש לשנות את המערך המקורי — לא להקצות מערך חדש
- הסדר היחסי של האיברים חייב להישמר
- מה שנמצא אחרי האינדקס המוחזר — לא חשוב

**דוגמאות:**
```
Input:  [1, 1, 2]
Output: 2, מערך = [1, 2, _]

Input:  [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
Output: 5, מערך = [0, 1, 2, 3, 4, _, _, _, _, _]
```

---

### ⚡ הפתרון — Two Pointers (שני מצביעים)

**הרעיון:**  
המערך **ממוין**, לכן כל הכפילויות של ערך מסוים נמצאות **ברצף**.  
נחזיק שני מצביעים:
- `uniqueIndex` — מצביע על **סוף האיזור הייחודי** (אינדקס הכתיבה הבא)
- `i` — סורק קדימה ומחפש ערכים חדשים

כאשר `nums[i]` שונה מ-`nums[uniqueIndex]` — מצאנו ערך חדש! נכתוב אותו.

```java
public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int uniqueIndex = 0; // מצביע על האיבר הייחודי האחרון שנמצא

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[uniqueIndex]) { // ערך חדש!
            uniqueIndex++;
            nums[uniqueIndex] = nums[i];    // העתק אותו לאיזור הייחודי
        }
    }

    return uniqueIndex + 1; // מספר האיברים = אינדקס אחרון + 1
}
```

**ויזואליזציה מפורטת על `[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]`:**

```
מצב התחלתי:
 [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
  ↑
uniqueIndex=0

i=1: nums[1]=0 == nums[0]=0  → כפילות, דלג
 [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
  ↑

i=2: nums[2]=1 != nums[0]=0  → ערך חדש!
     uniqueIndex++ → 1
     nums[1] = 1
 [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
     ↑

i=3: nums[3]=1 == nums[1]=1  → כפילות, דלג
i=4: nums[4]=1 == nums[1]=1  → כפילות, דלג

i=5: nums[5]=2 != nums[1]=1  → ערך חדש!
     uniqueIndex++ → 2
     nums[2] = 2
 [0, 1, 2, 1, 1, 2, 2, 3, 3, 4]
        ↑

i=6: nums[6]=2 == nums[2]=2  → כפילות, דלג

i=7: nums[7]=3 != nums[2]=2  → ערך חדש!
     uniqueIndex++ → 3
     nums[3] = 3
 [0, 1, 2, 3, 1, 2, 2, 3, 3, 4]
           ↑

i=8: nums[8]=3 == nums[3]=3  → כפילות, דלג

i=9: nums[9]=4 != nums[3]=3  → ערך חדש!
     uniqueIndex++ → 4
     nums[4] = 4
 [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
              ↑

return uniqueIndex + 1 = 5 ✅
המערך הייחודי: [0, 1, 2, 3, 4]
```

**💡 למה זה עובד?**  
כיוון שהמערך ממוין — כל כפילויות של ערך מסוים מגיעות ברצף.  
אז כשאנחנו רואים ערך שונה מהאחרון ב-`uniqueIndex`, אנחנו **בטוח** מצאנו ערך חדש.  
אם המערך לא היה ממוין — הגישה הזו לא הייתה עובדת!

**⏱️ סיבוכיות:**
- זמן: **O(n)** — מעבר יחיד על המערך
- מקום: **O(1)** — רק שני משתני מצביע, אין הקצאת זיכרון נוסף

---

## 3. Climbing Stairs — LeetCode #70

### 📋 הבעיה

אנחנו עולים מדרגות. יש `n` מדרגות עד למעלה.  
בכל צעד אפשר לעלות **1 מדרגה** או **2 מדרגות**.  
כמה דרכים שונות יש להגיע לקומה העליונה?

**דוגמאות:**
```
n=1: 1 דרך          → [1]
n=2: 2 דרכים        → [1+1] או [2]
n=3: 3 דרכים        → [1+1+1], [1+2], [2+1]
n=4: 5 דרכים        → [1+1+1+1], [1+1+2], [1+2+1], [2+1+1], [2+2]
n=5: 8 דרכים
```

**🔍 הבחנה קריטית — סדרת פיבונאצ'י!**

```
f(n) = f(n-1) + f(n-2)
```

**למה?**  
כדי להגיע למדרגה `n`, אפשר להגיע אליה:
- ממדרגה `n-1` (בצעד של 1) — כל הדרכים להגיע ל-`n-1`
- ממדרגה `n-2` (בצעד של 2) — כל הדרכים להגיע ל-`n-2`

סך הדרכים = סכום שתי האפשרויות.

```
f(1) = 1
f(2) = 2
f(3) = f(2) + f(1) = 3
f(4) = f(3) + f(2) = 5
f(5) = f(4) + f(3) = 8
...
```

זהו בדיוק רצף פיבונאצ'י (זזה ב-1): 1, 2, 3, 5, 8, 13, 21...

---

### 📐 פתרון 1 — Bottom-Up DP עם מערך

```java
public int climbStairs(int n) {
    if (n <= 2) return n;

    int[] dp = new int[n + 1];
    dp[1] = 1; // מדרגה 1: דרך אחת
    dp[2] = 2; // מדרגה 2: שתי דרכים

    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
}
```

**ויזואליזציה של מילוי הטבלה (n=5):**

```
i:    1    2    3    4    5
dp: [ 1,   2,   3,   5,   8 ]
           ↑    ↑
         dp[1]+dp[2]=3
                    ↑    ↑
                  dp[2]+dp[3]=5
                              ↑    ↑
                            dp[3]+dp[4]=8
```

**⏱️ סיבוכיות:**
- זמן: **O(n)**
- מקום: **O(n)** — מערך dp בגודל n+1

---

### 🚀 פתרון 2 — Space Optimized (האופטימלי)

**תובנה:** לחישוב `dp[i]` צריך רק `dp[i-1]` ו-`dp[i-2]`.  
לא צריך לשמור את כל המערך — רק 2 משתנים!

```java
public int climbStairsOptimized(int n) {
    if (n <= 2) return n;

    int prev2 = 1; // מייצג f(n-2), מתחיל כ-f(1)=1
    int prev1 = 2; // מייצג f(n-1), מתחיל כ-f(2)=2

    for (int i = 3; i <= n; i++) {
        int current = prev1 + prev2;
        prev2 = prev1;   // הזז את החלון קדימה
        prev1 = current;
    }

    return prev1;
}
```

**ויזואליזציה של "חלון נע" (n=5):**

```
התחלה: prev2=1, prev1=2

i=3: current = 2+1 = 3
     prev2=2, prev1=3
     [prev2, prev1] = [2, 3]

i=4: current = 3+2 = 5
     prev2=3, prev1=5
     [prev2, prev1] = [3, 5]

i=5: current = 5+3 = 8
     prev2=5, prev1=8
     [prev2, prev1] = [5, 8]

return prev1 = 8 ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)**
- מקום: **O(1)** — רק שני משתנים!

---

### 🔄 פתרון 3 — Top-Down עם Memoization (רקורסיה חכמה)

**הבעיה עם רקורסיה נאיבית:**
```
f(5) = f(4) + f(3)
f(4) = f(3) + f(2)    ← f(3) מחושב פעמיים!
f(3) = f(2) + f(1)    ← f(2) מחושב שלוש פעמים!
```

**הפתרון — Memoization:** שמור כל תוצאה שחישבת, ואל תחשב שוב.

```java
public int climbStairsMemo(int n) {
    int[] memo = new int[n + 1]; // כברירת מחדל מלא באפסים
    return helper(n, memo);
}

private int helper(int n, int[] memo) {
    if (n <= 2) return n;           // תנאי בסיס
    if (memo[n] != 0) return memo[n]; // כבר חושב — החזר מהזיכרון!

    memo[n] = helper(n-1, memo) + helper(n-2, memo);
    return memo[n];
}
```

**עץ הרקורסיה עם Memoization (n=5):**
```
              f(5)
             /    \
          f(4)    f(3)←──── נחשב פעם ראשונה, נשמר
         /    \
      f(3)*  f(2)
     /    \
  f(2)   f(1)

* f(3) — כבר קיים בזיכרון! → מחזיר מיד בלי לרדת שוב
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — כל ערך מחושב בדיוק פעם אחת
- מקום: **O(n)** — מערך הזיכרון + stack הרקורסיה

---

### 🏆 השוואת הגישות

| גישה | זמן | מקום | קריאות | מתי להשתמש? |
|------|-----|------|--------|-------------|
| Bottom-Up DP | O(n) | O(n) | גבוהה | כשרוצים לשמור את כל הטבלה |
| Space Optimized | O(n) | O(1) | בינונית | **הגרסה הטובה ביותר** |
| Top-Down Memo | O(n) | O(n) | גבוהה | כשהבעיה מורכבת יותר ורקורסיה טבעית |

---

## 4. Reverse Linked List — LeetCode #206

### 📋 הבעיה

הפוך רשימה מקושרת.

```
Input:  1 → 2 → 3 → 4 → 5 → NULL
Output: 5 → 4 → 3 → 2 → 1 → NULL
```

**מה זו רשימה מקושרת?**  
כל `ListNode` מכיל:
- `val` — הערך
- `next` — מצביע לצומת הבא (או null בסוף)

```java
class ListNode {
    int val;
    ListNode next;
}
```

---

### ⚡ פתרון 1 — איטרטיבי (Three Pointers)

**הרעיון:** עוברים על הרשימה ובכל צעד **הופכים כיוון של חץ אחד**.

```java
public ListNode reverseListIterative(ListNode head) {
    ListNode prev = null; // מה נמצא "מאחורינו"
    ListNode curr = head; // הצומת שמעבדים כרגע

    while (curr != null) {
        ListNode nextTemp = curr.next; // שמור את הבא לפני ששינינו
        curr.next = prev;             // הפוך את החץ
        prev = curr;                  // הזז prev קדימה
        curr = nextTemp;              // הזז curr קדימה
    }

    return prev; // prev הוא הראש החדש
}
```

**ויזואליזציה מלאה — `1 → 2 → 3 → NULL`:**

```
מצב התחלתי:
prev=NULL   curr=1 → 2 → 3 → NULL

────────── איטרציה 1 ──────────
nextTemp = curr.next = 2       ← שמור את 2 לפני השינוי
curr.next = prev = NULL        ← הפוך את החץ: 1 → NULL
prev = curr = 1                ← הזז prev ל-1
curr = nextTemp = 2            ← הזז curr ל-2

מצב: NULL ← 1    curr=2 → 3 → NULL
         ↑
        prev

────────── איטרציה 2 ──────────
nextTemp = curr.next = 3       ← שמור את 3
curr.next = prev = 1           ← הפוך: 2 → 1 → NULL
prev = curr = 2                ← הזז prev ל-2
curr = nextTemp = 3            ← הזז curr ל-3

מצב: NULL ← 1 ← 2    curr=3 → NULL
              ↑
             prev

────────── איטרציה 3 ──────────
nextTemp = curr.next = NULL    ← שמור NULL
curr.next = prev = 2           ← הפוך: 3 → 2 → 1 → NULL
prev = curr = 3                ← הזז prev ל-3
curr = nextTemp = NULL         ← curr = NULL, נצא מהלולאה

תוצאה: 3 → 2 → 1 → NULL
        ↑
      return prev ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — מעבר יחיד
- מקום: **O(1)** — רק 3 מצביעים

---

### 🔄 פתרון 2 — רקורסיבי

**הרעיון:** נרד רקורסיבית עד לצומת האחרון, ובדרך חזרה נחבר כל צומת לקודמו בכיוון הפוך.

```java
public ListNode reverseListRecursive(ListNode head) {
    // תנאי עצירה: רשימה ריקה או עם איבר אחד
    if (head == null || head.next == null) return head;

    // רד עד הסוף — newHead יהיה הצומת האחרון (החדש ראש)
    ListNode newHead = reverseListRecursive(head.next);

    // head.next עכשיו מצביע ל-head.next הבא
    // נגיד head=4, head.next=5:
    //   head.next.next = head → 5.next = 4  (חיבור אחורה)
    //   head.next = null       → 4.next = null (הסרת חץ קדימה)
    head.next.next = head;
    head.next = null;

    return newHead;
}
```

**ויזואליזציה של stack הרקורסיה — `1 → 2 → 3 → NULL`:**

```
ירידה (הקריאות הרקורסיביות):
  reverse(1) →
    reverse(2) →
      reverse(3) →
        reverse(NULL)? לא, תנאי: head.next==null
        return 3  ← newHead = 3

עלייה (חזרה מהרקורסיה):
  בחזרה ל-reverse(2):  [head=2, head.next=3]
    3.next = 2   →  2 ← 3
    2.next = null
    return newHead=3

  בחזרה ל-reverse(1):  [head=1, head.next=2]
    2.next = 1   →  1 ← 2 ← 3
    1.next = null
    return newHead=3

תוצאה: 3 → 2 → 1 → NULL ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)**
- מקום: **O(n)** — ה-call stack גדל עם הרשימה

**💡 מתי להשתמש בכל פתרון?**
- **איטרטיבי** — תמיד עדיף ב-production (O(1) מקום, אין סכנת stack overflow)
- **רקורסיבי** — אלגנטי ועוזר להבין עקרון הרקורסיה, פחות מעשי לרשימות ארוכות

---

## 5. Binary Search — LeetCode #704

### 📋 הבעיה

מערך **ממוין בסדר עולה** ומספר `target`.  
החזר את האינדקס של `target` — או `-1` אם לא קיים.  
**חובה:** זמן ריצה `O(log n)`.

```
Input:  nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4

Input:  nums = [-1, 0, 3, 5, 9, 12], target = 2
Output: -1
```

---

### ⚡ הרעיון — Divide and Conquer

במקום לסרוק את כל המערך (O(n)), נחצה אותו בכל צעד:

1. מסתכלים על **האמצע** של הטווח הנוכחי
2. אם `nums[mid] == target` → מצאנו!
3. אם `nums[mid] < target` → ה-target נמצא בחצי **הימני** → `left = mid + 1`
4. אם `nums[mid] > target` → ה-target נמצא בחצי **השמאלי** → `right = mid - 1`

כל צעד חוצה את מרחב החיפוש לחצי → `O(log n)` צעדים.

### ⚡ פתרון 1 — איטרטיבי

```java
public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        // ⚠️  mid = (left+right)/2 עלול לגרום Integer Overflow!
        // הפתרון הנכון:
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;                // מצאנו!
        } else if (nums[mid] < target) {
            left = mid + 1;           // חפש בחצי הימני
        } else {
            right = mid - 1;          // חפש בחצי השמאלי
        }
    }

    return -1; // לא נמצא
}
```

**ויזואליזציה על `[-1, 0, 3, 5, 9, 12]`, target=9:**

```
מצב התחלתי:
 idx:  0    1    2    3    4    5
nums: [-1,  0,   3,   5,   9,  12]
       ↑                        ↑
      left                    right

────── צעד 1 ──────
mid = 0 + (5-0)/2 = 2
nums[2] = 3 < 9 → חפש בימין
left = mid+1 = 3

nums: [-1,  0,   3,   5,   9,  12]
                      ↑         ↑
                    left      right

────── צעד 2 ──────
mid = 3 + (5-3)/2 = 4
nums[4] = 9 == 9 → נמצא! ✅
return 4
```

**ויזואליזציה על `[-1, 0, 3, 5, 9, 12]`, target=2:**

```
 idx:  0    1    2    3    4    5
nums: [-1,  0,   3,   5,   9,  12]

צעד 1: left=0, right=5, mid=2, nums[2]=3 > 2 → right=1
צעד 2: left=0, right=1, mid=0, nums[0]=-1 < 2 → left=1
צעד 3: left=1, right=1, mid=1, nums[1]=0 < 2 → left=2
צעד 4: left=2 > right=1 → יוצאים מהלולאה
return -1 ❌ (לא קיים)
```

**⏱️ סיבוכיות:**
- זמן: **O(log n)** — חצי בכל פעם
- מקום: **O(1)**

---

### 🔄 פתרון 2 — רקורסיבי

```java
public int searchRecursive(int[] nums, int target) {
    return helper(nums, target, 0, nums.length - 1);
}

private int helper(int[] nums, int target, int left, int right) {
    if (left > right) return -1; // טווח ריק — לא נמצא

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        return helper(nums, target, mid + 1, right); // חפש ימין
    } else {
        return helper(nums, target, left, mid - 1);  // חפש שמאל
    }
}
```

**⏱️ סיבוכיות:**
- זמן: **O(log n)**
- מקום: **O(log n)** — עומק stack הרקורסיה

**⚠️ Integer Overflow — למה `left + (right - left) / 2`?**

```
נניח: left = 1,000,000,000, right = 2,000,000,000

(left + right) / 2:
  1,000,000,000 + 2,000,000,000 = 3,000,000,000 > Integer.MAX_VALUE (≈2.1B)
  → Overflow! 💥

left + (right - left) / 2:
  (2,000,000,000 - 1,000,000,000) = 1,000,000,000 ✓ (לא overflow)
  1,000,000,000 + 1,000,000,000/2 = 1,500,000,000 ✅
```

---

## 6. Valid Palindrome — LeetCode #125

### 📋 הבעיה

קיבלנו מחרוזת `s`. קבע האם היא **פלינדרום** — כלומר נקראת אותו דבר קדימה ואחורה.

**חוקים:**
- קחו בחשבון רק **תווים אלפאנומריים** (אותיות ומספרים)
- התעלמו מ-**רווחים, פיסוק** וכד'
- התעלמו מ-**גודל אות** (case-insensitive)

```
"A man, a plan, a canal: Panama" → true
  ↓ אחרי סינון ↓
"amanaplanacanalpanama"
 ← נקרא אותו דבר משני הכיוונים ✅

"race a car" → false
  ↓ אחרי סינון ↓
"raceacar"
 r-a-c-e-a-c-a-r ≠ r-a-c-a-e-c-a-r ❌
```

---

### ⚡ פתרון 1 — Two Pointers In-Place (O(1) מקום)

**הרעיון:** שני מצביעים — `left` מהשמאל, `right` מהימין.  
מדלגים על תווים לא-אלפאנומריים ומשווים תווים מקבילים.

```java
public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) return true;

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        // דלג על תווים לא-אלפאנומריים מהשמאל
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }
        // דלג על תווים לא-אלפאנומריים מהימין
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }
        // השווה (case-insensitive)
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
```

**ויזואליזציה על `"A man, a plan, a canal: Panama"`:**

```
"A man, a plan, a canal: Panama"
 ^                             ^
left=0                      right=29

צעד 1:
  left=0  → 'A' → אלפאנומרי ✓
  right=29 → 'a' → אלפאנומרי ✓
  'A' vs 'a' → (toLowerCase) 'a'=='a' ✅
  left=1, right=28

צעד 2:
  left=1  → ' ' → לא אלפאנומרי, דלג → left=2
  left=2  → 'm' → אלפאנומרי ✓
  right=28 → 'm' → אלפאנומרי ✓
  'm' vs 'm' ✅
  left=3, right=27

צעד 3:
  left=3  → 'a' → אלפאנומרי ✓
  right=27 → 'a' → אלפאנומרי ✓
  'a' vs 'a' ✅
  ...
  (ממשיך עד שכל הזוגות מאושרים)

return true ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — כל תו נבדק לכל היותר פעם אחת
- מקום: **O(1)** — רק שני מצביעים!

---

### 🧹 פתרון 2 — Clean First (O(n) מקום)

**הרעיון:** קודם מנקים את המחרוזת, אחר כך בודקים.

```java
public boolean isPalindromeClean(String s) {
    // הסר הכל חוץ מאותיות ומספרים, והמר ל-lowercase
    String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int left = 0;
    int right = cleaned.length() - 1;

    while (left < right) {
        if (cleaned.charAt(left) != cleaned.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
```

**תהליך על `"A man, a plan, a canal: Panama"`:**
```
שלב 1 - replaceAll:  "AmanaplanacanalpanamaP" → המרה + סינון
שלב 2 - toLowerCase: "amanaplanacanalpanama"
שלב 3 - השוואה: [a]manaplanacanalpanaм[a] ← שווה
                  [m]anaplanacanalpana[m] ← שווה
                   ...
return true ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)**
- מקום: **O(n)** — נוצרת מחרוזת חדשה לאחר הסינון

**💡 הבדל מעשי:**  
הפתרון הראשון (Two Pointers) עדיף כי לא יוצר String חדש.  
הפתרון השני קריא יותר וקל לתחזוקה — בחרו לפי הצורך.

---

## 7. Maximum Depth of Binary Tree — LeetCode #104

### 📋 הבעיה

מצא את **העומק המקסימלי** של עץ בינארי.  
עומק = מספר הצמתים בנתיב הארוך ביותר מהשורש עד לעלה.

```
עץ לדוגמה:
        3
       / \
      9  20
        /  \
       15   7

עומק = 3 (הנתיב: 3 → 20 → 15 או 3 → 20 → 7)
```

**מבנה `TreeNode`:**
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
```

---

### ⚡ פתרון 1 — DFS רקורסיבי (האלגנטי)

**הרעיון:** עומק של עץ = `max(עומק תת-עץ שמאל, עומק תת-עץ ימין) + 1`

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0; // עץ ריק — עומק 0

    int leftDepth  = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
}
```

**ויזואליזציה — פתיחה וסגירה של הרקורסיה:**

```
maxDepth(3)
├── maxDepth(9)
│   ├── maxDepth(null) → 0
│   └── maxDepth(null) → 0
│   max(0, 0) + 1 = 1  ←── מוחזר ל-3
│
└── maxDepth(20)
    ├── maxDepth(15)
    │   ├── maxDepth(null) → 0
    │   └── maxDepth(null) → 0
    │   max(0, 0) + 1 = 1  ←── מוחזר ל-20
    │
    └── maxDepth(7)
        ├── maxDepth(null) → 0
        └── maxDepth(null) → 0
        max(0, 0) + 1 = 1  ←── מוחזר ל-20

    max(1, 1) + 1 = 2  ←── מוחזר ל-3

max(1, 2) + 1 = 3  ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — מבקרים כל צומת בדיוק פעם אחת
- מקום: **O(h)** — h הוא גובה העץ (עומק stack הרקורסיה)
  - עץ מאוזן: h = O(log n)
  - עץ מוטה (רשימה): h = O(n)

---

### 🌊 פתרון 2 — BFS איטרטיבי (Level by Level)

**הרעיון:** עוברים על העץ **רמה-רמה** (רוחב ראשון), וסופרים כמה רמות יש.

```java
public int maxDepthBFS(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;

    while (!queue.isEmpty()) {
        int levelSize = queue.size(); // כמה צמתים יש ברמה הנוכחית

        // עבד את כל הצמתים של הרמה הנוכחית
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();

            if (node.left  != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        depth++; // סיימנו רמה אחת — הוסף לעומק
    }

    return depth;
}
```

**ויזואליזציה של תור (Queue) רמה-רמה:**

```
עץ:         3
           / \
          9  20
            /  \
           15   7

רמה 1: Queue = [3]
  עבד 3: הוסף 9, 20 → Queue = [9, 20]
  depth = 1

רמה 2: Queue = [9, 20]
  עבד 9:  אין ילדים
  עבד 20: הוסף 15, 7 → Queue = [15, 7]
  depth = 2

רמה 3: Queue = [15, 7]
  עבד 15: אין ילדים
  עבד 7:  אין ילדים
  Queue ריק
  depth = 3

return 3 ✅
```

**⏱️ סיבוכיות:**
- זמן: **O(n)** — מבקרים כל צומת
- מקום: **O(w)** — w הוא הרוחב המקסימלי של העץ (גודל התור)
  - בעץ מלא: w = O(n/2) = O(n) ← יכול להיות גדול!
  - בעץ מוטה: w = O(1)

**💡 מתי להשתמש בכל פתרון?**

| | DFS רקורסיבי | BFS איטרטיבי |
|--|--|--|
| קריאות | ⭐⭐⭐⭐⭐ אלגנטי מאוד | ⭐⭐⭐ מילולי יותר |
| מקום (עץ מאוזן) | O(log n) | O(n/2) |
| מקום (עץ עמוק) | O(n) — סכנת stack overflow | O(1) |
| מקום (עץ רחב) | O(log n) | O(n) — Queue גדול |
| **המלצה** | **לרוב העצים** | **עצים מאוד עמוקים** |

---

## 📊 סיכום כולל

| # | תרגיל | גישה | זמן | מקום | Pattern |
|---|--------|------|-----|------|---------|
| 1 | Two Sum | HashMap | O(n) | O(n) | Hash Table |
| 2 | Remove Duplicates | Two Pointers | O(n) | O(1) | Two Pointers |
| 3 | Climbing Stairs | DP (Space-Opt) | O(n) | O(1) | Dynamic Programming |
| 4 | Reverse Linked List | Three Pointers | O(n) | O(1) | Linked List Traversal |
| 5 | Binary Search | Divide & Conquer | O(log n) | O(1) | Binary Search |
| 6 | Valid Palindrome | Two Pointers | O(n) | O(1) | Two Pointers |
| 7 | Max Depth BT | DFS Recursion | O(n) | O(h) | Tree DFS |

---

## 🧠 Patterns שחוזרים על עצמם

### Two Pointers
מוצאים ב-**Remove Duplicates** ו-**Valid Palindrome**.  
עובד כשיש **סדר** (מיון, או מבנה כמו string) ורוצים O(1) מקום.

### HashMap למיפוי ערך → אינדקס
מוצאים ב-**Two Sum**.  
עובד כשרוצים לדעת **האם ראינו ערך מסוים בעבר**, ב-O(1).

### Dynamic Programming
מוצאים ב-**Climbing Stairs**.  
עובד כשבעיה גדולה מתחלקת לתת-בעיות חופפות.

### Recursion על עצים
מוצאים ב-**Max Depth Binary Tree** ו-**Reverse Linked List**.  
עובד יפה כשהמבנה הוא רקורסיבי מטבעו (עצים, רשימות).

### Divide & Conquer
מוצאים ב-**Binary Search**.  
עובד על מבנים **ממוינים** — חוסך מ-O(n) ל-O(log n).

---

*נוצר ב-2026 | Java Interview Practice*
