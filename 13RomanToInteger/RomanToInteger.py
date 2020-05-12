class Solution:
    def romanToInt(self, s: str) -> int:
        roman_num = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
        lst = list(s)
        result = 0
        needSkip = -1
        for index,char in enumerate(lst):
            if(needSkip != index):
                if (index + 1 < len(lst)):
                    if roman_num.get(char) < roman_num.get(lst[index + 1]):
                        needSkip = index + 1 
                        if char == 'I':
                            if (lst[index + 1] == "V"):
                                result  = result + 4
                            else:
                                result = result + 9
                        elif char == 'X':
                            if (lst[index + 1] == "L"):
                                result  = result + 40
                            else:
                                result = result + 90
                        elif char == 'C':
                            if (lst[index + 1] == "D"):
                                result  = result + 400
                            else:
                                result = result + 900
                    else:
                        result = result + roman_num.get(char)
                else:
                    result = result + roman_num.get(char)
        return result


if __name__ == "__main__":
    so = Solution()
    print(so.romanToInt("III"))