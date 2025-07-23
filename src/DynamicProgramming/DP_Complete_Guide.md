# 🚀 Complete Dynamic Programming Guide
## For Beginners - With Visual Diagrams

---

# 📚 Table of Contents
1. [What is Dynamic Programming?](#what-is-dynamic-programming)
2. [Fibonacci Numbers](#fibonacci-numbers) 
3. [Count Board Problem](#count-board-problem)
4. [Count Maze Path](#count-maze-path)
5. [Comparison & When to Use Each Approach](#comparison--when-to-use-each-approach)

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
