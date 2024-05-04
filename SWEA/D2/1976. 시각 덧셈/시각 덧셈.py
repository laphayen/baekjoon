T = int(input())

for x in range(1, T+1):
    h1, m1, h2, m2 = map(int, input().split())

    result_m = m1 + m2
    result_h = h1 + h2

    if result_m > 60:
        result_m = result_m % 60
        result_h += 1

    if result_h > 12:
        result_h = result_h - 12

    print("#%d %d %d" %(x, result_h, result_m))