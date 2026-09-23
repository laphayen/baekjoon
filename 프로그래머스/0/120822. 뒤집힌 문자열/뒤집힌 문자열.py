def solution(my_string):
    result = ''
    for char in my_string[::-1]:
        # print(char)
        # String은 append 사용 못함
        result = result + char
    return result;