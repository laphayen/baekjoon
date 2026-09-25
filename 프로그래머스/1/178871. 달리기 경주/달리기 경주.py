def solution(players, callings):
    
    # 이중 for문으로 N**2 으로 시간 제한 걸림
    # N 이상의 시간 복잡도로 해결해야 함.
    
    # N 으로 해결하는 방법 N + N = N으로, 
    # 1. for 문으로 먼저 위치 파악
    # 2. for 문으로 위치 변경
    # 1번을 돌리는 이유는 이중 for문으로 인덱스 위치를 한 번 더 찾기 때문에
    # dic 으로 값과 위치를 한 번에 가지로 있다가 교환해준다
    
    #1.
    dic = {}
    for idx, player in enumerate(players):
        dic[player] = idx;
    # print('players: ', players)
    # print('dic: ', dic)
    
    #2.
    for call in callings:
        now_idx = dic[call]
        front_player = players[now_idx-1]
        # print(front_player)
        
        # 교환
        temp = front_player
        # print(temp)
        players[now_idx - 1] = call;
        players[now_idx] = temp;
        
        # print(players)
        
        dic[call] = now_idx-1;
        dic[temp] = now_idx;
        
        # print(dic)
        # players[call-1] = front_player
    return players


# def solution(players, callings):
    
#     for i in callings:
#         for index, value in enumerate(players):
#             if (i == value):
#                 temp = players[index-1];
#                 players[index-1] = players[index];
#                 players[index] = temp;
                
#                 # print(i);
#                 # print(index, value)
#     return players