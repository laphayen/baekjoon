T = int(input())

for x in range(1, T+1):
    num_list = list(map(int, input().split()))
    num_list_len = len(num_list)
    result = 0
    for i in num_list:
        result += i
    print("#%d %d" %(x, round(result/num_list_len)))