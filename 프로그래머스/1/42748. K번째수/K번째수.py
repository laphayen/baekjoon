def solution(array, commands):
    answer = []
    
    # 1. 각각의 커맨드 for문 돌려서 리스트 슬라이싱 (i-1, j-1)
    # 2. 각각의 리스트 정렬
    # 3. k번째 값 저장 (k-1)
    
    # 1.
    for value in commands:
        i = value[0] - 1;
        j = value[1];
        k = value[2];
        # print(i, j);
        itoj = array[i:j];
        itoj.sort();
        answer.append(itoj[k-1]);
    
    return answer