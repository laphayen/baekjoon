T = int(input())

for x in range(1, T+1):
    n = int(input())
    l = list(map(int, input().split()))[::-1]

    mx = 0
    result = 0

    for i in l:
        if mx < i:
            mx = i
        else:
            result += (mx - i)

    print("#%d %d" %(x, result))