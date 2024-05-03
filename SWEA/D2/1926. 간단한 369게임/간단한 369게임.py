n = int(input())

for i in range(1, n+1):
    s = str(i)
    c = 0
    for j in s:
        cmp = int(j)
        if cmp == 3 or cmp == 6 or cmp == 9:
            c += 1
    if c > 0:
        print("-"*c, end=" ")
    else:
        print(i, end=" ")