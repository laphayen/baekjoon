# def solution(nums):
#     dic = {}
    
#     for i in nums:
#         dic[i] = True;
    
#     return min(len(dic), len(nums)//2)

def solution(nums):
    return min(len(set(nums)), len(nums) // 2)
