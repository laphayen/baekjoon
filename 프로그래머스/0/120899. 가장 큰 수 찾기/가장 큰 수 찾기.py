def solution(array):
    res = 0;
    idx = 0;
    for i in range(len(array)):
        if (res < array[i]):
            res = array[i];
            idx = i;
    return [res, idx];