T = int(input())

for x in range(1, T+1):
    n = int(input())
    l = list(map(int, input().split()))
    l.sort()
    print("#%d " %(x), end="")
    for i in l:
        print(i, end=" ")
    print()