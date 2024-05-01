import sys

input = sys.stdin.readline

N = int(input())

stack = []

for x in range(N):
    l = input().split()
    key = int(l[0])
    if key == 1:
        stack.append(l[-1])
    elif key == 2:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
            stack.pop()
    elif key == 3:
        print(len(stack))
    elif key == 4:
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    elif key == 5:
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])