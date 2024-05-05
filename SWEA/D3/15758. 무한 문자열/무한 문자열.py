T = int(input())

for x in range(1, T+1):
    s1, s2 = input().split()
    s1_len = len(s1)
    s2_len = len(s2)
    if (s1*s2_len) == (s2*s1_len):
        print("#%d" %x, "yes")
    else:
        print("#%d" %x, "no")