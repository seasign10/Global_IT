def add_and_mul(a,b):
    return a+b, a*b # 리턴값이 tuple

result=add_and_mul(2, 3)
print(result)

result1, result2=add_and_mul(2, 3) #구조분해 할당
print(result1)
print(result2)

# lamda식
add=lambda a,b:a+b
result=add(3, 4)
print(result)