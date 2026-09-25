def solution(strings, n):
    return sorted(strings, key=lambda word: (word[n], word))
    
#     # 1. 딕셔너리에 각각의 요소 넣기 : 시간 복잡도 N
#     # 2. n으로 정렬
#     # 3. 값 반환
    
    
#     #1.
#     dic = {};
#     for str in strings:
#         print(str)
#         dic[str] = str[n];
#         print(dic)
        
#         result = sorted(dic.items(), key=lambda item: item[1])
        
#         print(result)
#     return result