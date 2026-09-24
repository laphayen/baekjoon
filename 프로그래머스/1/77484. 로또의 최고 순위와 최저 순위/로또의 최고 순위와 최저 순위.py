def solution(lottos, win_nums):
    
    # 1. 최소 일치 개수 = 일치하는 값
    # 최대 일치 개수 = 일치하는 값 + 0의 개수
    
    cnt_zero = 0;
    min_cnt = 0;
    
    rank_max = 0;
    rank_min = 0;
    
    for i in lottos:
        if (i == 0):
            cnt_zero += 1;
            
    for i in lottos:
        for j in win_nums:
            if (i == j):
                min_cnt += 1;
    
    li = [min_cnt+cnt_zero, min_cnt];
    result = []
    
    # 2. 최소와 최대의 경우 로또 규칙에 따라서 등 수 출력
    for i in li:
        if (i < 2):
            result.append(6);
        elif (i == 2):
            result.append(5);
        elif (i == 3):
            result.append(4);
        elif (i == 4):
            result.append(3);
        elif (i == 5):
            result.append(2);
        elif (i == 6):
            result.append(1);
    
    
    return result