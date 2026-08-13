class Solution:
    def get_key(self, sa):
        # return "".join(sorted(sa)) == "".join(sorted(sb))
        char_count = [0] * 26  # [0,0,0,0,0,0,0,0, .... ]
        '''
            a  b  c  d e f ... z
            46 47 48
            0  1  2  3
            - 'a'
        '''
        for character in sa:
            char_count[ord(character) - ord('a')] += 1

        return "#".join(map(str, char_count))

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_dict = {}
        for string in strs:
            key = self.get_key(string)
            if key in anagram_dict:
                anagram_dict[key].append(string)
            else:
                anagram_dict[key] = [string]

        result = []
        for key in anagram_dict:
            result.append(anagram_dict[key])

        return result

        



