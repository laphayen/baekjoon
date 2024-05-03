T = int(input())

for x in range(1, T+1):
    l = list(map(int, input().split()))
    l_max = 0
    for i in l:
        if l_max < i:
            l_max = i
    print("#%d %d" %(x, l_max))