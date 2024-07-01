T = int(input())
for tc in range(1, T+1):
    N = int(input())
    l = [list(map(int, input().split())) for _ in range(N)]
    l90 = [[0 for _ in range(N)] for _ in range(N)]
    l180 = [[0 for _ in range(N)] for _ in range(N)]
    l270 = [[0 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            l90[i][j] = l[N-1-j][i]
            l180[i][j] = l[N-1-i][N-1-j]
            l270[i][j] = l[j][N-1-i]
    print('#%d' %(tc))
    for i in range(N):
        print(''.join(list(map(str, l90[i]))), ''.join(list(map(str, l180[i]))),
              ''.join(list(map(str, l270[i]))))