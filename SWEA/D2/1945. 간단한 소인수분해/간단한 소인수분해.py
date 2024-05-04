T = int(input())

num = [2, 3, 5, 7, 11]

for x in range(1, T+1):

    result = []

    N = int(input())
    for i in num:
        c = 0
        while N % i == 0:
            N = N // i
            c += 1
        result.append(c)

    print("#%d" %(x), end=" ")
    for i in result:
        print(i, end=" ")
    print()
