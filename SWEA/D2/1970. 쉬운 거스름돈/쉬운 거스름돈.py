coin = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

T = int(input())

for x in range(1, T+1):
    result = []
    m = int(input())
    c = 0
    for i in coin:
        c = m // i
        m = m - (c * i)
        result.append(c)
    print("#%d" %(x))
    for j in result:
        print(j, end=" ")
    print()