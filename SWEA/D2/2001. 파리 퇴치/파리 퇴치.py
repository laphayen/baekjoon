T = int(input())

for x in range(1, T+1):
    n, m = map(int, input().split())
    mat = [list(map(int, input().split())) for i in range(n)]

    result = []

    for i in range(n-m+1):
        for j in range(n-m+1):
            s = 0
            for k in range(m):
                for l in range(m):
                    s += mat[i+k][j+l]
            result.append(s)

    print("#%d %d" %(x, max(result)))