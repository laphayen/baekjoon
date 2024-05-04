T = int(input())

for x in range(1, T+1):
    s = input()
    rs = s[::-1]
    result = 1
    for i in range(len(s)):
        if s[0] != rs[0]:
            result = 0
            break

    print("#%d %d" %(x, result))