import queue
def solution(nums):
    answer = 0
    len_nums = len(nums)
    compared = set()
    for i in range(len_nums):
        compared.add(nums[i])
        answer = max(answer, len(compared))
        if answer == len_nums/2:
            break
    return answer
