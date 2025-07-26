# 🚀 Complete Dynamic Programming Guide
## For Beginners - With Visual Diagrams

---

# 📚 Table of Contents
1. [What is Dynamic Programming?](#what-is-dynamic-programming)
2. [Fibonacci Numbers](#fibonacci-numbers) 
3. [Count Board Problem](#count-board-problem)
4. [Count Maze Path](#count-maze-path)
5. [Edit Distance Problem](#edit-distance-problem)
6. [0/1 Knapsack Problem](#01-knapsack-problem)
7. [Matrix Chain Multiplication](#matrix-chain-multiplication)
8. [Wine Problem](#wine-problem)
9. [Mixture Problem](#mixture-problem)
10. [Comparison & When to Use Each Approach](#comparison--when-to-use-each-approach)

---

# 🧠 What is Dynamic Programming?

Dynamic Programming (DP) is a technique to solve complex problems by breaking them into **smaller overlapping subproblems** and storing their solutions to avoid redundant calculations.

## 🔑 Key Concepts:
1. **Overlapping Subproblems**: Same smaller problems appear multiple times
2. **Optimal Substructure**: Solution depends on solutions of smaller problems  
3. **Memoization**: Store results to avoid recomputation

## 🌟 Two Main Approaches:
- **Top-Down (Memoization)**: Start from main problem, recursively solve and store results
- **Bottom-Up (Tabulation)**: Start from smallest problems, build up to main problem

---

# 1️⃣ Fibonacci Numbers

## 🎯 Problem: 
Find the nth Fibonacci number where F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2)

**Sequence**: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...

## 🔄 Approach 1: Pure Recursion

### How it works:
```
F(5) = F(4) + F(3)
F(4) = F(3) + F(2)     F(3) = F(2) + F(1)
F(3) = F(2) + F(1)     F(2) = F(1) + F(0)
...and so on
```

### 📊 Visual Recursion Tree (F(5)):
```
                    F(5)
                   /    \
               F(4)        F(3)
              /   \       /   \
           F(3)   F(2)  F(2)  F(1)
          /  \   /  \   /  \    |
       F(2) F(1)F(1)F(0)F(1)F(0) 1
      /  \   |   |   |   |   |
   F(1)F(0)  1   1   0   1   0
     |   |
     1   0
```

**🚨 Problem**: F(3) is calculated **3 times**, F(2) is calculated **5 times**!
- **Time**: O(2^n) - Exponential
- **Space**: O(n) - Recursion depth

## 💾 Approach 2: Top-Down DP (Memoization)

### How it works:
Store computed results in an array to avoid recomputation.

### 📊 Visual DP Array:
```
Call F(5):
dp = [?, ?, ?, ?, ?, ?]
     0  1  2  3  4  5

After F(2): dp[2] = 1
dp = [?, ?, 1, ?, ?, ?]

After F(3): dp[3] = 2  
dp = [?, ?, 1, 2, ?, ?]

After F(4): dp[4] = 3
dp = [?, ?, 1, 2, 3, ?]

After F(5): dp[5] = 5
dp = [?, ?, 1, 2, 3, 5]
```

**✅ Improvement**: Each subproblem solved **only once**!
- **Time**: O(n) - Each value computed once
- **Space**: O(n) - DP array + recursion stack

## 📈 Approach 3: Bottom-Up DP (Tabulation)

### How it works:
Build solution iteratively from smallest to largest.

### 📊 Step-by-Step Building:
```
Initialize: dp[0]=0, dp[1]=1
dp = [0, 1, ?, ?, ?, ?]

i=2: dp[2] = dp[1] + dp[0] = 1 + 0 = 1
dp = [0, 1, 1, ?, ?, ?]

i=3: dp[3] = dp[2] + dp[1] = 1 + 1 = 2  
dp = [0, 1, 1, 2, ?, ?]

i=4: dp[4] = dp[3] + dp[2] = 2 + 1 = 3
dp = [0, 1, 1, 2, 3, ?]

i=5: dp[5] = dp[4] + dp[3] = 3 + 2 = 5
dp = [0, 1, 1, 2, 3, 5]
```

**✅ Benefits**: No recursion overhead!
- **Time**: O(n) - Single loop
- **Space**: O(n) - Only DP array

---

# 2️⃣ Count Board Problem

## 🎯 Problem:
Count ways to reach position `n` starting from position `0` using dice rolls (1-6).

**Example**: From 0 to 3
- Ways: [1,1,1], [1,2], [2,1], [3]
- **Answer**: 4 ways

## 🎲 Visual Representation:
```
Position: 0 → 1 → 2 → 3 (target)
Dice:     1   1   1
          1   2
          2   1  
          3
```

## 🔄 Approach 1: Pure Recursion

### 📊 Recursion Tree (target=4):
```
                count(0,4)
        /    /    /    /    \    \
     c(1,4)c(2,4)c(3,4)c(4,4)c(5,4)c(6,4)
      |     |     |     |     |     |
    4ways  2ways  1way   1   invalid invalid
```

### How each call works:
```
count(0,4) = count(1,4) + count(2,4) + count(3,4) + count(4,4) + count(5,4) + count(6,4)
           = 4 + 2 + 1 + 1 + 0 + 0 = 8 ways
```

**🚨 Problem**: Repeated calculations
- **Time**: O(6^n) - Each position has 6 choices
- **Space**: O(n) - Recursion depth

## 💾 Approach 2: Top-Down DP

### 📊 DP Array Progress (target=4):
```
Initial: dp = [0, 0, 0, 0, 0]
                0  1  2  3  4

After count(4,4): dp[4] = 1
dp = [0, 0, 0, 0, 1]

After count(3,4): dp[3] = dp[4] = 1  
dp = [0, 0, 0, 1, 1]

After count(2,4): dp[2] = dp[3] + dp[4] = 1 + 1 = 2
dp = [0, 0, 2, 1, 1]

After count(1,4): dp[1] = dp[2] + dp[3] + dp[4] = 2 + 1 + 1 = 4
dp = [0, 4, 2, 1, 1]

After count(0,4): dp[0] = dp[1] + dp[2] + dp[3] + dp[4] = 4 + 2 + 1 + 1 = 8
dp = [8, 4, 2, 1, 1]
```

## 📈 Approach 3: Bottom-Up DP

### 📊 Building from End to Start:
```
arr = [?, ?, ?, ?, 1, 0, 0, 0, 0, 0] (extended array)
       0  1  2  3  4  5  6  7  8  9

i=3: arr[3] = arr[4]+arr[5]+arr[6]+arr[7]+arr[8]+arr[9] = 1+0+0+0+0+0 = 1
arr = [?, ?, ?, 1, 1, 0, 0, 0, 0, 0]

i=2: arr[2] = arr[3]+arr[4]+...+arr[8] = 1+1+0+0+0+0 = 2  
arr = [?, ?, 2, 1, 1, 0, 0, 0, 0, 0]

i=1: arr[1] = arr[2]+arr[3]+arr[4]+...+arr[7] = 2+1+1+0+0+0 = 4
arr = [?, 4, 2, 1, 1, 0, 0, 0, 0, 0]

i=0: arr[0] = arr[1]+...+arr[6] = 4+2+1+1+0+0 = 8
arr = [8, 4, 2, 1, 1, 0, 0, 0, 0, 0]
```

## 🎯 Approach 4: Space Optimized

### How it works:
Use sliding window of size 6 (dice faces).

### 📊 Sliding Window Process:
```
arr = [1, 0, 0, 0, 0, 0] (last 6 positions)
       ^
      pos=4

slide=3: sum = 1+0+0+0+0+0 = 1
Shift right: arr = [1, 1, 0, 0, 0, 0]
             pos=3→        ^

slide=2: sum = 1+1+0+0+0+0 = 2  
Shift right: arr = [2, 1, 1, 0, 0, 0]
             pos=2→        ^

slide=1: sum = 2+1+1+0+0+0 = 4
Shift right: arr = [4, 2, 1, 1, 0, 0]
             pos=1→        ^

slide=0: sum = 4+2+1+1+0+0 = 8
Final: arr = [8, 4, 2, 1, 1, 0]
```

---

# 3️⃣ Count Maze Path

## 🎯 Problem:
Count unique paths from top-left (0,0) to bottom-right (endRow,endColumn). Can only move **right** or **down**.

## 🗺️ Visual Grid (3×3):
```
S → → E    S = Start (0,0)
↓   ↓ ↓    E = End   (2,2)  
↓   ↓ ↓    → = Right move
E ← ← E    ↓ = Down move
```

**Possible paths for 3×3**: **6 unique paths**
1. Right→Right→Down→Down
2. Right→Down→Right→Down
3. Right→Down→Down→Right  
4. Down→Right→Right→Down
5. Down→Right→Down→Right
6. Down→Down→Right→Right

## 🔄 Approach 1: Pure Recursion

### 📊 Recursion Tree (2×2 grid):
```
                maze(0,0)
               /         \
         maze(0,1)      maze(1,0)
          /     \        /     \
    maze(0,2) maze(1,1) maze(1,1) maze(2,0)
       |       /   \      /   \       |
      1×   maze(1,2) maze(2,1) maze(1,2) maze(2,1)
              |       |        |       |
             1×      1×       1×      1×
```

**Note**: `maze(1,1)` calculated **twice** → Overlapping subproblems!

## 💾 Approach 2: Top-Down DP

### 📊 DP Table Building (3×3):
```
Initial DP:
[0, 0, 0]
[0, 0, 0]  
[0, 0, 0]

After base cases:
[?, ?, ?]
[?, ?, ?]
[?, ?, 1] ← dp[2][2] = 1 (destination)

Filling backwards:
[?, ?, 1]    [?, 3, 1]    [6, 3, 1]
[?, ?, 1] → [3, 2, 1] → [3, 2, 1]
[?, ?, 1]    [1, 1, 1]    [1, 1, 1]
```

### Step-by-step calculation:
```
dp[2][1] = dp[2][2] = 1
dp[2][0] = dp[2][1] = 1  
dp[1][2] = dp[2][2] = 1
dp[1][1] = dp[1][2] + dp[2][1] = 1 + 1 = 2
dp[1][0] = dp[1][1] + dp[2][0] = 2 + 1 = 3
dp[0][2] = dp[1][2] = 1
dp[0][1] = dp[0][2] + dp[1][1] = 1 + 2 = 3  
dp[0][0] = dp[0][1] + dp[1][0] = 3 + 3 = 6
```

## 📈 Approach 3: Bottom-Up DP

### 📊 Building from Destination:
```
Step 1: Set destination
[?, ?, ?]
[?, ?, ?]
[?, ?, 1] ← Start here

Step 2: Fill last row & column  
[?, ?, 1] ← dp[i][2] = 1
[?, ?, 1] ← dp[i][2] = 1
[1, 1, 1] ← dp[2][j] = 1

Step 3: Fill remaining cells
[6, 3, 1] ← dp[i][j] = dp[i+1][j] + dp[i][j+1]
[3, 2, 1]
[1, 1, 1]
```

## 🎯 Approach 4: Space Optimized

### How it works:
Use 1D array representing one row at a time.

### 📊 Row-by-row Processing:
```
Initial: dp = [1, 1, 1] (last row)

Process row 1 (from right to left):
dp[2] = dp[2] = 1 (boundary)
dp[1] = dp[1] + dp[2] = 1 + 1 = 2
dp[0] = dp[0] + dp[1] = 1 + 2 = 3
Result: dp = [3, 2, 1]

Process row 0 (from right to left):  
dp[2] = dp[2] = 1 (boundary)
dp[1] = dp[1] + dp[2] = 2 + 1 = 3
dp[0] = dp[0] + dp[1] = 3 + 3 = 6
Result: dp = [6, 3, 1]
```

---

# 5️⃣ Edit Distance Problem

## 🎯 Problem: 
Find the minimum number of operations (insert, delete, replace) required to transform one string into another.

**Example**: Transform "saturday" → "sunday"
- Replace 'a' with 'u': "sturday"
- Replace 't' with 'n': "sunrday" 
- Delete 'r': "sunday"
**Result**: 3 operations

## 🔄 Approach 1: Pure Recursion

### Algorithm:
```
editDistance(str1, str2):
    if str1 is empty: return length of str2
    if str2 is empty: return length of str1
    
    if first characters match:
        return editDistance(rest of str1, rest of str2)
    else:
        insert = editDistance(str1, rest of str2) + 1
        delete = editDistance(rest of str1, str2) + 1  
        replace = editDistance(rest of str1, rest of str2) + 1
        return minimum of (insert, delete, replace)
```

### 📊 Visual Example ("cat" → "dog"):
```
                editDistance("cat", "dog")
                         /      |        \
                      +1/    +1 |         \+1
                      /         |          \
            ("at","dog")  ("cat","og")  ("at","og")
               /   |   \      /   |   \     /   |   \
             ...  ...  ...  ...  ...  ... ...  ... ...
```

**Time Complexity**: O(3^(m+n)) - Exponential  
**Space Complexity**: O(m+n) - Recursion stack

## ⚡ Approach 2: Top-Down DP (Memoization)

### Algorithm:
```
editDistanceDP(str1, str2, i, j, dp):
    if i == str1.length: return str2.length - j
    if j == str2.length: return str1.length - i
    
    if dp[i][j] != 0: return dp[i][j]
    
    if str1[i] == str2[j]:
        dp[i][j] = editDistanceDP(str1, str2, i+1, j+1, dp)
    else:
        insert = editDistanceDP(str1, str2, i, j+1, dp) + 1
        delete = editDistanceDP(str1, str2, i+1, j, dp) + 1
        replace = editDistanceDP(str1, str2, i+1, j+1, dp) + 1
        dp[i][j] = min(insert, delete, replace)
    
    return dp[i][j]
```

**Time Complexity**: O(m×n)  
**Space Complexity**: O(m×n)

## 🏗️ Approach 3: Bottom-Up DP

### Algorithm:
```
editDistanceBU(str1, str2):
    dp[i][j] = min edit distance for first i chars of str1 to first j chars of str2
    
    Base cases:
    dp[0][j] = j (insert j characters)
    dp[i][0] = i (delete i characters)
    
    For each cell:
    if str1[i-1] == str2[j-1]:
        dp[i][j] = dp[i-1][j-1]
    else:
        dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
```

### 📊 DP Table Example ("cat" → "dog"):
```
    ""  d  o  g
""   0  1  2  3
c    1  1  2  3
a    2  2  2  3  
t    3  3  3  3
```

**Time Complexity**: O(m×n)  
**Space Complexity**: O(m×n)

---

# 6️⃣ 0/1 Knapsack Problem

## 🎯 Problem: 
Given weights and values of items, find maximum value that can be obtained with weight limit W.

**Example**: 
- Items: [(weight=1, value=1), (weight=3, value=4), (weight=4, value=5), (weight=5, value=7)]
- Capacity: 7
- **Result**: Maximum value = 9 (items with weights 3+4)

## 🔄 Approach 1: Pure Recursion  

### Algorithm:
```
knapsack(weights, values, index, capacity):
    if index == n or capacity == 0:
        return 0
    
    exclude = knapsack(weights, values, index+1, capacity)
    
    include = 0
    if weights[index] <= capacity:
        include = values[index] + knapsack(weights, values, index+1, capacity - weights[index])
    
    return max(include, exclude)
```

### 📊 Visual Decision Tree:
```
                    knapsack(items, 0, 7)
                   /                    \
              exclude                 include (w=1,v=1)
           knapsack(1,7)              knapsack(1,6)
            /        \                 /           \
        exclude    include         exclude      include
      knapsack(2,7) knapsack(2,4) knapsack(2,6) knapsack(2,3)
         ...          ...            ...          ...
```

**Time Complexity**: O(2^n) - Exponential  
**Space Complexity**: O(n) - Recursion depth

## ⚡ Approach 2: Top-Down DP (Memoization)

### Algorithm:
```
knapsackDP(weights, values, index, capacity, dp):
    if index == n or capacity == 0:
        return 0
        
    if dp[index][capacity] != 0:
        return dp[index][capacity]
    
    exclude = knapsackDP(weights, values, index+1, capacity, dp)
    
    include = 0
    if weights[index] <= capacity:
        include = values[index] + knapsackDP(weights, values, index+1, capacity - weights[index], dp)
    
    dp[index][capacity] = max(include, exclude)
    return dp[index][capacity]
```

**Time Complexity**: O(n×W)  
**Space Complexity**: O(n×W)

## 🏗️ Approach 3: Bottom-Up DP

### Algorithm:
```
knapsackBU(weights, values, capacity):
    dp[i][w] = maximum value using first i items with weight limit w
    
    For i from 0 to n:
        For w from 0 to capacity:
            if weights[i-1] <= w:
                dp[i][w] = max(dp[i-1][w], dp[i-1][w-weights[i-1]] + values[i-1])
            else:
                dp[i][w] = dp[i-1][w]
```

### 📊 DP Table Example:
```
Capacity:  0  1  2  3  4  5  6  7
Item 0:    0  1  1  1  1  1  1  1  (w=1,v=1)
Item 1:    0  1  1  4  5  5  5  5  (w=3,v=4)  
Item 2:    0  1  1  4  5  6  6  9  (w=4,v=5)
Item 3:    0  1  1  4  5  7  8  9  (w=5,v=7)
```

**Time Complexity**: O(n×W)  
**Space Complexity**: O(n×W)

---

# 7️⃣ Matrix Chain Multiplication

## 🎯 Problem: 
Find the minimum number of scalar multiplications needed to compute the product of a chain of matrices.

**Example**: 
- Matrices: A₁(4×2) × A₂(2×3) × A₃(3×5) × A₄(5×1)
- Different parenthesizations have different costs
- **Goal**: Find optimal parenthesization

## 🔄 Approach 1: Pure Recursion

### Algorithm:
```
matrixChainMultiplication(arr, start, end):
    if start + 1 == end:
        return 0  // Single matrix, no multiplication needed
    
    min_cost = INFINITY
    for k from start+1 to end-1:
        left_cost = matrixChainMultiplication(arr, start, k)
        right_cost = matrixChainMultiplication(arr, k, end)
        split_cost = arr[start] * arr[k] * arr[end]
        
        total_cost = left_cost + right_cost + split_cost
        min_cost = min(min_cost, total_cost)
    
    return min_cost
```

### 📊 Visual Example (matrices 4×2, 2×3, 3×5, 5×1):
```
Array: [4, 2, 3, 5, 1]
       A₁   A₂   A₃   A₄

                MCM(0,4)
               /    |    \
           k=1/   k=2|     \k=3
            /       |      \
      MCM(0,1)   MCM(0,2)   MCM(0,3)
      +MCM(1,4)  +MCM(2,4)  +MCM(3,4)
      +4×2×1     +4×3×1     +4×5×1
```

**Time Complexity**: O(2^n) - Exponential  
**Space Complexity**: O(n) - Recursion depth

## ⚡ Approach 2: Top-Down DP (Memoization)

### Algorithm:
```
matrixChainMultiplicationDP(arr, start, end, dp):
    if start + 1 == end:
        return 0
        
    if dp[start][end] != 0:
        return dp[start][end]
    
    min_cost = INFINITY
    for k from start+1 to end-1:
        left_cost = matrixChainMultiplicationDP(arr, start, k, dp)
        right_cost = matrixChainMultiplicationDP(arr, k, end, dp)
        split_cost = arr[start] * arr[k] * arr[end]
        
        total_cost = left_cost + right_cost + split_cost
        min_cost = min(min_cost, total_cost)
    
    dp[start][end] = min_cost
    return min_cost
```

### 📊 DP Table Example:
```
     0   1   2   3   4
0    0   0  24  88  158
1    -   0   0  30  48  
2    -   -   0   0  15
3    -   -   -   0   0
4    -   -   -   -   0
```

**Time Complexity**: O(n³)  
**Space Complexity**: O(n²)

---

# 8️⃣ Wine Problem

## 🎯 Problem: 
Given wines with different values, find the maximum profit by selling them optimally over time (wine value increases each year).

**Example**: 
- Wines: [2, 3, 5, 1, 4]
- Year 1: Can sell wine worth 2×1 = 2
- Year 2: Can sell wine worth 3×2 = 6, etc.
- **Goal**: Maximize total profit

## Algorithm Concept:
```
At each step, choose to sell either:
- First wine: value[left] × year + solve(left+1, right, year+1)  
- Last wine: value[right] × year + solve(left, right-1, year+1)

Return maximum of both choices
```

**Time Complexity**: O(n²) with DP  
**Space Complexity**: O(n²)

---

# 9️⃣ Mixture Problem

## 🎯 Problem: 
Given colored substances with different properties, find the minimum cost to mix them optimally.

**Example**: 
- Substances with different mixing costs
- **Goal**: Find optimal mixing sequence

## Algorithm Concept:
```
Similar to Matrix Chain Multiplication:
- Try all possible split points
- Calculate mixing cost for each split
- Choose minimum cost option
```

**Time Complexity**: O(n³) with DP  
**Space Complexity**: O(n²)

{{ ... }}

---

# 📊 Comparison & When to Use Each Approach

## Time & Space Complexity Summary:

| Problem | Recursive | Top-Down DP | Bottom-Up DP | Space Optimized |
|---------|-----------|-------------|--------------|-----------------|
| **Fibonacci** | O(2^n), O(n) | O(n), O(n) | O(n), O(n) | O(n), O(1) |
| **Board Path** | O(6^n), O(n) | O(n), O(n) | O(n), O(n) | O(n), O(1) |
| **Maze Path** | O(2^(m×n)), O(m+n) | O(m×n), O(m×n) | O(m×n), O(m×n) | O(m×n), O(min(m,n)) |

## 🎯 When to Use Each:

### 🔄 Pure Recursion
- **Use for**: Understanding the problem logic
- **Best for**: Small inputs, learning concepts
- **Avoid for**: Large inputs (too slow)

### 💾 Top-Down DP (Memoization)  
- **Use for**: Natural recursive thinking
- **Best for**: When not all subproblems are needed
- **Good for**: Problems with complex recursion patterns

### 📈 Bottom-Up DP (Tabulation)
- **Use for**: Better performance (no recursion overhead)
- **Best for**: When all subproblems must be solved
- **Good for**: Iterative thinkers

### 🎯 Space Optimized
- **Use for**: Memory constraints
- **Best for**: Large inputs where space matters
- **Good for**: Production code

## 🚀 Learning Path:
1. **Start with**: Pure recursion to understand problem
2. **Add memoization**: To optimize recursive solution  
3. **Convert to tabulation**: For better performance
4. **Space optimize**: For memory efficiency

## 🔑 Key Takeaways:
- **DP = Recursion + Memoization**
- **Always identify**: Base cases and recurrence relation
- **Practice pattern recognition**: Many problems follow similar patterns
- **Start simple**: Master basic problems before complex ones

---

*Happy Coding! 🎉 Dynamic Programming becomes easier with practice. Start with these three fundamental problems and gradually tackle more complex ones.*
