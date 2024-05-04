
T = int(input())

for z in range(1, T+1):
    n, k = map(int, input().split())

    board = [list(map(int, input().split())) for i in range(n)]

    result = 0
    # 열 검사

    for i in range(n):
        c = 0
        for j in range(n):
            if board[i][j] == 1:
                c += 1
            if board[i][j] == 0 or j == n-1:
                if c == k:
                    result += 1
                c = 0

    for i in range(n):
        c = 0
        for j in range(n):
            if board[j][i] == 1:
                c += 1
            if board[j][i] == 0 or j == n-1:
                if c == k:
                    result += 1
                c = 0

    print("#%d %d" %(z, result))