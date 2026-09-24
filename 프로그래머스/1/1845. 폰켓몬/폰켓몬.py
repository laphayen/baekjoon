def solution(nums):
    dic = {}
    
    for i in nums:
        dic[i] = True;
    
    return min(len(dic), len(nums)//2)
    
    
            



# ######
#  3 1 2 3
# 3x o o x
# 1o x o o
# 2o o x o
# 3x o o x