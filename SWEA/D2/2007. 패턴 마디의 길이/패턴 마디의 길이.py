T = int(input())
for i in range(T):
    s = input()
    p_1 = []
    p_2 = []
    for j in range(10):
        p_1 = s[:j]
        p_2 = s[j:j*2]
        if (j != 0) and (p_1 == p_2):
            print('#%d %d' %((i+1), len(p_1)))
            break