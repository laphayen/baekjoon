T = int(input())

for x in range(1, T+1):
    a, b = map(int, input().split())
    if a < b:
        print("#%d <" %(x))
    elif a == b:
        print("#%d =" %(x))
    else:
        print("#%d >" %(x))