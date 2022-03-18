

문제에 대한 설명

백준 -> 기본 수학 1 -> <a href="https://www.acmicpc.net/problem/10757" target="_blank">10757 큰 수 A+B</a>에 대한 연습입니다.

# 1. 문제 읽기
 
>두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

첫째 줄에 A와 B가 주어진다. ($0 < A,B < 10^{10000}$)
첫째 줄에 A+B를 출력한다.



### 예제 입·출력
#### 입력
>9223372036854775807 9223372036854775808
#### 출력
>18446744073709551615

#### 내 생각💡
단순 덧셈이아닌 int, long 형의 범위를 넘는 큰 수 이기 때문에 문자열 형태로 풀어야 할 것 같다.

# 2. 풀이

### 풀이 과정

덧셈을 하게 되면 자릿수가 최대 한자리 늘어날 수 있다.
입력받은 숫자 중 더 길이가 긴 숫자에 + 1한 크기의 배열을 만든다.

```java
int maxLength = str[0].length() > str[1].length() ? str[0].length() : str[1].length();
maxLength += 1;
int num[][] = new int[2][maxLength];
```

1의 자리 숫자 부터 int형 배열에 넣는다.

```java
for (int k = 0; k < 2; k++) {
    int a = 0;
    for (int i = str[k].length() - 1; i >= 0; i--) {
        num[k][a] = Character.getNumericValue(str[k].charAt(i));
        a++;
    }
}
```

1의 자리 수 부터 덧셈

```java
for (int i = 0; i < maxLength; i++) {
    num[0][i] = num[0][i] + num[1][i];
}
```

자릿수 올림
한자리 씩 더해서 자릿수 올림이 되면 다음 배열에 + 1 해준다.

```java
for (int i = 0; i < maxLength; i++) {
    if (num[0][i] >= 10) {
        num[0][i] -= 10;
        num[0][i + 1] += 1;
    }
}
```

출력은 반대에서 부터
비어있는 값은 패스하기 위해 0이면 건너 뛰어야 한다.
근데 중간에 0이 있을 수 도 있기 떄문에 그냥 0 만 찾으면 값이 달라 질 수 있어서 구분해준다.

```java
for (int i = maxLength - 1; i >= 0; i--) {
    if (num[0][i] == 0)
        
        continue;
    else {
        for (int k = i; k >= 0; k--) {
            answer = answer + String.valueOf(num[0][k]);
        }
        break;
    }
}
```

![1](https://user-images.githubusercontent.com/45132207/104227191-5ef1ed80-548c-11eb-9a1b-23d89a8908bf.PNG)

# 3. 더 풀어 보기🚨

결과를 보면 알 수 있듯이 수행시간이 긴편이다.
코드를 살펴보면

>많은 포문
많은 형변환

크게 두가지와 여러 문제들이 있는 것 같다.

일단 `answer = answer + String.valueOf(num[0][k]);`
의 연산을 StringBuilder로 바꾸어 주었다.

```java
// String answer = "";
StringBuilder sb = new StringBuilder();

// answer = answer + String.valueOf(num[0][k]);
sb.append(String.valueOf(num[0][k]));
```

![2](https://user-images.githubusercontent.com/45132207/104228881-cdd04600-548e-11eb-94b5-2ec25815ad6b.PNG)

처음 자바 코드 문제를 풀면서 scanf를 buffer로 사용하였을 때 만큼 메모리와 수행시간이 줄어 들었다.

포문이 많긴 하지만 실제로 수행하는데에는 큰 차이가 없는 수준이어서 StringBuilder 하나만으로 시간은 많이 단축 시켰다.

---
<a href="https://github.com/azqazq195/Coding-Test/tree/master/src/Baekjun/기본수학1/큰수AB.java" target="_blank">전체 코드</a>