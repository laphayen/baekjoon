def solution(participant, completion):
    # 1. 선 정렬
    participant.sort()
    completion.sort()
    
    # 2. 교차 검증 2차원 for문
    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]