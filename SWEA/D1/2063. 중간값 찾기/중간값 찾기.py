N = int(input())

l = list(map(int, input().split()))
l.sort()
mid = int(N / 2)
print(l[mid])