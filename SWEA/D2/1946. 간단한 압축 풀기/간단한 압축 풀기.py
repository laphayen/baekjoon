T = int(input())

for x in range(1, T+1):
    n = int(input())
    l = []
    for i in range(n):
        alpha, num = input().split()
        num = int(num)
        for i in range(num):
            l.append(alpha)
    cont = 1
    print("#%d" %x)
    for i in l:
        if cont % 10 == 0:
            print(i)
        else:
            print(i, end="")
        cont += 1
    print()