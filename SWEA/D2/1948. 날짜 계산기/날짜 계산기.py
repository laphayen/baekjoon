days = [0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]

T = int(input())

for x in range(1, T+1):
    m1, d1, m2, d2 = map(int, input().split())
    first = days[m1] + d1
    second = days[m2] + d2
    print("#%d %d" %(x, second-first+1))