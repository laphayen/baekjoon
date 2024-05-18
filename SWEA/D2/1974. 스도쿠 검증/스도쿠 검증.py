
T = int(input())

for x in range(1, T+1):
    mat = [list(map(int, input().split())) for i in range(9)]

    result = 1

    # 가로 검새
    for i in range(9):
        cnt_r = [0]*10
        cnt_c = [0]*10
        for j in range(9):
            cnt_r[mat[i][j]] += 1
            cnt_c[mat[j][i]] += 1

        for k in range(1, 10):
            if cnt_c[k] != 1:
                result = 0
                break
            if cnt_r[k] != 1:
                result = 0

    for i in range(3):
        for j in range(3):
            cnt_m = [0] * 10
            for k in range(3):
                for l in range(3):
                    cnt_m[mat[3*i+k][3*j+l]] += 1

            for k in range(1, 10):
                if cnt_m[k] != 1:
                    result = 0
                    break
    print("#%d %d" %(x, result))
