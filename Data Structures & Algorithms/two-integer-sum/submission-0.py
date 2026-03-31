class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        hashmap = {}

        for i in range(len(nums)):
            curr = target - nums[i]
            if curr in hashmap:
                return [hashmap[curr], i]
            hashmap[nums[i]] = i
        
        print(hashmap)
        return [0,0]