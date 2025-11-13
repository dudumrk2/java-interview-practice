#!/bin/bash

# Quick Push to GitHub Script
# Run this after creating the repository on GitHub

echo "🚀 Pushing Java Interview Practice to GitHub..."
echo ""

cd /Users/duduma/code/java-interview-practice

# Check if repository exists on GitHub
echo "📡 Checking connection to GitHub..."
git ls-remote origin &> /dev/null

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Repository doesn't exist on GitHub yet!"
    echo ""
    echo "Please create it first:"
    echo "1. Go to: https://github.com/new"
    echo "2. Repository name: java-interview-practice"
    echo "3. Make it Public"
    echo "4. DO NOT initialize with README/gitignore/license"
    echo "5. Click 'Create repository'"
    echo ""
    echo "Then run this script again."
    exit 1
fi

echo "✅ Repository found on GitHub!"
echo ""
echo "📤 Pushing code..."

git push -u origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "🎉 Success! Your code is now on GitHub!"
    echo ""
    echo "View it at: https://github.com/dudumrk2/java-interview-practice"
    echo ""
else
    echo ""
    echo "❌ Push failed. You may need to authenticate."
    echo ""
    echo "Try one of these:"
    echo "1. Use GitHub Desktop"
    echo "2. Set up SSH keys: https://docs.github.com/en/authentication/connecting-to-github-with-ssh"
    echo "3. Use Personal Access Token: https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token"
    echo ""
fi

