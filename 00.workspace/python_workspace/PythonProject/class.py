class FourCal:
    #생성자. self는 java의 this와 같은 역할
    def __init__(self, first, second):
        self.first=first
        self.second=second
    #setter
    def setdata(self, first, second):
        self.first = first
        self.second = second
    #메서드
    def add(self):
        result = self.first + self.second
        return result

#instance 생성
a=FourCal(3, 4)
print(a.add())
