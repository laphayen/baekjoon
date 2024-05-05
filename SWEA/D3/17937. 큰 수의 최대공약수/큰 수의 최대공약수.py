T = int(input())

for x in range(1, T+1):
    a, b = map(int, input().split())

    result = 1

    if a == b:
        result = a

    print("#%d %d" %(x, result))