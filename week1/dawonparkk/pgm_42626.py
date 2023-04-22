import heapq as hq

def solution(scoville, K):

    hq.heapify(scoville) # 최소값이 0번째 인덱스에 위치 : 0(n)
    answer = 0
    while True:
        first = hq.heappop(scoville) #O(log(n))
        if first >= K:
            break
        if len(scoville) == 0:
            return -1
        second = hq.heappop(scoville)
        hq.heappush(scoville, first + second*2) # O(log(n))
        answer += 1  

    return 
