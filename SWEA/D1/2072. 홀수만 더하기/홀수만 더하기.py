T = int(input())

for x in range(T):
    num_list = list(map(int, input().split()))
    result = 0
    for i in num_list:
        if i % 2 != 0:
            result += i
    print("#%d %d" %(x+1, result))