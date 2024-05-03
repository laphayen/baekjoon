T = int(input())

for x in range(1, T+1):
    l = list(map(int, input().split()))
    l.sort()
    l.pop()
    l.pop(0)
    print("#%d %d" %(x, round(sum(l)/len(l))))