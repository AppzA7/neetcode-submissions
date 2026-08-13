class Solution:

    def encode(self, strs: List[str]) -> str:
        output = ""
        for word in strs:
            output += "#" + str(len(word)) + "#" + word
        return output


        # ["#12llo world", "world", "#help##gh", "#gh"]
        # 0123    456789 10 11 12 13 14 15 16 17 18
        # #12#    #12llo    w  o  r  l  d  #  5   #  world#9##help##gh#3##gh
        # i
        # "#" + len(s) + "#" + s
        # #12llo world
        # world

    def decode(self, s: str) -> List[str]:
        words = []
        index = 0;
        while index < len(s):
            terminal_index = s.find('#', index + 1)
            length = int(s[index+1:terminal_index])
            # read from terminal_index + 1 to terminal + 1 + lengtha
            word = s[terminal_index + 1:terminal_index + 1 + length]
            words.append(word)
            index = terminal_index + 1 + length

        return words
