for tc in range(int(input())):
    A, B = map(int, input().split())
    cnt = 0
    for i in range(A, B + 1):
        C = i ** (1 / 2)
        if C == int(C):
            i = str(i)
            C = str(int(C))
            if i == i[::-1] and C == C[::-1]:
                cnt += 1

    print("#%d %d" %(tc+1, cnt))