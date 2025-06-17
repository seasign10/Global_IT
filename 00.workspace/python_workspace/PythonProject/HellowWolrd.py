from copy import copy

a=[1,2,3,4,5]
b=a[:2]
c=a[2:]
print(b)
print(c)

a[2]=8
print(a)
print(a[1]*a[2])
print(len(a))
print(a.pop())
print(a)

a.extend([6, 7])
print(a)

a = {'name': 'pey', 'phone': '010-9999-1234', 'birth': '1118'}
print(a.keys())
print(a.values())
print(a.items())

s1 = set([1, 2, 3, 4, 5 ,6])
s2 = set([4, 5, 6, 7, 8, 9])
print(s1 - s2)
print(s1) #원본 변경없음

a=[1,2,3]
b=a
print(id(a))
print(id(b))

# a=[1,2,3]
# b=a[:]
# print(id(a))
# print(id(b))
#
# a=[1,2,3]
# b=copy(a)
# print(id(a))
# print(id(b))

a[1]=4
print(a)
print(b)

pocket = ['paper', 'cellphone', 'money']
if 'money' in pocket:
    print("택시를 타고 갑니다.")
else:
    print("걸어갑니다.")

pocket = ['paper', 'cellphone']
card=True
if 'money' in pocket:
    print("택시를 타고 갑니다.")
elif card:
    print("버스를 타고 갑니다.")
else:
    print("걸어갑니다.")