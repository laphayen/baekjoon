def solution(id_list, report, k):
    
    # 한 번에 한 명 - 중복 제거 - set
    # k번 정지
    # 마지막에 정지
    
    # id_list - 이용자의 ID 배열
    # report - 신고한 이용자의 ID
    # k - 신고 횟수
    
    # print(id_list)
    # print(report)
    # print(k)
    
    # 1. 신고누적 딕셔너리(나중에 K번 이후는 정지) 시간복잡도 N으로 딕셔너리에 저장 초기값 - 0 
    # 2. 내가 누굴 신고 했는지 가지고 있는 딕션너리 또는 배열 -> 근데 이건 리포트 자체잖아?
    # 3. report에서 공백 기준으로 나눠서 신고 당했으면 저장
    # 4. 내가 신고한 계정의 정지면 횟수 증가
    
    report_nums = {}
    kill_count = {}
    answer = [];
    # report = set()
    
    for id in id_list:
        report_nums[id] = 0;
        kill_count[id] = set();
    
    for line in report:
        name = line.split(' ')
        # print(kill_count)
        if name[1] not in kill_count[name[0]]:
            report_nums[name[1]] = report_nums.get(name[1], 0) + 1
            kill_count[name[0]].add(name[1])
        
        
    
#     print('report_nums: ', report_nums)
#     print('kill_count: ', kill_count)
    
    for i, j in kill_count.items():
        cnt = 0;
        # 각각의 요소를 접근해서 k 이상일 경우의 ID수를 누적
        for id in j:
            # print(report_nums[item])
            if (report_nums[id] >= k):
                cnt += 1;
        # 누적된 ID
        answer.append(cnt)
    
    # print(answer)
    
    return answer