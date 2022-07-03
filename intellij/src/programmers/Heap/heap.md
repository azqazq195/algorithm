프로그래머스 -> 코딩테스트 고득점 Kit -> 힙(Heap) 개념 공부입니다.

# 1. 설명

>힙은 특정한 규칙을 가지는 트리로, 힙을 이용해서 우선순위 큐를 구현할 수 있습니다.
많은 언어에서 이미 구현된 우선순위 큐 라이브러리를 제공합니다. 이를 활용하면 효율적으로 문제를 풀 수 있습니다. <span style="color:#D46A6A" ><strong>우선순위 큐</strong></span>를 이용해서 해결하기에 적합한 문제들을 만나보세요.

*- [프로그래머스 Heap](https://programmers.co.kr/learn/courses/30/parts/12117)*

먼저 우선순위 큐를 알아보자.

---

## 우선순위 큐

First in First Out 방식인 일반적인 큐와 다르게 
우선순위 큐는 들어간 순서에 상관 없이 우선순위가 높은 데이터가 먼자 나오는 것을 말한다.

우선순위 큐를 구현하는 방법으로 세가지가 있는데

- 배열
- 연결리스트
- 힙

아래의 특징들로 인해 힙으로 구현한다.

#### 배열
데이터의 삽입, 삭제 과정에서 데이터를 한 칸씩 당기거나 밀어야 하는 연산을 계속 해야 한다.
삽입의 위치를 찾으려고 배열을 전체 순회 할 수 있다.

#### 연결리스트
삽입의 위치를 찾으려고 배열을 전체 순회 할 수 있다.

#### 힙
이진트리의 구조로 부모와 자식 노드의 비교를 통해 삽입, 삭제를 한다.

---

## 힙 정렬

>힙 정렬(Heap sort)이란 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법으로서, 
내림차순 정렬을 위해서는 최대 힙을 구성하고 
오름차순 정렬을 위해서는 최소 힙을 구성하면 된다.

*- [위키](https://ko.wikipedia.org/wiki/%ED%9E%99_%EC%A0%95%EB%A0%AC)*

#### 알고리즘

1. n개의 노드에 대한 완전 이진 트리를 구성한다.이때 루트 노드부터 부모노드, 왼쪽 자식노드, 오른쪽 자식노드 순으로 구성한다.

2. 최대 힙을 구성한다. 최대 힙이란 부모노드가 자식노드보다 큰 트리를 말하는데, 단말 노드를 자식노드로 가진 부모노드부터 구성하며 아래부터 루트까지 올라오며 순차적으로 만들어 갈 수 있다.

3. 가장 큰 수(루트에 위치)를 가장 작은 수와 교환한다.
2와 3을 반복한다.

#### 시간복잡도

이진 트리를 최대 힙으로 만들기 위하여 최대 힙으로 재구성 하는 과정이 트리의 깊이 만큼 이루어지므로 $O(\log n)$의 수행시간이 걸린다. 구성된 최대 힙으로 힙 정렬을 수행하는데 걸리는 전체시간은 힙 구성시간과 $n$개의 데이터 삭제 및 재구성 시간을 포함한다.