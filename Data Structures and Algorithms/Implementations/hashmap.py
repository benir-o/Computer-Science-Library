city_map={}
cities=["Calgary","Vancouver","Toronto"]
city_map["Canada"]=[]
city_map["Canada"]+=cities
print(city_map)

class Solution:
    def groupAnagrams(self, strs: List[str])->List[List[str]]:
        anagram=defaultdict(List)
        result=[]

        for s in strs:
            sorted_s=sorted(s)
            