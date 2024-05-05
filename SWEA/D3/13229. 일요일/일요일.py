day_dic = {"MON":1, "TUE":2, "WED":3, "THU":4, "FRI":5, "SAT":6, "SUN":7 }

T = int(input())

for x in range(1, T+1):
    s = input()
    if s == "SUN":
        print("#%d %d" %(x, 7))
    else:
        print("#%d %d" %(x, 7 - day_dic[s]))