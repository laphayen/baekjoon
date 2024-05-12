T = int(input())

for x in range(1, T+1):
    s = input()
    cout = 1
    while 10:
        s1 = s[:cout]
        s2 = s[cout:cout*2]
        if s1 == s2:
            break
        else:
            cout += 1
    print("#%d %d" %(x, cout))