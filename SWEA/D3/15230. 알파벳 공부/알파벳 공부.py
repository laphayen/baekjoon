alpha = "abcdefghijklmnopqrstuvwxyz"

T = int(input())

for x in range(1, T+1):
    s = input()
    cout = 0
    for i in range(len(s)):
        if s[i] == alpha[i]:
            cout += 1
        else:
            break
    print("#%d %d" %(x, cout))