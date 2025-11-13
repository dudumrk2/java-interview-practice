#!/bin/bash

# Java Interview Practice - Quick Run Script
# This script helps you compile and run individual problems

echo "🚀 Java Interview Practice - Quick Runner"
echo "=========================================="

# Colors for output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to compile and run a Java file
run_problem() {
    local file_path=$1
    local class_name=$2

    echo -e "\n${BLUE}📝 Running: ${class_name}${NC}"
    echo "----------------------------------------"

    # Compile
    javac -d bin -sourcepath src "$file_path"

    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✓ Compilation successful${NC}"
        echo ""
        # Run
        java -cp bin "$class_name"
    else
        echo "❌ Compilation failed"
        return 1
    fi
}

# Create bin directory if it doesn't exist
mkdir -p bin

# Menu
echo ""
echo "Select a problem to run:"
echo ""
echo "📊 Arrays:"
echo "  1) Two Sum"
echo "  2) Remove Duplicates"
echo ""
echo "🔤 Strings:"
echo "  3) Valid Palindrome"
echo ""
echo "🔗 Linked Lists:"
echo "  4) Reverse Linked List"
echo ""
echo "🌳 Trees:"
echo "  5) Max Depth Binary Tree"
echo ""
echo "🔍 Searching:"
echo "  6) Binary Search"
echo ""
echo "💡 Dynamic Programming:"
echo "  7) Climbing Stairs"
echo ""
echo "  0) Run ALL"
echo ""
read -p "Enter your choice (0-7): " choice

case $choice in
    1)
        run_problem "src/arrays/TwoSum.java" "arrays.TwoSum"
        ;;
    2)
        run_problem "src/arrays/RemoveDuplicates.java" "arrays.RemoveDuplicates"
        ;;
    3)
        run_problem "src/strings/ValidPalindrome.java" "strings.ValidPalindrome"
        ;;
    4)
        # Need to compile utils first
        javac -d bin src/utils/ListNode.java
        run_problem "src/linkedlists/ReverseLinkedList.java" "linkedlists.ReverseLinkedList"
        ;;
    5)
        # Need to compile utils first
        javac -d bin src/utils/TreeNode.java
        run_problem "src/trees/MaxDepthBinaryTree.java" "trees.MaxDepthBinaryTree"
        ;;
    6)
        run_problem "src/searching/BinarySearch.java" "searching.BinarySearch"
        ;;
    7)
        run_problem "src/dp/ClimbingStairs.java" "dp.ClimbingStairs"
        ;;
    0)
        echo -e "\n${BLUE}🏃 Running all problems...${NC}\n"

        # Compile utils first
        javac -d bin src/utils/*.java

        # Run all
        run_problem "src/arrays/TwoSum.java" "arrays.TwoSum"
        run_problem "src/arrays/RemoveDuplicates.java" "arrays.RemoveDuplicates"
        run_problem "src/strings/ValidPalindrome.java" "strings.ValidPalindrome"
        run_problem "src/linkedlists/ReverseLinkedList.java" "linkedlists.ReverseLinkedList"
        run_problem "src/trees/MaxDepthBinaryTree.java" "trees.MaxDepthBinaryTree"
        run_problem "src/searching/BinarySearch.java" "searching.BinarySearch"
        run_problem "src/dp/ClimbingStairs.java" "dp.ClimbingStairs"

        echo -e "\n${GREEN}🎉 All problems executed!${NC}"
        ;;
    *)
        echo "❌ Invalid choice"
        exit 1
        ;;
esac

echo ""
echo "=========================================="
echo "✅ Done!"

