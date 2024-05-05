T = int(input())

for x in range(1, T+1):
    N = int(input())
    S = input()

    front = S[:N//2]
    rear = S[N//2:]

    if front == rear:
        print("#%d" %(x), "Yes")
    else:
        print("#%d" %(x), "No")