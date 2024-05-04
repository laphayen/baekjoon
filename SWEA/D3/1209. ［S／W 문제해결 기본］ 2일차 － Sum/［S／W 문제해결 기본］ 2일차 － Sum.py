for x in range(1, 11):
    n = int(input())
    matrix = [list(map(int, input().split())) for i in range(100)]

    result = 0

    # 행 최대값 구하기
    for i in range(100):
        c = 0
        for j in range(100):
            c += matrix[i][j]
        if result < c:
            result = c

    # 열 최대값 구하기
    for i in range(100):
        c = 0
        for j in range(100):
            c += matrix[j][i]
        if result < c:
            result = c

    c = 0
    # 우하 대각선
    for i in range(100):
        c += matrix[i][i]
        if result < c:
            result = c
    c = 0
    # 좌하 대각선
    for i in range(100):
        c += matrix[i][99-i]
        if result < c:
            result = c
    print("#%d %d" %(x, result))