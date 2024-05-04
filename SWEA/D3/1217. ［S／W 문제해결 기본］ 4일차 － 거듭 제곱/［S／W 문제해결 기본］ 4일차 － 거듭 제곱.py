def power(num, e):
    if e == 1:
        return num
    return power(num, e-1) * num

for x in range(1, 11):
    n = int(input())
    num, e = map(int, input().split())
    print("#%d %d" %(x, power(num, e)))