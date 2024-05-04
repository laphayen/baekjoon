T = int(input())

for x in range(1, T+1):
    n = int(input())
    result = 0
    for j in range(1, n+1):
        if j % 2 != 0:
            result += j
        else:
            result -= j
    print("#%d %d" %(x, result))